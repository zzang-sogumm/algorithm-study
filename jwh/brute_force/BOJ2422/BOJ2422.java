package jwh.brute_force.BOJ2422;

import java.io.IOException;
import java.util.Scanner;

public class BOJ2422 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = 0, m = 0, cnt = 0;

        n = sc.nextInt();
        m = sc.nextInt();

        boolean[][] ice = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int q = 0, w = 0;
            q = sc.nextInt();
            w = sc.nextInt();
            ice[q][w] = true;
            ice[w][q] = true;
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ice[i][j])
                    continue;
                for (int k = j + 1; k < n + 1; k++) {
                    if (!ice[j][k] && !ice[i][k])
                        cnt++;
                }
            }
        }

        System.out.println(cnt);
        sc.close();
    }
}