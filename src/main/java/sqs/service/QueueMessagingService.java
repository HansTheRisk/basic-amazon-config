package sqs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

public abstract class QueueMessagingService<T extends GenericMessage> {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    protected void publish(String destinationName, T message) {
        queueMessagingTemplate.send(destinationName, message);
    }

    protected Message<?> receive(String destinationName) {
        return queueMessagingTemplate.receive(destinationName);
    }

}
