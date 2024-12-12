package services;

import entities.Event;
import exceptions.EventNotFoundException;
import utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventService {
    private Connection connection;

    public EventService() {
        this.connection = DatabaseConnection.getConnection();
    }

    public void createEvent(String name, String date, String location) {
        String sql = "INSERT INTO Event (eventName, eventDate, eventLocation) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, date);
            stmt.setString(3, location);
            stmt.executeUpdate();
            System.out.println("Event created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeEvent(int eventId) {
        String sql = "DELETE FROM Event WHERE eventId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, eventId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new EventNotFoundException("Event with ID " + eventId + " not found.");
            }
            System.out.println("Event removed successfully.");
        } catch (SQLException | EventNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
