package isu.brute_force;

import java.io.*;

/**
 * dynamic programming
 * 점화식 만들어야 함....................
 */
public class BOJ9095 {

    public static void main(String[] args) throws IOException {
        new BOJ9095().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        int[] dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // 점화식
        for (int j = 4; j <= 10; j++) {
            dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
        }

        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(reader.readLine());
            writer.write(dp[target] + "\n");
        }

        writer.flush(); // 내용 출력
        writer.close(); // 종료
        reader.close();
    }
}