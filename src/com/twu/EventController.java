import java.util.*;

public class EventController {
    private List<Event> allEvents;
    private Set<String> allEventsName;
    private RankController rankController;
    private Event[] eventsSequence;

    EventController(RankController priceController) {
        this.allEvents = new ArrayList<>();
        this.allEventsName = new HashSet<>();
        this.rankController = priceController;
    }

    void addEvent(Event event) {
        String eventName = event.getEventName();
        if (allEventsName.add(eventName.toUpperCase())) {
            allEvents.add(event);
            rankController.getAllRankingPrices().add(0);
            rankController.getObtainedRanking().add(0);
            System.out.println("添加成功!");
        } else {
            System.out.println("该热搜已经存在，添加失败！");
        }
    }

    public int getEventRank(String eventName) {
        for (int index = 0; index < allEvents.size(); index++) {
            if (allEvents.get(index).getEventName().equals(eventName)) {
                return index + 1;
            }
        }
        return -1;
    }

    public Event getEventByName(String eventName) {
        for (Event event : allEvents) {
            if (event.getEventName().equals(eventName)) {
                return event;
            }
        }
        return null;
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
        adjustPurchasedEventPosition();
    }

    public void adjustPurchasedEventPosition() {
        Map<Integer, String> eventsNewRank = rankController.getEventsNewRank();
        for (Map.Entry<Integer, String> eventNewRank : eventsNewRank.entrySet()) {
            String eventName = eventNewRank.getValue();
            int originalRank = getEventRank(eventName);
            int newRank = eventNewRank.getKey();
            Event event = getEventByName(eventName);
            allEvents.set(newRank - 1, event);
            allEvents.remove(originalRank - 1);
        }
    }

    boolean increaseHeat(String eventName, int ticketsNumber) {
        for (Event event : allEvents) {
            if (event.getEventName().equals(eventName)) {
                int originalHeat = event.getHeat();
                if (event.isSuperEvent()) {
                    event.setHeat(originalHeat + ticketsNumber * 2);
                } else {
                    event.setHeat(originalHeat + ticketsNumber);
                }
                return true;
            }
        }
        System.out.println("该热搜不存在。。");
        return false;
    }
}
