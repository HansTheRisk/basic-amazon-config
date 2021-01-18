package sns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;

public abstract class SnsMessagingService {

    @Autowired
    private NotificationMessagingTemplate notificationMessagingTemplate;

    public <T extends Serializable> void publish(String destinationName, String subject, T message) {
        notificationMessagingTemplate.sendNotification(destinationName, message, subject);
    }

}
