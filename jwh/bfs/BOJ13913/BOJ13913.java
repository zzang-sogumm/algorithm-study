// 숨바꼭질과 비슷하지만, 경로를 찾아줘야하는 문제
package jwh.bfs.BOJ13913;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

class BOJ13913 {
    static int x, k;
    static int[] result;
    static int[] how_to;
    // static List<List<Integer>> list = new ArrayList<>(); ->?리스트를 사용하려 했지만, list안에
    // 담기는 숫자가 50억개가 넘는 사태가 발생
    static HashMap<Integer, Integer> map = new HashMap<>(); // 해시맵으로 변경

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        result = new int[100001];
        how_to = new int[100001];
        Arrays.fill(result, 100001);
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        result[x] = 0;
        bfs(x, k);
        System.out.println(result[k]);

        int tmp = k;
        how_to[0] = k;
        for (int i = 1; i <= result[k]; i++) {
            tmp = map.get(tmp);
            how_to[i] = tmp;

        }

        for (int i = result[k]; i >= 0; i--) {
            System.out.print(how_to[i] + " ");
        }

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
                    map.put(tmp + 1, tmp);
                    q.add(tmp + 1);
                }
            }

            if (tmp - 1 >= 0) {
                if (result[tmp - 1] > result[tmp] + 1) {
                    result[tmp - 1] = result[tmp] + 1;
                    map.put(tmp - 1, tmp);
                    q.add(tmp - 1);
                }
            }

            if (tmp * 2 < 100001) {
                if (result[tmp * 2] > result[tmp] + 1) {
                    result[tmp * 2] = result[tmp] + 1;
                    map.put(tmp * 2, tmp);
                    q.add(tmp * 2);
                }
            }

        }

    }
}