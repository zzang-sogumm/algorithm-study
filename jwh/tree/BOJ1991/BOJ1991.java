package jwh.tree.BOJ1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1991 {

    static ArrayList<ArrayList<String>> ls = new ArrayList<>();
    static int n;
    static String tree[][];
    static String result[];
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<String> stack = new Stack<>();
        n = Integer.parseInt(st.nextToken());
        result = new String[n];
        Arrays.fill(result, "");
        visit = new boolean[n];
        tree = new String[1000][2];

        for (int i = 0; i < n; i++) {
            ls.add(new ArrayList<String>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            String c = st.nextToken();
            ls.get(i).add(a);
            ls.get(i).add(b);
            ls.get(i).add(c);

        }

        stack.push(ls.get(0).get(0));
        while (!stack.isEmpty()) {
            String str = stack.pop();
            result[0] += str;
            for (int i = 0; i < n; i++) {
                if (str.equals(ls.get(i).get(0))) {
                    if (!ls.get(i).get(2).equals(".")) {
                        stack.add(ls.get(i).get(2));
                    }
                    if (!ls.get(i).get(1).equals(".")) {
                        stack.add(ls.get(i).get(1));
                    }
                    break;
                }
            }
        } // 전위순회
        in("A"); // 중순
        po("A"); // 후순

        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);

    }

    public static void in(String str) {
        int x = 0;
        for (int i = 0; i < n; i++) {
            if (str.equals(ls.get(i).get(0))) {
                x = i;
            }
        }
        if (ls.get(x).get(1).equals(".") && ls.get(x).get(2).equals(".")) {
            result[1] += ls.get(x).get(0);
        } else {
            if (!ls.get(x).get(1).equals(".")) {
                in(ls.get(x).get(1));
            }
            result[1] += ls.get(x).get(0);
            if (!ls.get(x).get(2).equals(".")) {
                in(ls.get(x).get(2));
            }
        }
    }

    public static void po(String str) {
        int x = 0;
        for (int i = 0; i < n; i++) {
            if (str.equals(ls.get(i).get(0))) {
                x = i;
                break;
            }
        }
        if (ls.get(x).get(1).equals(".") && ls.get(x).get(2).equals(".")) {
            result[2] += ls.get(x).get(0);
        } else {
            if (!ls.get(x).get(1).equals(".")) {
                po(ls.get(x).get(1));
            }
            if (!ls.get(x).get(2).equals(".")) {
                po(ls.get(x).get(2));

            }
            result[2] += ls.get(x).get(0);

        }
    }

}
