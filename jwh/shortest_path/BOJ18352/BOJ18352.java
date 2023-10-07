package jwh.shortest_path.BOJ18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18352 {
    static int n;
    static int m;
    static int k;
    static int x;
    static ArrayList<ArrayList<Integer>> gp = new ArrayList<>();
    static int dist[];
    static int result[];
    static int cnt;
    static int INF = Integer.MAX_VALUE - 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        dist = new int[n + 1];
        result = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dist[i] = INF;
            gp.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st1.nextToken());
            int l = Integer.parseInt(st1.nextToken());
            gp.get(j).add(l);
        }

        dk(x);
        for (int i = 1; i <= n; i++) {
            if (result[i] > 0) {
                System.out.println(i);
                cnt++;
            }
        }
        if (cnt < 1) {
            System.out.println(-1);
        }
    }

    public static void dk(int src) {
        Queue<Integer> q = new LinkedList<>();
        boolean visit[] = new boolean[n + 1];
        dist[src] = 0;
        q.add(src);
        while (!q.isEmpty()) {
            int u = q.poll();
            if (visit[u])
                continue;
            visit[u] = true;
            for (int v = 0; v < gp.get(u).size(); v++) {
                int now = gp.get(u).get(v);
                if (dist[now] > dist[u] + 1) {
                    dist[now] = dist[u] + 1;
                    q.add(now);
                    if (dist[now] == k) {
                        result[now] = 1;
                    }
                }
            }

        }
    }

}
