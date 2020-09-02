import java.util.*;

public class EventController {
    private List<Event> allEvents;
    private Set<String> allEventsName;
    private PriceController priceController;

    EventController(PriceController priceController) {
        this.allEvents = new ArrayList<>();
        this.allEventsName = new HashSet<>();
        this.priceController = priceController;
    }

    void addEvent(Event event) {
        String eventName = event.getEventName();
        if (allEventsName.add(eventName.toUpperCase())) {
            allEvents.add(event);
            priceController.getAllRankingPrices().add(0);
            priceController.getObtainedRanking().add(0);
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
        List<Integer> obtainedRanking = priceController.getObtainedRanking();
        for (int index = 0; index < obtainedRanking.size(); index++) {
            Integer newRank = obtainedRanking.get(index);
            if (newRank > 0) {
                Event eventsToBeAdjusted = allEvents.get(index);
                allEvents.set(newRank - 1, eventsToBeAdjusted);
                allEvents.remove(index);
                obtainedRanking.set(index, 0);
            }
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
