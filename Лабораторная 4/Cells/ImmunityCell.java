package Cells;

public class ImmunityCell extends Cell {
    //задаем в конструкторе период жизни клетки, координаты и устанавливаем иммунитет
    public ImmunityCell(int x, int y) {
        super(x, y);
        setImmunity(true);
        setPeriod(4);
    }

    //уменьшаем время жизни клетки
    @Override
    public void tick() {
        setPeriod(getPeriod() - 1);
    }

    //возвращаем значок элемента
    @Override
    public String getIcon() {
        return "I";
    }
}
