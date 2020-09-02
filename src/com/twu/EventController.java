import java.util.*;

public class EventController {
    private List<Event> allEvents;
    private Set<String> allEventsName;

    public EventController() {
        this.allEvents = new ArrayList<>();
        this.allEventsName = new HashSet<>();
    }

    public void addEvent(String eventName) {
        Event event = new Event(eventName);
        if (allEventsName.add(eventName.toUpperCase())) {
            allEvents.add(event);
        }
    }

    public void removeEvent(String eventName) {
        for (int i = 0; i < allEvents.size(); i++) {
            if (allEvents.get(i).getEventName().equals(eventName)) {
                allEvents.remove(i);
            }
        }
    }

    public void showEvent() {
        sortingEvent(allEvents);
        for (int i = 0; i < allEvents.size(); i++) {
            System.out.println(i + 1 + " " + allEvents.get(i).getEventName() + " " + allEvents.get(i).getHeat());
        }
    }

    private void sortingEvent(List<Event> allEvents) {
        Collections.sort(allEvents, new Comparator<Event>() {
            @Override
            public int compare(Event event, Event anotherEvent) {
                return anotherEvent.getHeat() - event.getHeat();
            }
        });
    }

    public void increaseHeat(String eventName, int ticketsNumber) {
        for (int i = 0; i < allEvents.size(); i++) {
            if (allEvents.get(i).getEventName().equals(eventName)) {
                allEvents.get(i).setHeat(ticketsNumber);
            }
        }
    }
}
