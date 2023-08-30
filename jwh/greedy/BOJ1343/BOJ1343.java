package jwh.greedy.BOJ1343;

import java.util.Scanner;

public class BOJ1343 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String input = "";
        input = sc.next();
        if (input.length() > 50) {
            System.out.println("error");
        } else
            System.out.println(check(input));

    }

    static String check(String x) {

        char[] arr = new char[51];
        String output = "";

        for (int i = 0; i < x.length(); i++) {
            arr[i] = x.charAt(i);
        }

        for (int i = 0; i < x.length(); i++) {

            if (arr[i] == '.') {
                output = output + ".";
            } else if (arr[i] == arr[i + 1] && arr[i + 1] == arr[i + 2] && arr[i + 2] == arr[i + 3]) {
                output = output + "AAAA";
                i = i + 3;
            } else if (arr[i] == arr[i + 1]) {
                output = output + "BB";
                i = i + 1;
            } else {
                output = "-1";
                break;
            }

        }

        return output;

    }

}