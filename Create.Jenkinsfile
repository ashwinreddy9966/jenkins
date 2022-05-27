pipeline {
    agent any
    parameters
         { choice(name: 'ENV', choices: ['dev', 'prod'], description: 'ENV')
            string(choices: 'APP_VERSION',description: 'Choose App Version To Deploy : Ignore this VPC and DB', name: "APP_VERSION")
          }
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
            steps {
            dir('EC2') { git branch: 'main', url:'https://github.com/ashwinreddy9966/terraform-databases.git'
                       sh "ls -ltr"
                       sh "export TF_VAR_APP_VERSION=2.0.1"
                       sh "cp env-${ENV}/Terrafile . ; terrafile"
                       sh "terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars"
                       sh "terraform plan -var-file=env-${ENV}/${ENV}.tfvars"
                       sh "terraform apply -auto-approve -var-file=env-${ENV}/${ENV}.tfvars || true"
                       sh "terraform apply -auto-approve -var-file=env-${ENV}/${ENV}.tfvars"
                    }
            }
        }
        stage('Creating-ALB') {
            steps {
                dir('VPC') {  git branch: 'main', url: 'https://github.com/ashwinreddy9966/terraform-loadbalancers.git'
                        sh "ls -ltr"
                        sh "cp env-${ENV}/Terrafile . ; terrafile"
                        sh "terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars -reconfigure"
                        sh "terraform plan -var-file=env-${ENV}/${ENV}.tfvars"
                        sh "terraform apply -auto-approve -var-file=env-${ENV}/${ENV}.tfvars"
                     }
                 }
            }
               stage('Creating-User') {
                   steps {
                       dir('USER') {  git branch: 'main', url: 'https://github.com/ashwinreddy9966/user.git'
                          sh '''
                            cd terraform-mutable
                            export TF_VAR_APP_VERSION=1.0.1
                            terrafile -f env-${ENV}/Terrafile
                            terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars
                            terraform plan -var-file=env-${ENV}/${ENV}.tfvars
                            terraform apply -var-file=env-${ENV}/${ENV}.tfvars -auto-approve
                          '''
                            }
                        }
                   }
               stage('Creating-Catalogue') {
                   steps {
                       dir('Catalogue') {  git branch: 'main', url: 'https://github.com/ashwinreddy9966/catalogue.git'
                          sh '''
                            cd terraform-mutable
                            export TF_VAR_APP_VERSION=1.1.2
                            terrafile -f env-${ENV}/Terrafile
                            terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars
                            terraform plan -var-file=env-${ENV}/${ENV}.tfvars
                            terraform apply -var-file=env-${ENV}/${ENV}.tfvars -auto-approve
                          '''
                            }
                        }
                  }
            stage('Creating-Payment') {
                steps {
                    dir('PAYMENT') {  git branch: 'main', url: 'https://github.com/ashwinreddy9966/payment.git'
                          sh '''
                            cd terraform-mutable
                            export TF_VAR_APP_VERSION=1.0.5
                            terrafile -f env-${ENV}/Terrafile
                            terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars -reconfigure
                            terraform plan -var-file=env-${ENV}/${ENV}.tfvars
                            terraform apply -var-file=env-${ENV}/${ENV}.tfvars -auto-approve
                          '''
                         }
                     }
                }
            stage('Creating-Cart') {
                steps {
                    dir('CART') {  git branch: 'main', url: 'https://github.com/ashwinreddy9966/cart.git'
                          sh '''
                            cd terraform-mutable
                            export TF_VAR_APP_VERSION=1.0.5
                            terrafile -f env-${ENV}/Terrafile
                            terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars -reconfigure
                            terraform plan -var-file=env-${ENV}/${ENV}.tfvars
                            terraform apply -var-file=env-${ENV}/${ENV}.tfvars -auto-approve
                          '''
                         }
                     }
                }
            stage('Creating-Shipping') {
                steps {
                    dir('SHIPPING') {  git branch: 'main', url: 'https://github.com/ashwinreddy9966/shipping.git'
                          sh '''
                            cd terraform-mutable
                            export TF_VAR_APP_VERSION=1.0.2
                            terrafile -f env-${ENV}/Terrafile
                            terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars -reconfigure
                            terraform plan -var-file=env-${ENV}/${ENV}.tfvars
                            terraform apply -var-file=env-${ENV}/${ENV}.tfvars -auto-approve
                          '''
                         }
                     }
                }
                   stage('Creating-Frontend') {
                       steps {
                           dir('FRONTEND') {  git branch: 'main', url: 'https://github.com/ashwinreddy9966/frontend.git'
                              sh '''
                                pwd ; ls -ltr
                                cd ./terraform-mutable
                                export TF_VAR_APP_VERSION=1.0.9
                                terrafile -f env-${ENV}/Terrafile
                                terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars -reconfigure
                                terraform plan -var-file=env-${ENV}/${ENV}.tfvars
                                terraform apply -var-file=env-${ENV}/${ENV}.tfvars -auto-approve
                              '''
                                }
                            }
                       }
                  }
            }