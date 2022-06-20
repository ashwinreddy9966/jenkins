pipeline {
  agent any
  stages {
//     stage('VPC') {
//       steps {
//         dir('VPC') {
//           git branch: 'main', url: 'https://github.com/ashwinreddy9966/terraform-vpc.git'
//           sh '''
//             terrafile -f env-prod/Terrafile
//             terraform init -backend-config=env-prod/prod-backend.tfvars
//             terraform apply -var-file=env-prod/prod.tfvars -auto-approve
//           '''
//         }
//       }
//     }

//     stage('DB') {
//       steps {
//         dir('DB') {
//           git branch: 'main', url: 'https://github.com/ashwinreddy9966/terraform-databases.git'
//           sh '''
//             terrafile -f env-prod/Terrafile
//             terraform init -backend-config=env-prod/prod-backend.tfvars
//             terraform apply -var-file=env-prod/prod.tfvars -auto-approve || true
//             terraform apply -var-file=env-prod/prod.tfvars -auto-approve
//           '''
//         }
//       }
//     }

//     stage('EKS') {
//       steps {
//         dir('EKS') {
//           git branch: 'main', url: 'https://github.com/ashwinreddy9966/kubernetes.git'
//           sh '''
//             cd eks
//             make create
//             aws eks update-kubeconfig --name prod-eks-cluster
//           '''
//         }
//       }
//     }

    stage('Backend') {
      parallel {

        stage('CART') {
          steps {
            dir('CHART') {
              git branch: 'main', url: 'https://github.com/ashwinreddy9966/roboshop-helm-chart.git'
            }
            dir('CART') {
              git branch: 'main', url: 'https://github.com/ashwinreddy9966/cart.git'
              sh '''
                  ls -ltr
                  helm upgrade -i -f values.yaml cart ../CHART
                '''
            }
          }
        }

        stage('CATALOGUE') {
          steps {
            dir('CATALOGUE') {
              git branch: 'main', url: 'https://github.com/ashwinreddy9966/catalogue.git'
              sh '''
                 ls -ltr
                 helm upgrade -i -f values.yaml catalogue ../CHART
          '''
            }
          }
        }

        stage('USER') {
          steps {
            dir('USER') {
              git branch: 'main', url: 'https://github.com/ashwinreddy9966/user.git'
              sh '''
                ls -ltr
                  helm upgrade -i -f values.yaml user ../CHART
          '''
            }
          }
        }

        stage('PAYMENT') {
          steps {
            dir('PAYMENT') {
              git branch: 'main', url: 'https://github.com/ashwinreddy9966/payment.git'
              sh '''
               ls -ltr
                  helm upgrade -i -f values.yaml payment ../CHART
          '''
            }
          }
        }

        stage('SHIPPING') {
          steps {
            dir('SHIPPING') {
              git branch: 'main', url: 'https://github.com/ashwinreddy9966/shipping.git'
              sh '''
                ls -ltr
                  helm upgrade -i -f values.yaml shipping ../CHART
          '''
            }
          }
        }

        stage('FRONTEND') {
          steps {
            dir('FRONTEND') {
              git branch: 'main', url: 'https://github.com/ashwinreddy9966/frontend.git'
              sh '''
                 ls -ltr
                  helm upgrade -i -f values.yaml frontend ../CHART
          '''
            }
          }
        }

      }
    }


  }

  post {
    always {
      cleanWs()
    }
  }

}
