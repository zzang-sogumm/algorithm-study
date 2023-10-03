package jwh.backtracking.BOJ9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9663_v2 {
    static int n;
    static boolean[][] visit;
    static int dx[] = { 1, -1, 1, -1 };
    static int dy[] = { 1, 1, -1, -1 }; // 대각
    static int sx[] = { 1, -1, 0, 0 };
    static int sy[] = { 0, 0, 1, -1 };
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        visit = new boolean[n][n];

        dfs(0);

        System.out.println(cnt);
    }

    public static void dfs(int dep) {
        if (dep == n) {
            cnt++;
            return;
        }
        // 배열 돌면서 visit 하지 않은 곳 찾아가는거임
        for (int j = 0; j < n; j++) {
            if (check(dep, j)) {
                visit[dep][j] = true;
                dfs(dep + 1);
                visit[dep][j] = false;
            }
        }
    }

    public static boolean check(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            while (nx < n && nx >= 0 && ny < n && ny >= 0) {
                if (visit[nx][ny] == true) {
                    return false;
                }
                nx += dx[i];
                ny += dy[i];
            } // 대각
            int mx = x + sx[i];
            int my = y + sy[i];
            while (mx < n && mx >= 0 && my < n && my >= 0) {
                if (visit[mx][my] == true) {
                    return false;
                }
                mx += sx[i];
                my += sy[i];
            } // 직선
        }
        return true;
    }
}
