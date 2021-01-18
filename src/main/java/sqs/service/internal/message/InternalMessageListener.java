package sqs.service.internal.message;

import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import sns.message.InternalMessage;

public interface InternalMessageListener<T extends InternalMessage> {

    @SqsListener
    public void processMessage(T message, String senderId);

}
