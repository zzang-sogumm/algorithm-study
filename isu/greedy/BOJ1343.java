package isu.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1343 {
    static final String FAIL = "-1";

    public static void main(String[] args) throws IOException {
//        new Main().run();
        new BOJ1343().run2();
    }

    private void run2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine();

        String result = board.replace("XXXX", "AAAA");
        result = result.replace("XX", "BB");

        if (result.contains("X")) {
            result = FAIL;
        }

        System.out.println(result);
    }


    private void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        String board = br.readLine();

        String[] pieces = board.split("\\.");

        for (String piece : pieces) {
            int len = piece.length();

            if (len == 0) { // 그냥 온점인 경우
                result.append(".");
                continue;
            }

            if (len % 2 != 0) { // 조각이 홀수인 경우 덮을 수 없음
                System.out.println("-1");
                return;
            }

            String next = appendNextPieces(piece);
            result.append(next);
        }

        // 마지막 온점 떼어줌
        result.deleteCharAt(result.length() - 1);
        result.append("\n");

        System.out.println(result);
    }

    private String appendNextPieces(String piece) {
        StringBuilder nextPieces = new StringBuilder();
        int length = piece.length();

        nextPieces.append("AAAA".repeat(length / 4));

        if (length % 4 != 0) { // 4칸씩 나누어 떨어지지 않는 경우, 뒤에 BB를 붙여줌
            nextPieces.append("BB");
        }

        nextPieces.append(".");

        return nextPieces.toString();
    }
}

