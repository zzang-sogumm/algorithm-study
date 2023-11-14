package jwh.shortest_path.BOJ13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ13549 {
    static int x, k;
    static int dist[];
    static boolean visit[];
    static int min = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dist = new int[100001];
        Arrays.fill(dist, 100001);
        visit = new boolean[100001]; // 거리, 방문 최대값으로 초기화
        if (x == k) { // 동생과 자신의 거리가 같을 때, 0으로 출력하기 위함
            min = 0;
        } else {
            bfs(x, k);
        }

        System.out.println(min);
    }

    static void bfs(int x, int k) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(x); // 큐에 현재 위치 대입
        dist[x] = 0; // 현재 거리는 0
        while (!q.isEmpty()) {
            int now = q.poll();
            if (!visit[now]) { // 방문하지 않았다면 ?
                visit[now] = true; // 방문
                if (now == k) { // 현재 위치가 동생과 같다면 출력
                    min = dist[now];
                }
                if (now * 2 < 100001) { // 현재위치 *2가 범위를 초과하지 않을 때,
                    q.add(now * 2); // 큐에 넣어줌
                    dist[now * 2] = dist[now]; // 거리도 갱신
                }
                if (now - 1 >= 0) {
                    if (dist[now - 1] > dist[now] + 1) { // 현재 위치-1이 범위를 초과하지 않고, 이전 거리보다 크다면
                        dist[now - 1] = dist[now] + 1; // 다익스트라
                        q.add(now - 1);
                    }
                }
                if (now + 1 < 100001) {
                    if (dist[now + 1] > dist[now] + 1) {
                        dist[now + 1] = dist[now] + 1;
                        q.add(now + 1);
                    }
                }

            }

        }
    }

}
