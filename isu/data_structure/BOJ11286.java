package isu.data_structure;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ11286 {
    static PriorityQueue<Integer> positiveQue, negativeQue;

    public static void main(String[] args) throws IOException {
        new BOJ11286().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        positiveQue = new PriorityQueue<>();
        negativeQue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(reader.readLine());

            if (num == 0) {
                // 절댓값이 가장 작은 값 출력
                printAbsMin(writer);
            } else if (num < 0) {
                negativeQue.add(num);
            } else { // num > 0
                positiveQue.add(num);
            }
        }

        writer.flush(); // 내용 출력
        writer.close(); // 종료
    }

    private void printAbsMin(BufferedWriter writer) throws IOException {
        if (positiveQue.isEmpty() && negativeQue.isEmpty()) {
            // 두 큐가 모두 빈 경우 0 출력
            writer.write(0 + "\n");
        } else if (positiveQue.isEmpty()) {
            // 양수 큐만 빈 경우 음수 큐에서 제일 큰 값(절대값이 가장 작은 값) 출력
            writer.write(negativeQue.poll() + "\n");
        } else if (negativeQue.isEmpty()) {
            // 음수 큐만 빈 경우 양수 큐에서 제일 큰 값 출력
            writer.write(positiveQue.poll() + "\n");
        } else { // 두 큐 모두 비어있지 않은 경우
            int negativeAbs = -negativeQue.peek();
            int positive = positiveQue.peek();

            // 각 큐의 절댓값 중 가장 작은 값을 서로 비교
            // 더 작은 값을 출력하고 그 값은 poll 함
            if (negativeAbs > positive) {
                writer.write(positiveQue.poll() + "\n");
            } else {
                writer.write(negativeQue.poll() + "\n");
            }
        }
    }
}
