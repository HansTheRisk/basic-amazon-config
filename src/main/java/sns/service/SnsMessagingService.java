package sns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.messaging.support.GenericMessage;

public abstract class SnsMessagingService<T extends GenericMessage> {

    @Autowired
    private NotificationMessagingTemplate notificationMessagingTemplate;

    protected void publish(String destinationName, String subject, T message) {
        notificationMessagingTemplate.sendNotification(destinationName, message, subject);
    }

}
