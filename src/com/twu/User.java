public class User {
    private String userName;
    private int ticketsNumber;
    private EventController eventController;

    public User(String userName) {
        this.userName = userName;
        this.ticketsNumber = 10;
        this.eventController = new EventController();
    }

    public void viewEvents() {
        eventController.showEvent();
    }

    public void addEvent(String eventName) {
        eventController.addEvent(eventName);
    }
}
