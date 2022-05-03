folder('CI-Jobs') {
    displayName('CI-Jobs')
    description('Folder for RoboShop CI Components')
}

multibranchPipelineJob('CI-Jobs/Cart') {
    branchSources {
        git {
            id('123456789') // IMPORTANT: use a constant and unique identifier
            remote('https://github.com/jenkinsci/job-dsl-plugin.git')
            credentialsId('github-ci')
            includes('JENKINS-*')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}