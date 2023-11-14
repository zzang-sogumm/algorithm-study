package jwh.graph_search.BOJ2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ2606 {
    static int n = 0, m = 0, result = 0;
    static int gp[][] = new int[101][101];
    static boolean check[] = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st1.nextToken());

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int u = 0, v = 0;
            u = Integer.parseInt(st2.nextToken());
            v = Integer.parseInt(st2.nextToken());
            gp[u][v] = gp[v][u] = 1; // 노드끼리는 순서가 상관없다. ex) 1, 2노드 2,1 노드 상관없이 1이랑 2가 인접해있다는 사실만 1로 표시

        }

        check[1] = true; // 방문 체크하기위해 1을 트루로 체크
        graph(1, check); // 1번 컴퓨터 바이러스걸렸다!

        System.out.println(result);
        br.close();

    }

    static void graph(int v, boolean check[]) {

        for (int j = 2; j <= n; j++) {
            if (gp[v][j] != 1 || check[j] == true) { // 1번이랑 몇번이 인접하니? 찾는 구문
                continue;
            } else { // 인접하면?
                result++;
                check[j] = true;
                graph(j, check); // 인접한 번호의 노드 또 탐색
            }

        }
    }

}
