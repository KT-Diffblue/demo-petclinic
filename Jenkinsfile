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

        stage('Install Diffblue CLI') {
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

        stage('License Diffblue CLI') {
            steps {
                withCredentials([string(credentialsId: 'diffblue-cover-license-key', variable: 'DIFFBLUE_LICENSE_KEY')]) {
                    echo "Applying Diffblue CLI license..."
                    sh '''
                        echo $DIFFBLUE_LICENSE_KEY > .dcover.license
                        cp .dcover.license $WORKSPACE/.dcover.license
                        chmod 644 $WORKSPACE/.dcover.license
                    '''
                }
            }
        }

        stage('Use dcover cli in Jenkins') {
            steps {
                sh '''
                    echo "Running dcover to create and commit tests"
                    "$DIFFBLUE_COVER_LOCATION" ci activate build validate create
                '''
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Generate Tests with Diffblue') {
            steps {
                sh '''
                    echo "Running Diffblue to generate tests"
                    "$DIFFBLUE_COVER_LOCATION" ci test
                '''
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
