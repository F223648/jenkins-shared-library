package org.yourteam

class NotificationService implements Serializable {
    def script

    NotificationService(script) {
        this.script = script
    }

    void sendSlack(String message, String color = 'good') {
        script.echo "Sending Slack Notification [${color}]: ${message}"
        
        // Use curl to send the message to the webhook URL
        def payload = "{\"attachments\": [{\"text\": \"${message}\", \"color\": \"${color}\"}]}"
        script.sh "curl -X POST -H 'Content-type: application/json' --data '${payload}' ${script.env.SLACK_WEBHOOK}"
    }

    void sendEmail(String to, String subject, String body) {
        script.echo "Sending Email to ${to} | Subject: ${subject} | Body: ${body}"
    }
}
