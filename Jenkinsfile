pipeline {
    agent any

    tools {
        maven 'Maven 3'
        jdk 'Java17'
    }

    environment {
        DIFFBLUE_RELEASE_URL = 'https://release.diffblue.com/cli/latest'
        DIFFBLUE_LICENSE_KEY = credentials('diffblue-cover-license-key')
    }
    stages {
            stage('Use dcover cli in Jenkins') {
                steps {
                    sh '''
                        echo "Running dcover to create and commit tests"
                       "$DIFFBLUE_COVER_LOCATION" ci activate build validate create
                    '''
                }
            }
        }
}
