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

multibranchPipelineJob('CI-Jobs/Catalogue') {
    branchSources {
        git {
            id('123456889') // IMPORTANT: use a constant and unique identifier
            remote('https://github.com/ashwinreddy9966/catalogue.git')
            credentialsId('GitHub-Cred')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}

multibranchPipelineJob('CI-Jobs/User') {
    branchSources {
        git {
            id('123456889') // IMPORTANT: use a constant and unique identifier
            remote('https://github.com/ashwinreddy9966/user.git')
            credentialsId('GitHub-Cred')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}

multibranchPipelineJob('CI-Jobs/Shipping') {
    branchSources {
        git {
            id('123456889') // IMPORTANT: use a constant and unique identifier
            remote('https://github.com/ashwinreddy9966/shipping.git')
            credentialsId('GitHub-Cred')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}

multibranchPipelineJob('CI-Jobs/Frontend') {
    branchSources {
        git {
            id('123456889') // IMPORTANT: use a constant and unique identifier
            remote('https://github.com/ashwinreddy9966/frontend.git')
            credentialsId('GitHub-Cred')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}