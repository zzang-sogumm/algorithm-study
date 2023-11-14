package isu.two_pointer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10025 {

    public static void main(String[] args) throws IOException {
        new BOJ10025().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        int[] buckets = new int[1000001];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int g = Integer.parseInt(tokenizer.nextToken());
            int x = Integer.parseInt(tokenizer.nextToken());

            buckets[x] = g;
        }

        int sum = 0, max = 0;
        int range = K * 2 + 1;

        for (int index = 0; index < 1000001; index++) {
            // index가 range 이상인 경우만 겹치지 않는 값 빼줌
            if (index >= range) {
                sum -= buckets[index - range];
            }

            // 추가된 값 더해줌
            sum += buckets[index];

            max = Math.max(sum, max);
        }

        writer.write(String.valueOf(max)); // 버퍼에 넣을 내용
        writer.flush(); // 내용 출력
        writer.close(); // 종료
    }
}