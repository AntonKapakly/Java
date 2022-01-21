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
        Card card1 = cards[index];
        int next = card1.getNext();
        while (next != -1) {
            index = next;
            card1 = cards[index];
            next = card1.getNext();
        }
        card1.setNext(i);
    }

    public void print() {
        int next = start;
        while (next != -1) {
            Card card = cards[next];
            card.print();
            System.out.print(" ");
            next = card.getNext();
        }
        System.out.println("\n");
    }

}
