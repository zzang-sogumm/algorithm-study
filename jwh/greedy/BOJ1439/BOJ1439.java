package jwh.greedy.BOJ1439;

import java.io.IOException;
import java.util.Scanner;

public class BOJ1439 {

    static int cnt_z = 0;
    static int cnt_o = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String str = "";

        int result = 0;

        str = sc.nextLine();

        int[] S = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            S[i] = str.charAt(i);
        }

        loop(S);

        result = Math.max(cnt_z, cnt_o);

        System.out.println(result);

        sc.close();
    }

    static void loop(int[] S) {

        int[] tmp_o = S;
        int[] tmp_z = S;

        for (int i = 0; i < tmp_o.length; i++) {
            if (i < tmp_z.length - 1) {
                if (tmp_o[i] != tmp_o[i + 1]) {
                    if (tmp_o[i + 1] != 48) {
                        cnt_o = cnt_o + 1;
                    }
                }
            }
        }

        for (int j = 0; j < tmp_z.length; j++) {
            if (j < tmp_z.length - 1) {
                if (tmp_z[j] != tmp_z[j + 1]) {
                    if (tmp_z[j + 1] != 49) {
                        cnt_z = cnt_z + 1;
                    }
                }
            }
        }
    }

}
