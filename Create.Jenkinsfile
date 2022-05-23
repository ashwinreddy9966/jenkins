pipeline {
    agent any
         parameters { choice(name: 'ENV', choices: ['dev', 'prod'], description: 'ENV') }
    stages {
        stage('Terraform-VPC') {
            steps {
            dir('MAVEN') {
                git branch: 'main', credentialsId: 'GitLabCred', url: 'https://github.com/ashwinreddy9966/terraform-vpc.git'
                }
                    sh "cp env-${ENV}/Terrafile . ; terrafile"
                    sh "terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars"
                    sh "terraform plan -var-file=env-${ENV}/${ENV}.tfvars"
                    sh "terraform destroy -auto-approve -var-file=env-${ENV}/${ENV}.tfvars"
                 }
           }

        stage('Download the TF-EC2 Code') {
            steps {
            dir('EC2') {
                git branch: 'main', credentialsId: 'GitLabCred', url: 'https://gitlab.com/clouddevops-b47/terraform-ec2.git'
                }
                     sh "cp env-${ENV}/Terrafile . ; terrafile"
                     sh "terraform init -backend-config=env-${ENV}/${ENV}-backend.tfvars"
                     sh "terraform plan -var-file=env-${ENV}/${ENV}.tfvars"
                     sh "terraform destroy -auto-approve -var-file=env-${ENV}/${ENV}.tfvars"
            }
        }

    }
}
