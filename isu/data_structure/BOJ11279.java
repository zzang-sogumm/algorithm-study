package isu.data_structure;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ11279 {

    public static void main(String[] args) throws IOException {
        new BOJ11279().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(reader.readLine());

            if (num == 0) {
                if (que.isEmpty()) {
                    writer.write(0 + "\n");
                } else {
                    writer.write(que.poll() + "\n");
                }
            } else {
                que.add(num);
            }
        }

        writer.flush(); // 내용 출력
        writer.close(); // 종료
    }
}
