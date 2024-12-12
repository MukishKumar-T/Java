package entities;

public abstract class Notification {
    private String message;

    public Notification(String message) {
        this.message = message;
    }

    public String getMessage() { return message; }
    public abstract void send();
}
