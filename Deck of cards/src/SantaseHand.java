import java.util.ArrayList;
import java.util.List;

public class SantaseHand {
    private List<Card> hand;
    private static int playerNo;

    public SantaseHand(int playerNo, List<Card> hand) {
        this.playerNo = playerNo;
        this.hand = hand;
    }

    public static int getPlayerNo(){
        return playerNo;
    }

}
