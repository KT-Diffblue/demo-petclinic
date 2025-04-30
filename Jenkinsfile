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
                    echo "Get and unzip dcover jars into directory dcover, store dcover script location for later use"
                    mkdir --parents dcover
                    curl -L "$DIFFBLUE_RELEASE_URL" --output dcover/dcover.zip --silent
                    unzip -o dcover/dcover.zip -d dcover
                    DIFFBLUE_COVER_LOCATION="dcover/dcover"
                    '''
                }
            }
        }
}
