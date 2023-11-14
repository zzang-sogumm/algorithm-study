package jwh.binary_search.BOJ1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class BOJ1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = 0, n = 0;

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int line[] = new int[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            line[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(line);

        long s = 0, e = 0, mid = 0;

        e = line[k - 1];

        while (s <= e) {
            long cnt = 0;
            mid = (s + e) / 2;
            if (mid == 0) {
                s = 2;
                break;
            } else {
                for (int i = 0; i < k; i++) {
                    cnt += line[i] / mid;
                }
            }

            if (cnt < n) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }

        }

        System.out.println(s - 1);

        br.close();

    }

}
