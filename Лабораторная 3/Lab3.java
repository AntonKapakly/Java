public class Lab3 {
    public static void main(String[] args) {
        Deck array = new Deck();
        Players playerFirst = new Players();
        Players playerSecond = new Players();
        int[] deck = array.create();
        System.out.println("Колода: ");
        array.print(deck);
        deck = array.mix(deck);
        System.out.println("Перемешанная колода: ");
        array.print(deck);
        System.out.println("Колода карт 1 игрока: ");
        playerFirst.getCards(1, deck);
        System.out.println("");
        System.out.println("Колода карт 2 игрока: ");
        playerSecond.getCards(2, deck);
    }
}
