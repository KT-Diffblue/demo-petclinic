pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'jenkins-pipeline', url: 'https://github.com/KT-Diffblue/demo-spring-petclinic'
            }
        }

        stage('Set up Diffblue License') {
            steps {
                withCredentials([file(credentialsId: 'diffblue-env-vars.sh', variable: 'ENV_VARS_FILE')]) {
                    sh 'source $ENV_VARS_FILE'
                    echo "Diffblue Release URL: ${DIFFBLUE_RELEASE_URL}"
                    echo "Diffblue License Key: ${DIFFBLUE_LICENSE_KEY}"
                }
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Generate Tests') {
            steps {
                sh './dcover create'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
