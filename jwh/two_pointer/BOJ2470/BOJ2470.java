package jwh.two_pointer.BOJ2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class BOJ2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int n = 0, t_l = 0, t_r = 0;
        int l = 0, r = 0;
        double result = 2000000001;
        n = Integer.parseInt(st.nextToken());

        double[] wat = new double[n];

        for (int i = 0; i < n; i++) {
            wat[i] = Double.parseDouble(st2.nextToken());
        } // 입력란

        Arrays.sort(wat);

        r = n - 1;
        while (l < r) {
            double tmp = 0;
            tmp = wat[l] + wat[r];
            result = Math.min(Math.abs(result), Math.abs(tmp));
            if (Math.abs(tmp) == Math.abs(result)) {
                t_l = (int) wat[l];
                t_r = (int) wat[r];
            }

            if (r == l) {
                break;
            } else if (result <= tmp) {
                r -= 1;
            } else if (result > tmp) {
                l += 1;
            } else if (result == 0) {
                t_l = (int) wat[l];
                t_r = (int) wat[r];
                break;
            }
        }
        System.out.println(t_l + " " + t_r);
        br.close();
    }
}
