package app;

import services.EventService;
import services.NotificationService;
import services.VolunteerService;

import java.util.Scanner;

public class EventReminderApp {
    public static void main(String[] args) {
        EventService eventService = new EventService();
        NotificationService notificationService = new NotificationService();
        VolunteerService volunteerService = new VolunteerService();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Event Reminder Application!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create Event");
            System.out.println("2. Remove Event");
            System.out.println("3. Schedule Notification");
            System.out.println("4. Send Notifications");
            System.out.println("5. Add Volunteer");
            System.out.println("6. Add Notification");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter event name: ");
                    String name = scanner.next();
                    System.out.print("Enter event date (yyyy-MM-dd): ");
                    String date = scanner.next();
                    System.out.print("Enter location: ");
                    String location = scanner.next();
                    eventService.createEvent(name, date, location);
                    break;
                case 2:
                    System.out.print("Enter event ID to remove: ");
                    int eventId = scanner.nextInt();
                    eventService.removeEvent(eventId);
                    break;
                case 5:
                    System.out.print("Enter Volunteer name");
                    String vname = scanner.next();
                    System.out.print("Enter Volunteer contactInfo");
                    String contact = scanner.next();
                    System.out.print("Enter event ID");
                    int eventid = scanner.nextInt();
                    volunteerService.addVolunteer(vname, contact, eventid);
                    break;
                case 6:
                	System.out.print("Enter eventId to send the notification:");
                    int notificationid = scanner.nextInt();
                    System.out.print("Enter message to be send as notification:");
                    String mess = scanner.next();
                    notificationService.addNotification(notificationid, mess);
                    break;
                case 3:
                    System.out.print("Enter notification ID to schedule: ");
                    int notificationId = scanner.nextInt();
                    notificationService.scheduleNotification(notificationId);
                    break;
                case 4:
                    notificationService.sendNotifications();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
