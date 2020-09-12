class Event {
    private String eventName;
    private int heat;
    private boolean isSuperEvent;

    Event(String eventName) {
        this.eventName = eventName;
        this.heat = 0;
    }

    Event(String eventName, boolean isSuperEvent) {
        this.eventName = eventName;
        this.isSuperEvent = isSuperEvent;
        this.heat = 0;
    }

    String getEventName() {
        return eventName;
    }

    int getHeat() {
        return heat;
    }

    boolean isSuperEvent() {
        return isSuperEvent;
    }

    void setHeat(int heat) {
        this.heat = heat;
    }
}
