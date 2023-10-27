package jwh.brute_force.BOJ14500;

import java.util.*;
import java.io.*;

public class BOJ14500 {

    static int n, m;
    static int result = 0;
    static int max = 0;
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = true;
                max += map[i][j];
                extra(i, j);
                search(i, j, 0);
                visit[i][j] = false;
                max -= map[i][j];
            }
        }

        System.out.println(result);
        // test_map();
    }

    static void extra(int i, int j) { // ㅜ모양에 대한 특수식
        int tmp = max;
        int[] dr = { 0, 0, 1, -1 };
        int[] dc = { 1, -1, 0, 0 };
        for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];
            if (nr < 0 || nr >= n || nc < 0 || nc >= m || visit[nr][nc]) { // 맵을 벗어나면 안됨
                continue;
            } else {
                tmp += map[nr][nc];
            } // i,j에 대해 4 귀퉁이 모두 더했음.
        }

        for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];
            if (nr < 0 || nr >= n || nc < 0 || nc >= m || visit[nr][nc]) { // 맵을 벗어나면 안됨
                result = Math.max(result, tmp);
                continue;
            } else {
                tmp -= map[nr][nc];
                result = Math.max(result, tmp);
                tmp += map[nr][nc];
            }
            // 한 귀퉁이씩 빼면서 계산해보자
        }

    }

    static void search(int i, int j, int dep) { // 이어지는 직선은 탐색했지만, ㅜ 모양은 탐색못하는 구문
        if (dep == 3) {
            result = Math.max(result, max);
            return;
        }
        int[] dr = { 0, 0, 1, -1 };
        int[] dc = { 1, -1, 0, 0 };
        for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];
            if (nr < 0 || nr >= n || nc < 0 || nc >= m || visit[nr][nc]) { // 맵을 벗어나면 안됨
                continue;
            } else {
                max += map[nr][nc];
                visit[nr][nc] = true;
                search(nr, nc, dep + 1);
                visit[nr][nc] = false;
                max -= map[nr][nc];
            }
        }
    }

    static void test_map() {
        for (int i = 0; i < n; i++) {
            System.out.println("");
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
        }
    }

}