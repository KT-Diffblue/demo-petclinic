pipeline {
    agent any

    tools {
        maven 'Maven 3'
        jdk 'Java17'
    }

    environment {
        DCOVER_PATH = 'dcover'  // Use this to call dcover consistently
        DIFFBLUE_RELEASE_URL = 'https://download.diffblue.com/cover/dce-latest.tar.gz' // URL for Diffblue CLI
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'jenkins-pipeline', url: 'https://github.com/KT-Diffblue/demo-spring-petclinic'
            }
        }

        stage('Install Diffblue CLI') {
            steps {
                script {
                    echo "Downloading and extracting Diffblue CLI..."
                    sh '''
                        # Create the dcover directory if it doesn't exist
                        mkdir -p dcover

                        # Download and extract the Diffblue CLI tarball
                        curl -L "$DIFFBLUE_RELEASE_URL" --output dcover/dcover.tar.gz --silent

                        # Extract the tar.gz file
                        tar -xzf dcover/dcover.tar.gz -C dcover

                        # Set the dcover location for later use
                        export DIFFBLUE_COVER_LOCATION="dcover/dcover"

                        # Make the dcover CLI executable
                        chmod +x $DIFFBLUE_COVER_LOCATION
                    '''
                }
            }
        }

        stage('License Diffblue CLI') {
            steps {
                withCredentials([file(credentialsId: 'diffblue-license', variable: 'LICENSE_FILE')]) {
                    echo "Applying Diffblue CLI license..."
                    sh '''
                        cp $LICENSE_FILE .dcover.license
                    '''
                }
            }
        }

        stage('Build') {
            steps {
                echo "Building the project..."
                sh 'mvn clean compile'
            }
        }

        stage('Generate Tests with Diffblue') {
            steps {
                echo "Generating tests with Diffblue CLI"
