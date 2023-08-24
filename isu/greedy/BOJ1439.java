package isu.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1439 {

    public static void main(String[] args) throws IOException {
        new BOJ1439().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();

        int count01 = 0;
        int count10 = 0;

        for (int index = 0; index < word.length() - 1; index++) {
            char now = word.charAt(index);
            char next = word.charAt(index + 1);

            if (now == '0' && next == '1') {
                count01++;
            } else if (now == '1' && next == '0') {
                count10++;
            }
        }

        System.out.println(Math.max(count01, count10));
    }
}
