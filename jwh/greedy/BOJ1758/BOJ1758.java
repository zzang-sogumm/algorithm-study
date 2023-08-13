package jwh.greedy.BOJ1758;

import java.util.*;

public class BOJ1758 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int input = 0;
        input = sc.nextInt();
        System.out.println(check(input));

    }

    static long check(int x) {

        long[] line = new long[x];

        long tip = 0;

        for (int i = 0; i < x; i++) {
            line[i] = sc.nextInt();
        }

        Arrays.sort(line);

        for (int i = x; i > 0; i--) {
            if (line[i - 1] - (x - i) >= 0) {
                tip = tip + line[i - 1] - (x - i);
            }
        }

        return (tip);
    }

}
