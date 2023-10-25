package jwh.tree.BOJ14675;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BOJ14675 {
    static int n;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            search(a, b);
        }
        System.out.println(sb);
        br.close();
    }

    static void search(int index, int node) {
        if (index == 1) {
            if (list.get(node).size() >= 2) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        } else if (index == 2) {
            sb.append("yes").append("\n");
        }

    }
}
/*
 * if (list.get(node).equals(null)) {
 * sb.append("no").append("\n");
 * } else if (list.get(node).size() == 1) {
 * int check = 0;
 * for (int i = 0; i < n; i++) {
 * for (int j = 0; j < list.get(i).size(); j++) {
 * if (list.get(i).get(j).equals(node)) {
 * sb.append("yes").append("\n");
 * check++;
 * break;
 * }
 * }
 * }
 * if (check == 0) {
 * sb.append("no").append("\n");
 * }
 * } else {
 * sb.append("yes").append("\n");
 * }
 */