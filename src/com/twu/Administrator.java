public class Administrator {
    private String administratorName;
    private EventController eventController;

    public Administrator(String administratorName) {
        this.administratorName = administratorName;
        this.eventController = new EventController();
    }

    public String getAdministratorName() {
        return administratorName;
    }

    public void addEvent(String eventName, boolean isSuperEvent) {
        Event event = new Event(eventName, isSuperEvent);
        eventController.addEvent(event);
    }
}
