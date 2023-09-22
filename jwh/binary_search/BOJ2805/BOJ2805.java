package jwh.binary_search.BOJ2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class BOJ2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long tree[] = new long[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree); // 나무를 정렬

        long s = 0;
        long e = tree[n - 1]; // 정렬을 통한 최대 나무의 길이를 e로 설정

        while (s <= e) {
            long mid = (s + e) / 2; // 절단기 높이를 mid로 설정
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (tree[i] > mid) { // 절단하여 남는 나무들만 계산
                    sum += tree[i] - mid; // 절단된 나무의 합 계산
                }
            }
            if (sum < m) { // 합이 m보다 작다면, 절단기 높이를 줄여서 합을 늘리고
                e = mid - 1;
            } else { // 반대로
                s = mid + 1;
            }

        }

        System.out.println(e);
        br.close();

    }
}
