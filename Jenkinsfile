pipeline {
  agent any
  stages {
    stage('Git Checkout') {
      steps {
        git 'https://github.com/babajuneed/HelloWorld-Jenkins.git'
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
        junit(testResults: 'target/surefire-reports/TEST-*.xml', keepProperties: true, keepTestNames: true)
      }
    }

    stage('Code Build') {
      steps {
        sh 'mvn clean install'
        archiveArtifacts 'target/helloworld-jenkins-*.war'
      }
    }

    stage('Deploy Artifact To Tomcat') {
      steps {
        sh 'cp /var/lib/jenkins/workspace/Blue_Ocean_Jenkins_pipeline_main/target/helloworld-jenkins-3.3.5.war /var/lib/apache-tomcat-10.1.34/webapps/'
        sh 'sudo systemctl status tomcat'
      }
    }

  }
  tools {
    maven 'M3'
  }
}