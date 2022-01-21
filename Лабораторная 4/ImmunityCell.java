public class ImmunityCell extends Cell {

    protected int period;

    public ImmunityCell(int x, int y) {
        super(x, y);
        period = 4;
    }

    private ImmunityCell(int x, int y, int period) {
        super(x,y);
        this.period = period;
    }

    @Override
    public Cell nextGeneration(Skin skin) {
        if (period == 1) return new Cell(x, y);
        return new ImmunityCell(x, y, period - 1);
    }

    @Override
    public String getIcon() {
        return "#";
    }

    @Override
    public boolean getInfected() {
        return false;
    }

}
