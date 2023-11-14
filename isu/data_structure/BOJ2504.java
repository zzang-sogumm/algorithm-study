package isu.data_structure;

import java.io.*;
import java.util.Stack;

public class BOJ2504 {

    public static void main(String[] args) throws IOException {
        new BOJ2504().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String brackets = reader.readLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int value = 1;

        for (int i = 0; i < brackets.length(); i++) {
            char nowBracket = brackets.charAt(i);

            switch (nowBracket) {
                case '(':
                    stack.push(nowBracket);
                    value *= 2;
                    break;

                case '[':
                    stack.push(nowBracket);
                    value *= 3;
                    break;

                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        answer = 0;
                        break;
                    } else if (brackets.charAt(i - 1) == '(') {
                        answer += value;
                    }
                    stack.pop();
                    value /= 2;
                    break;

                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        answer = 0;
                        break;
                    }

                    if (brackets.charAt(i - 1) == '[') {
                        answer += value;
                    }
                    stack.pop();
                    value /= 3;
                    break;
            }
        }

        // 스택에 괄호가 남아있으면 올바르지 못한 괄호열임
        if (!stack.isEmpty()) {
            answer = 0;
        }

        writer.write(String.valueOf(answer));
        writer.flush(); // 내용 출력
        writer.close(); // 종료
    }
}
