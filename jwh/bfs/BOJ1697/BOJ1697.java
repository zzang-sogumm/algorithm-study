package jwh.bfs.BOJ1697;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class BOJ1697 {
    static int x, k;
    static int[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        result = new int[100001];
        Arrays.fill(result, 100001);
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        result[x] = 0;
        bfs(x, k);

        System.out.println(result[k]);

        br.close();
    }

    static void bfs(int start, int end) {
        if (start == end) {
            result[end] = 0;
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (true) {

            int tmp = q.poll();
            if (tmp == end) {
                break;
            }

            // 새로 들어가는곳에서 이미 더 빠른 초가 있으면 들어가지마라

            if (tmp + 1 < 100001) {
                if (result[tmp + 1] > result[tmp] + 1) {
                    result[tmp + 1] = result[tmp] + 1;
                    q.add(tmp + 1);
                }
            }

            if (tmp - 1 >= 0) {
                if (result[tmp - 1] > result[tmp] + 1) {
                    result[tmp - 1] = result[tmp] + 1;
                    q.add(tmp - 1);
                }
            }

            if (tmp * 2 < 100001) {
                if (result[tmp * 2] > result[tmp] + 1) {
                    result[tmp * 2] = result[tmp] + 1;
                    q.add(tmp * 2);
                }
            }

        }

    }
}