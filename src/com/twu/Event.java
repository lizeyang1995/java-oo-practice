import java.util.*;

public class Event {
    private List<Map<String, Integer>> allEvents;
    private Set<String> allEventsName;

    public Event() {
        this.allEvents = new ArrayList<>();
        this.allEventsName = new HashSet<>();
    }

    public void addEvent(String eventName) {
        Map<String, Integer> event = new HashMap<>();
        if (allEventsName.add(eventName.toUpperCase())) {
            event.put(eventName, 0);
            allEvents.add(event);
        }
    }

    public void removeEvent(String eventName) {
        for (int i = 0; i < allEvents.size(); i++) {
            if (allEvents.get(i).get(eventName) != null) {
                allEvents.remove(i);
            }
        }
    }
}
