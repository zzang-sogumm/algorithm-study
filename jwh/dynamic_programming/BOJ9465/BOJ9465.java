package jwh.dynamic_programming.BOJ9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class BOJ9465 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = 0, n = 0;
        t = Integer.parseInt(st.nextToken());
        int result[] = new int[t];
        for (int k = 0; k < t; k++) {

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st1.nextToken());
            int a[][] = new int[2][n];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(st2.nextToken());
                }
            }
            int dp[][] = new int[2][n];

            dp[0][0] = a[0][0];
            dp[1][0] = a[1][0];
            if (n > 1) {
                dp[0][1] = dp[1][0] + a[0][1];
                dp[1][1] = dp[0][0] + a[1][1];
            }

            for (int j = 2; j < n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + a[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + a[1][j];
            }

            result[k] = Math.max(dp[0][n - 1], dp[1][n - 1]);

        }
        for (int i = 0; i < t; i++) {
            System.out.println(result[i]);
        }

        br.close();
    }

}
