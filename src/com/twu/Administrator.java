public class Administrator {
    private String administratorName;
    private EventController eventController;

    public Administrator(String administratorName, EventController eventController) {
        this.administratorName = administratorName;
        this.eventController = eventController;
    }

    public String getAdministratorName() {
        return administratorName;
    }

    public void addEvent(String eventName, boolean isSuperEvent) {
        Event event = new Event(eventName, isSuperEvent);
        eventController.addEvent(event);
    }

    public void showEvent() {
        eventController.showEvent();
    }
}
