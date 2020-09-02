public class User {
    private String userName;
    private int ticketsNumber;
    private EventController eventController;
    private RankController rankController;

    public User(String userName, EventController eventController, RankController rankController) {
        this.userName = userName;
        this.ticketsNumber = 10;
        this.eventController = eventController;
        this.rankController = rankController;
    }

    public String getUserName() {
        return userName;
    }

    public int getTicketsNumber() {
        return ticketsNumber;
    }

    public void showEvent() {
        eventController.showEvent();
    }

    public void addEvent(String eventName) {
        Event event = new Event(eventName);
        eventController.addEvent(event);
    }

    public void vote(String eventName, int ticketsNumber) {
        if (ticketsNumber <= this.ticketsNumber) {
            boolean isSuccess = eventController.increaseHeat(eventName, ticketsNumber);
            if (isSuccess) {
                this.ticketsNumber -= ticketsNumber;
                System.out.println("投票成功!");
            }
        } else {
            System.out.println("票数不够！");
        }
    }

    public void purchaseEvent(String eventName, int newRank, int price) {
        int eventRank = eventController.getEventRank(eventName);
        if (eventRank > -1 && eventRank != newRank) {
            rankController.bidding(newRank, eventRank, eventName, price);
        } else {
            System.out.println("购买失败！");
        }
    }
}
