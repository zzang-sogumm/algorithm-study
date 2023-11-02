package jwh.simulation.BOJ1713;

import java.util.*;
import java.io.*;

public class BOJ1713 {

    static int n, m;
    static int[] cntArr;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        cntArr = new int[1000];
        result = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            cntArr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0; // count를 통해 n 즉 자리가 다 찼는지 알아보자.
        LinkedList<Integer> list = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> priority_map = new HashMap<>();
        /*
         * PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
         * if (map.get(o1) < map.get(o2)) {
         * return -1;
         * } else if (map.get(o1) == map.get(o2)) {
         * return 1;
         * } else {
         * return 0;
         * }
         * });
         */

        for (int i = 0; i < m; i++) { // m개의 후보 추천을 탐색하자.
            if (count != n) { // count를 증가시키면서, 자리가 다 차지 않았다면 계속 증가시킨다.
                count++;
                int test = 0; // 사진틀에 이미 해당 후보가 올라가있는지 판단.
                for (int j = 0; j < list.size(); j++) { // 리스트 사이즈만큼 진행한다.
                    if (list.get(j) == cntArr[i]) { // 이미 사진틀에 후보가 있는 경우, 해당 값의 가중치를 증가
                        if (map.get(cntArr[i]) == null) {
                            map.put(cntArr[i], 1);
                        } else {
                            map.put(cntArr[i], map.get(cntArr[i]) + 1);
                        }
                        count--;
                        test++; // 루프 돌았단얘기
                        break;
                    }
                }
                if (test == 0) { // 자리에 cntArr[i]의 값이 없다면?
                    list.add(cntArr[i]); // 자리에 넣어줌.
                    if (map.get(cntArr[i]) == null) {
                        map.put(cntArr[i], 1);
                    } else {
                        map.put(cntArr[i], map.get(cntArr[i]) + 1);
                    }
                    priority_map.put(cntArr[i], i);
                }
            } else { // 자리가 다 찼다면?
                int tmp = 0;// 값이 차있는지, 아닌지 판단하는 변수
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) == cntArr[i]) { // 이미 차있는 값과 같은 경우, 해당 값의 가중치를 증가
                        map.put(cntArr[i], map.get(cntArr[i]) + 1);
                        tmp++; // 루프 돌았단얘기
                        break;
                    }
                }
                if (tmp == 0) { // 자리가 차있고, 새로운 값이라면?? 3자리를 다 돌면서, 가중치부터 봐야함
                    int out = 1001;
                    int min = 0; // 가중치가 다 똑같으면 젤 먼저들어온놈이니깐 0이맞음.

                    for (int j = 0; j < n; j++) { // 가중치가 젤 작은 값 + 맨 첨에 들어온놈 반환해야함
                        if (out > map.get(list.get(j))) {
                            min = j; // 가중치가 젤 작은 index
                        } else if (out == map.get(list.get(j))) { // 가중치가 같으면?
                            if (priority_map.get(list.get(min)) > priority_map.get(list.get(j))) { // 우선순위 판단 더 먼저
                                                                                                   // 들어왔으면?
                                min = j;
                            }
                        }
                        out = Math.min(out, map.get(list.get(j)));
                    }
                    int index = min;

                    map.remove(list.get(index));
                    priority_map.remove(list.get(index));
                    list.remove(index);
                    list.add(index, cntArr[i]);
                    if (map.get(cntArr[i]) == null) {
                        map.put(cntArr[i], 1);
                    } else {
                        map.put(cntArr[i], map.get(cntArr[i]) + 1);
                    }
                    priority_map.put(cntArr[i], i);

                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        Arrays.sort(result);

        for (int i = 0; i < n; i++) {
            if (result[i] != 0) {
                System.out.print(result[i] + " ");
            }

        }

    }
}