import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = 0, k = 0, point = 0, tmp = 0;
        int r = 1, l = 0, result = 0;
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] buc = new int[1000001];

        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int g = 0, x = 0;
            g = Integer.parseInt(st1.nextToken());
            x = Integer.parseInt(st1.nextToken());
            buc[x] = g;
            point = Math.max(point, x);
        }

        r = (k * 2) + 1;

        for (int i = 0; i < r && i < 1000001; i++) {
            tmp += buc[i];
            result = Math.max(result, tmp);
        }

        while (r < 1000001) {
            tmp -= buc[l];
            tmp += buc[r];
            l += 1;
            r += 1;
            result = Math.max(result, tmp);
        }

        System.out.println(result);
        br.close();
    }
}