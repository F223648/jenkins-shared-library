package org.yourteam

class NotificationService implements Serializable {
    def script

    NotificationService(script) {
        this.script = script
    }

    void sendSlack(String message, String color = 'good') {
        script.echo "Sending Slack Notification [${color}]: ${message}"
        // In a real environment with the Slack Plugin:
        // script.slackSend(color: color, message: message)
    }

    void sendEmail(String to, String subject, String body) {
        script.echo "Sending Email to ${to} | Subject: ${subject} | Body: ${body}"
        // In a real environment:
        // script.mail(to: to, subject: subject, body: body)
    }
}
