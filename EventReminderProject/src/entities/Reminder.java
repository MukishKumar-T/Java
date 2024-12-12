package entities;

import interfaces.Notifiable;

public class Reminder implements Notifiable {
    private int reminderId;
    private String message;
    private String reminderTime;

    public Reminder(int reminderId, String message, String time) {
        this.reminderId = reminderId;
        this.message = message;
        this.reminderTime = time;
    }

    @Override
    public void sendReminder() {
        System.out.println("Sending reminder: " + message + " at " + reminderTime);
    }

    @Override
    public void scheduleNotification() {
        System.out.println("Scheduling reminder notification at " + reminderTime);
    }

    @Override
    public void updateNotificationStatus() {
        System.out.println("Updating reminder notification status.");
    }
}
