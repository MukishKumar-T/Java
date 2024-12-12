package entities;

import interfaces.Notifiable;

public class Volunteer implements Notifiable {
    private int volunteerId;
    private String volunteerName;
    private String contactInfo;

    public Volunteer(int volunteerId, String name, String contactInfo) {
        this.volunteerId = volunteerId;
        this.volunteerName = name;
        this.contactInfo = contactInfo;
    }

    @Override
    public void sendReminder() {
        System.out.println("Sending reminder to volunteer: " + volunteerName);
    }

    @Override
    public void scheduleNotification() {
        System.out.println("Scheduling notification for volunteer: " + volunteerName);
    }

    @Override
    public void updateNotificationStatus() {
        System.out.println("Updating notification status for volunteer: " + volunteerName);
    }
}
