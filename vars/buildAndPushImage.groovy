import org.yourteam.DockerHelper

def call(Map config) {
    if (!config.name || !config.tag) {
        error "buildAndPushImage: 'name' and 'tag' parameters are required."
    }
    
    String dockerfile = config.dockerfile ?: 'Dockerfile'
    
    DockerHelper docker = new DockerHelper(this)
    docker.buildImage(config.name, config.tag, dockerfile)
    docker.pushImage(config.name, config.tag)
}
