package jwh.greedy.BOJ2217;

import java.util.Scanner;
import java.util.*;

public class BOJ2217 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int input = 0;
        input = sc.nextInt();
        System.out.println(check(input));

    }

    static int check(int x) {

        int[] lope = new int[x];

        int max = 0;

        for (int i = 0; i < x; i++) {
            lope[i] = sc.nextInt();
        }

        Arrays.sort(lope);

        for (int i = x; i > 0; i--) {
            if (max < (lope[i - 1] * (x - i + 1))) {
                max = lope[i - 1] * (x - i + 1);
            }
        }

        return (max);

    }

}