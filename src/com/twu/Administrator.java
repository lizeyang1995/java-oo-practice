class Administrator {
    private String administratorName;
    private EventController eventController;

    Administrator(String administratorName, EventController eventController) {
        this.administratorName = administratorName;
        this.eventController = eventController;
    }

    String getAdministratorName() {
        return administratorName;
    }

    void addEvent(String eventName, boolean isSuperEvent) {
        Event event = new Event(eventName, isSuperEvent);
        eventController.addEvent(event);
    }

    void showEvent() {
        eventController.showEvent();
    }
}
