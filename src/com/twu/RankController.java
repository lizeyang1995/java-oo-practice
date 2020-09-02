import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankController {
    private List<Integer> obtainedRanking;
    private List<Integer> allRankingPrices;
    private Map<Integer, String> eventNewRank;
    private List<String> deletedEvent;

    public RankController() {
        obtainedRanking = new ArrayList<>();
        allRankingPrices = new ArrayList<>();
        eventNewRank = new HashMap<>();
        this.deletedEvent = new ArrayList<>();
    }

    public List<Integer> getObtainedRanking() {
        return obtainedRanking;
    }

    public List<Integer> getAllRankingPrices() {
        return allRankingPrices;
    }

    public Map<Integer, String> getEventNewRank() {
        return eventNewRank;
    }

    public List<String> getDeletedEvent() {
        return deletedEvent;
    }

    public void bidding(int newRank, int originalRanking, String eventName, int price) {
        if (allRankingPrices.get(newRank - 1) < price) {
            System.out.println("竞价成功！");
            allRankingPrices.set(newRank - 1, price);
            allRankingPrices.set(originalRanking - 1, 0);
            obtainedRanking.set(originalRanking - 1, newRank);
            if (eventNewRank.containsKey(newRank)) {
                deletedEvent.add(eventNewRank.get(newRank));
            }
            eventNewRank.put(newRank, eventName);
        } else {
            System.out.println("竞价失败！");
        }
    }
}
