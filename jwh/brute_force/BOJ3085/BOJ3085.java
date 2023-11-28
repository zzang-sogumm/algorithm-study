package jwh.brute_force.BOJ3085;

import java.util.*;
import java.io.*;

public class BOJ3085 {

    static int n;
    static int result = 0;

    static char[][] cntArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        cntArr = new char[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < n; j++) {
                char c = str.charAt(j);
                cntArr[i][j] = c;
            }
        }
        // result = search();
        change(); // 인접합 두칸 고르고 바꾸기
        System.out.println(result);

        // test_map();
    }

    static int search() { // 최대 몇개 먹을 수 있나 찾아보는 함수
        int max = 0;
        int tmp = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (cntArr[i][j] == cntArr[i][j - 1]) { // 같은 행에서 몇개까지 연결되어있는가?
                    tmp = tmp + 1;
                } else {
                    tmp = 1;
                }
                max = Math.max(tmp, max);
            }
            tmp = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (cntArr[j][i] == cntArr[j - 1][i]) { // 같은 열에서 몇개까지 연결되어있는가?
                    tmp = tmp + 1;
                } else {
                    tmp = 1;
                }
                max = Math.max(tmp, max);
            }
            tmp = 1;
        }

        // System.out.println(max);
        return max;
    }

    static void change() { // 상,하,좌,우 한번씩 바꿔보면서 진행
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    char tmp = ' ';
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) { // 맵을 벗어나거나
                        continue;
                    } else if (cntArr[i][j] == cntArr[nx][ny]) { // 같은 사탕은 바꿀 수 없다.
                        continue;
                    } else {
                        tmp = cntArr[nx][ny];
                        cntArr[nx][ny] = cntArr[i][j];
                        cntArr[i][j] = tmp;
                    }
                    // test_map();
                    result = Math.max(result, search());
                    if (tmp != ' ') { // 바꾼거 원상복구
                        tmp = cntArr[nx][ny];
                        cntArr[nx][ny] = cntArr[i][j];
                        cntArr[i][j] = tmp;
                    }
                }
            }
        }

    }

    static void test_map() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(cntArr[i][j]);
            }
            System.out.println();
        }
        System.out.println(" ");
    }

}