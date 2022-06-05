pipeline {
    agent any
    parameters { choice(name: 'ENV', choices: ['dev', 'prod'], description: 'ENV') }
    stages {
         stage('Deleting Frontend User Catalogue') {
            parallel {
               stage('Deleting-Frontend') {
                       steps {
                           dir('FRONTEND') {  git branch: 'main', url: 'https://github.com/ashwinreddy9966/frontend.git'
                              sh '''
                                pwd ; ls -ltr
                                cd ./terraform-mutable
                                export TF_VAR_APP_VERSION=1.0.9
                                terrafile -f env-${ENV}/Terrafile
                                terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars -reconfigure
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
                            export TF_VAR_APP_VERSION=2.0.0
                            terrafile -f env-${ENV}/Terrafile
                            terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars -reconfigure
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
                            export TF_VAR_APP_VERSION=2.0.0
                            terrafile -f env-${ENV}/Terrafile
                            terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars -reconfigure
                            terraform destroy -var-file=env-${ENV}/${ENV}.tfvars -auto-approve
                          '''
                            }
                        }
                  }
                }
             }
         stage('Deleting Payment Cart Shipping') {
            parallel {
            stage('Deleting-Payment') {
                steps {
                    dir('PAYMENT') {  git branch: 'main', url: 'https://github.com/ashwinreddy9966/payment.git'
                          sh '''
                            cd terraform-mutable
                            export TF_VAR_APP_VERSION=1.0.5
                            terrafile -f env-${ENV}/Terrafile || true
                            terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars -reconfigure || true
                            terraform destroy -var-file=env-${ENV}/${ENV}.tfvars -auto-approve || true
                          '''
                         }
                     }
                }
            stage('Deleting-Cart') {
                steps {
                    dir('PAYMENT') {  git branch: 'main', url: 'https://github.com/ashwinreddy9966/cart.git'
                          sh '''
                            cd terraform-mutable
                            export TF_VAR_APP_VERSION=1.0.5
                            terrafile -f env-${ENV}/Terrafile || true
                            terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars -reconfigure || true
                            terraform destroy -var-file=env-${ENV}/${ENV}.tfvars -auto-approve || true
                          '''
                         }
                     }
                }
            stage('Deleting-Shipping') {
                steps {
                    dir('SHIPPING') {  git branch: 'main', url: 'https://github.com/ashwinreddy9966/shipping.git'
                          sh '''
                            cd terraform-mutable
                            export TF_VAR_APP_VERSION=1.0.2
                            terrafile -f env-${ENV}/Terrafile
                            terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars -reconfigure
                            terraform destroy -var-file=env-${ENV}/${ENV}.tfvars -auto-approve
                          '''
                         }
                     }
                }
             }
         }
     stage('DB-n-ALB') {
        parallel {
        stage('Deleting-DB') {
            steps {
                dir('VPC') {  git branch: 'main', url: 'https://github.com/ashwinreddy9966/terraform-databases.git'
                        sh "ls -ltr"
                        sh "export TF_VAR_APP_VERSION=2.0.1"
                        sh "cp env-${ENV}/Terrafile . ; terrafile"
                        sh "terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars -reconfigure"
                        sh "terraform destroy -var-file=env-${ENV}/${ENV}.tfvars -auto-approve || true"
                        sh "terraform destroy -auto-approve -var-file=env-${ENV}/${ENV}.tfvars"
                     }
                 }
            }

        stage('Deleting-ALB') {
            steps {
                dir('VPC') {  git branch: 'main', url: 'https://github.com/ashwinreddy9966/terraform-loadbalancers.git'
                        sh '''
                                    terrafile -f  env-${ENV}/Terrafile
                                    export TF_VAR_APP_VERSION=2.0.1
                                    terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars -reconfigure
                                    terraform destroy -var-file=env-${ENV}/${ENV}.tfvars -auto-approve || true"
                                    terraform destroy -auto-approve -var-file=env-${ENV}/${ENV}.tfvars
                        '''
                     }
                 }
            }
         }
      }

        stage('Deleting-VPC') {
            steps {
            dir('EC2') { git branch: 'main', url:'https://github.com/ashwinreddy9966/terraform-vpc.git'
                        sh '''
                                    terrafile -f  env-${ENV}/Terrafile
                                    export TF_VAR_APP_VERSION=2.0.1
                                    terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars
                                    terraform destroy -auto-approve -var-file=env-${ENV}/${ENV}.tfvars
                        '''
                        }
                    }
                 }
             }
        }

