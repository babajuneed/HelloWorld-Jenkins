pipeline {
    agent any

    tools {
        maven 'M3'
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
                bat 'mvn clean compile'
            }
        }

        stage('Unit Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
               withSonarQubeEnv('sonar-server') {
                    bat """
                        "${env.SONAR_HOME}\\bin\\sonar-scanner" ^
                        -Dsonar.projectName=HelloWorld-Jenkins ^
                        -Dsonar.java.binaries=. ^
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
                bat 'mvn clean install'
            }
        }

        stage('Deploy Artifact To Tomcat') {
            steps {
                bat 'copy "%WORKSPACE%\\target\\helloworld-jenkins-3.3.5.war" "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\"'
                bat 'net stop Tomcat9 && net start Tomcat9'
            }
        }
    }
}
