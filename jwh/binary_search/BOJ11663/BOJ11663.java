package jwh.binary_search.BOJ11663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = 0, m = 0;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int dot[] = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dot[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(dot);

        for (int i = 0; i < m; i++) {
            int line[] = new int[2];
            int sub[] = new int[2];

            st = new StringTokenizer(br.readLine());
            line[0] = Integer.parseInt(st.nextToken());
            line[1] = Integer.parseInt(st.nextToken());
            Arrays.sort(line);

            for (int j = 0; j < 2; j++) {
                int s = 0, e = 0, mid;
                e = n - 1;
                while (s <= e) {
                    mid = (s + e) / 2;
                    if (dot[mid] >= line[j]) {
                        e = mid - 1;
                    } else if (dot[mid] < line[j]) {
                        s = mid + 1;
                    }
                }
                if (s > n - 1) {
                    s = n - 1;
                }
                if (j == 1 && dot[s] > line[1]) {
                    s = s - 1;
                }
                if (line[0] < dot[0] && line[1] < dot[0]) {
                    sub[0] = -1;
                } else if (line[1] > dot[n - 1] && line[0] > dot[n - 1]) {
                    sub[0] = -1;
                } else {
                    sub[j] = s;
                }

            }
            if (sub[0] == -1) {
                sb.append(0).append("\n");
            } else {
                sb.append(sub[1] - sub[0] + 1).append("\n");
            }

        }

        System.out.println(sb);

        br.close();

    }

}
