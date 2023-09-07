package isu.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16439 {
    static int memberNum, chickenNum;
    static int max;

    public static void main(String[] args) throws IOException {
        new BOJ16439().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        memberNum = Integer.parseInt(tokenizer.nextToken());
        chickenNum = Integer.parseInt(tokenizer.nextToken());

        int[][] satisfaction = new int[memberNum][chickenNum];
        // 만족도 점수 담기
        for (int row = 0; row < memberNum; row++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int col = 0; col < chickenNum; col++) {
                satisfaction[row][col] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        max = Integer.MIN_VALUE;
        boolean[] visited = new boolean[chickenNum];

        dfs(0, 0, visited, satisfaction);

        System.out.println(max);
    }

    private void dfs(int index, int depth, boolean[] visited, int[][] satisfaction) {
        if (depth == 3) {
            int sum = 0;

            for (int row = 0; row < memberNum; row++) {
                int num = 0;

                for (int col = 0; col < chickenNum; col++) {
                    if (visited[col]) { // 고른 치킨에 대한 멤버의 만족도 최대값을 구함
                        num = Math.max(num, satisfaction[row][col]);
                    }
                }
                sum += num;
            }

            max = Math.max(sum, max);
            return;
        }

        for (int i = index; i < chickenNum; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1, visited, satisfaction);
                visited[i] = false;
            }
        }
    }
}

