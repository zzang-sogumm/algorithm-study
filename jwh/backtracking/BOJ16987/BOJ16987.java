package jwh.backtracking.BOJ16987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16987 {
    static int n;
    static int m;
    static int str[];
    static int heavy[];
    static boolean visit[];
    static int cnt;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        str = new int[1000];
        heavy = new int[1000];
        visit = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            str[i] = Integer.parseInt(st1.nextToken());
            heavy[i] = Integer.parseInt(st1.nextToken());
        }
        dfs(0, 0);
        System.out.println(max);
    }

    public static void dfs(int now, int cnt) {
        if (now == n) {
            max = Math.max(cnt, max);
            return;
        }
        if (!visit[now]) { // 내께 깨진거면
            for (int i = 0; i < n; i++) {
                if (!visit[i]) { // 칠라는데 남에꺼가 깨져있으면
                    if (now == i) { // 내꺼로 내껄 팰순없으니.. continue
                        continue;
                    }
                    str[now] = str[now] - heavy[i];
                    str[i] = str[i] - heavy[now]; // 체력을 깎아보자
                    if (str[now] <= 0 && str[i] <= 0) { // 둘다 깨짐
                        visit[now] = true;
                        visit[i] = true;
                        dfs(now + 1, cnt + 2);
                        visit[now] = false;
                        visit[i] = false;
                    } else if (str[now] <= 0) { // 지꺼(now) 깨짐
                        visit[now] = true;
                        dfs(now + 1, cnt + 1);
                        visit[now] = false;
                    } else if (str[i] <= 0) { // 남에꺼(i) 깨짐
                        visit[i] = true;
                        dfs(now + 1, cnt + 1);
                        visit[i] = false;
                    } else {
                        dfs(now + 1, cnt);
                    }
                    str[now] = str[now] + heavy[i];
                    str[i] = str[i] + heavy[now];
                } // 체력을 다시 살려주자
            }
            if (now == 0 && cnt == 0) {
                return;
            } // 1번 계란은 무조건 치고 들어가야됨. 그러므로 1번 계란이 아닌경우는 스킵
            dfs(now + 1, cnt);
        } else {
            dfs(now + 1, cnt);
            return;
        }

    }

}
