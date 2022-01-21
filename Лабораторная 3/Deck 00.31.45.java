public class Deck {

    private final int n = 36;
    private Card[] cards;
    private static Card[] deckOfCards;

    public Deck() {
        cards = new Card[n];
        deckOfCards = new Card[n];
        for (int i = 0; i < n; i++) {
            cards[i] = new Card(i);
            deckOfCards[i] = cards[i];
        }

    }

    public void printAll() {
        for(Card card : cards) {
            card.print();
            System.out.print(" ");
        }
        System.out.println("\n");
    }

    public void mix() {
        int randomPlace;
        for(int i = n-1; i > 0; i--) {
            randomPlace = (int) (Math.random()*(i+1));
            Card tmp = cards[i];
            cards[i] = cards[randomPlace];
            cards[randomPlace] = tmp;
        }
    }

    public static Card[] getCards() {
        return deckOfCards;
    }

    public void splitCards(Player p1, Player p2) {
        for (int i = 0; i < n - 1; i += 2) {
            p1.addCard(cards[i]);
            p2.addCard(cards[i + 1]);
        }
    }

}
