public class Players {
    public void getCards (int c, int[] deck) {
        for (int i = -1 + c; i < 36; i += 2)
            System.out.print(deck[i] + "; ");
    }
}
