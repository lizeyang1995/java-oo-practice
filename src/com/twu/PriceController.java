import java.util.ArrayList;
import java.util.List;

public class PriceController {
    private List<Integer> obtainedRanking;
    private List<Integer> allRankingPrices;

    public PriceController() {
        obtainedRanking = new ArrayList<>();
        allRankingPrices = new ArrayList<>();
    }

    public List<Integer> getObtainedRanking() {
        return obtainedRanking;
    }

    public List<Integer> getAllRankingPrices() {
        return allRankingPrices;
    }

    public boolean bidding(int newRank, int originalRanking, int price) {
        if (allRankingPrices.get(newRank - 1) < price) {
            System.out.println("购买成功！");
            allRankingPrices.set(newRank - 1, price);
            allRankingPrices.set(originalRanking - 1, 0);
            obtainedRanking.set(originalRanking - 1, newRank);
            return true;
        }
        System.out.println("购买失败！");
        return false;
    }
}
