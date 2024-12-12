package entities;

public class Schedule {
    private int eventId;
    private String startTime;
    private String endTime;

    public Schedule(int eventId, String startTime, String endTime) {
        this.eventId = eventId;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
