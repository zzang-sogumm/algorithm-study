package isu.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1758 {

    public static void main(String[] args) throws IOException {
        new BOJ1758().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());
        int[] tips = new int[num];

        for (int i = 0; i < num; i++) {
            tips[i] = Integer.parseInt(reader.readLine());
        }

        // 오름차순 정렬
        Arrays.sort(tips);

        // 팁을 많이 주려고 한 사람부터 앞에 세움
        long tip = 0; // 각 팁의 최대값이 100,000, 사람 수의 최대값이 100,000이므로 long으로 선언
        for (int rank = 1; rank <= num; rank++) {
            tip += computeTip(tips[num - rank], rank);
        }

        System.out.println(tip);
    }

    private int computeTip(int money, int rank) {
        int tip = money - (rank - 1);

        return Math.max(tip, 0);
    }
}

