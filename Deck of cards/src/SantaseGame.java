import java.util.*;

public class SantaseGame {
    private final List<Card> deck = Card.getStandardDeck();
    private final int playerCount = 2;
    private int cardsInHand;
    private Card.Suit trumpSuit;
    private static boolean trump = false;
    private List<SantaseHand> santaseHands;
    private List<Card> remainingCards;

    public SantaseGame(int cardsInHand) {
        this.cardsInHand = cardsInHand;
        santaseHands = new ArrayList<>(cardsInHand);
    }

    public static boolean isTrump(){
        return trump;
    }

    public void startPlay(){
        Collections.shuffle(deck);
        int randomMiddle = new Random().nextInt(12,24);
        Collections.rotate(deck, randomMiddle);
        Card.printDeck(deck);

        int cardsDealt = playerCount * cardsInHand;

        if(deck.size() <= cardsDealt){
            throw new IllegalStateException("Not enough cards to determine trump.");
        }

        Card trumpCard = deck.get(cardsDealt);
        trumpSuit = trumpCard.suit();
        trump = true;
        remainingCards = new ArrayList<>(deck.subList(cardsDealt + 1, deck.size()));

        System.out.println("Trump: " +trumpCard + "; Trump suit: " +trumpSuit);
        Collections.swap(remainingCards, 0, remainingCards.size()-1);
        Card.printDeck(remainingCards, "Remaining cards:", 4);

        handRank();
        System.out.println("-".repeat(25));
    }


    public void handRank(){
        if (deck.size() < playerCount * cardsInHand) {
            throw new IllegalStateException("Not enough cards in the deck to deal.");
        }

        Card[][] hands = new Card[playerCount][cardsInHand];
        for(int deckIndex = 0, i = 0; i < cardsInHand; i++){
            for(int j = 0; j < playerCount; j++){
                hands[j][i] = deck.get(deckIndex++);
            }
        }
        int playerNo = 1;
        for (Card[] hand : hands){
            santaseHands.add(new SantaseHand(playerNo++, Arrays.asList(hand)));
        }
        System.out.println();
        avgWinChance(hands);
    }


    public void avgWinChance(Card[][] hands){
        if (trumpSuit == null) {
            throw new IllegalStateException("Trump suit has not been set.");
        }

        int[] scores = new int[playerCount];
        for(int i = 0; i < playerCount; i++){
            List<Card> hand = Arrays.asList(hands[i]);
            for(Card card : hand){
                scores[i] += card.rank();
            }
            Card kingTrump = Card.getFaceCard(trumpSuit, 'K');
            Card queenTrump = Card.getFaceCard(trumpSuit, 'Q');
            if(hand.contains(kingTrump) && hand.contains(queenTrump)){
                scores[i] += 40;
            }

            System.out.println("Player %d. Rank:%d %-40s".formatted(i+1, scores[i], hand));
        }

        int totalScore = Arrays.stream(scores).sum();
        if (totalScore == 0) {
            System.out.println("No points scored. Win chances are equal.");
            return;
        }

        System.out.println("-".repeat(25));

        for(int i = 0; i < playerCount; i++){
            double winChance = ((double) scores[i] / totalScore) * 100;
            System.out.printf("Player %d Win Chance: %.2f%%\n", i+1, winChance);
        }
    }
}
