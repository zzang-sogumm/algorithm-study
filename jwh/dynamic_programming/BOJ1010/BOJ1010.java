package jwh.dynamic_programming.BOJ1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ1010 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = 0;
		double result = 0;

		t = Integer.parseInt(st.nextToken());

		for (int i = 0; i < t; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			Double r = 0.0;
			Double n = 0.0;
			r = Double.parseDouble(st1.nextToken());
			n = Double.parseDouble(st1.nextToken());

			result = factorial(n) / (factorial(n - r) * factorial(r));

			System.out.println((int) Math.round(result));
		}

		br.close();
	}

	static double factorial(double n) {
		if (n <= 1) {
			return 1;
		}
		return n * factorial(n - 1);

	}

}
