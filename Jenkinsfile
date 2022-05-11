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
     stage('Feature Stage') {
         if (env.BRANCH_NAME == 'feature') {
             echo 'I only execute on the feature branch'
         }
     }
}