package sns.message;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.io.Serializable;
import java.util.Collections;

public abstract class InternalMessage<T extends Object> implements Serializable, Message<T> {
    protected T payload;
    protected MessageHeaders messageHeaders;

    public InternalMessage(T payload) {
        this(payload, new MessageHeaders(Collections.EMPTY_MAP));
    }

    public InternalMessage(T payload, MessageHeaders messageHeaders) {
        this.payload = payload;
        this.messageHeaders = messageHeaders;
    }
}
