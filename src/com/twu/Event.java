import java.util.*;

public class Event {
    private List<Map<String, Integer>> allEvents = new ArrayList<>();
    private Set<String> allEventsName = new HashSet<>();

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
}
