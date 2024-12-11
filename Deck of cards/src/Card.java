import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public record Card(Suit suit, String face, int rank) {
    public enum Suit{
        CLUB, DIAMOND, HEARD, SPADE;

        public char getImage(){
            return (new char[]{9827,9830,9829,9824})[this.ordinal()];
        }
    }

    @Override
    public String toString() {
        int index = face.equals("10") ? 2:1;
        String faceString = face.substring(0, index);
        return "%s%c(%d)".formatted(faceString, suit.getImage(), rank);
    }

    public static  Card getNumbericCard(Suit suit, int cardNumber){
//        if(cardNumber >1 && cardNumber<11){
//            return new Card(suit, String.valueOf(cardNumber), cardNumber-2);
//        }
        switch (cardNumber){
            case 9:
                if(cardNumber == 9 && SantaseGame.isTrump()){
                    return new Card(suit, String.valueOf(cardNumber), 14);
                }
                return new Card(suit, String.valueOf(cardNumber), 2);
            case 10:
                return new Card(suit, String.valueOf(cardNumber), 10);
            default:
                System.out.println("Invalid Numeric card selected!");
                return null;
        }

    }

    public static Card getFaceCard(Suit suit, char abbrev){
//        int charIndex = "JQKA".indexOf(abbrev);
//        if(charIndex > -1){
//            return new Card(suit, ""+abbrev, charIndex+9);
//        }
        switch(abbrev){
            case 'J':
                return new Card(suit, "" + abbrev, 2);
            case 'Q':
                return new Card(suit, "" + abbrev, 3);
            case 'K':
                return new Card(suit, "" + abbrev, 4);
            case 'A':
                return new Card(suit, "" + abbrev, 11);
            default:
                System.out.println("Invalid Face card selected!");
                return null;
        }
    }

    public static List<Card> getStandardDeck(){
        List<Card> deck = new ArrayList<>(52);
        for(Suit suit : Suit.values()){
            for(int i = 9; i<=10; i++){
                deck.add(getNumbericCard(suit, i));
            }
            for(char c : new char[]{'J','Q','K','A'}){
                deck.add(getFaceCard(suit, c));
            }
        }
        return deck;
    }

    public static void printDeck(List<Card> deck){
        printDeck(deck, "Current deck:", 4);
    }

    public static void printDeck(List<Card> deck, String description, int rows){
        System.out.println("-".repeat(25));
        if(description != null) System.out.println(description);

        int cardsInRows = deck.size() / rows;
        for(int i = 0; i< rows; i++){
            int startIndex = i * cardsInRows;
            int endIndex = startIndex + cardsInRows;
            deck.subList(startIndex, endIndex).forEach(c -> System.out.print(c + " "));
            System.out.println();
        }
    }

}
