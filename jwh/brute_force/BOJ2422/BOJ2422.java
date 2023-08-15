package jwh.brute_force.BOJ2422;

import java.util.Scanner;

public class BOJ2422 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int input = 0;
        input = sc.nextInt();
        System.out.println(check(input));

    }

    static int check(int x) {

        int len = 0, e_num = 0, in_len = 0;

        in_len = x;

        if (x > 3) {
            try {
                len = factorial(x) / (factorial(x - 3) * factorial(3));
            } catch (Exception e) {
                System.out.println("error");
            }
            int[][] ice = new int[len][3];
            int[][] eject = new int[x][2];

            int sub = 0;

            e_num = sc.nextInt();
            for (int i = 0; i < e_num; i++) {
                for (int j = 0; j < 2; j++) {
                    eject[i][j] = sc.nextInt();
                }
            }

            sub = cal(ice, eject, len, in_len, e_num);

            return (len - sub);
        } else if (x == 3) {

            int[][] eject = new int[x][2];

            e_num = sc.nextInt();

            for (int i = 0; i < e_num; i++) {
                for (int j = 0; j < 2; j++) {
                    eject[i][j] = sc.nextInt();
                }
            }

            if ((eject[0][0] == 1 && eject[0][1] == 2) || (eject[0][0] == 2 && eject[0][1] == 1))
                return 0;
            else if ((eject[0][0] == 3 && eject[0][1] == 2) || (eject[0][0] == 2 && eject[0][1] == 3))
                return 0;
            else if ((eject[0][0] == 1 && eject[0][1] == 3) || (eject[0][0] == 3 && eject[0][1] == 1))
                return 0;
            else if ((eject[1][0] == 1 && eject[1][1] == 2) || (eject[1][0] == 2 && eject[1][1] == 1))
                return 0;
            else if ((eject[1][0] == 3 && eject[1][1] == 2) || (eject[1][0] == 2 && eject[1][1] == 3))
                return 0;
            else if ((eject[1][0] == 1 && eject[1][1] == 3) || (eject[1][0] == 3 && eject[1][1] == 1))
                return 0;
            else
                return 1;
        } else if (x == 2) {
            return 1;
        } else if (x == 1) {
            return 1;
        } else
            return 0;
    }

    static int cal(int[][] x, int[][] y, int z, int p, int m) {

        comb(x, z, p);
        int e_len_c = 0;
        int cnt = 0;
        e_len_c = m;

        for (int i = 0; i < z; i++) {
            for (int j = 0; j < 3; j++) {
                for (int c = 0; c < e_len_c; c++) {
                    if (x[i][j] == y[c][0]) {
                        if (x[i][0] == y[c][1] || x[i][1] == y[c][1] || x[i][2] == y[c][1]) {
                            cnt = cnt + 1;
                            if (i < z - 1)
                                i = i + 1;
                            else
                                break;

                        }

                    } else if (x[i][j] == y[c][1]) {
                        if (x[i][0] == y[c][0] || x[i][1] == y[c][0] || x[i][2] == y[c][0]) {
                            cnt = cnt + 1;
                            if (i < z - 1)
                                i = i + 1;
                            else
                                break;
                        }
                    }

                }
            }

        }

        return cnt;

    }

    static void comb(int[][] x, int z, int p) {

        int[] temp = new int[z * 3];
        int t = 0, tt = 0;

        for (int q = 1; q < p - 1; q++) {
            for (int w = 1 + q; w < p; w++) {
                for (int e = 1 + w; e < p + 1; e++) {
                    temp[t] = q;
                    temp[t + 1] = w;
                    temp[t + 2] = e;
                    t = t + 3;
                }
            }
        }

        for (int i = 0; i < z; i++) {
            for (int j = 0; j < 3; j++) {
                x[i][j] = temp[tt];
                tt = tt + 1;
            }
        }

    }

    static int factorial(int n) {
        if (n <= 1)

            return 1;

        else

            return factorial(n - 1) * n;

    }

}