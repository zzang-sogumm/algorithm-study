package jwh.simulation.BOJ17140;

import java.util.*;
import java.io.*;

public class BOJ17140 {

    static int r, c, k;
    static int[][] map;

    static int[][] exMap;

    static int[] cntArr; // 수의 갯수를 기록할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[3][3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (true) {
            // 범위를 체크하고 값을 찾으면 time 출력
            // 답이 범위에 없어도 이 후 연산에 따라 답이 나올 수 있다(tc 6번 케이스)
            if (r <= map.length && c <= map[0].length && map[r - 1][c - 1] == k) {
                System.out.println(time);
                break;
            }
            // 100초가 지나도 답이 없으면 -1 출력
            if (time > 100) {
                System.out.println(-1);
                break;
            }

            int rLen = map.length;
            int cLen = map[0].length;

            // 행, 열의 길이를 비교하여 다른 연산 수행
            if (rLen >= cLen) {
                rCal();
            } else {
                cCal();
            }

            time++;
        }

    }

    // R 연산
    static void rCal() {
        exMap = new int[300][300]; // 연산 후의 상태를 기록할 배열(자동으로 0을 채워줌)
        int maxListLen = 0; // 가장 긴 행의 길이 기록

        // 각 행을 탐색하며 연산
        for (int i = 0; i < map.length; i++) {
            // 현재 행에 있는 수의 갯수를 기록
            cntArr = new int[101];
            for (int j = 0; j < map[0].length; j++) {
                int num = map[i][j];
                cntArr[num]++;
            }
            // PriorityQueue를 사용하여 숫자와 해당 수의 갯수를 넣은 객체를 정렬
            PriorityQueue<Number> sortQue = new PriorityQueue<>();
            for (int n = 1; n <= 100; n++) {
                if (cntArr[n] != 0) {
                    sortQue.add(new Number(n, cntArr[n]));
                }
            }
            // 가장 긴 행의 길이 기록
            maxListLen = Math.max(maxListLen, sortQue.size());

            // exMap에 정렬 끝난 상태를 기록
            int idx = 0;
            while (!sortQue.isEmpty()) {
                Number num = sortQue.poll();
                exMap[i][idx] = num.num;
                idx++;
                exMap[i][idx] = num.cnt;
                idx++;
            }

        }

        // exMap을 map(원본 배열)로 복사
        // 문제 조건 중 행, 열이 100을 넘어가면 처음 100개를 제외한 나머지는 버린다
        int r = map.length;
        int c = 2 * maxListLen;
        if (r > 100) {
            r = 100;
        }
        if (c > 100) {
            c = 100;
        }

        map = new int[r][c];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = exMap[i][j];
            }
        }

    }

    // C 연산
    static void cCal() {
        exMap = new int[300][300];
        int maxListLen = 0;
        for (int j = 0; j < map[0].length; j++) {
            cntArr = new int[101];
            for (int i = 0; i < map.length; i++) {
                int num = map[i][j];
                cntArr[num]++;
            }

            PriorityQueue<Number> sortQue = new PriorityQueue<>();
            for (int n = 1; n <= 100; n++) {
                if (cntArr[n] != 0) {
                    sortQue.add(new Number(n, cntArr[n]));
                }
            }
            maxListLen = Math.max(maxListLen, sortQue.size());

            int idx = 0;
            while (!sortQue.isEmpty()) {
                Number num = sortQue.poll();
                exMap[idx][j] = num.num;
                idx++;
                exMap[idx][j] = num.cnt;
                idx++;
            }

        }

        int r = 2 * maxListLen;
        int c = map[0].length;
        if (r > 100) {
            r = 100;
        }
        if (c > 100) {
            c = 100;
        }
        map = new int[r][c];
        for (int j = 0; j < map[0].length; j++) {
            for (int i = 0; i < map.length; i++) {
                map[i][j] = exMap[i][j];
            }
        }

    }

    // 수의 갯수, 크기를 비교하여 정렬
    static class Number implements Comparable<Number> {
        int num, cnt;

        Number(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Number n) {
            // 수의 갯수 먼저 비교하여 정렬
            if (this.cnt < n.cnt) {
                return -1;
            } else if (this.cnt > n.cnt) {
                return 1;
            } else {
                // 수가 같다면 수의 크기를 비교하여 정렬
                if (this.num < n.num) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }
}