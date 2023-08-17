import java.util.Scanner;
import java.util.Arrays;

public class BOJ14467 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int count = 0;
        count = sc.nextInt();
        System.out.println(check(count));

    }

    static int check(int x) {

        int cnt = 0, cow = 0, where = 0;
        int arr[] = new int[100];
        Arrays.fill(arr, -1);

        for (int i = 0; i < x; i++) {
            cow = sc.nextInt();
            where = sc.nextInt();
            if (arr[cow] == -1) {
                arr[cow] = where;
            } else {
                if (arr[cow] != where) {
                    cnt++;
                    arr[cow] = where;
                }
            }
        }

        return cnt;

    }

}