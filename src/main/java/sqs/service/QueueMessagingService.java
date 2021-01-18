package sqs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.Message;

public abstract class QueueMessagingService<T extends Message> {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    public void publish(String destinationName, T message) {
        queueMessagingTemplate.send(destinationName, message);
    }

    public T receive(String destinationName) {
        return (T) queueMessagingTemplate.receive(destinationName);
    }

}
