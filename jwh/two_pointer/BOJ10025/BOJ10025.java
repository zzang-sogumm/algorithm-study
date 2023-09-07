package jwh.two_pointer.BOJ10025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class BOJ10025 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = 0, k = 0, point = 0;
        int r = 1, l = 0, result = 0;
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] buc = new int[2000002];
        Arrays.fill(buc, 0);

        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int g = 0, x = 0;
            g = Integer.parseInt(st1.nextToken());
            x = Integer.parseInt(st1.nextToken());
            buc[x] = g;
            point = Math.max(point, x);
        }

        while (r <= point) {
            int tmp = 0;
            for (int i = l; i <= r; i++) {
                tmp = tmp + buc[i];
            }
            result = Math.max(result, tmp);
            l += 1;
            r = l + (k * 2);
        }

        System.out.println(result);
        br.close();
    }
}
