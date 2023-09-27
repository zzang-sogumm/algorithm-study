package jwh.graph_search.BOJ1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class BOJ1325 {
    static ArrayList<Integer> list[] = new ArrayList[100001];
    static int result[] = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0, m = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = 0, v = 0;
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            list[u].add(v);
        }

        for (int i = 1; i <= n; i++) {
            boolean visit[] = new boolean[10001];
            gp(i, visit);
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            max = Math.max(result[i], max);
        }

        for (int i = 1; i <= n; i++) {
            if (result[i] == max) {
                System.out.println(i);
            }
        }
        br.close();
    }

    static void gp(int a, boolean[] visit) {
        visit[a] = true;

        for (int i : list[a]) {
            if (!visit[i]) {
                result[i]++;
                gp(i, visit);
            }

        }

    }
}
