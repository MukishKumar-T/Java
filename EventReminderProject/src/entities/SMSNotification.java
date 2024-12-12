package entities;

public class SMSNotification extends Notification {
    public SMSNotification(String message) {
        super(message);
    }

    @Override
    public void send() {
        System.out.println("Sending SMS Notification: " + getMessage());
    }
}
