package jwh.data_structre2.BOJ14425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ14425 {

	static int n = 0, m = 0, cnt = 0;
	static HashSet<String> set1 = new HashSet<String>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			set1.add(s);

		}

		for (int i = 0; i < m; i++) {
			String temp = br.readLine();
			if (set1.contains(temp)) {
				cnt = cnt + 1;
			}
		}
		System.out.println(cnt);
	}

}