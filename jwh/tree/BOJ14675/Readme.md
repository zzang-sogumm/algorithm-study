/\*

- if (list.get(node).equals(null)) {
- sb.append("no").append("\n");
- } else if (list.get(node).size() == 1) {
- int check = 0;
- for (int i = 0; i < n; i++) {
- for (int j = 0; j < list.get(i).size(); j++) {
- if (list.get(i).get(j).equals(node)) {
- sb.append("yes").append("\n");
- check++;
- break;
- }
- }
- }
- if (check == 0) {
- sb.append("no").append("\n");
- }
- } else {
- sb.append("yes").append("\n");
- }
  \*/

단절점과 단절선

트리 문제는 항상 고민이다
트리를 직접 구현해야 하는거 아닌가.

자식이 1개인 루트노드는 단절점이 될 수 없다
자식이 없는 말단노드는 단절점이 될 수 없다.

이차원배열로 가능한가?

search에서 일단 자식이 없으면 -> 배열에서 tree[2] 했는데 값이 없으면
NO 출력
else 해서
자식이 1개인데, 그놈을 tree서치 해봤는데, 아무도 그놈을 반환하지않는다?
No 출력

단절선을 구별하는법

단절선이 아닐 수 있나?

트리구조라 다 단절선이잖아?
----------시간초과
그냥 간선이 2개 이하인 노드만 찾으면 됐다
