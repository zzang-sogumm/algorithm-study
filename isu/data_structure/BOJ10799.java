package isu.data_structure;

import java.io.*;
import java.util.Stack;

public class BOJ10799 {

    public static void main(String[] args) throws IOException {
        new BOJ10799().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] brackets = reader.readLine().split("");
        Stack<String> stack = new Stack<>();
        int count = 0;

        for (int index = 0; index < brackets.length; index++) {
            String bracket = brackets[index];

            if (bracket.equals("(")) {
                stack.push(bracket);
            } else { // ) 인 경우
                // 이전 괄호 확인
                if (brackets[index - 1].equals("(")) {
                    // ( 였다면 레이저를 의미 -> stack 사이즈만큼 더함
                    stack.pop();
                    count += stack.size();
                } else {
                    // ) 였다면 닫힌 괄호를 의미 -> 카운트 + 1
                    stack.pop();
                    count++;
                }
            }
        }

        writer.write(String.valueOf(count)); // 버퍼에 넣을 내용
        writer.flush(); // 내용 출력
        writer.close(); // 종료
    }
}
