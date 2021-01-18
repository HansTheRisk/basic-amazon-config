package sqs.service.internal;

import sns.message.InternalMessage;
import sqs.service.QueueMessagingService;

public abstract class InternalQueueMessagingService<T extends InternalMessage> extends QueueMessagingService<T> {

    public void publish(String destinationName, T message) {
        super.publish(destinationName, message);
    }

    public T receive(String destinationName) {
        return super.receive(destinationName);
    }
}
