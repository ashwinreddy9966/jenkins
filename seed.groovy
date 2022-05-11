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

multibranchPipelineJob('CI-Jobs/catalogue') {
    branchSources {
        github {
            id('23232323') // IMPORTANT: use a constant and unique identifier
            scanCredentialsId('GitHub-Cred')
            repoOwner('ashwinreddy9966')
            repository('catalogue')
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
        github {
            id('23232323') // IMPORTANT: use a constant and unique identifier
            scanCredentialsId('GitHub-Cred')
            repoOwner('ashwinreddy9966')
            repository('user')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}

multibranchPipelineJob('CI-Jobs/shipping') {
    branchSources {
        github {
            id('23232323') // IMPORTANT: use a constant and unique identifier
            scanCredentialsId('GitHub-Cred')
            repoOwner('ashwinreddy9966')
            repository('shipping')
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
        github {
            id('23232323') // IMPORTANT: use a constant and unique identifier
            scanCredentialsId('GitHub-Cred')
            repoOwner('ashwinreddy9966')
            repository('frontend')
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
        github {
            id('23232323') // IMPORTANT: use a constant and unique identifier
            scanCredentialsId('GitHub-Cred')
            repoOwner('ashwinreddy9966')
            repository('payment')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}

multibranchPipelineJob('CI-Jobs/Dispatch') {
    branchSources {
        github {
            id('23232323') // IMPORTANT: use a constant and unique identifier
            scanCredentialsId('GitHub-Cred')
            repoOwner('ashwinreddy9966')
            repository('dispatch')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}

multibranchPipelineJob('Test-MB') {
    branchSources {
        github {
            id('23232323') // IMPORTANT: use a constant and unique identifier
            scanCredentialsId('GitHub-Cred')
            repoOwner('ashwinreddy9966')
            repository('jenkins')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}