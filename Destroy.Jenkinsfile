pipeline {
  agent any
  stages {

    stage('DB') {
      steps {
        dir('DB') {
          git branch: 'main', url: 'https://github.com/ashwinreddy9966/terraform-databases.git'
          sh '''
            terrafile -f env-prod/Terrafile
            terraform init -backend-config=env-prod/prod-backend.tfvars
            terraform destroy -var-file=env-prod/prod.tfvars -auto-approve || true
            terraform destroy -var-file=env-prod/prod.tfvars -auto-approve || true
          '''
        }
      }
    }

    stage('EKS') {
      steps {
        dir('EKS') {
          git branch: 'main', url: 'https://github.com/ashwinreddy9966/kubernetes.git'
          sh '''
            cd eks
            make destroy

          '''
        }
      }
    }

     stage('VPC') {
       steps {
         dir('VPC') {
           git branch: 'main', url: 'https://github.com/ashwinreddy9966/terraform-vpc.git'
           sh '''
             terrafile -f env-prod/Terrafile
             terraform init -backend-config=env-prod/prod-backend.tfvars
             terraform destroy -var-file=env-prod/prod.tfvars -auto-approve
           '''
             }
           }
         }
      }
   }