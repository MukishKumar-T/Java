package services;

import entities.Notification;
import entities.EmailNotification;
import entities.SMSNotification;
import interfaces.Notifiable;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NotificationService {
    private List<Notification> notifications;
    private HashMap<Integer, Notifiable> notificationMap;
	private Connection connection;

    public NotificationService() {
    	this.connection = DatabaseConnection.getConnection();
        notifications = new ArrayList<>();
        notificationMap = new HashMap<>();
        notifications.add(new EmailNotification("Email notification for event."));
        notifications.add(new SMSNotification("SMS notification for event."));
    }
    public void addNotification(int eventid, String message) {
        String sql = "INSERT INTO Notification (eventId, message) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, eventid);
            stmt.setString(2, message);
            stmt.executeUpdate();
            System.out.println("Notification added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void sendNotifications() {
        for (Notification notification : notifications) {
            new Thread(notification::send).start();
        }
    }

    public void scheduleNotification(int notificationId) {
        Notifiable notifiable = notificationMap.get(notificationId);
        if (notifiable != null) {
            notifiable.scheduleNotification();
        } else {
            System.out.println("Notification ID " + notificationId + " not found.");
        }
    }
}
