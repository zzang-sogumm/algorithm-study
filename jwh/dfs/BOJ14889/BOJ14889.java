package jwh.dfs.BOJ14889;

import java.io.*;
import java.util.*;

class BOJ148891 {
    static int n;
    static int tmp = 0;
    static int[][] s;
    static int charge;
    static int min = Integer.MAX_VALUE;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        charge = n / 2;

        s = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[n];

        dfs(0, 0);
        System.out.println(min);

        br.close();
    }

    static void diff() {
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visit[i] == true && visit[j] == true) {
                    team_start += s[i][j];
                    team_start += s[j][i];
                } else if (visit[i] == false && visit[j] == false) {
                    team_link += s[i][j];
                    team_link += s[j][i];
                }
            }
        }
        int val = Math.abs(team_start - team_link);

        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }

        min = Math.min(val, min);

    }

    static void dfs(int idx, int dep) {

        if (dep == charge) {
            diff();
            return;
        }

        for (int i = idx; i < n; i++) {

            if (!visit[i]) {
                visit[i] = true;
                dfs(i + 1, dep + 1);
                visit[i] = false;
            }
        }
    }
}