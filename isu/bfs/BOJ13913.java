package isu.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ13913 {
    static int start, target;
    static int[] visited = new int[100001];
    static int[] path = new int[100001];

    public static void main(String[] args) throws IOException {
        new BOJ13913().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        start = Integer.parseInt(tokenizer.nextToken());
        target = Integer.parseInt(tokenizer.nextToken());

        // target이 더 뒤에 있는 경우, 무조건 뒤로 갈 수 밖에 없음
        // 같은 곳에 있는 경우는 0과 해당 자리 출력
        if (target <= start) {
            writer.write(start - target + "\n");

            while (target <= start) {
                writer.write(start + " ");
                start--;
            }
            writer.flush();
            return;
        }

        bfs();

        writer.write(visited[target] - 1 + "\n");

        Stack<Integer> stack = new Stack<>();
        stack.push(target);

        // target에서부터 이전 경로로 돌아가면서 start까지 stack에 담음
        while (target != start) {
            stack.push(path[target]);
            target = path[target];
        }

        while (!stack.isEmpty()) {
            writer.write(stack.pop() + " ");
        }

        writer.flush();
        writer.close();
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
                path[num - 1] = num; // 이동하기 전 위치 저장
            }

            // case 2: 앞으로 한 칸 이동하는 경우
            if (num + 1 <= 100000 && visited[num + 1] == 0) {
                visited[num + 1] = visited[num] + 1;
                queue.add(num + 1);
                path[num + 1] = num;
            }

            // case 3: 앞으로 순간이동 하는 경우
            if (num * 2 <= 100000 && visited[num * 2] == 0) {
                visited[num * 2] = visited[num] + 1;
                queue.add(num * 2);
                path[num * 2] = num;
            }
        }
    }
}