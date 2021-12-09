public class Main {
    public static void main(String[] args) {
        Skin skin = new Skin();
        skin.createField();
        int counter = 21;
        for (int i = 0; i < counter; i++) {
            skin.printField();
            skin.epidemicTick();
        }
    }
}
