import java.util.ArrayList;
import java.util.List;

public class PriceController {
    private EventController eventController;
    private List<Integer> allRankingPrices;

    public PriceController(EventController eventController) {
        this.eventController = eventController;
        allRankingPrices = new ArrayList<>();
    }

    public boolean bidding(int newRank, int originalRanking, int price) {
        if (allRankingPrices.get(newRank - 1) < price) {
            System.out.println("购买成功！");
            allRankingPrices.set(newRank - 1, price);
            allRankingPrices.set(originalRanking - 1, 0);
            return true;
        }
        System.out.println("购买失败！");
        return false;
    }
}
