package isu.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
    다익스트라 알고리즘, bfs 사용
    일반 큐가 아니라 덱(혹은 우선순위 큐도 좋을 듯) 사용
 */
public class BOJ1261 {
    static int[][] maze;
    static boolean[][] visited;
    static int N, M;
    static int answer;

    public static void main(String[] args) throws IOException {
        new BOJ1261().run();
    }

    private void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];

        // 미로 입력
        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        dfs();

        System.out.println(answer);
    }

    private void dfs() {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {-1, 1, 0, 0};

        Deque<Room> queue = new ArrayDeque<>();
        queue.add(new Room(0, 0, 0));
        visited[0][0] = true; // (0,0) 방문 체크

        while (!queue.isEmpty()) {
            int positionX = queue.peek().x;
            int positionY = queue.peek().y;
            // 벽은 우선순위가 높은 앞쪽부터 poll
            int wallCount = queue.pollFirst().wall;

            // 도착지에 들어온 경우, 그것이 최소값이므로 바로 리턴
            if (positionX == N - 1 && positionY == M - 1) {
                answer = wallCount;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int row = positionX + dx[i];
                int col = positionY + dy[i];

                // 범위를 벗어나거나 이미 방문한 경우 실행하지 않음
                if (row < 0 || row >= N || col < 0 || col >= M || visited[row][col]) {
                    continue;
                }

                // 빈 방인 경우 우선순위가 높기 때문에 덱의 앞으로
                if (maze[row][col] == 0) {
                    visited[row][col] = true;
                    queue.addFirst(new Room(row, col, wallCount));
                } else { // 벽인 경우 우선순위가 낮기 때문에 덱의 뒤로
                    maze[row][col] = 0; // 벽 부숨
                    visited[row][col] = true;
                    queue.addLast(new Room(row, col, wallCount + 1));
                }
            }
        }
    }
}

class Room {
    int x;
    int y;
    int wall;

    public Room(int x, int y, int wall) {
        this.x = x;
        this.y = y;
        this.wall = wall;
    }
}