/**
 * 1트: dfs -> 메모리 초과
 * 깊이 우선 탐색은 너무 많이 탐색,, 최단 경로는 bfs가 적합
 *
 * 반례 # 1 -> Maximum call stack size exceeded
 * 입력: 24 300
 * 출력: 10
 *      24 23 22 21 20 19 38 76 75 150 300
 *
 * 반례 # 2 -> 시간 초과
 * 입력: 2 1024
 * 출력: 9
 *      2 4 8 16 32 64 128 256 512 1024
 *
 * 반례 # 3 -> Maximum call stack size exceeded
 * 입력: 100 1
 * 출력: 99
 *      100~1까지 순서대로
 */
function solution1() {
  const fs = require("fs");
  const input = fs.readFileSync("example.txt").toString().trim().split(" ");

  const [n, k] = input.map(Number);

  let visited = new Array(100_001).fill(false);
  let answer = Number.MAX_SAFE_INTEGER;
  let answer_path = [];

  function dfs(path, depth, visited) {
    console.log(path);
    if (depth > answer) {
      return;
    }

    let cur = path[path.length - 1];

    if (cur === k) {
      if (depth < answer) {
        answer = depth;
        answer_path = [...path];
      }
      return;
    }

    for (let next of [cur + 1, cur - 1, cur * 2]) {
      if (!visited[next] && next >= 0 && next <= 100_000) {
        visited[next] = true;
        dfs([...path, next], depth + 1, visited);
        visited[next] = false;
      }
    }
  }

  dfs([n], 0, visited);
  console.log(answer);
  console.log(...answer_path);
}

/**
 * 2트: bfs
 * 최단경로이기 때문에 bfs로 빠르게 탐색할 수 있음
 */
function solution2() {
  const fs = require("fs");
  const input = fs.readFileSync("example.txt").toString().trim().split(" ");

  const [n, k] = input.map(Number);

  let visited = new Array(100_001).fill(false);
  let path = new Array(100_001).fill(0);

  function bfs(n) {
    let queue = [[n, 0]];
    visited[n] = 1;

    while (queue.length) {
      console.log(path.slice(0, 20));
      const [cur, depth] = queue.shift();

      if (cur === k) {
        return depth;
      }

      for (let next of [cur - 1, cur + 1, cur * 2]) {
        if (!visited[next] && next >= 0 && next <= 100_000) {
          path[next] = cur;
          visited[next] = true;
          queue.push([next, depth + 1]);
        }
      }
    }
  }

  const times = bfs(n);

  let order = [];
  order.push(k);

  let prev = path[k];
  for (let i = 0; i < times; i++) {
    order.push(prev);
    prev = path[prev];
  }

  console.log(times);
  console.log(...order.reverse());
}

solution2();
