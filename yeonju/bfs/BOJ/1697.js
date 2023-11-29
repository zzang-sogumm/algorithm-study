/**
 * 1트: 모르겠어서 정답 확인,,
 * 풀이방법: bfs
 */

function solution() {
  const fs = require("fs");
  const input = fs.readFileSync("example.txt").toString().trim().split(" ");

  const [n, k] = input.map(Number);

  let queue = [[n, 0]];
  let visited = new Array(100001).fill(false);

  while (queue.length) {
    const [cur, depth] = queue.shift();

    if (visited[cur]) {
      continue;
    }

    visited[cur] = true;

    if (cur === k) {
      console.log(depth);
      break;
    }

    for (let next of [cur + 1, cur - 1, cur * 2]) {
      if (!visited[next] && next >= 0 && next <= 100000) {
        queue.push([next, depth + 1]);
      }
    }
  }
}

solution();
