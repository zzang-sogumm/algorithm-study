package jwh.data_structre2.BOJ2346;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class BOJ2346 {
    static LinkedList<Integer> li = new LinkedList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            li.add(i); // li 는 풍선의 순서
        }
        int cur = 0; // 현재 돌아가는 위치
        int cur_val = 0; // 현재 풍선의 번호
        int paper = 0; // 풍선 내부의 종이쪼가리
        int[] triger = new int[n + 1]; // 풍선 종이쪼가리 배열

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        for (int i = 0; i < n; i++) {
            triger[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            cur_val = li.get(cur);
            sb.append(li.get(cur) + " ");
            li.remove(cur);
            if (li.size() == 0)
                break;

            paper = triger[--cur_val]; // 0부터 배열이기때문에 현재 값 - 1로 위치선정

            if (paper > 0) {
                --cur;
                cur = (cur + paper) % li.size(); // 양수로 움직일때에는?
            } else {
                paper = Math.abs(paper);
                paper = li.size() - (paper % li.size());
                cur = (cur + paper) % li.size(); // 음수로 움직일때에는?
            }

        }
        System.out.println(sb);

        br.close();
    }

}