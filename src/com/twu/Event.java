import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Event {
    static List<Map<String, Integer>> allEvents = new ArrayList<>();
    public static void addEvent(String eventName) {
        Map<String, Integer> event = new HashMap<>();
        event.put(eventName, 0);
        allEvents.add(event);
    }
}
