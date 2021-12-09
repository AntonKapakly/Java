import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Введите кол-во первых простых пар с разностью 2: ");
        int N = s.nextInt();
        int n = 0;
        int p1 = 0;
        int p2 = 0;
        int count = 3;
        int t;
        boolean key;
        while (n != N) {
            key = true;
            for (int j = 3; j < count; j += 2)
                if (count % j == 0) {
                    key = false;
                    break;
                }
            if (key) {
                t = p2;
                p2 = count;
                p1 = t;
                if (p2 - p1 == 2) {
                    n++;
                    System.out.println(p1 + " " + p2);
                }
            }
            count += 2;
        }
    }
}
