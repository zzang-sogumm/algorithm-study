package jwh.dynamic_programming.BOJ1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ1912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = 0, result = -1000;
        n = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st1.nextToken());
        }

        int dp[] = new int[n];

        dp[0] = a[0]; // 최초 최대값은 자기 자신
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + a[j]; // 이전 최대값 + 자신 = 최대
            if (dp[j - 1] < 0) { // 이전 최대값이 -일때, 자기자신이 최대, 어차피 result에서 걸러짐
                dp[j] = a[j];
            }
        }

        for (int i = 0; i < n; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);

        br.close();
    }

}
