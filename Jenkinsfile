pipeline {
    agent any

    tools {
        maven 'Maven 3'
        jdk 'Java17'
    }

    environment {
        DCOVER_PATH = 'dcover'  // use this to call dcover consistently
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
                    # Download and extract Diffblue CLI
                    wget https://download.diffblue.com/cover/dce-latest.tar.gz
                    tar -xzf dce-latest.tar.gz
                    mv dce-*/dcover dcover
                    chmod +x dcover
                '''
            }
        }

        stage('License Diffblue CLI') {
            steps {
                withCredentials([file(credentialsId: 'diffblue-license', variable: 'LICENSE_FILE')]) {
                    sh '''
                        cp $LICENSE_FILE .dcover.license
                    '''
                }
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Generate Tests with Diffblue') {
            steps {
                sh './${DCOVER_PATH} create'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
