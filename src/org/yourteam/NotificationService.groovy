package org.yourteam

class NotificationService implements Serializable {
    def script

    NotificationService(script) {
        this.script = script
    }

    void sendSlack(String message, String color = 'good') {
        script.echo "Sending Slack Notification [${color}]: ${message}"
        
        // Use single quotes for the JSON payload to prevent shell expansion of brackets []
        def payload = "{\"attachments\": [{\"text\": \"${message}\", \"color\": \"${color}\"}]}"
        script.sh "curl -X POST -H 'Content-type: application/json' --data '${payload}' \"\$SLACK_WEBHOOK\""
    }

    void sendEmail(String to, String subject, String body) {
        script.echo "Sending Email to ${to} | Subject: ${subject} | Body: ${body}"
    }
}
