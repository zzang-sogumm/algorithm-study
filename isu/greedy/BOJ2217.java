package isu.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2217 {

    public static void main(String[] args) throws IOException {
        new BOJ2217().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());
        int[] ropes = new int[num];

        for (int i = 0; i < num; i++) {
            ropes[i] = Integer.parseInt(reader.readLine());
        }

        // 오름차순 정렬
        Arrays.sort(ropes);

        int max = 0;
        for (int i = 0; i < num; i++) {
            // (여러 로프 중 최소 값 * 로프의 개수)를 각각 계산해서 최대값 구함
            max = Math.max(max, ropes[i] * (num - i));
        }

        System.out.println(max);
    }
}
