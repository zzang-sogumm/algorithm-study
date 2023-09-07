package isu.two_pointer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ21921 {

    public static void main(String[] args) throws IOException {
        new BOJ21921().run();
    }

    // 누적합, 슬라이딩 윈도우
    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int day = Integer.parseInt(tokenizer.nextToken());
        int range = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        int[] visitorNums = new int[day];

        for (int i = 0; i < day; i++) {
            visitorNums[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int sum = 0, max = 0, count = 0;

        for (int index = 0; index < day; index++) {
            sum += visitorNums[index];

            if (index >= range) { // 범위 맨 앞에 숫자는 다시 빼줌
                sum -= visitorNums[index - range];
            }

            if (index >= range - 1) {
                if (sum > max) { // 최대값이 변경되는 경우
                    max = sum;
                    count = 1; // 카운트 초기화
                } else if (sum == max) { // 최대값이 중복되는 경우
                    count++; // 카운트  + 1
                }
            }
        }

        if (max == 0) {
            writer.write("SAD");
        } else {
            writer.write(max + "\n");
            writer.write(String.valueOf(count));
        }

        writer.flush(); // 내용 출력
        writer.close(); // 종료
    }
}
