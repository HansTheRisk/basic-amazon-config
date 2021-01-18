package sns.service.internal;

import sns.message.InternalMessage;
import sns.service.SnsMessagingService;

public abstract class InternalNotificationMessagingService<T extends InternalMessage> extends SnsMessagingService<T> {

    final String SUBJECT = "INTERNAL";

    protected void publish(String destinationName, T message) {
        super.publish(destinationName, SUBJECT, message);
    }

}
