package jwh.simulation.BOJ17144;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ17144 {
    static int map[][]; // 맵 제작
    static int tmp[][]; // 확산시 가중치 잠시 저장할곳
    static int r; // 행 전역변수
    static int c; // 열 전역변수
    static List<Integer> cleaner = new ArrayList<Integer>();
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 }; // 0-우,1-좌,3-상,4-하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()); // 행
        c = Integer.parseInt(st.nextToken()); // 열
        int t = Integer.parseInt(st.nextToken()); // 시간
        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 맵 미세먼지 입력 끝

        for (int i = 0; i < t; i++) {
            tmp = new int[r][c];
            flood();// 미세먼지 확산 구현
            move(); // 공기청정기에 의한 움직임 구현
        }

        System.out.println(result());

        // print_map(); // 맵 프린트

        br.close();
    }

    static void move() {
        // cleaner 에 0열 ?행 을 저장시켜놨음. 위 아래 역순으로 끌어오면 될듯
        int up_pos = cleaner.get(0); // 윗놈 y좌표 (행좌표)
        int down_pos = cleaner.get(1); // 아랫놈 y좌표 (행좌표) x는 항상 0
        up(up_pos);
        down(down_pos);

    }

    static void up(int up_pos) {
        for (int i = up_pos - 1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        } // 위
        for (int i = 0; i < c - 1; i++) {
            map[0][i] = map[0][i + 1];
        } // 좌
        for (int i = 0; i < up_pos; i++) {
            map[i][c - 1] = map[i + 1][c - 1];
        } // 아래
        for (int i = c - 1; i > 0; i--) {
            map[up_pos][i] = map[up_pos][i - 1];
        } // 우
        map[up_pos][1] = 0;
    }

    static void down(int down_pos) {
        for (int i = down_pos + 1; i < r - 1; i++) {
            map[i][0] = map[i + 1][0];
        } // 위
        for (int i = 0; i < c - 1; i++) {
            map[r - 1][i] = map[r - 1][i + 1];
        } // 좌
        for (int i = r - 1; i >= down_pos; i--) {
            map[i][c - 1] = map[i - 1][c - 1];
        } // 아래
        for (int i = c - 1; i > 0; i--) {
            map[down_pos][i] = map[down_pos][i - 1];
        } // 우
        map[down_pos][1] = 0;
    }

    static void flood() {// 미세먼지의 확산
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] > 0) {
                    check_way(i, j);
                } else if (map[i][j] < 0) { // 공기청정기 위치 받아놓기
                    cleaner.add(i);
                }
            }
        } // 1. map을 한칸씩 돌면서, 미세먼지가 있다면, 해당 칸주변을 탐색하고 확산을 진행시킨다.
        sum(); // tmp에 저장했던거 map이랑 합쳐주기
    }

    static void check_way(int y, int x) { // x는 열, y는 행
        int cnt = 0;
        for (int i = 0; i < 4; i++) { // 4 방향을 탐색해보고
            int nx = x + dx[i]; // 새로운 열
            int ny = y + dy[i]; // 새로운 행 즉, map[ny][nx]
            if (nx < 0 || nx >= c || ny < 0 || ny >= r || map[ny][nx] == -1) { // 맵이탈 있으면 continue
                continue;
            } else { // 맵이탈이 없으면, 해당 위치에 확산 예정이니깐, map/5 해서 뿌려주자
                tmp[ny][nx] += map[y][x] / 5;
                cnt++;
            }
        }
        map[y][x] = map[y][x] - (map[y][x] / 5) * cnt;

    }

    static void sum() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] += tmp[i][j];
            }
        }
    }

    static void print_map() {
        for (int i = 0; i < r; i++) {
            System.out.println("");
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j] + " ");
            }
        }
        System.out.println("");
    }

    static int result() {
        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] >= 0) {
                    max += map[i][j];
                }
            }
        }
        return max;
    }
}
