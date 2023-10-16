package jwh.tree.BOJ1068;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1068 {
    static int n;
    static int cnt = 0;
    static int m = 0;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<Integer>()); // 리스트는 0부터 노드의 개수만큼 생성된다.
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a != -1) { // 만약 루트노드가 아니라면?
                list.get(a + 1).add(i); // 입력되는 수치 +1의 장소에 해당 노드가 저장되게된다.
            } else if (a == -1) { // 루트노드 저장
                list.get(0).add(i);
            }
        }

        // System.out.println(list); // 중간체크

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        m += 1;

        // 해당 노드를 제거하고, 확인해보자
        if (list.get(0).get(0) == m) { // 루트노드가 제거되어야한다면 0 출력
            cnt = 0;
        } else {
            while (list.get(m).size() != 0) { // 삭제되어야 할 노드의 자식이 있다면
                Queue<Integer> q = new LinkedList<>();
                q.add(list.get(m).get(0));
                while (!q.isEmpty()) {
                    int tmp = q.poll();
                    while (list.get(tmp).size() != 0) {
                        q.add(list.get(tmp).get(0));
                        list.get(tmp).remove(0);
                    }
                }
                list.get(m).remove(0);
                // 계속 삭제하자
            }
            for (int i = 1; i <= n; i++) { // 1부터 노드까지
                for (int j = 0; j < list.get(i).size(); j++) {
                    if (list.get(i).get(j) == m) { // 노드중에 삭제해야될놈이 자식에 있으면?
                        list.get(i).remove(j); // 그 자식을 삭제해줍시다.
                    }
                }
            }
            // System.out.println(list); //중간체크
            search(n);
        }
        // System.out.println(list); // 중갖체크

        if (list.get(list.get(0).get(0)).size() == 1) { // 루트노드의 사이즈가 1이라면
            if (list.get(list.get(0).get(0)).get(0) == m) { // 루트노드의 자식노드가 m이라면
                cnt = 1;
            }
        }

        System.out.println(cnt);
        br.close();
    }

    static void search(int index) {
        for (int i = 1; i <= index; i++) { // 1부터 노드를 탐색하며
            if (list.get(i).size() == 0) { // 만약 노드의 자식이 없다면?
                for (int j = 0; j <= index; j++) { // 다시한번 0부터 노드를 탐색하며
                    for (int k = 0; k < list.get(j).size(); k++) {
                        if (list.get(j).get(k) == i) { // 노드의 부모가 있다고 판단되면
                            cnt++; // cnt ++한다.
                        }
                    }
                }
            }
        }
    }
}
