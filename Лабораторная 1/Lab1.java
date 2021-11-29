import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Введите кол-во первых простых пар с разностью 2: ");
        int N = s.nextInt();
        int n = 0;
        int p1 = 0;
        int p2 = 0;
        int a;
        int count = 0;
        while (n != N) {
            count += 1;
            a = 0;
            for (int j = 2; j <= count; j++)
                if (count % j == 0)
                    a += j;
            if (a == count) {
                if (p1 == 0)
                    p1 = count;
                else
                    p2 = count;
                if (p2 != 0)
                    if (p2 - p1 == 2) {
                        n += 1;
                        System.out.println(p1 + " " + p2);
                        p1 = count;
                    } else
                        p1 = count;
            }
        }
    }
}
