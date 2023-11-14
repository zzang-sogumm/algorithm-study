package isu.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3085 {
    private static int N;
    private static char[][] candyMap;
    private static int MAX;

    public static void main(String[] args) throws IOException {
        new BOJ3085().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        candyMap = new char[N][N];
        MAX = 0;

        // 입력 저장
        for (int i = 0; i < N; i++) {
            String candyLine = reader.readLine();

            for (int j = 0; j < N; j++) {
                candyMap[i][j] = candyLine.charAt(j);
            }
        }

        // 오른쪽 사탕과 교환
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                colSwap(i, j);
                candyCheck();
                colSwap(i, j);
            }
        }

        // 아래쪽 사탕과 교환
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                rowSwap(i, j);
                candyCheck();
                rowSwap(i, j);
            }
        }

        System.out.println(MAX);
    }

    private void colSwap(int row, int col) {
        char temp = candyMap[row][col];
        candyMap[row][col] = candyMap[row][col + 1];
        candyMap[row][col + 1] = temp;
    }

    private void rowSwap(int row, int col) {
        char temp = candyMap[row][col];
        candyMap[row][col] = candyMap[row + 1][col];
        candyMap[row + 1][col] = temp;
    }

    private void candyCheck() {
        // col check
        for (int i = 0; i < N; i++) {
            int colCount = 1;

            for (int j = 0; j < N - 1; j++) {
                // col 체크
                if (candyMap[i][j] == candyMap[i][j + 1]) {
                    colCount++;
                    MAX = Math.max(MAX, colCount);
                } else {
                    colCount = 1;
                }
            }
        }

        // row check
        for (int i = 0; i < N; i++) {
            int rowCount = 1;

            for (int j = 0; j < N - 1; j++) {
                if (candyMap[j][i] == candyMap[j + 1][i]) {
                    rowCount++;
                    MAX = Math.max(MAX, rowCount);
                } else if (candyMap[j][i] != candyMap[j + 1][i]) {
                    rowCount = 1;
                }
            }
        }
    }
}