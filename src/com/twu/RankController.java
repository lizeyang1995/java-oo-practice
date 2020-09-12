import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RankController {
    private List<Integer> allRankingPrices;
    private Map<Integer, String> eventsNewRank;

    RankController() {
        allRankingPrices = new ArrayList<>();
        eventsNewRank = new HashMap<>();
    }

    List<Integer> getAllRankingPrices() {
        return allRankingPrices;
    }

    Map<Integer, String> getEventsNewRank() {
        return eventsNewRank;
    }

    void bidding(int newRank, int originalRanking, String eventName, int price) {
        if (allRankingPrices.get(newRank - 1) < price) {
            System.out.println("竞价成功！");
            allRankingPrices.set(newRank - 1, price);
            allRankingPrices.set(originalRanking - 1, 0);
            adjustEventNewRank(newRank, eventName);
        } else {
            System.out.println("竞价失败！");
        }
    }

    private void adjustEventNewRank(int newRank, String eventName) {
        eventsNewRank.put(newRank, eventName);
    }
}
