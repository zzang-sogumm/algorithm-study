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

        e = a[n - 1]; // end값은 지방의 쵀대 요청금액

        while (s <= e) { // 최대 요청금액이 정해질때까지
            int sum = 0;
            int mid = (s + e) / 2; // 중간 금액은 최소 + 최대 /2

            for (int i = 0; i < n; i++) {
                if (a[i] >= mid) { // 지방 요청금액이 중간보다 크다면?
                    sum += mid; // 중간값을 더해줌
                } else {
                    sum += a[i]; // 지방 요청금액이 중간보다 작다면 그냥 지방 요청금액을 더해줌
                }
            }

            if (sum > max_give) { // 위에 다 더했을 떄, 최대 예산보다 크다면?
                e = mid - 1; // 중간금액이 작아져야 하니, 최대금액을 줄임
            } else if (sum <= max_give) { // 그게 아니라면, 중간금액이 커져야하니 시작값을 늘림
                s = mid + 1;
                max = Math.max(max, mid);// 중간금액을 키우면서 그 중 제일 큰 중간금액이 예산 중 최대값
            }
        }

        System.out.println(max);

        br.close();

    }

}
