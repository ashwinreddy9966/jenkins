pipeline {
    agent any
    parameters { choice(name: 'ENV', choices: ['dev', 'prod'], description: 'ENV') }
    stages {
            stage('Deleting-Cart') {
                steps {
                    dir('CART') {  git branch: 'main', url: 'https://github.com/ashwinreddy9966/cart.git'
                            sh "ls -ltr"
                            sh "cd terraform-mutable"
                            sh "cp env-${ENV}/Terrafile . ; terrafile"
                            sh "terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars"
                            sh "terraform plan -var-file=env-${ENV}/${ENV}.tfvars"
                            sh "terraform destroy -auto-approve -var-file=env-${ENV}/${ENV}.tfvars"
                         }
                     }
                }
            stage('Deleting the Components') {
            

            }

        stage('Deleting-DB') {
            steps {
                dir('VPC') {  git branch: 'main', url: 'https://github.com/ashwinreddy9966/terraform-databases.git'
                        sh "ls -ltr"
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
                       sh "cp env-${ENV}/Terrafile . ; terrafile"
                       sh "terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars"
                       sh "terraform plan -var-file=env-${ENV}/${ENV}.tfvars"
                       sh "terraform destroy -auto-approve -var-file=env-${ENV}/${ENV}.tfvars"
                    }
            }
        }
    }
}