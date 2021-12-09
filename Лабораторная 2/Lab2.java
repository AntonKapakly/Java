import java.util.Scanner;

public class Lab2 {

    public static int rightBorder = 99;
    public static int leftBorder = -99;

    public static int[][] createArray (int N, int M) {
        int[][] array = new int[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                array[i][j] = (int) (Math.random()*(rightBorder-leftBorder + 1)) + leftBorder;
        return array;
    }

    public static int maxCol (int[][] array) {
        int maxItem = leftBorder - 1;
        int maxColumn = 0;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++)
                if (array[i][j] > maxItem) {
                    maxItem = array[i][j];
                    maxColumn = j;
                }
        return maxColumn;
    }

    public static int[][] delMaxCol (int[][] array, int maxColumn) {
        int key = 0;
        int[][] newArray = new int[array.length][array[0].length-1];
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++) {
                if (j == maxColumn) {
                    key = 1;
                    continue;
                }
                newArray[i][j-key] = array[i][j];
            }
        return newArray;
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++){
                System.out.printf("%10d", array[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner m = new Scanner(System.in);
        Scanner n = new Scanner(System.in);
        System.out.print("Введите кол-во строк M: ");
        int M = m.nextInt();
        System.out.print("Введите кол-во столбцов N: ");
        int N = n.nextInt();
        int[][] array = createArray(N, M);
        System.out.println("Исходная матрица:");
        printArray(array);
        int maxColumn = maxCol(array);
        array = delMaxCol(array, maxColumn);
        System.out.println("Новая матрица:");
        printArray(array);
    }
}
