package isu.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2422 {
    static int[] combo = new int[3];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        new BOJ2422().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int icecreamNum = Integer.parseInt(tokenizer.nextToken());
        int badComboNum = Integer.parseInt(tokenizer.nextToken());

        boolean[] visited = new boolean[icecreamNum + 1];
        boolean[][] badCombo = new boolean[icecreamNum + 1][icecreamNum + 1];

        // 이차원 배열에 구린 조합 저장
        for (int i = 0; i < badComboNum; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            badCombo[a][b] = true;
            badCombo[b][a] = true;
        }

        dfs(0, 1, badCombo, visited);

        System.out.println(count);
    }

    private void dfs(int depth, int index, boolean[][] badCombo, boolean[] visited) {
        if (depth == 3) {
            if (!isBadCombo(badCombo)) {
                count++;
            }
            return;
        }

        for (int i = index; i < badCombo.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combo[depth] = i;
                dfs(depth + 1, i, badCombo, visited);
                visited[i] = false;
            }
        }
    }

    private boolean isBadCombo(boolean[][] badCombo) {
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (badCombo[combo[i]][combo[j]]) {
                    return true;
                }
            }
        }

        return false;
    }
}

