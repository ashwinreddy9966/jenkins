pipeline {
    agent any
    parameters { choice(name: 'ENV', choices: ['dev', 'prod'], description: 'ENV') }
    stages {
         stage('Deleting the Components') {
             parallel {
                   stage('Deleting-Frontend') {
                       steps {
                           dir('FRONTEND') {  git branch: 'main', url: 'https://github.com/ashwinreddy9966/frontend.git'
                              sh '''
                                pwd ; ls -ltr
                                cd ./terraform-mutable
                                export TF_VAR_APP_VERSION=2.0.1
                                terrafile -f env-${ENV}/Terrafile
                                terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars
                                terraform plan -var-file=env-${ENV}/${ENV}.tfvars
                                terraform destroy -var-file=env-${ENV}/${ENV}.tfvars -auto-approve
                              '''
                                }
                            }
                       }


               stage('Deleting-User') {
                   steps {
                       dir('USER') {  git branch: 'main', url: 'https://github.com/ashwinreddy9966/user.git'
                          sh '''
                            cd terraform-mutable
                            export TF_VAR_APP_VERSION=2.0.1
                            terrafile -f env-${ENV}/Terrafile
                            terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars
                            terraform plan -var-file=env-${ENV}/${ENV}.tfvars
                            terraform destroy -var-file=env-${ENV}/${ENV}.tfvars -auto-approve
                          '''
                            }
                        }
                   }
               stage('Deleting-Catalogue') {
                   steps {
                       dir('Catalogue') {  git branch: 'main', url: 'https://github.com/ashwinreddy9966/catalogue.git'
                          sh '''
                            cd terraform-mutable
                            export TF_VAR_APP_VERSION=2.0.1
                            terrafile -f env-${ENV}/Terrafile
                            terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars
                            terraform plan -var-file=env-${ENV}/${ENV}.tfvars
                            terraform destroy -var-file=env-${ENV}/${ENV}.tfvars -auto-approve
                          '''
                            }
                        }
                  }
            stage('Deleting-Payment') {
                steps {
                    dir('PAYMENT') {  git branch: 'main', url: 'https://github.com/ashwinreddy9966/payment.git'
                          sh '''
                            cd terraform-mutable
                            export TF_VAR_APP_VERSION=2.0.1
                            terrafile -f env-${ENV}/Terrafile
                            terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars
                            terraform plan -var-file=env-${ENV}/${ENV}.tfvars
                            terraform destroy -var-file=env-${ENV}/${ENV}.tfvars -auto-approve
                          '''
                         }
                     }
                }
            stage('Deleting-Cart') {
                steps {
                    dir('PAYMENT') {  git branch: 'main', url: 'https://github.com/ashwinreddy9966/cart.git'
                          sh '''
                            cd terraform-mutable
                            export TF_VAR_APP_VERSION=2.0.1
                            terrafile -f env-${ENV}/Terrafile
                            terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars
                            terraform plan -var-file=env-${ENV}/${ENV}.tfvars
                            terraform destroy -var-file=env-${ENV}/${ENV}.tfvars -auto-approve
                          '''
                         }
                     }
                }
            stage('Deleting-Shipping') {
                steps {
                    dir('SHIPPING') {  git branch: 'main', url: 'https://github.com/ashwinreddy9966/shipping.git'
                          sh '''
                            cd terraform-mutable
                            export TF_VAR_APP_VERSION=2.0.1
                            terrafile -f env-${ENV}/Terrafile
                            terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars
                            terraform plan -var-file=env-${ENV}/${ENV}.tfvars
                            terraform destroy -var-file=env-${ENV}/${ENV}.tfvars -auto-approve
                          '''
                         }
                     }
                }
             } // Closing of parallel stage
          }  // Deletion state completed

        stage('Deleting-DB') {
            steps {
                dir('VPC') {  git branch: 'main', url: 'https://github.com/ashwinreddy9966/terraform-databases.git'
                        sh "ls -ltr"
                        export TF_VAR_APP_VERSION=2.0.1
                        sh "cp env-${ENV}/Terrafile . ; terrafile"
                        sh "terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars"
                        sh "terraform plan -var-file=env-${ENV}/${ENV}.tfvars"
                        sh "terraform destroy -auto-approve -var-file=env-${ENV}/${ENV}.tfvars"
                     }
                 }
            }

        stage('Deleting-ALB') {
            steps {
                dir('VPC') {  git branch: 'main', url: 'https://github.com/ashwinreddy9966/terraform-loadbalancers.git'
                       sh "ls -ltr"
                       export TF_VAR_APP_VERSION=2.0.1
                       sh "cp env-${ENV}/Terrafile . ; terrafile"
                       sh "terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars"
                       sh "terraform plan -var-file=env-${ENV}/${ENV}.tfvars"
                       sh "terraform destroy -auto-approve -var-file=env-${ENV}/${ENV}.tfvars"
                     }
                 }
            }

        stage('Deleting-VPC') {
            steps {
            dir('EC2') { git branch: 'main', url:'https://github.com/ashwinreddy9966/terraform-vpc.git'
                       sh "ls -ltr"
                       export TF_VAR_APP_VERSION=2.0.1
                       sh "cp env-${ENV}/Terrafile . ; terrafile"
                       sh "terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars"
                       sh "terraform plan -var-file=env-${ENV}/${ENV}.tfvars"
                       sh "terraform destroy -auto-approve -var-file=env-${ENV}/${ENV}.tfvars"
                        }
                    }
                 }
             }
        }
    }