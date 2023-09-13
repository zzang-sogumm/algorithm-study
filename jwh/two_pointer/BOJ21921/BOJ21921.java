package jwh.two_pointer.BOJ21921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class BOJ21921 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = 0, n = 0, visit = 0;
        int l = 0, r = 0, cnt = 0;
        int temp = 0;
        x = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[] day = new int[x];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < x; i++) {
            day[i] = Integer.parseInt(st1.nextToken());
        } // 입력란

        while (r + n <= x) {// 총 일수는 우측포인터 + 포인터차이를 넘지않도록
            while (r + n > l) {// 우측포인터 +n 은 l보다 커서 차이를 유지하도록
                temp += day[l];
                l += 1;
            } // 합해준 후 좌측포인터 +1;
            if (temp == visit)
                cnt++;
            else if (visit < temp) {
                visit = temp;
                cnt = 1;
            } // 일수 카운팅
            temp -= day[r];// 맨 좌측 방문자 제외 후 다음연산으로
            r += 1;// 우측포인터 한칸 이동
        }
        if (visit == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(visit);
            System.out.println(cnt);
        }

        br.close();
    }
}
