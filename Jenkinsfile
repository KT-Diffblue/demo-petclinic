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
            steps {Started by user kevin


                   Obtained Jenkinsfile from git https://github.com/KT-Diffblue/demo-spring-petclinic
                   org.codehaus.groovy.control.MultipleCompilationErrorsException: startup failed:
                   WorkflowScript: 65: expecting anything but ''\n''; got it anyway @ line 65, column 57.
                      rating tests with Diffblue CLI
                                                    ^

                   1 error

                   	at org.codehaus.groovy.control.ErrorCollector.failIfErrors(ErrorCollector.java:309)
                   	at org.codehaus.groovy.control.ErrorCollector.addFatalError(ErrorCollector.java:149)
                   	at org.codehaus.groovy.control.ErrorCollector.addError(ErrorCollector.java:119)
                   	at org.codehaus.groovy.control.ErrorCollector.addError(ErrorCollector.java:131)
                   	at org.codehaus.groovy.control.SourceUnit.addError(SourceUnit.java:349)
                   	at org.codehaus.groovy.antlr.AntlrParserPlugin.transformCSTIntoAST(AntlrParserPlugin.java:220)
                   	at org.codehaus.groovy.antlr.AntlrParserPlugin.parseCST(AntlrParserPlugin.java:191)
                   	at org.codehaus.groovy.control.SourceUnit.parse(SourceUnit.java:233)
                   	at org.codehaus.groovy.control.CompilationUnit$1.call(CompilationUnit.java:189)
                   	at org.codehaus.groovy.control.CompilationUnit.applyToSourceUnits(CompilationUnit.java:966)
                   	at org.codehaus.groovy.control.CompilationUnit.doPhaseOperation(CompilationUnit.java:626)
                   	at org.codehaus.groovy.control.CompilationUnit.processPhaseOperations(CompilationUnit.java:602)
                   	at org.codehaus.groovy.control.CompilationUnit.compile(CompilationUnit.java:579)
                   	at groovy.lang.GroovyClassLoader.doParseClass(GroovyClassLoader.java:323)
                   	at groovy.lang.GroovyClassLoader.parseClass(GroovyClassLoader.java:293)
                   	at PluginClassLoader for script-security//org.jenkinsci.plugins.scriptsecurity.sandbox.groovy.GroovySandbox$Scope.parse(GroovySandbox.java:163)
                   	at PluginClassLoader for workflow-cps//org.jenkinsci.plugins.workflow.cps.CpsGroovyShell.doParse(CpsGroovyShell.java:188)
                   	at PluginClassLoader for workflow-cps//org.jenkinsci.plugins.workflow.cps.CpsGroovyShell.reparse(CpsGroovyShell.java:173)
                   	at PluginClassLoader for workflow-cps//org.jenkinsci.plugins.workflow.cps.CpsFlowExecution.parseScript(CpsFlowExecution.java:650)
                   	at PluginClassLoader for workflow-cps//org.jenkinsci.plugins.workflow.cps.CpsFlowExecution.start(CpsFlowExecution.java:596)
                   	at PluginClassLoader for workflow-job//org.jenkinsci.plugins.workflow.job.WorkflowRun.run(WorkflowRun.java:339)
                   	at hudson.model.ResourceController.execute(ResourceController.java:101)
                   	at hudson.model.Executor.run(Executor.java:446)
                   Finished: FAILURE

                echo "Generating tests with Diffblue CLI"

