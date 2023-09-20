package jwh.dynamic_programming.BOJ11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = 0, result = 0;
        int a[] = new int[1001];
        int len[] = new int[1001];
        n = Integer.parseInt(st.nextToken());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st1.nextToken());
            len[i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (a[i] > a[j])
                    len[i] = Math.max(len[i], len[j] + 1);
            }
        }

        for (int i = 1; i <= n; i++) {
            result = Math.max(result, len[i]);
        }

        System.out.println(result);

        br.close();
    }

}
