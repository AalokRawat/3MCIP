package design.stack.overflow;

public class Message {
    String messageId;
    MessageType type;
    String message;

    public Message(String messageId, MessageType type, String message) {
        this.messageId = messageId;
        this.type = type;
        this.message = message;
    }

    public String getMessageId() {
        return messageId;
    }

    public MessageType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
