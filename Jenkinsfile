pipeline {
    agent any
    tools {
        maven 'Maven 3.8.6'
        sonarqube 'SonarQube Scanner'
    }
    stages {
        stage('Verify Maven') {
            steps {
                sh 'mvn --version'
            }
        }
        stage('Build') {
            steps {
                sh 'echo "Hello World!"'
            }
        }
        stage('Unit Test') {
            steps {
                sh 
                    # Test Case 1: Check for Hello World
                    if [ "$(echo "Hello World!")" == "Hello World!" ]; then
                        echo "Test Case 1 Passed: Hello World!"
                    else
                        echo "Test Case 1 Failed: Hello World!"
                    fi

                    # Test Case 2: Check for Hello World with spaces
                    if [ "$(echo "  Hello World!  ")" == "  Hello World!  " ]; then
                        echo "Test Case 2 Passed: Hello World with spaces"
                    else
                        echo "Test Case 2 Failed: Hello World with spaces"
                    fi

                    # Test Case 3: Check for Hello World with uppercase
                    if [ "$(echo "HELLO WORLD!")" == "HELLO WORLD!" ]; then
                        echo "Test Case 3 Passed: Hello World with uppercase"
                    else
                        echo "Test Case 3 Failed: Hello World with uppercase"
                    fi

                    # Test Case 4: Check for Hello World with lowercase
                    if [ "$(echo "hello world!")" == "hello world!" ]; then
                        echo "Test Case 4 Passed: Hello World with lowercase"
                    else
                        echo "Test Case 4 Failed: Hello World with lowercase"
                    fi

                    # Test Case 5: Check for Hello World with special characters
                    if [ "$(echo "Hello World!@#$%^&*()")" == "Hello World!@#$%^&*()" ]; then
                        echo "Test Case 5 Passed: Hello World with special characters"
                    else
                        echo "Test Case 5 Failed: Hello World with special characters"
                    fi

                    # Test Case 6: Check for Hello World with numbers
                    if [ "$(echo "Hello World!1234567890")" == "Hello World!1234567890" ]; then
                        echo "Test Case 6 Passed: Hello World with numbers"
                    else
                        echo "Test Case 6 Failed: Hello World with numbers"
                    fi

                    for i in {1..6}; do
                        echo "Test $i completed!"
                        sleep 10
                    done
                
                sh 'echo "Unit testing completed!"'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn sonar:sonar'
                }
            }
        }
    }
    post {
        always {
            sh 'echo "Pipeline completed!"'
        }
        failure {
            mail to: 'your-email@example.com',
                 subject: 'Pipeline failed!',
                 body: 'The pipeline has failed. Please check the logs.'
        }
    }
}
