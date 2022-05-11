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
            echo 'I only execute on the main branch'
        }
     else {
         stage('Dev Stage') {
            echo 'I only execute on the main branch'
          }
     }
 }
    if (env.BRANCH_NAME == 'feature') {
     stage('Feature Stage') {
             echo 'I only execute on the feature branch'
         }
     }
}