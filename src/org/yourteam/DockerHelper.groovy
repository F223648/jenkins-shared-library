package org.yourteam

class DockerHelper implements Serializable {
    def script

    DockerHelper(script) {
        this.script = script
    }

    void buildImage(String name, String tag, String dockerfile = 'Dockerfile') {
        script.echo "Building Docker Image: ${name}:${tag} using ${dockerfile}"
        script.sh "docker build -t ${name}:${tag} -f ${dockerfile} ."
    }

    void pushImage(String name, String tag) {
        script.echo "Pushing Docker Image: ${name}:${tag}"
        script.sh "docker push ${name}:${tag}"
    }
}
