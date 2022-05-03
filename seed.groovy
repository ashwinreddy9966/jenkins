folder('CI-Jobs') {
    displayName('CI-Jobs')
    description('Folder for RoboShop CI Components')
}

multibranchPipelineJob('CI-Jobs/Cart') {
    branchSources {
        git {
            id('123456789') // IMPORTANT: use a constant and unique identifier
            remote('https://github.com/ashwinreddy9966/cart.git')
            credentialsId('GitHub-Cred')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}

multibranchPipelineJob('CI-Jobs/Payment') {
    branchSources {
        git {
            id('123456889') // IMPORTANT: use a constant and unique identifier
            remote('https://github.com/ashwinreddy9966/payment.git')
            credentialsId('GitHub-Cred')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}