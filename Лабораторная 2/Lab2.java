import java.util.Scanner;
import java.util.Arrays;

public class Lab2 {

    public static int[][] createArray (int N, int M) {
        int[][] array = new int[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                array[i][j] = (int) (Math.random()*(99*2 + 1)) - 99;
        return array;
    }

    public static int maxCol (int[][] array, int N, int M) {
        int maxItem = -100;
        int maxColumn = 0;
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                if (array[i][j] > maxItem) {
                    maxItem = array[i][j];
                    maxColumn = j;
                }
        return maxColumn;
    }

    public static int[][] delMaxCol (int N, int M, int maxCollumn, int[][] array) {
        int[][] newArray = new int[M][N-1];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++) {
                if (j == maxCollumn)
                    continue;
                if (j > maxCollumn)
                    newArray[i][j-1] = array[i][j];
                else
                    newArray[i][j] = array[i][j];
            }
        return newArray;
    }

    public static void main(String[] args) {
        Scanner m = new Scanner(System.in);
        Scanner n = new Scanner(System.in);
        System.out.print("Введите кол-во строк M: ");
        int M = m.nextInt();
        System.out.print("Введите кол-во столбцов N: ");
        int N = n.nextInt();
        int[][] array = createArray(N, M);
        System.out.println(Arrays.deepToString(array));
        int maxColumn = maxCol(array, N, M);
        int[][] newArray = delMaxCol(N, M, maxColumn, array);
        System.out.println(Arrays.deepToString(newArray));
    }
}
