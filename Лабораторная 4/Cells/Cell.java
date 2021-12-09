package Cells;

public class Cell {
    //параметры ячейки
    private boolean infection = false;   //заражена или нет
    private boolean immunity = false;    //имеет ли иммунитет
    private int period = 0;              //задаём время жизни
    private final int x;                     //координаты
    private final int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getPeriod() {
        return period;
    }

    protected void setPeriod(int period) {
        this.period = period;
    }

    protected void setImmunity(boolean immunity) {
        this.immunity = immunity;
    }

    public boolean isImmunity() {
        return immunity;
    }

    protected void setInfection(boolean infection) {
        this.infection = infection;
    }

    public boolean isInfection() {
        return infection;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //возвращаем значок элемента
    public String getIcon() {
        return "H";
    }

    //в данном случае ничего не делает, тк нужен для наследников
    public void tick() {
    }

}
