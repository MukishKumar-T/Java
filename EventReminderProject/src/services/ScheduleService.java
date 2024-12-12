package services;

import entities.Schedule;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleService {
    private Connection connection;

    public ScheduleService() {
        this.connection = DatabaseConnection.getConnection();
    }

    public void addSchedule(int eventId, String startTime, String endTime) {
        String sql = "INSERT INTO Schedule (eventId, startTime, endTime) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, eventId);
            stmt.setString(2, startTime);
            stmt.setString(3, endTime);
            stmt.executeUpdate();
            System.out.println("Schedule added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Schedule> getSchedulesByEvent(int eventId) {
        List<Schedule> schedules = new ArrayList<>();
        String sql = "SELECT * FROM Schedule WHERE eventId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, eventId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Schedule schedule = new Schedule(
                    rs.getInt("scheduleId"),
                    rs.getString("startTime"),
                    rs.getString("endTime")
                );
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedules;
    }

    public void updateSchedule(int scheduleId, String newStartTime, String newEndTime) {
        String sql = "UPDATE Schedule SET startTime = ?, endTime = ? WHERE scheduleId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, newStartTime);
            stmt.setString(2, newEndTime);
            stmt.setInt(3, scheduleId);
            stmt.executeUpdate();
            System.out.println("Schedule updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeSchedule(int scheduleId) {
        String sql = "DELETE FROM Schedule WHERE scheduleId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, scheduleId);
            stmt.executeUpdate();
            System.out.println("Schedule removed successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
