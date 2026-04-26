import org.yourteam.NotificationService

def call(Map config) {
    if (!config.message) {
        error "notifySlack: 'message' parameter is required."
    }
    
    String color = config.color ?: 'good'
    
    NotificationService notifier = new NotificationService(this)
    notifier.sendSlack(config.message, color)
}
