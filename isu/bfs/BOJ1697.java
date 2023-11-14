package isu.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {
    static int start, target;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        new BOJ1697().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        start = Integer.parseInt(tokenizer.nextToken());
        target = Integer.parseInt(tokenizer.nextToken());

        // target이 더 뒤에 있는 경우, 무조건 뒤로 갈 수 밖에 없음
        // 같은 곳에 있다면 0 출력
        if (target <= start) {
            System.out.println(start - target);
            return;
        }

        bfs();
        System.out.println(visited[target] - 1);
    }

    private void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1; // 시작점은 이미 방문한 것으로 처리

        while (!queue.isEmpty()) {
            int num = queue.poll();

            // target과 만난 경우 바로 탈출시킴
            if (num == target) {
                return;
            }

            /* 세 가지 경우를 모두 체크해서
                방문하지 않았으면서 범위를 벗어나지 않는 경우에
                (이미 방문한 경우, 그것이 최소값이기 때문에 또 계산하지 않음)
                visited[해당 칸]에 초를 입력함
             */
            // case 1: 뒤로 한 칸 이동하는 경우
            if (num - 1 > 0 && visited[num - 1] == 0) {
                visited[num - 1] = visited[num] + 1;
                queue.add(num - 1);
            }

            // case 2: 앞으로 한 칸 이동하는 경우
            if (num + 1 <= 100000 && visited[num + 1] == 0) {
                visited[num + 1] = visited[num] + 1;
                queue.add(num + 1);
            }

            // case 3: 앞으로 순간이동 하는 경우
            if (num * 2 <= 100000 && visited[num * 2] == 0) {
                visited[num * 2] = visited[num] + 1;
                queue.add(num * 2);
            }
        }
    }
}