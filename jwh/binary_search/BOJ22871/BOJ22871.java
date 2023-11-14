package jwh.binary_search.BOJ22871;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        long a[] = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        long dp[] = new long[n + 1];
        dp[1] = 0; // 첫번째 징검다리는 어차피 못건넘
        for (int i = 2; i <= n; i++) {
            dp[i] = Long.MAX_VALUE; // dp 최댓값으로 해주고
            for (int j = 1; j < i; j++) {
                long power = Math.max((i - j) * (1 + (Math.abs(a[i] - a[j]))), dp[j]); // 힘의 최대값을 구함
                dp[i] = Math.min(dp[i], power); // 자신까지 올 수 있는 힘 중 최소값
            }
        }

        System.out.println(dp[n]);

        br.close();

    }
}
