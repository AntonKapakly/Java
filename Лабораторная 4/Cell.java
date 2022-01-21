public class Cell {

    protected final int x;
    protected final int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Cell nextGeneration(Skin skin) {
        if (skin.getNext(x, y).infected())
            return skin.getNext(x, y);
        return new Cell(x, y);
    }

    public boolean getInfected() {
        return true;
    }

    public boolean infected() {
        return false;
    }

    public String getIcon() {
        return ".";
    }

}

