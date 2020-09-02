import java.util.ArrayList;
import java.util.List;

public class PriceController {
    private EventController eventController;
    private List<Integer> allRankingPrices;

    public PriceController(EventController eventController) {
        this.eventController = eventController;
        allRankingPrices = new ArrayList<>();
    }
}
