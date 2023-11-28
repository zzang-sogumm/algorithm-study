package jwh.bfs.BOJ1261;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int x;
    int y;
    int cnt;

    public Node(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Node o) {
        return cnt - o.cnt;
    }
}

class BOJ1261 {
    static int n, m;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[m][n];

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(line[j]);
                map[i][j] = num;
            }
        }

        System.out.println(bfs(0, 0));

        br.close();
    }

    static int bfs(int x, int y) {
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };
        Queue<Node> q = new PriorityQueue<>();
        boolean[][] visit = new boolean[m][n];

        visit[y][x] = true;
        q.add(new Node(x, y, 0));

        while (!q.isEmpty()) {
            Node tmp = q.poll();

            int tx = tmp.x;
            int ty = tmp.y;
            int tc = tmp.cnt;

            if (tx == n - 1 && ty == m - 1) {
                return tc;
            }

            for (int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1) {
                    continue;
                }
                if (visit[ny][nx])
                    continue;

                visit[ny][nx] = true;
                if (map[ny][nx] == 0) {
                    q.add(new Node(nx, ny, tc));
                } else {
                    q.add(new Node(nx, ny, tc + 1));
                }

            }
        }
        return 0;
    }
}