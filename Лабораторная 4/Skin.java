import Cells.*;

public class Skin {
    private final int width = 21;
    private final int height = 21;

    private final Cell[][] field = new Cell[height][width];

    public void createField() {
        for (int str = 0; str < height; str++) {
            for (int column = 0; column < width; column++) {
                field[str][column] = new Cell(column, str);
            }

        }
        //устанавливаем в среднюю ячейку зараженную клетку
        field[(height - 1) / 2][(width - 1) / 2] = new InfectionCell((height - 1) / 2, (width - 1) / 2);
    }

    public void printField() {
        System.out.println();
        for (Cell[] arr : field) {
            for (Cell item : arr) {
                System.out.print(item.getIcon() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private Cell getCell(int x, int y) {
        return field[y][x];
    }

    //вывод ячеек, которые заражаются за одну итерацию
    private Cell[] epidemicEffect() {
        /*
        массив, где будут храниться измененные значения, длина массива именно такая,
         тк неизвестно сколько ячеек будет заражено, поэтому ставим
         максимальное значение для нашего поля
        */
        Cell[] infectionCells = new Cell[field.length * field[0].length];
        //счетчик количества инфицированный ячеек
        int cellCounter = 0;
        //перебор ячеек в поле
        for (Cell[] arr : field) {
            for (Cell item : arr) {
                //если ячейка инфицирована, то выбираем ячейки в «зоне риска»
                if (item.isInfection()) {
                    int x = item.getX();
                    int y = item.getY();
                    int[][] points = {
                            {x - 1, y - 1},
                            {x - 1, y},
                            {x - 1, y + 1},
                            {x, y - 1},
                            {x, y + 1},
                            {x + 1, y - 1},
                            {x + 1, y},
                            {x + 1, y + 1},
                    };

                    Cell newInfection;
                    for (int[] point : points) {
                        /*
                        определяем существует ли такая ячейка или нет, если да, то рандомим:
                         будет ли новая клетка заражена или нет
                        */
                        if (point[0] >= 0 && point[0] < width && point[1] >= 0 && point[1] < height) {
                            if (Math.random() > 0.5) {
                                newInfection = getCell(point[0], point[1]);
                                infectionCells[cellCounter] = newInfection;
                                cellCounter++;
                                break;
                            }
                        }
                    }

                }

            }
        }
        //возвращаем только заполненные элементы массива infectionCells
        Cell[] addedCells = new Cell[cellCounter];
        for (int cellNum = 0; cellNum < cellCounter; cellNum++) {
            addedCells[cellNum] = infectionCells[cellNum];
        }

        return addedCells;
    }

    public void epidemicTick() {
        //получаем новые зараженные клетки
        Cell[] addedCells = epidemicEffect();
        for (int str = 0; str < height; str++) {
            for (int column = 0; column < width; column++) {
                field[str][column].tick();
                //перебираем новые зараженные клетки
                for (Cell cell : addedCells) {
                    //если координаты клетки из поля совпадают с зараженной, то начинаем с ней работать
                    if (cell.getX() == column && cell.getY() == str) {
                        //если у нее нет иммунитета и в прошлый период она не заражена, то заражаем
                        if (!cell.isImmunity() && !cell.isInfection()) {
                            field[str][column] = new InfectionCell(column, str);
                        }
                        break;
                    }

                }
                //если у клетки истек иммунитет, то превращаем ее в обычную клетку
                if (field[str][column].isImmunity() && field[str][column].getPeriod() == 0) {
                    field[str][column] = new Cell(str, column);
                }
                //если у клетки истек период заражения, то даём ей иммунитет
                if (field[str][column].isInfection() && field[str][column].getPeriod() == 0) {
                    field[str][column] = new ImmunityCell(str, column);
                }

            }
        }
    }

}
