package jwh.two_pointer.BOJ20922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ20922 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = 0, k = 0, len = 0;
        int l = 0, r = 0, tmp = 0;
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] line = new int[n];
        int[] check = new int[100001];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            line[i] = Integer.parseInt(st1.nextToken());
        } // 입력란

        while (r < n && l < n) { // 좌, 우 포인터 모두 n보다 작게 설정
            check[line[l]] += 1; // 겹치는 원소 판독하기위한 체크
            if (check[line[l]] > k) {// 겹치는 원소 판독하기위한 체크
                tmp = l - r;// 길이는 좌-우포인터로
                len = Math.max(len, tmp);// 가장 긴 길이로
                check[line[r]] -= 1;// 판독한 후 다음 원소들 판독을 위한 초기화
                check[line[l]] -= 1;// 위와 동일
                r += 1;// 우포인터는 한칸 전진
                l -= 1;// 좌포인터는 그 자리에 있어야하지만, 밑에서 +1되니 감소시키기
            }
            if (l == n - 1) {
                tmp = l - r + 1;
                len = Math.max(len, tmp);
            } // 포인터가 끝까지 갔음에도 원소가 판독되지않고 순탄하게 끝났을 경우의 길이계산식
            l += 1;
        }

        System.out.println(len);

        br.close();
    }
}
