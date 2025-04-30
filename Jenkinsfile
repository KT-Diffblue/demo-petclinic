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
            stage('Checkout') {
                        steps {
                            git branch: 'jenkins-pipeline', url: 'https://github.com/KT-Diffblue/demo-spring-petclinic'
                        }
                    }

            stage('Use dcover cli in Jenkins') {
                steps {
                withCredentials([usernamePassword(credentialsId: 'github', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_PASSWORD')]) {
                    sh '''
                        git config user.name "$GIT_USERNAME"
                        git config user.email "<your-email@example.com>"
                        git remote set-url origin https://$GIT_USERNAME:$GIT_PASSWORD@github.com/KT-Diffblue/demo-spring-petclinic.git
                        dcover/dcover ci activate build validate create
                    '''
                }

                    sh '''
                    echo "Get and unzip dcover jars into directory dcover, store dcover script location for later use"
                    mkdir -p dcover
                    curl -L "$DIFFBLUE_RELEASE_URL" --output dcover/dcover.zip --silent
                    unzip -o dcover/dcover.zip -d dcover
                    DIFFBLUE_COVER_LOCATION="dcover/dcover"
                    echo "Running dcover to create and commit tests"
                    "$DIFFBLUE_COVER_LOCATION" ci activate build validate create

                    '''
                }
            }
        }
}
