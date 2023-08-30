package isu.greedy;

import java.util.Scanner;

public class BOJ14916 {
    public static void main(String[] args) {
        new BOJ14916().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int change = sc.nextInt();
        sc.close();

        int count = -1;
        int time = change / 5;

        // 5로 나눈 몫이 0이 될 때까지 계산
        for (int i = time; i >= 0; i--) {
            int rest = change - (5 * i);

            if (rest % 2 == 0) { // 나머지가 짝수인 경우 count 계산
                count = (rest / 2) + i;
                break;
            }
        }

        System.out.println(count);
    }
}
