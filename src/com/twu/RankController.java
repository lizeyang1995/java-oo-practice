import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankController {
    private List<Integer> obtainedRanking;
    private List<Integer> allRankingPrices;
    private List<Map<Integer, String>> eventsNewRank;
    private List<String> deletedEvent;

    public RankController() {
        obtainedRanking = new ArrayList<>();
        allRankingPrices = new ArrayList<>();
        eventsNewRank = new ArrayList<>();
        this.deletedEvent = new ArrayList<>();
    }

    public List<Integer> getObtainedRanking() {
        return obtainedRanking;
    }

    public List<Integer> getAllRankingPrices() {
        return allRankingPrices;
    }

    public List<Map<Integer, String>> getEventsNewRank() {
        return eventsNewRank;
    }

    public List<String> getDeletedEvent() {
        return deletedEvent;
    }

    public void bidding(int newRank, int originalRanking, String eventName, int price) {
        if (allRankingPrices.get(newRank - 1) < price) {
            System.out.println("竞价成功！");
            allRankingPrices.set(newRank - 1, price);
            allRankingPrices.set(originalRanking - 1, 0);
            Map<Integer, String> eventNewRank = new HashMap<>();
            eventNewRank.put(newRank, eventName);
            eventsNewRank.add(eventNewRank);
        } else {
            System.out.println("竞价失败！");
        }
    }
}
