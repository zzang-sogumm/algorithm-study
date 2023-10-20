package jwh.shortest_path.BOJ14938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14938 {
    static int n, m, r;
    static int dist[][];
    static int item[];
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        dist = new int[n][n];
        item = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j)
                    dist[i][j] = 1000;
            }
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            dist[a - 1][b - 1] = l;
            dist[b - 1][a - 1] = l;
        }
        bfs();

        for (int i = 0; i < n; i++) {
            check(i);
        }

        System.out.println(max);

    }

    static void bfs() {

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }

    static void check(int i) {
        int temp = 0;
        for (int j = 0; j < n; j++) {
            if (dist[i][j] <= m && i != j) {
                temp += item[j];
            }
        }

        temp += item[i];
        max = Math.max(max, temp);
    }

}
