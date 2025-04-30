pipeline {
    agent any

    stages {
        stage('Checkout SCM') {
            steps {
                sshagent(['github-ssh']) {
                    sh '''
                        git clone git@github.com:KT-Diffblue/demo-spring-petclinic.git
                        cd demo-spring-petclinic
                        git checkout jenkins-pipeline
                    '''
                }
            }
        }

        stage('Use dcover cli in Jenkins') {
            steps {
                sshagent(['github-ssh']) {
                    sh '''
                        echo 'Running dcover to create and commit tests'
                        dcover/dcover ci activate build validate create
                    '''
                }
            }
        }
    }
}
