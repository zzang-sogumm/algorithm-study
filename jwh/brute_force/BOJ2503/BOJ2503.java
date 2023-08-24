package jwh.brute_force.BOJ2503;

import java.io.IOException;
import java.util.Scanner;

public class BOJ2503 {

    static int n;
    static int result;
    static int[] b_b, st, b, res;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        result = 0;
        st = new int[n];
        b = new int[n];
        b_b = new int[n];

        for (int i = 0; i < n; i++) {
            b_b[i] = sc.nextInt();
            st[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        for (int i = 123; i <= 987; i++) {
            loop(i);
        }
        System.out.println(result);

        sc.close();
    }

    static void loop(int num) {
        int q = 0, w = 0, e = 0, a = 0, s = 0, d = 0, eq = 0;

        for (int i = 0; i < n; i++) {
            q = b_b[i] / 100;
            w = (b_b[i] % 100) / 10;
            e = (b_b[i] % 10);
            // 입력 숫자 3자리로 잘라내기
            a = num / 100;
            s = (num % 100) / 10;
            d = num % 10;
            // 순회 숫자 3자리로 잘라내기
            if (a == s || a == d || s == d || a == 0
                    || s == 0 || d == 0) // 0이 나오거나 중복 제외
                continue;
            int str = 0;
            int bal = 0;
            if (q == a) {
                str++;
            }
            if (w == s) {
                str++;
            }
            if (e == d) {
                str++;
            }
            if (q == s) {
                bal++;
            }
            if (q == d) {
                bal++;
            }
            if (w == a) {
                bal++;
            }
            if (w == d) {
                bal++;
            }
            if (e == a) {
                bal++;
            }
            if (e == s) {
                bal++;
            }
            // 입력숫자, 순회숫자 비교해서 스트라이크, 볼 증가
            if (str == st[i] && bal == b[i]) {
                eq++;
            } // 스트라이크, 볼이 입력된 바와 같다면 EQ를 증가
        }
        if (eq == n) {
            result++;
        } // eq가 입력된만큼 다 맞을 경우 해당 경우의 수가 맞다는 증거이니, result 증가
    }

}

/*
 * import java.io.IOException;
 * import java.util.Scanner;
 * 
 * public class Main {
 * 
 * static int n;
 * static int result;
 * static int[] b_b, s, b, res;
 * static int[][] tmp_s, tmp_b;
 * static boolean[] check;
 * 
 * public static void main(String[] args) throws IOException {
 * Scanner sc = new Scanner(System.in);
 * 
 * n = sc.nextInt();
 * 
 * s = new int[4];
 * b = new int[4];
 * b_b = new int[4];
 * check = new boolean[10];
 * 
 * for (int i = 0; i < n; i++) {
 * b_b[i] = sc.nextInt();
 * s[i] = sc.nextInt();
 * b[i] = sc.nextInt();
 * }
 * 
 * loop();
 * dfs(1, 1);
 * 
 * sc.close();
 * }
 * 
 * static void loop() {
 * int q = 0, w = 0, e = 0;
 * tmp_s = new int[n][4];
 * tmp_b = new int[n][4];
 * res = new int[4];
 * 
 * for (int i = 0; i < n; i++) {
 * q = b_b[i] / 100;
 * w = (b_b[i] % 100) / 10;
 * e = (b_b[i] % 10);
 * 
 * if (s[i] > 0) {
 * tmp_s[i][0] = q;
 * tmp_s[i][1] = w;
 * tmp_s[i][2] = e;
 * 
 * }
 * if (b[i] > 0) {
 * tmp_b[i][0] = q;
 * tmp_b[i][1] = w;
 * tmp_b[i][2] = e;
 * }
 * }
 * 
 * }
 * 
 * private static void dfs(int idx, int lev) {
 * 
 * if (lev == 3) {
 * int sum = 0;
 * for (int i = 0; i < n; i++) {
 * int temp = 0;
 * for (int j = 1; j < 10; j++) {
 * if (check[j]) {
 * if (s[j - 1] > 0) {
 * 
 * }
 * 
 * }
 * }
 * sum += temp;
 * }
 * result = Math.max(sum, result);
 * return;
 * }
 * 
 * for (int i = idx; i < 9; i++) {
 * if (!check[i]) {
 * check[i] = true;
 * dfs(i + 1, lev + 1);
 * check[i] = false;
 * }
 * }
 * 
 * return;
 * }
 * 
 * }
 * 
 */