package jwh.tree.BOJ5639;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int num;
    Node left;
    Node right;

    Node(int num) {
        this.num = num;
    }

    public void insert(int num) {
        if (num < this.num) {
            if (this.left == null) {
                this.left = new Node(num);
            } else {
                this.left.insert(num);
            }
        } else {
            if (this.right == null) {
                this.right = new Node(num);
            } else {
                this.right.insert(num);
            }
        }
    }
}

public class BOJ5639 {
    static LinkedList<Integer> in = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());

        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.equals(""))
                break;
            in.add(Integer.parseInt(input));
        }
        Node tree = new Node(in.get(0));

        for (int i = 1; i < in.size(); i++) {
            tree.insert(in.get(i));
        }

        postorder(tree);

        br.close();
    }

    public static void postorder(Node root) {
        if (root.left != null)
            postorder(root.left);
        if (root.right != null)
            postorder(root.right);
        System.out.println(root.num);
    }

}
