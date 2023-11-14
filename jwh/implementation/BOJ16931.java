package jwh.implementation;

import java.util.*;
import java.io.*;

public class BOJ16931 {

    static int n, m;
    static int[][] cntArr;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cntArr = new int[n][m];
        result = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                cntArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = (cntArr[i][j] * 4 + 2);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                same_floor(i, j); // 같은 층 또는 더 높은 층 대해 탐색하고 겹치면 -1씩해줌
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max += result[i][j];
            }
        }
        System.out.println(max);
        // test_map();
    }

    static void same_floor(int i, int j) {
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (cntArr[i][j] <= cntArr[nx][ny]) {
                    result[i][j] -= cntArr[i][j];
                } else {
                    result[i][j] -= cntArr[nx][ny];
                }
            }

        }
    }

    static void test_map() {
        for (int i = 0; i < n; i++) {
            System.out.println("");
            for (int j = 0; j < m; j++) {
                System.out.print(cntArr[i][j]);
            }
        }
    }
}
