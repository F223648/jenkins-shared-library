def call(Map config) {
    if (!config.projectKey) {
        error "runSonarScan: 'projectKey' parameter is required."
    }
    
    echo "Running SonarQube Scanner for ${config.projectKey}"
    // withSonarQubeEnv expects a configured SonarQube Server in Jenkins
    withSonarQubeEnv('sonar-server') {
        sh """
        sonar-scanner \
          -Dsonar.projectKey=${config.projectKey} \
          -Dsonar.sources=app/ \
          -Dsonar.javascript.lcov.reportPaths=app/coverage/lcov.info \
          -Dsonar.host.url=${env.SONAR_HOST_URL} \
          -Dsonar.login=${env.SONAR_AUTH_TOKEN}
        """
    }
}
