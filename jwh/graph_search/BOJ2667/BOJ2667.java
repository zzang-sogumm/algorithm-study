package jwh.graph_search.BOJ2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

class BOJ2667 {
    static int map[][];
    static boolean visit[][] = new boolean[26][26];
    static int result[];
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int n = 0, cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        result = new int[n * n];
        Arrays.fill(result, 0);
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                char ch = str.charAt(j);
                map[i][j] = Character.getNumericValue(ch);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && map[i][j] != 0) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        Arrays.sort(result);

        for (int i = 0; i < n * n; i++) {
            if (result[i] > 0) {
                System.out.println(result[i]);
            }
        }

        br.close();
    }

    static void bfs(int x, int y) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(x, y));
        visit[x][y] = true;
        result[cnt] += 1;
        while (!q.isEmpty()) {
            pair s = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = s.x + dx[i];
                int ny = s.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                if (visit[nx][ny] || map[nx][ny] == 0) {
                    continue;
                }
                q.add(new pair(nx, ny));
                result[cnt] += 1;
                visit[nx][ny] = true;
            }
        }
    }
}

class pair {
    int x;
    int y;

    pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
