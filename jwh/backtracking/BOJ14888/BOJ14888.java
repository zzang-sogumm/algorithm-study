package jwh.backtracking.BOJ14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {
    static int n;
    static int[] a;
    static int[] op;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        a = new int[n];
        op = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        back(0, a[0]);

        System.out.println(max);
        System.out.println(min);

    }

    public static void back(int index, int sum) {
        if (index == n - 1) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                switch (i) {
                    case 0:
                        back(index + 1, sum + a[index + 1]);
                        break;

                    case 1:
                        back(index + 1, sum - a[index + 1]);
                        break;

                    case 2:
                        back(index + 1, sum * a[index + 1]);
                        break;

                    case 3:
                        back(index + 1, sum / a[index + 1]);
                        break;

                }
                op[i]++;
            }

        }
    }
}