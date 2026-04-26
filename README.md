# Jenkins Shared Library

This repository contains Groovy classes and global variables for use in Jenkins Pipelines.

## Structure
- `src/org/yourteam/NotificationService.groovy`: Provides Slack and Email notification capabilities.
- `src/org/yourteam/DockerHelper.groovy`: Provides Docker build and push wrapper capabilities.
- `vars/notifySlack.groovy`: Global variable to send a Slack message.
- `vars/buildAndPushImage.groovy`: Global variable to build and push Docker images.
- `vars/runSonarScan.groovy`: Global variable to execute a SonarQube scan.

## Usage

Load this library dynamically in your `Jenkinsfile`:

```groovy
@Library('jenkins-shared-library@main') _

pipeline {
    agent any
    stages {
        stage('Test Library') {
            steps {
                notifySlack(message: 'Testing library!', color: 'good')
                buildAndPushImage(name: 'myapp', tag: 'latest')
                runSonarScan(projectKey: 'myapp')
            }
        }
    }
}
```
