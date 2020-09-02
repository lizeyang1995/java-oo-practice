public class User {
    private String userName;
    private int ticketsNumber;
    private EventController eventController;

    public User(String userName) {
        this.userName = userName;
        this.ticketsNumber = 10;
        this.eventController = new EventController();
    }

    public void showEvent() {
        eventController.showEvent();
    }

    public void addEvent(String eventName) {
        eventController.addEvent(eventName);
    }

    public void increaseHeat(String eventName, int ticketsNumber) {
        if (ticketsNumber <= this.ticketsNumber) {
            eventController.increaseHeat(eventName, ticketsNumber);
            this.ticketsNumber -= ticketsNumber;
        } else {
            System.out.println("票数不够！");
        }
    }
}
