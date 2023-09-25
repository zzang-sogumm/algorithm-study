package jwh.graph_search.BOJ11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class BOJ11725 {
    static int n = 0, m = 0;
    static int result[] = new int[100001];
    static boolean check[] = new boolean[100001];
    static ArrayList<Integer> list[] = new ArrayList[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>(); // 리스트 안에 또 리스트임.
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int u = 0, v = 0;
            u = Integer.parseInt(st1.nextToken());
            v = Integer.parseInt(st1.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        graph(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(result[i]);
        }
        br.close();

    }

    static void graph(int v) {

        check[v] = true; // 찾고있는 노드를 방문했다고 표시
        for (int i : list[v]) {
            if (!check[i]) {
                result[i] = v;
                graph(i);
            }
        }

    }

}
