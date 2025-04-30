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

        stages {
                stage('Use dcover cli in Jenkins') {
                    steps {
                        sh '''
                        echo "Get and unzip dcover jars into directory dcover, store dcover script location for later use"
                        mkdir --parents dcover
                        wget "$DIFFBLUE_RELEASE_URL" --output-document dcover/dcover.zip --quiet
                        unzip -o dcover/dcover.zip -d dcover
                        DIFFBLUE_COVER_LOCATION="dcover/dcover"
                        '''
                    }
                }
            }
            stages {
                stage('Use dcover cli in Jenkins') {
                    steps {
                        sh '''
                            ...

                            echo "Running dcover to create and commit tests"
                            "$DIFFBLUE_COVER_LOCATION" ci activate build validate create

                        '''
                    }
                }
            }
    }
}
