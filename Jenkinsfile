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
    stage('Test Stage') {
        if (env.BRANCH_NAME == 'main') {
            echo 'I only execute on the main branch'
        } else {
            echo 'I execute elsewhere'
        }
    }
    if (env.BRANCH_NAME == 'feature') {
     stage('Feature Stage') {
             echo 'I only execute on the feature branch'
         }
     }
}