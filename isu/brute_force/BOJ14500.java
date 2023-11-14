package isu.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 완전 탐색(dfs)이랑 비슷한 듯
 * <p>
 * 다섯가지 모양의 모든 경우의 수를 찾는 게 아니라,
 * 4칸 이동(깊이 4)하는 모든 경우 중에서 가장 큰 값 구하면 된다.
 * <p>
 * 'ㅗ' 모양을 예외처리 해주기 위해 두 번째 칸에서 한 번 꺾어서 더 탐색해준다.
 */
public class BOJ14500 {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int max = 0;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        new BOJ14500().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        // 입력
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        // dfs
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                search(map[i][j], i, j, 1);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    private void search(int sum, int row, int col, int depth) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int x = row + dx[i];
            int y = col + dy[i];

            // map 범위 벗어나는 경우 실행하지 않음
            if (x < 0 || y < 0 || x >= N || y >= M) {
                continue;
            }

            if (!visited[x][y]) {

                // 'ㅗ' 모양 예외처리 -> 두 번째 칸에서 dfs 한 번 더 해줌
                if (depth == 2) {
                    visited[x][y] = true;
                    search(sum + map[x][y], row, col, depth + 1);
                    visited[x][y] = false;
                }

                visited[x][y] = true;
                search(sum + map[x][y], x, y, depth + 1);
                visited[x][y] = false;
            }
        }
    }
}