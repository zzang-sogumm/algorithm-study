package isu.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {

    public static void main(String[] args) throws IOException {
        new BOJ14501().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int day = Integer.parseInt(reader.readLine());

        int[] times = new int[day];
        int[] pays = new int[day];
        int[] dp = new int[day + 1]; // 각 날짜의 최대 수익

        for (int i = 0; i < day; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            times[i] = Integer.parseInt(tokenizer.nextToken());
            pays[i] = Integer.parseInt(tokenizer.nextToken());
        }

        // 점화식
        for (int i = 0; i < day; i++) {
            int time = times[i] + i; // 현재 날짜
            if (time <= day) { // 날짜가 범위를 벗어나지 않는 경우
                // 소요 시간과 금액을 더해서 dp에 저장
                dp[time] = Math.max(dp[time], dp[i] + pays[i]);
            }

            // 이전의 최대값과 비교해서 넣어줌
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }

        System.out.println(dp[day]);
    }
}

