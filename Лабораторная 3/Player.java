public class Player {

    private Card[] cards = Deck.getCards();
    private int start = -1;

    public void addCard(Card card) {
        int index = start;
        int i = cards[card.getValue()].getValue();
        if (index == -1) {
            start = i;
            return;
        }
        Card c = cards[index];
        int next = c.getNext();
        while (next != -1) {
            index = next;
            c = cards[index];
            next = c.getNext();
        }
        c.setNext(i);
    }

    public void print() {
        int next = start;
        while (next != -1) {
            Card c = cards[next];
            c.print();
            System.out.print(" ");
            next = c.getNext();
        }
        System.out.println("\n");
    }

}
