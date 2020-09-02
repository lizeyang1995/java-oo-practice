import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankController {
    private List<Integer> obtainedRanking;
    private List<Integer> allRankingPrices;
    private Map<String, Integer> eventNewRank;

    public RankController() {
        obtainedRanking = new ArrayList<>();
        allRankingPrices = new ArrayList<>();
        eventNewRank = new HashMap<>();
    }

    public List<Integer> getObtainedRanking() {
        return obtainedRanking;
    }

    public List<Integer> getAllRankingPrices() {
        return allRankingPrices;
    }

    public void bidding(int newRank, int originalRanking, String eventName, int price) {
        if (allRankingPrices.get(newRank - 1) < price) {
            System.out.println("竞价成功！");
            allRankingPrices.set(newRank - 1, price);
            allRankingPrices.set(originalRanking - 1, 0);
            obtainedRanking.set(originalRanking - 1, newRank);
            eventNewRank.put(eventName, newRank);
        } else {
            System.out.println("竞价失败！");
        }
    }
}
