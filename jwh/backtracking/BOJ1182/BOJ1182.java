package jwh.backtracking.BOJ1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ1182 {
    static int n = 0, s = 0, cnt = 0;
    static int map[], sum[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        map = new int[n];
        sum = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        if (s == 0) {
            System.out.println(cnt - 1);
        } else
            System.out.println(cnt);

        br.close();

    }

    static void dfs(int dep, int sum) {

        if (dep == n) {
            if (sum == s)
                cnt++;
            return;
        }
        dfs(dep + 1, sum + map[dep]);
        dfs(dep + 1, sum);

    }

}
