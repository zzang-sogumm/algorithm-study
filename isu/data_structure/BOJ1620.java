package isu.data_structure;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ1620 {

    public static void main(String[] args) throws IOException {
        new BOJ1620().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int pocketNum = Integer.parseInt(tokenizer.nextToken());
        int questionNum = Integer.parseInt(tokenizer.nextToken());

        HashMap<String, String> pocketmonBook = new HashMap<>();

        for (int index = 1; index <= pocketNum; index++) {
            String name = reader.readLine();
            String num = String.valueOf(index);
            pocketmonBook.put(num, name);
            pocketmonBook.put(name, num);
        }

        for (int index = 0; index < questionNum; index++) {
            String question = reader.readLine();
            writer.write(pocketmonBook.get(question) + "\n");
        }

        // 시간 초과
//        for (int index = 0; index < questionNum; index++) {
//            String question = reader.readLine();
//
//            if (question.matches("^[0-9]*$")) { // 숫자인 경우
//                int num = Integer.parseInt(question);
//                writer.write(pocketmonBook.get(num) + "\n");
//            } else { // 문자인 경우
//                for (int key : pocketmonBook.keySet()) {
//                    if (pocketmonBook.get(key).equals(question)) {
//                        writer.write(key + "\n");
//                        break;
//                    }
//                }
//            }


        writer.flush(); // 내용 출력
        writer.close(); // 종료
        reader.close();
    }
}
