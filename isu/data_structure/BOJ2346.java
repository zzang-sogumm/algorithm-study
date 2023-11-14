package isu.data_structure;

import java.io.*;
import java.util.*;

public class BOJ2346 {
    static class Balloon {
        int index;
        String num;

        public Balloon(int index, String num) {
            this.index = index;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        new BOJ2346().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        reader.close();

        Deque<Balloon> balloons = new ArrayDeque<>();
        // 덱에 종이에 적힌 수 넣어줌
        for (int i = 1; i <= N; i++) {
            balloons.add(new Balloon(i, tokenizer.nextToken()));
        }

        while (balloons.size() > 1) {
            Balloon balloon = balloons.pollFirst();
            int burstNum = Integer.parseInt(balloon.num);
            int balloonNum = balloon.index;

            if (burstNum > 0) {
                positivePollAndOffer(burstNum, balloons);
            } else {
                // 음수는 한 칸 더 가준다.
                negativePollAndOffer(-burstNum + 1, balloons);
            }
            writer.write(balloonNum + " ");
        }

        // 마지막 풍선도 출력함
        writer.write(String.valueOf(Objects.requireNonNull(balloons.poll()).index));

        writer.flush();
        writer.close(); // 종료
    }

    private void positivePollAndOffer(int burstNum, Deque<Balloon> balloons) {
        for (int i = 1; i < burstNum; i++) {
            Balloon balloon = balloons.pollFirst();
            balloons.addLast(balloon);
        }
    }

    private void negativePollAndOffer(int burstNum, Deque<Balloon> balloons) {
        for (int i = 1; i < burstNum; i++) {
            Balloon balloon = balloons.pollLast();
            balloons.addFirst(balloon);
        }
    }
}
