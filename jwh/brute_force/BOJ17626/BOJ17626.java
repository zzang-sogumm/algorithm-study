import java.io.IOException;
import java.util.Scanner;

public class BOJ17626 {

    static int n, n1, cnt, tmp, result;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n + 1];

        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            int min = 50001;
            for (int j = 1; j * j <= i; j++) {
                int idx = i - j * j;
                min = Math.min(min, arr[idx]);
            }
            arr[i] = min + 1;
        }

        System.out.println(arr[arr.length - 1]);

        sc.close();
    }
}
// 처음 시도한 dfs
/*
 * private static void dfs(int idx, int lev) {
 * tmp = 0;
 * 
 * if (n == 1) {
 * cnt = cnt + 1;
 * } else if (n == 2) {
 * cnt = cnt + 2;
 * } else if (idx * idx < n && lev == 0) {
 * dfs((idx + 1), lev);
 * } else if (idx * idx > n && lev != 0) {
 * tmp = n - ((idx - 1) * (idx - 1));
 * cnt = cnt + 1;
 * dfs(idx - 1, lev - 1);
 * lev = 0;
 * } else if (idx * idx == n) {
 * cnt = cnt + 1;
 * }
 * 
 * }
 * 
 * }
 */