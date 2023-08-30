package jwh.greedy.BOJ14916;

import java.util.Scanner;

public class BOJ14916 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int charge = 0, count = 0;
        charge = sc.nextInt();
        count = check(charge);
        System.out.println(count);

    }

    static int check(int x) {

        int five = 0, two = 0;

        if (x < 2 || x == 3) {
            return -1;
        } else if ((x % 5) % 2 == 0) {
            five = x / 5;
            two = (x % 5) / 2;

        } else {
            five = (x / 5) - 1;
            two = (((x % 5) + 5) / 2);
        }

        return (five + two);

    }

}