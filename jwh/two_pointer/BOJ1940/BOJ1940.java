package jwh.two_pointer.BOJ1940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class BOJ1940 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int n = 0, m = 0;
        int l = 0, r = 0, cnt = 0;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st1.nextToken());

        int[] tank = new int[n];

        for (int i = 0; i < n; i++) {
            tank[i] = Integer.parseInt(st2.nextToken());
        } // 입력란

        r = 1;
        while (l < n) {
            while (r < n) {
                int tmp = 0;
                tmp = tank[l] + tank[r];
                if (tmp == m) {
                    cnt++;
                    break;
                }
                r += 1;
            }
            l += 1;
            r = l + 1;
        }
        System.out.println(cnt);
        br.close();
    }
}
