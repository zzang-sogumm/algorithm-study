package isu.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17626 {

    public static void main(String[] args) throws IOException {
        new BOJ17626().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());

        int[] dp = new int[number + 1];

        dp[0] = 0;
        dp[1] = 1;


        // 점화식
        // dp[i] = min(dp[i - a*a]) + 1
        for (int index = 2; index <= number; index++) {
            int min = Integer.MAX_VALUE;

            for (int a = 1; a * a <= index; a++) {
                min = Math.min(min, dp[index - a * a]);
            }

            dp[index] = min + 1;
        }

        System.out.println(dp[number]);
    }
}
