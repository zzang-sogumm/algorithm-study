package jwh.backtracking.BOJ9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9663 {
    static int n;
    static int visit[];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        visit = new int[n];

        dfs(0);

        System.out.println(cnt);
    }

    public static void dfs(int dep) {
        if (dep == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            visit[dep] = i;
            if (check(dep)) {
                dfs(dep + 1);
            }
        }
    }

    public static boolean check(int index) {
        for (int i = 0; i < index; i++) {
            if (visit[index] == visit[i]) {// 직선상에 있음을 배제
                return false;
            } else if (Math.abs(index - i) == Math.abs(visit[index] - visit[i])) { // 열의 차이 == 행의 차이 면 대각선 상에 있음
                return false;
            }
        }
        return true;
    }
}
