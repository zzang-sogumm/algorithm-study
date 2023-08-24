package isu.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2503 {
    static boolean[] check;
    static int ballCount, strikeCount;

    public static void main(String[] args) throws IOException {
        new BOJ2503().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int questionNum = Integer.parseInt(reader.readLine());

        initCheckArr();

        for (int i = 0; i < questionNum; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int num = Integer.parseInt(tokenizer.nextToken());
            int strike = Integer.parseInt(tokenizer.nextToken());
            int ball = Integer.parseInt(tokenizer.nextToken());

            for (int index = 123; index <= 987; index++) {
                if (check[index]) { // true인 경우에만 게임 진행
                    baseballGame(index, num, strike, ball);
                }
            }
        }

        computeCount();
    }

    private void baseballGame(int index, int num, int strike, int ball) {
        strikeCount = 0;
        ballCount = 0;

        String input = Integer.toString(num);
        String answer = Integer.toString(index);

        for (int a = 0; a < 3; a++) {
            if (input.charAt(a) == answer.charAt(a)) {
                strikeCount++;
            }
            for (int b = 0; b < 3; b++) {
                if (input.charAt(a) == answer.charAt(b) && a != b) {
                    ballCount++;
                }
            }
        }

        if (strike != strikeCount || ball != ballCount) {
            check[index] = false;
        }
    }

    private void computeCount() {
        int count = 0;

        for (int index = 123; index <= 987; index++) {
            if (check[index]) {
                count++;
            }
        }
        System.out.println(count);
    }

    private void initCheckArr() {
        check = new boolean[1000];

        for (int index = 123; index <= 987; index++) {
            String number = String.valueOf(index);

            if (number.contains("0")) {  // 0이 포함된 경우 제외시킴
                continue;
            } else if (number.charAt(0) == number.charAt(1) ||
                    number.charAt(1) == number.charAt(2) ||
                    number.charAt(2) == number.charAt(0)) {
                // 숫자가 겹치는 경우 제외시킴
                continue;
            }

            check[index] = true;
        }
    }
}
