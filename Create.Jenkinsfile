pipeline {
    agent any
    parameters
         { choice(name: 'ENV', choices: ['dev', 'prod'], description: 'ENV')
            string(name: 'APP_VERSION', defaultValue: '', description: 'Choose App Version To Deploy : Ignore this VPC and DB')
          }
    options { timeout(time: 30, unit: 'MINUTES')  }

    stages {
        stage('Creating-VPC') {
            steps {
                dir('VPC') {  git branch: 'main', url: 'https://github.com/ashwinreddy9966/terraform-vpc.git'
                        sh "ls -ltr"
                        sh "export TF_VAR_APP_VERSION=2.0.1"
                        sh "cp env-${ENV}/Terrafile . ; terrafile"
                        sh "terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars -reconfigure"
                        sh "terraform plan -var-file=env-${ENV}/${ENV}.tfvars"
                        sh "terraform apply -auto-approve -var-file=env-${ENV}/${ENV}.tfvars"
                     }
                 }
            }
        stage('Creating-DB') {
            dir('EC2') { git branch: 'main', url:'https://github.com/ashwinreddy9966/terraform-databases.git'
            steps {
                       sh "ls -ltr"
                       sh "export TF_VAR_APP_VERSION=2.0.1"
                       sh "cp env-${ENV}/Terrafile . ; terrafile"
                       sh "terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars -reconfigure"
                       sh "terraform plan -var-file=env-${ENV}/${ENV}.tfvars"
                       sh "terraform apply -auto-approve -var-file=env-${ENV}/${ENV}.tfvars || true"
                       sh "terraform apply -auto-approve -var-file=env-${ENV}/${ENV}.tfvars"
                    }
               }
        }

        stage('Creating-EKS') {
                dir('EKS') {  git branch: 'main', url: 'https://github.com/ashwinreddy9966/kubernetes.git'
                steps {
                        sh '''
                           cd eks
                           make create
                           aws eks update-kubeconfig --name prod-eks-cluster
                         '''
                                 }
                             }
                        }
        stage('Backend') {
            parallel {
            stage('CART') {
                dir('CART') {
                steps {
                    git branch: 'main', url:'https://github.com/ashwinreddy9966/cart.git'
                    git branch: 'main', url:'https://github.com/ashwinreddy9966/roboshop-helm-chart.git'
                       sh "ls -ltr"
                       }
                    }
                }
             stage('CATALOGUE') {
                 dir('CATALOGUE') {
                  steps {
                     git branch: 'main', url:'https://github.com/ashwinreddy9966/catalogue.git'
                        sh "ls -ltr"
                        }
                     }
                 }
             stage('USER') {
                 dir('USER') {
                     steps {
                     git branch: 'main', url:'https://github.com/ashwinreddy9966/cart.git'
                        sh "ls -ltr"
                        }
                     }
                 }
              stage('SHIPPING') {
                  dir('SHIPPING') {
                   steps {
                      git branch: 'main', url:'https://github.com/ashwinreddy9966/shipping.git'
                         sh "ls -ltr"
                         }
                      }
                  }
               stage('PAYMENT') {
                   dir('PAYMENT') {
                    steps {
                       git branch: 'main', url:'https://github.com/ashwinreddy9966/payment.git'
                          sh "ls -ltr"
                           }
                       }
                   }                             
                } //end of parallel
            }  // end of backend
        }
    }
