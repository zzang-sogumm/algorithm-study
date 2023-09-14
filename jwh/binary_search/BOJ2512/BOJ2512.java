package jwh.binary_search.BOJ2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class BOJ2512 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = 0, max_give = 0, max = 0, s = 0, e = 0;
        n = Integer.parseInt(st.nextToken());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st1.nextToken());
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        max_give = Integer.parseInt(st2.nextToken());

        Arrays.sort(a); // 이분탐색을 위한 오름차순 정렬

        e = a[n - 1];

        while (s <= e) {
            int sum = 0;
            int mid = (s + e) / 2;

            for (int i = 0; i < n; i++) {
                if (a[i] >= mid) {
                    sum += mid;
                } else {
                    sum += a[i];
                }
            }

            if (sum > max_give) {
                e = mid - 1;
            } else if (sum <= max_give) {
                s = mid + 1;
                max = Math.max(max, mid);
            }
        }

        System.out.println(max);

        br.close();

    }

}
