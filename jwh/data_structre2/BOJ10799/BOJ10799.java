package jwh.data_structre2.BOJ10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class BOJ10799 {
    static Stack<String> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String stick = new String();
        String[] split = new String[100001];
        stick = br.readLine();

        split = stick.split("");

        int s_num = 0, laser = 0, result = 0; // s_num은 철근, laser는 레이저, result 잘린 조각 수

        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("(")) { // (가 입력되었으면 스택에 넣어줌
                stack.push("(");
                s_num++;
            } else if (stack.empty()) {
                System.out.println("스택이 비었습니다.");
                continue;
            } else if (split[i - 1].equals("(") && split[i].equals(")")) { // 바로 전 문자열이(이고, 다음 문자열이)일 경우는 레이져로 판단함
                stack.pop();
                if (stack.empty()) { // 스택이 비어있으면, 잘릴게 없다고 판단, s넘만 줄이고 컨티뉴
                    s_num--;
                    continue;
                } else if (stack.peek().equals("(")) { // 이전 문자열도 (경우, 잘릴게 있다고 판단, 레이저 증가
                    s_num--;
                    laser++;
                }
            } else if (split[i].equals(")")) { // 레이저 제외 )만 나왔을경우, 철근의 끝 이라고 판단하여 조각증가, 철근 수 감소
                s_num--;
                result++;
            }

            if (laser > 0) {
                result = result + s_num * laser; // 잘렸을경우 계산식
                laser--;
            }

            // System.out.println("s넘" + s_num + "레쟈" + laser + "리절" + result);
        }
        System.out.println(result);
        br.close();
    }

}
