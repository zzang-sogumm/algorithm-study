package jwh.data_structre2.BOJ1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ1620 {

	static int n = 0, m = 0, cnt = 0;
	static HashMap<Integer, String> map1 = new HashMap<Integer, String>();
	static HashMap<String, Integer> map2 = new HashMap<String, Integer>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 1; i < n + 1; i++) {
			String s = br.readLine();
			map1.put(i, s);
			map2.put(s, i);
		}

		for (int i = 0; i < m; i++) {
			String temp = br.readLine();
			if (temp.matches(".*[0-9].*")) {
				sb.append(map1.get(Integer.parseInt(temp))).append("\n");
			} else
				sb.append(map2.get(temp)).append("\n");
		}
		System.out.println(sb);
	}

}

// 시간초과 코드
/*
 * import java.io.IOException;
 * import java.util.Scanner;
 * 
 * public class Main {
 * static String[] data;
 * static String[] ans;
 * static String[] out;
 * static int n = 0, m = 0, cnt = 0;
 * 
 * public static void main(String[] args) throws IOException {
 * Scanner sc = new Scanner(System.in);
 * n = sc.nextInt();
 * m = sc.nextInt();
 * data = new String[n + 1];
 * ans = new String[m + 1];
 * out = new String[m + 1];
 * 
 * for (int i = 0; i < n; i++) {
 * data[i] = sc.next();
 * }
 * 
 * for (int i = 0; i < m; i++) {
 * ans[i] = sc.next();
 * }
 * 
 * count();
 * output();
 * 
 * sc.close();
 * }
 * 
 * public static void count() {
 * cnt = 0;
 * for (int i = 0; i < m; i++) {
 * if (ans[i].matches(".*[0-9].*")) {
 * out[i] = (data[Integer.parseInt(ans[i]) - 1]);
 * } else {
 * for (int j = 0; j < n; j++) {
 * if (data[j].contains(ans[i])) {
 * out[i] = Integer.toString(j + 1);
 * }
 * }
 * }
 * }
 * 
 * }
 * 
 * public static void output() {
 * for (int i = 0; i < m; i++) {
 * System.out.println(out[i]);
 * }
 * 
 * }
 * 
 * }
 * 
 */