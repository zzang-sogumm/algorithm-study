package isu.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ14425 {

    public static void main(String[] args) throws IOException {
        new BOJ14425().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int count = 0;
        HashSet<String> set = new HashSet<>();

        for (int index = 0; index < n; index++) {
            set.add(reader.readLine());
        }

        for (int index = 0; index < m; index++) {
            if (set.contains(reader.readLine())) {
                count++;
            }
        }

        System.out.println(count);
    }
}
