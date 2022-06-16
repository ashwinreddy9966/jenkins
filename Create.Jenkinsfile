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
            steps {
            dir('EC2') { git branch: 'main', url:'https://github.com/ashwinreddy9966/terraform-databases.git'
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
            steps {
                dir('EKS') {  git branch: 'main', url: 'https://github.com/ashwinreddy9966/kubernetes.git'
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
                dir('EC2') {
                    git branch: 'main', url:'https://github.com/ashwinreddy9966/cart.git'
                    git branch: 'main', url:'https://github.com/ashwinreddy9966/roboshop-helm-chart.git'
                       sh "ls -ltr"

                    }

                }

            }
        }
    }
}
