// node {
// stage('Test'){
//     print 'hello world'
//     }
// }
//
//
// // node {
// // stage('Test') {
// //     print 'hello H'
// //   }
// // }

node {
   if (env.BRANCH_NAME == 'main') {
    stage('Test Stage') {
            print 'I only execute on the main branch'
        }
     } else {
         stage('Dev Stage') {
            print 'I only execute on the master branch'
              }
         }
     }
