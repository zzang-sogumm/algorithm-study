package jwh.data_structre2.BOJ2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class BOJ2504 {
    static Stack<String> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = new String();
        String[] split = new String[30];
        str = br.readLine();
        split = str.split("");
        int mul = 1, result = 0;// mul이라는 일시적인 곱셈 변수를 생성

        outerLoop: for (int i = 0; i < split.length; i++) {
            switch (split[i]) {
                case "(":
                    stack.push("(");
                    mul *= 2;
                    break;
                case "[":
                    stack.push("[");
                    mul *= 3;
                    break;
                case ")":
                    if (stack.isEmpty() || !stack.peek().equals("(")) {
                        result = 0;
                        break outerLoop;
                    }
                    if (split[i - 1].equals("("))
                        result += mul;
                    stack.pop();
                    mul /= 2;
                    break;
                case "]":
                    if (stack.isEmpty() || !stack.peek().equals("[")) {
                        result = 0;
                        break outerLoop;
                    }
                    if (split[i - 1].equals("["))
                        result += mul;
                    stack.pop();
                    mul /= 3;
                    break;
            }
        }
        if (!stack.empty()) {
            result = 0;
        }
        System.out.println(result);
        br.close();
    }
}
