pipeline {
    agent any
         parameters { choice(name: 'ENV', choices: ['dev', 'prod'], description: 'ENV') }
    stages {
        stage('Terraform-VPC') {
            steps {
            dir('MAVEN') { git branch: 'main', url: 'https://github.com/ashwinreddy9966/terraform-vpc.git' }
                    sh "ls -ltr"
                    sh "cp env-${ENV}/Terrafile . ; terrafile"
                    sh "terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars"
                    sh "terraform plan -var-file=env-${ENV}/${ENV}.tfvars"
                    sh "terraform destroy -auto-approve -var-file=env-${ENV}/${ENV}.tfvars"
                 }
           }

        stage('Terraform-DB') {
            steps {
            dir('EC2') { git branch: 'main', url:'https://github.com/ashwinreddy9966/terraform-ec2.git' }
                   sh "ls -ltr"
                   sh "cp env-${ENV}/Terrafile . ; terrafile"
                   sh "terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars"
                   sh "terraform plan -var-file=env-${ENV}/${ENV}.tfvars"
                   sh "terraform destroy -auto-approve -var-file=env-${ENV}/${ENV}.tfvars"
            }
        }

    }
}
