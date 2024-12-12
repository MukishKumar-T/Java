package entities;

public class EmailNotification extends Notification {
    public EmailNotification(String message) {
        super(message);
    }

    @Override
    public void send() {
        System.out.println("Sending Email Notification: " + getMessage());
    }
}
