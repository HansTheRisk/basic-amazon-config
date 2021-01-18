package sns.message;

import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;

import java.util.Collections;

public class InternalMessage<T extends Object> extends GenericMessage<T> {

    public InternalMessage(T payload) {
        this(payload, new MessageHeaders(Collections.EMPTY_MAP));
    }

    public InternalMessage(T payload, MessageHeaders messageHeaders) {
        super(payload, messageHeaders);
    }
}
