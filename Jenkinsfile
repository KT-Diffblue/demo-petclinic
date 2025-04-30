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
                sshagent(['github-ssh']) {
                    git branch: 'jenkins-pipeline', url: 'git@github.com:KT-Diffblue/demo-spring-petclinic.git'
                }
            }
        }

        stage('Use dcover cli in Jenkins') {
            steps {
                sshagent(['github-ssh-key']) {
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
}
