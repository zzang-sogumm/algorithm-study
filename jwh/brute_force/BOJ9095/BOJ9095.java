package jwh.brute_force.BOJ9095;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.StringTokenizer;

class BOJ9095 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int[] result = new int[t];
        int[] dp = new int[11];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for (int i = 3; i < 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            result[i] = dp[n - 1];
        }

        for (int i = 0; i < t; i++) {
            System.out.println(result[i]);
        }

        br.close();
    }
}