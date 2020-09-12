class User {
    private String userName;
    private int ticketsNumber;
    private EventController eventController;
    private RankController rankController;

    User(String userName, EventController eventController, RankController rankController) {
        this.userName = userName;
        this.ticketsNumber = 10;
        this.eventController = eventController;
        this.rankController = rankController;
    }

    String getUserName() {
        return userName;
    }

    int getTicketsNumber() {
        return ticketsNumber;
    }

    void showEvent() {
        eventController.showEvent();
    }

    void addEvent(String eventName) {
        Event event = new Event(eventName);
        eventController.addEvent(event);
    }

    void vote(String eventName, int ticketsNumber) {
        if (ticketsNumber <= this.ticketsNumber) {
            boolean isSuccess = eventController.increaseHeat(eventName, ticketsNumber);
            if (isSuccess) {
                this.ticketsNumber -= ticketsNumber;
                System.out.println("投票成功!");
                eventController.adjustPositionAfterVoting(eventName);
            }
        } else {
            System.out.println("票数不够！");
        }
    }

    void purchaseEvent(String eventName, int newRank, int price) {
        boolean becauseOfBuying = true;
        int eventRank = eventController.getEventRank(eventName);
        if (eventRank > -1 && eventRank != newRank) {
            rankController.bidding(newRank, eventRank, eventName, price);
            eventController.adjustPurchasedEventPosition(becauseOfBuying);
        } else {
            System.out.println("购买失败！");
        }
    }
}
