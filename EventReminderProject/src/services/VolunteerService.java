package services;

import entities.Volunteer;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VolunteerService {
    private Connection connection;

    public VolunteerService() {
        this.connection = DatabaseConnection.getConnection();
    }

    public void addVolunteer(String name, String contactInfo, int eventId) {
        String sql = "INSERT INTO Volunteer (volunteerName, contactInfo, eventId) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, contactInfo);
            stmt.setInt(3, eventId);
            stmt.executeUpdate();
            System.out.println("Volunteer added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Volunteer> getVolunteersByEvent(int eventId) {
        List<Volunteer> volunteers = new ArrayList<>();
        String sql = "SELECT * FROM Volunteer WHERE eventId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, eventId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Volunteer volunteer = new Volunteer(
                    rs.getInt("volunteer_id"),
                    rs.getString("name"),
                    rs.getString("contact_info")
                );
                volunteers.add(volunteer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return volunteers;
    }

    public void updateVolunteer(int volunteerId, String newName, String newContactInfo) {
        String sql = "UPDATE Volunteer SET volunteerName = ?, contactInfo = ? WHERE volunteerId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, newName);
            stmt.setString(2, newContactInfo);
            stmt.setInt(3, volunteerId);
            stmt.executeUpdate();
            System.out.println("Volunteer updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeVolunteer(int volunteerId) {
        String sql = "DELETE FROM Volunteer WHERE volunteerId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, volunteerId);
            stmt.executeUpdate();
            System.out.println("Volunteer removed successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
