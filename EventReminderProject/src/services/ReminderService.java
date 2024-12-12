package services;

import entities.Reminder;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReminderService {
    private Connection connection;

    public ReminderService() {
        this.connection = DatabaseConnection.getConnection();
    }

    public void addReminder(int eventId, String message, String reminderTime) {
        String sql = "INSERT INTO Reminder (eventId, message, reminderTime) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, eventId);
            stmt.setString(2, message);
            stmt.setString(3, reminderTime);
            stmt.executeUpdate();
            System.out.println("Reminder added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Reminder> getRemindersByEvent(int eventId) {
        List<Reminder> reminders = new ArrayList<>();
        String sql = "SELECT * FROM Reminder WHERE eventId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, eventId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Reminder reminder = new Reminder(
                    rs.getInt("reminderId"),
                    rs.getString("message"),
                    rs.getString("reminderTime")
                );
                reminders.add(reminder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reminders;
    }

    public void updateReminder(int reminderId, String newMessage, String newTime) {
        String sql = "UPDATE Reminder SET message = ?, reminderTime = ? WHERE reminderId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, newMessage);
            stmt.setString(2, newTime);
            stmt.setInt(3, reminderId);
            stmt.executeUpdate();
            System.out.println("Reminder updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeReminder(int reminderId) {
        String sql = "DELETE FROM Reminder WHERE reminderId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, reminderId);
            stmt.executeUpdate();
            System.out.println("Reminder removed successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
