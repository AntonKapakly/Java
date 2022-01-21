public class InfectionCell extends ImmunityCell{

    public InfectionCell(int x, int y) {
        super(x, y);
        period = 6;
    }

    private InfectionCell(int x, int y, int period) {
        super(x, y);
        this.period = period;
    }

    @Override
    public Cell nextGeneration(Skin skin) {
        if (period == 1) return new ImmunityCell(x, y);
        int[][] points = {
                {x + 1, y + 1},
                {x - 1, y - 1},
                {x, y + 1},
                {x - 1, y},
                {x + 1, y - 1},
                {x - 1, y + 1},
                {x, y - 1},
                {x + 1, y},
                {x + 1, y + 1}
        };
        Cell cell;
        if (Math.random() > 0.5) {
            for (int[] point : points) {
                if (point[0] >= 0 && point[0] < skin.getWidth() && point[1] >= 0 && point[1] < skin.getHeight()) {
                    cell = skin.getCell(point[0], point[1]);
                    if (isInfected(cell)) {
                        skin.setNext(point[0], point[1], new InfectionCell(point[0], point[1]));
                        break;
                    }
                }
            }
        }
        return new InfectionCell(x, y, period - 1);
    }

    @Override
    public String getIcon() {
        return "Z";
    }

    @Override
    public boolean infected() {
        return true;
    }

    private boolean isInfected(Cell cell) {
        return cell.getInfected() && Math.random() > 0.5;
    }

}
