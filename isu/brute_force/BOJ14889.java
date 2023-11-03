package isu.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889 {
    private static int N;
    private static int min = Integer.MAX_VALUE;
    private static int[][] value;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        new BOJ14889().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        N = Integer.parseInt(reader.readLine());
        value = new int[N][N];
        visited = new boolean[N];

        // 입력
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                value[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    private void dfs(int memberNum, int depth) {

        if (depth == N / 2) {
            computeValue();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(memberNum + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    private void computeValue() {
        int start = 0, link = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 둘 다 방문한 선수는 start 팀에 누적
                if (visited[i] && visited[j]) {
                    start += value[i][j];
                }
                // 둘 다 방문하지 않은 선수는 link 팀에 누적
                else if (!visited[i] && !visited[j]) {
                    link += value[i][j];
                }
            }
        }

        int diff = Math.abs(start - link);

        if (diff == 0) {
            min = 0;
        }

        min = Math.min(diff, min);
    }
}