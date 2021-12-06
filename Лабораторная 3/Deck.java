public class Deck {
    public int[] create () {
        int[] deck = new int[36];
        for (int i = 1; i < 37; i++)
            deck[i-1] = i;
        return deck;
    }

    public int[] mix (int[] deck) {
        int j;
        int randomPlace;
        int t;
        for (int i = 35; i > 0; i--){
            j = i - 1;
            randomPlace = (int) (Math.random()*j);
            t = deck[i];
            deck[i] = deck[randomPlace];
            deck[randomPlace] = t;
        }
        return deck;
    }

    public void print (int[] deck) {
        for (int i = 0; i < deck.length; i++)
            System.out.print(deck[i] + "; ");
        System.out.println();
    }
}
