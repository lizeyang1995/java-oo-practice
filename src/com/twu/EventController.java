import java.util.*;

public class EventController {
    private List<Event> allEvents;
    private Set<String> allEventsName;

    EventController() {
        this.allEvents = new ArrayList<>();
        this.allEventsName = new HashSet<>();
    }

    void addEvent(String eventName) {
        Event event = new Event(eventName);
        if (allEventsName.add(eventName.toUpperCase())) {
            allEvents.add(event);
        } else {
            System.out.println("该热搜已经存在，添加失败！");
        }
    }

    public void removeEvent(String eventName) {
        for (int i = 0; i < allEvents.size(); i++) {
            if (allEvents.get(i).getEventName().equals(eventName)) {
                allEvents.remove(i);
                return;
            }
        }
    }

    void showEvent() {
        sortingEvent(allEvents);
        for (int i = 0; i < allEvents.size(); i++) {
            System.out.println(i + 1 + " " + allEvents.get(i).getEventName() + " " + allEvents.get(i).getHeat());
        }
    }

    private void sortingEvent(List<Event> allEvents) {
        allEvents.sort(new Comparator<Event>() {
            @Override
            public int compare(Event event, Event anotherEvent) {
                return anotherEvent.getHeat() - event.getHeat();
            }
        });
    }

    void increaseHeat(String eventName, int ticketsNumber) {
        for (Event event : allEvents) {
            if (event.getEventName().equals(eventName)) {
                int originalHeat = event.getHeat();
                if (event.isSuperEvent()) {
                    event.setHeat(originalHeat + ticketsNumber * 2);
                } else {
                    event.setHeat(originalHeat + ticketsNumber);
                }
                return;
            }
        }
        System.out.println("该热搜不存在。。");
    }
}
