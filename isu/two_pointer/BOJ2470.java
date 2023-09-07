package isu.two_pointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {

    public static void main(String[] args) throws IOException {
        new BOJ2470().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int[] nums = new int[N];
        int[] answer = new int[2];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(nums);

        int startIdx = 0;
        int endIdx = N - 1;
        int min = Integer.MAX_VALUE;

        while (startIdx < endIdx) {
            int sum = nums[startIdx] + nums[endIdx];

            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                answer[0] = nums[startIdx];
                answer[1] = nums[endIdx];

                if (sum == 0) { // 0 인 경우 더이상 탐색하지 않음
                    break;
                }
            }

            if (sum < 0) {    // 차가 0보다 작은 경우 -> startIdx를 오른쪽으로 옮김
                startIdx++;
            } else {          // 차가 0보다 큰 경우 -> endIdx를 왼쪽으로 옮김
                endIdx--;
            }
        }

        writer.write(answer[0] + " " + answer[1]); // 버퍼에 넣을 내용
        writer.flush(); // 내용 출력
        writer.close(); // 종료
    }
}
