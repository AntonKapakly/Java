public class Skin {

    private final int width = 21;
    private final int height = 21;
    private Cell[][] array1 = createField();
    private Cell[][] array2 = createField();

    public void printField() {
        System.out.println();
        for (Cell[] arr: array1) {
            for (Cell item:arr) {
                System.out.print(item.getIcon() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private Cell[][] createField() {
        Cell[][] array = new Cell[width][height];
        for (int str=0; str<height;str++){
            for (int column=0; column<width;column++){
                array[str][column] = new Cell(str, column);
            }
        }
        array[(height-1)/2][(width-1)/2]=new InfectionCell((height-1)/2,(width-1)/2);
        return array;
    }

    public void nextGeneration() {
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                array2[i][j] = array1[i][j].nextGeneration(this);
        Cell[][] tmp = array1;
        array1 = array2;
        array2 = tmp;
    }

    protected Cell getCell(int x, int y) {
        return array1[x][y];
    }

    protected void setNext(int x, int y, Cell cell) {
        array2[x][y] = cell;
    }

    protected Cell getNext(int x, int y) {
        return array2[x][y];
    }

    protected int getWidth() {
        return width;
    }

    protected int getHeight() {
        return height;
    }

}
