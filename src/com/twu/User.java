public class User {
    private String userName;
    private int ticketsNumber;
    private EventController eventController;
    private PriceController priceController;

    public User(String userName, EventController eventController, PriceController priceController) {
        this.userName = userName;
        this.ticketsNumber = 10;
        this.eventController = eventController;
        this.priceController = priceController;
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
        if (eventRank > -1) {
            boolean bidSuccess = priceController.bidding(newRank, eventRank, price);
            if (!bidSuccess) {
                System.out.println("竞价失败！");
            }
        } else {
            System.out.println("你要购买的事件不存在！");
        }
    }
}
