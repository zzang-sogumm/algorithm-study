package jwh.binary_search.BOJ3079;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class BOJ3079 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        int t[] = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(t);

        long s = 1;
        long e = m * t[0]; // 인원수에 최소 걸리는 시간을 곱해서 최대값을 생성
        while (s <= e) {
            long mid = (s + e) / 2; // 중간값 탐색
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += (mid / t[i]); // sum과 m을 비교하며 mid값 책정
            }
            if (sum >= m) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        System.out.println(s);

        br.close();

    }
}
