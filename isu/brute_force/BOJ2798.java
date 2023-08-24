package isu.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2798 {

    public static void main(String[] args) throws IOException {
        new BOJ2798().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int cardNum = Integer.parseInt(tokenizer.nextToken());
        int dealer = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        int[] cards = new int[cardNum];

        for (int index = 0; index < cardNum; index++) {
            cards[index] = Integer.parseInt(tokenizer.nextToken());
        }

        int result = startGame(cards, dealer);

        System.out.println(result);
    }

    private int startGame(int[] cards, int dealer) {
        int max = 0;
        int num = cards.length;

        for (int i = 0; i < num - 2; i++) {
            for (int j = i + 1; j < num - 1; j++) {
                for (int k = j + 1; k < num; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum <= dealer) {
                        max = Math.max(max, sum);
                    }
                }
            }
        }

        return max;
    }
}

