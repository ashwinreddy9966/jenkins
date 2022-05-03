folder('CI-Jobs') {
    displayName('CI-Jobs')
    description('Folder for RoboShop CI Components')
}

multibranchPipelineJob('CI-Jobs/Cart') {
    branchSources {
        github {
            id('23232323') // IMPORTANT: use a constant and unique identifier
            scanCredentialsId('GitHub-Cred')
            repoOwner('ashwinreddy9966')
            repository('cart')
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