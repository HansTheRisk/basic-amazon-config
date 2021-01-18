package sns.service.internal;

import sns.message.InternalMessage;
import sns.service.SnsMessagingService;

public abstract class InternalNotificationMessagingService extends SnsMessagingService {

    final String SUBJECT = "INTERNAL";

    public <T extends InternalMessage> void publish(String destinationName, T message) {
        super.publish(destinationName, SUBJECT, message);
    }

}
