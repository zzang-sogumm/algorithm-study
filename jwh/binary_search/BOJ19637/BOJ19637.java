package jwh.binary_search.BOJ19637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ19637 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = 0, m = 0;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        String style[] = new String[n];
        int lim[] = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            style[i] = st1.nextToken();
            lim[i] = Integer.parseInt(st1.nextToken());
        }
        int champ[] = new int[m];
        String result[] = new String[m];
        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            champ[i] = Integer.parseInt(st2.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int s = 0, e = 0;
            e = n - 1; // 엔드를 최대값
            int mid = 0;
            while (s <= e) {
                mid = (s + e) / 2;
                if (lim[mid] < champ[i]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
            result[i] = style[s];
            sb.append(style[s]).append("\n");
        }
        System.out.println(sb);

        br.close();

    }

}
