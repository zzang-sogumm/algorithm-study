package jwh.tree.BOJ9372;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ9372 {

    static ArrayList<ArrayList<Integer>> plane = new ArrayList<>();
    static int cnt;
    static int result = Integer.MAX_VALUE;
    static boolean[] visit;
    static int[] print;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        print = new int[t];

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 국가수
            int m = Integer.parseInt(st.nextToken()); // 왕복 비행기 수
            for (int k = 0; k <= n; k++) { // 국가의 수 만큼 생성
                plane.add(new ArrayList<>());
            }
            for (int j = 0; j < m; j++) { // 왕복 비행기 수 만큼 만듬
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                plane.get(a).add(b);
                plane.get(b).add(a);
            }

            print[i] = n - 1;
        }

        for (int i = 0; i < t; i++) {
            System.out.println(print[i]);
        }

        br.close();
    }

}
