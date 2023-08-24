package jwh.brute_force.BOJ2798;

import java.util.Scanner;

public class BOJ2798 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int input = 0;
        input = sc.nextInt();
        System.out.println(check(input));

    }

    static int check(int x) {

        int[] card = new int[x];

        int max = 0;
        max = sc.nextInt();

        for (int i = 0; i < x; i++) {
            card[i] = sc.nextInt();
        }

        max = sum(x, card, max);

        return (max);
    }

    static int sum(int x, int[] y, int z) {

        int tmp_sum = 0, m_sum = 0, s_sum = 0;
        m_sum = z;

        for (int i = 0; i < x - 2; i++) {
            for (int j = 1 + i; j < x - 1; j++) {
                for (int k = 2 + j - 1; k < x; k++) {
                    tmp_sum = y[i] + y[j] + y[k];
                    if (tmp_sum <= m_sum && s_sum < tmp_sum) {
                        s_sum = tmp_sum;
                    }
                }
            }
        }

        return s_sum;
    }

}