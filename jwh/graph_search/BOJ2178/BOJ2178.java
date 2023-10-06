package jwh.graph_search.BOJ2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

class BOJ2178 {
    static int map[][];
    static boolean visit[][] = new boolean[101][101];
    static int[][] dx = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static int n = 0, m = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char ch = str.charAt(j);
                map[i][j] = Character.getNumericValue(ch);
            }
        }

        bfs(0, 0);

        System.out.println(map[n - 1][m - 1]);
        br.close();
    }

    static void bfs(int x, int y) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(x, y)); // 큐에 현재 x,y를 넣음

        while (!q.isEmpty()) {
            pair s = q.poll(); // 큐에 있는 x,y를 하나씩 빼면서 수행
            for (int i = 0; i < 4; i++) { // 상,하,좌,우 한번씩 이동시켜봄
                int nx = s.x + dx[i][0];
                int ny = s.y + dx[i][1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                } // 이동시키면서 맵밖으로 나가면 다시 for문
                if (visit[nx][ny] || map[nx][ny] == 0) {
                    continue;
                } // 이동시키면서 벽이거나, 방문했었으면 다시 for문
                q.add(new pair(nx, ny)); // 문제없는 nx,ny는 큐에 add 시킴 (다음엔 거기서부터 시작할거니깐)
                map[nx][ny] = map[s.x][s.y] + 1; // nx,ny에 1씩 증가시키며, 마지막엔 거리가 나오게 설정
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