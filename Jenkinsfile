pipeline {
    agent any
    tools {
        maven 'M3'
        //sonar 'sonar'
    }
    environment {
        SONAR_HOME = tool 'sonar'
    }
    stages {
        stage('Git Checkout') {
            steps {
                git changelog: false, poll: false, url: 'https://github.com/Atharsh2001/HelloWorld-Jenkins.git'
            }
        }
        stage('Code Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Unit Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonar-server') {
                    sh """
                        "${env.SONAR_HOME}/bin/sonar-scanner" \
                        -Dsonar.projectName=HelloWorld-Jenkins \
                        -Dsonar.java.binaries=. \
                        -Dsonar.projectKey=HelloWorld-Jenkins
                    """
                }
            }
        }
        stage('Dependency Scan') {
            steps {
                dependencyCheck additionalArguments: ' --scan ./', odcInstallation: 'owasp'
                dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
            }
        }
        stage('Code Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Deploy Artifact To Tomcat') {
            steps {
                sh 'cp %WORKSPACE%/target/helloworld-jenkins-3.3.5.war /var/lib/tomcat9/webapps/'
                sh 'sudo service tomcat9 restart'
            }
        }
    }
}
