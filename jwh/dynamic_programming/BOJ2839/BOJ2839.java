
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = 0, result = 0;

        n = Integer.parseInt(st.nextToken());

        if (n < 3) {
            result = -1;
        } else if (n == 4 || n == 7) {
            result = -1;
        } else {
            switch (n % 5) {
                case 0:
                    result = n / 5 + (n % 5) / 3;
                    break;
                case 1:
                    result = n / 5 + ((n % 5) + 5) / 3 - 1;
                    break;
                case 2:
                    result = n / 5 + ((n % 5) + 10) / 3 - 2;

                    break;
                case 3:
                    result = n / 5 + (n % 5) / 3;
                    break;
                case 4:
                    result = n / 5 + ((n % 5) + 5) / 3 - 1;
                    break;
            }

        }
        System.out.println(result);

        br.close();
    }

}
