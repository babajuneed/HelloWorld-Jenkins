# HelloWorld-Jenkins CI/CD Pipeline

This project demonstrates a complete CI/CD pipeline setup for a Java application using Jenkins. The pipeline script, located in the **Jenkinsfile**, builds, tests, analyzes, scans, and deploys the application to an Apache Tomcat server.

## Overview

In this pipeline, we use Jenkins to automate the build, test, and deployment stages for a Java application. The pipeline includes integration with several essential tools for code quality, security, and deployment.

### Pipeline Stages
1. **Git Checkout**: Clones the code from the GitHub repository.
2. **Code Compile**: Compiles the Java application using Maven.
3. **Unit Test**: Runs unit tests to verify the functionality.
4. **SonarQube Analysis**: Checks code quality using SonarQube.
5. **Dependency Scan**: Scans for vulnerabilities using OWASP Dependency-Check.
6. **Code Build**: Packages the application as a `.war` file.
7. **Deploy to Tomcat**: Deploys the packaged `.war` file to the Tomcat server.

## Prerequisites

Ensure the following tools are installed and configured:
- **Jenkins**: For pipeline automation.
- **Java JDK 17**: Required for Java development.
- **Maven**: For building and managing Java project dependencies.
- **SonarQube**: For code quality analysis.
- **Apache Tomcat**: To host and deploy the application.
- **OWASP Dependency-Check Plugin**: For security scans in Jenkins.

## Getting Started

1. **Clone this repository:**
   ```bash
   git clone https://github.com/your-username/HelloWorld-Jenkins.git

2. **Import this project into Jenkins as a new pipeline job:**
   * Go to Jenkins Dashboard > New Item > Enter a name and select "Pipeline".
   * Configure the Git repository URL and specify the Jenkinsfile from this repository.
3. **Configure Jenkins tools under Manage Jenkins > Global Tool Configuration:**

   * Set up JDK, Maven, and SonarQube as per the pipeline requirements.
     
## Running the Pipeline
Once configured, trigger the pipeline by clicking Build Now in Jenkins. You’ll see each stage executing in sequence, providing a full CI/CD workflow.

## See Jenkinsfile
For the complete pipeline script, refer to the Jenkinsfile in this repository.
