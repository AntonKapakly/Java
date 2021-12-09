package Cells;

public class InfectionCell extends Cell {
    //задаем в конструкторе период жизни клетки, координаты и устанавливаем иммунитет
    public InfectionCell(int x, int y) {
        super(x, y);
        setInfection(true);
        setPeriod(6);
    }

    //уменьшаем время жизни клетки
    @Override
    public void tick() {
        setPeriod(getPeriod() - 1);
    }

    @Override
    public String getIcon() {
        return "Z";
    }
}
