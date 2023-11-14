package jwh.simulation.BOJ21610;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ21610 {
    static class pos {
        int y, x;

        public pos(int x, int y) {
            this.y = y;
            this.x = x;
        }
    }

    static int[][] map;

    static ArrayList<pos> cloud_list = new ArrayList<>();
    static int n = 0; // n은 맵크기
    static int m = 0; // m 은 이동기 갯수
    static boolean visit[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n]; // 맵 초기화

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cloud_list_init(); // 구름 리스트 초기 생성값

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            visit = new boolean[n][n];
            move(dir, dist); // 구름 이동하고 물의 양 증가
            copy(); // 물복사 하고
            make(); // 구름을 제외한 2이상에 구름만들고, 구름삭제해야됨
        }

        System.out.println(result());

        // result(); 최종 합산을 반환
        // test_map(); map 테스트 함수
        // test_cloud_list(); 구름_리스트버젼 테스트
        // cloud_list_size(); 구름_리스트의 크기를 반환하는 함수
        br.close();
    }

    private static int result() {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += map[i][j];
            }
        }
        return result;
    }

    static void cloud_list_init() {
        cloud_list.add(new pos(0, n - 1));
        cloud_list.add(new pos(1, n - 1));
        cloud_list.add(new pos(0, n - 2));
        cloud_list.add(new pos(1, n - 2));
    }

    static void move(int dir, int dist) {
        // dir이 들어오면, 해당 dir대로 nx, ny로 표현해주는거 구현하기
        // dist는 for문의 최대수치로 해봅시다
        // 구름의 좌표를 먼저 불러오고, 해당 좌표를 움직여야 할 것 같음
        // nx < 0 이면 nx = n-1 , nx > n-1 이면 nx = 0,
        // x는 -가 좌고 +가 우지만.. y는 -가 상이고 +가 하다
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, -1, 0, 1 };

        int nx = 0, ny = 0;
        for (int i = 0; i < cloud_list.size(); i++) { // 구름 숫자만큼 반복하는데
            nx = cloud_list.get(i).x;
            ny = cloud_list.get(i).y; // x,y 참조
            dist %= n;
            for (int j = 0; j < dist; j++) {
                switch (dir) {
                    case 1: { // 좌
                        nx = nx + dx[0];
                        ny = ny + dy[0];
                        break;
                    }
                    case 2: { // 좌상
                        nx = nx + dx[0];
                        ny = ny + dy[1];
                        break;
                    }
                    case 3: { // 상
                        nx = nx + dx[1];
                        ny = ny + dy[1];
                        break;
                    }
                    case 4: { // 우상
                        nx = nx + dx[2];
                        ny = ny + dy[1];
                        break;
                    }
                    case 5: { // 우
                        nx = nx + dx[2];
                        ny = ny + dy[2];
                        break;
                    }
                    case 6: { // 우하
                        nx = nx + dx[2];
                        ny = ny + dy[3];
                        break;
                    }
                    case 7: { // 하
                        nx = nx + dx[3];
                        ny = ny + dy[3];
                        break;
                    }
                    case 8: { // 좌하
                        nx = nx + dx[0];
                        ny = ny + dy[3];
                        break;
                    }

                }
                if (nx < 0) {
                    nx = n - 1;
                }
                if (nx > n - 1) {
                    nx = 0;
                }
                if (ny < 0) {
                    ny = n - 1;
                }
                if (ny > n - 1) {
                    ny = 0;
                }
            }

            cloud_list.get(i).x = nx;
            cloud_list.get(i).y = ny;
            visit[ny][nx] = true;
            map[ny][nx] += 1; // 바가지에 1씩 증가
        }
    }

    static void copy() {// 물복사 마법을 일으켜야하는 부분.

        int[] dx = { -1, 1, 1, -1 };
        int[] dy = { 1, -1, 1, -1 };
        // 대각선을 참조해서 해당 map의 숫자가 0 이상일경우, 1씩 증가시킨다.
        for (int i = 0; i < cloud_list.size(); i++) { // 물복사 버그는 이전 구름의 양 만큼 진행한다.
            int x = cloud_list.get(i).x;// x의 위치 참조
            int y = cloud_list.get(i).y;// y의 위치 참조
            for (int j = 0; j < 4; j++) { // 대각선 탐색기
                int nx = x + dx[j];
                int ny = y + dy[j];
                if (nx < 0 || nx > n - 1) {
                    continue;
                }
                if (ny < 0 || ny > n - 1) {
                    continue;
                }
                // 대각선을 탐색할때에는, 맵을 크게 보지 않기 떄문에, 넘치면 그냥 다음 대각 탐색

                if (map[ny][nx] > 0) {
                    map[y][x] += 1;
                }
            }
        }
    }

    static void make() {

        for (int i = cloud_list.size() - 1; i >= 0; i--) {
            cloud_list.remove(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[j][i] >= 2 && !visit[j][i]) { // 바구니 안에 2 이상이고 구름이 아니라면?
                    map[j][i] -= 2; // 2를 빼줍시다.
                    // 그리고 여기에다가 구름을 추가해야하는데..순서가 중요하진 않지만.. 밀어 넣긴 해야함
                    cloud_list.add(new pos(i, j));
                }
            }
        }

    }

    static void test_map() {
        for (int i = 0; i < n; i++) {
            System.out.println("");
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
        }
    }

}
