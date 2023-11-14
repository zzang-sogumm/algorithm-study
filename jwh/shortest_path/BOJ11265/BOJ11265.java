package jwh.shortest_path.BOJ11265;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11265 {
    static int n, m;
    static int map[][];
    static String result[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        result = new String[m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        /*
         * for (int i = 0; i < n; i++) {
         * System.out.println("");
         * for (int j = 0; j < n; j++) {
         * System.out.print(map[i][j]);
         * }
         * }
         */

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            check(a, b, c, i);
        }
        for (int i = 0; i < m; i++) {
            System.out.println(result[i]);
        }

    }

    static void bfs() {

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
    } // 여러 정점에서 여러 정점으로 가는 최단거리를 찾아야하기때문에, 플로이드 - 와샬

    static void check(int a, int b, int c, int i) {
        if (map[a - 1][b - 1] > c) {
            result[i] = "Stay here";
        } else {
            result[i] = "Enjoy other party";
        }

    }

}
