public class Event {
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

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    void setHeat(int heat) {
        this.heat = heat;
    }

    public void setSuperEvent(boolean issuperEvent) {
        this.isSuperEvent = issuperEvent;
    }
}
