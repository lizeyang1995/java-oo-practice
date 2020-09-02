import java.util.ArrayList;
import java.util.List;

public class PriceController {
    private List<Integer> obtainedRanking;
    private List<Integer> allRankingPrices;

    public PriceController(EventController eventController) {
        obtainedRanking = new ArrayList<>();
        allRankingPrices = new ArrayList<>();
    }

    public boolean bidding(int newRank, int originalRanking, int price) {
        if (allRankingPrices.get(newRank - 1) < price) {
            System.out.println("购买成功！");
            allRankingPrices.set(newRank - 1, price);
            allRankingPrices.set(originalRanking - 1, 0);
            obtainedRanking.set(originalRanking, newRank);
            return true;
        }
        System.out.println("购买失败！");
        return false;
    }
}
