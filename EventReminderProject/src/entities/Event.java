package entities;

public class Event {
    private int eventId;
    private String eventName;
    private String eventDate;
    private String eventLocation;

    public Event(int eventId, String name, String date, String location) {
        this.eventId = eventId;
        this.eventName = name;
        this.eventDate = date;
        this.eventLocation = location;
    }

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getName() {
		return eventName;
	}

	public void setName(String name) {
		this.eventName = name;
	}

	public String getDate() {
		return eventDate;
	}

	public void setDate(String date) {
		this.eventDate = date;
	}

	public String getLocation() {
		return eventLocation;
	}

	public void setLocation(String location) {
		this.eventLocation = location;
	}

}
