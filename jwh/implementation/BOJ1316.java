import java.util.Scanner;

public class BOJ1316 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = 0, count = 0;
        size = scanner.nextInt();
        String[] noun = new String[size];
        char[] check = new char[100];
        char[] loop = new char[100];

        outerloop: for (int i = 0; i < size; i++) {
            noun[i] = scanner.next();
            for (int j = 0; j < noun[i].length(); j++) {
                check[j] = noun[i].charAt(j);
            }
            for (int k = 0; k < noun[i].length(); k++) {
                if (check[k] != check[k + 1]) {
                    loop[k] = check[k];
                }
                if (check[k] == check[k + 1]) {
                    loop[k] = check[k + 1];
                }

                for (int x = 0; x < noun[i].length(); x++) {
                    if (loop[i] == check[x]) {
                        break outerloop;
                    }
                }
            }

            count = count + 1;

        }

        System.out.println(count);

        scanner.close();
    }
}