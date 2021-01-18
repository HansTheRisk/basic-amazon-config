package sqs.service.internal;

import org.springframework.messaging.Message;
import sns.message.InternalMessage;
import sqs.service.QueueMessagingService;

public abstract class InternalQueueMessagingService extends QueueMessagingService<InternalMessage> {

    protected void publish(String destinationName, InternalMessage message) {
        super.publish(destinationName, message);
    }

    protected InternalMessage receive(String destinationName) {
        Message<?> message = super.receive(destinationName);
        return new InternalMessage(message.getPayload(), message.getHeaders());
    }
}
