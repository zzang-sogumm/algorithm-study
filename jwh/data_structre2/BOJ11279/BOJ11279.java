package jwh.data_structre2.BOJ11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11279 {

    static int n, x, size;
    static int[] heap;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        heap = new int[100001];
        heap[0] = 0;
        size = 0;

        for (int i = 0; i < n; i++) {
            x = Integer.parseInt(br.readLine());
            if (x == 0) {
                sub(x);
            } else {
                add(x);
            }
        }
        System.out.println(sb.toString());

    }

    static void add(int x) {
        size++;
        heap[size] = x;
        for (int i = size; i > 1; i /= 2) {
            if (heap[i] > heap[i / 2]) {
                swap(i, i / 2);
            } else {
                break;
            }
        }

    }

    static void sub(int x) {
        if (heap[1] != 0) {
            sb.append(heap[1] + "\n");
            heap[1] = heap[size];
            heap[size] = 0;
            size = size - 1;
            for (int j = 1; j * 2 <= size;) {
                if (heap[j] > heap[j * 2] && heap[j] > heap[j * 2 + 1]) {
                    break;
                } else if (heap[j * 2 + 1] < heap[j * 2]) {
                    swap(j, j * 2);
                    j = j * 2;
                } else {
                    swap(j, j * 2 + 1);
                    j = j * 2 + 1;
                }
            }
        } else
            sb.append(0 + "\n");

    }

    static void swap(int x, int y) {
        int temp = 0;
        temp = heap[x];
        heap[x] = heap[y];
        heap[y] = temp;
    }

}
