public class Card {

    private final int value;
    private int next = -1;

    public Card(int value) {
        this.value = value;
    }

    private final String[] values = {"6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private final String[] suits = {"clubs", "diamonds", "hearts", "spades"};

    public void print() {
        System.out.print(suits[value/9] + "_" + values[value%9] + ";");
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

}
