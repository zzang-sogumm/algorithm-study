# [zzang-sogumm] algorithm-study

[![Since](https://img.shields.io/badge/since-2023.08.06-6A5ACD.svg?&edge_flat=false)](https://github.com/zzang-sogumm/algorithm-study)

## 🧂 Goals

- 자료구조, 알고리즘의 원리와 패턴을 익히는 데 목적을 둡니다.
- 꾸준한 훈련을 통해 문제 해결력을 기릅니다.
- 모두가 만족할 만한 성공적인 스터디를 만들어 가봅시다~ 탈출은 능력순,,^^⭐️

<br />

## 🧂 Members

<table>
    <tr>
        <td>
            <a href="https://github.com/yeonju0110">
                <img src="https://github.com/yeonju0110.png" width="70px" />
            </a>
        </td>
        <td>
            <a href="https://github.com/isu-nice">
                <img src="https://github.com/isu-nice.png" width="70px" />
            </a>
        </td>
        <td>
            <a href="https://github.com/jwh1124">
                <img src="https://github.com/jwh1124.png" width="70px" />
            </a>
        </td>
    </tr>
    <tr>
        <td><p align="center">조연주</p></td>
        <td><p align="center">신이수</p></td>
        <td><p align="center">정원혁</p></td>
    </tr>
</table>

<br />

[![Solved.ac 프로필](http://mazassumnida.wtf/api/v2/generate_badge?boj=yeonju0110)](https://solved.ac/yeonju0110)
[![Solved.ac 프로필](http://mazassumnida.wtf/api/v2/generate_badge?boj=isu081818)](https://solved.ac/isu081818)
[![Solved.ac 프로필](http://mazassumnida.wtf/api/v2/generate_badge?boj=jwh1124)](https://solved.ac/jwh1124)

<br />

## 🧂 Rules

매주 문제를 선정하여 '각자 2일에 두 문제씩', '하루는 실시간으로 한 문제를 같이' 풉니다.
새로운 개념을 시작하는 주에는 강의를 통해 해당 개념을 숙지한 후, 문제풀이를 진행합니다.

- <b>2일에 두 문제씩</b>
  - 각자 시간을 정해서 문제 풀이를 진행합니다.
  - 절대 풀지 못할 것 같은 문제는 적당한 시점에 포기하고, 다른 사람의 풀이를 통해 영감을 얻고 배우도록 합니다.
- <b>실시간 진행 방식</b>
  1.  실전처럼 30분동안 1문제를 풀고 PR을 보냅니다.
  2.  한주동안 문제 풀이를 하면서, 각자 정리한 개념이나 어려웠던 문제들을 공유하고 설명합니다.
  3.  전주에 올린 PR 리뷰에 대해 공유할만한 내용이 있다면, 이를 공유합니다.

<br />

## 🧂 Conventions

### 📌 Commit convention

1문제씩 나눠서 커밋합니다.

```
add : 새로 푼 문제
refactor: 기존에 못 푼 문제, 풀이 방법 개선한 문제
remove : 코드 및 문서 삭제
docs : README.md 등의 문서 작성 및 수정
```

- 예시)
  ```
  add: BOJ 2023
  docs: 리드미 파일 수정
  ```

### 📌 PR convention

- PR Template에 맞춰서 작성합니다.
- 실시간 문제 풀이 후에 PR을 보냅니다.
- 차주에 코드리뷰를 진행합니다.

### 📌 Project convention

```
📦 ALGORITHM-STUDY
 ├─ 📂 docs
 ├─ 📂 isu
 │ ├─ 📂 greedy
 │ │  └─ BOJ2023.java
 │ ├─ ...
 │ └─ 📜 README.md
 ├─ 📂 jwh
 │ ├─ 📂 implementation
 │ ├─ ...
 │ └─ 📜 README.md
 ├─ 📂 yeonju
 │ ├─ 📂 greedy
 │ ├─ ...
 │ └─ 📜 README.md
 └─ 📜 README.md
```

- 문제 유형별로 폴더 분리
- 파일명: 문제 번호 or 이름
- `docs` 폴더: 공유할 만한 문서를 모아두는 곳
- 각자 폴더에 있는 `README`파일: 개인이 자유롭게 작성

### 📌 File convention

- 풀이 상단이나 하단에 문제 풀이 방식을 주석으로 적어둡니다.
  - 다른 사람이 풀이를 보더라도 바로 이해할 수 있게 하기 위함입니다.

<br />

## 🧂 진도표

### ⛳️ week1

| 플랫폼 | 문제 번호 | 문제 이름                                                    | 유형 | 난이도  |
| ------ | --------- | ------------------------------------------------------------ | ---- | ------- |
| BOJ    | 20546     | [🐜 기적의 매매법 🐜](https://www.acmicpc.net/problem/20546) | 구현 | silver5 |
| BOJ    | 2578      | [빙고](https://www.acmicpc.net/problem/2578)                 | 구현 | silver4 |
| BOJ    | 4396      | [지뢰찾기](https://www.acmicpc.net/problem/4396)             | 구현 | silver4 |
| BOJ    | 1316      | [그룹 단어 체커](https://www.acmicpc.net/problem/1316)       | 구현 | silver5 |

### ⛳️ week2

| 플랫폼 | 문제 번호 | 문제 이름                                                                              | 유형      | 난이도  |
| ------ | --------- | -------------------------------------------------------------------------------------- | --------- | ------- |
| BOJ    | 14916     | [거스름돈](https://www.acmicpc.net/problem/14916)                                      | 그리디    | silver5 |
| BOJ    | 1343      | [폴리오미노](https://www.acmicpc.net/problem/1343)                                     | 그리디    | silver5 |
| BOJ    | 2217      | [로프](https://www.acmicpc.net/problem/2217)                                           | 그리디    | silver4 |
| BOJ    | 1758      | [알바생 강호](https://www.acmicpc.net/problem/1758)                                    | 그리디    | silver4 |
| BOJ    | 2798      | [블랙잭](https://www.acmicpc.net/problem/2798)                                         | 완전 탐색 | bronze2 |
| BOJ    | 2422      | [한윤정이 이탈리아에 가서 아이스크림을 사먹는데](https://www.acmicpc.net/problem/2422) | 완전 탐색 | silver4 |
| BOJ    | 14501     | [퇴사](https://www.acmicpc.net/problem/14501)                                          | 완전 탐색 | silver3 |
| BOJ    | 1439      | [뒤집기](https://www.acmicpc.net/problem/1439)                                         | 그리디    | silver5 |

### ⛳️ week3

| 플랫폼 | 문제 번호 | 문제 이름                                                           | 유형      | 난이도  |
| ------ | --------- | ------------------------------------------------------------------- | --------- | ------- |
| BOJ    | 16439     | [치킨치킨치킨](https://www.acmicpc.net/problem/16439)               | 완전 탐색 | silver4 |
| BOJ    | 2503      | [숫자 야구](https://www.acmicpc.net/problem/2503)                   | 완전 탐색 | silver3 |
| BOJ    | 17626     | [Four Squares](https://www.acmicpc.net/problem/17626)               | 완전 탐색 | silver3 |
| BOJ    | 1620      | [나는야 포켓몬 마스터 이다솜](https://www.acmicpc.net/problem/1620) | 자료구조  | silver4 |
| BOJ    | 14425     | [문자열 집합](https://www.acmicpc.net/problem/14425)                | 자료구조  | silver3 |
| BOJ    | 11279     | [최대 힙](https://www.acmicpc.net/problem/11279)                    | 자료구조  | silver2 |
| BOJ    | 11286     | [절댓값 힙](https://www.acmicpc.net/problem/11286)                  | 자료구조  | silver1 |

### ⛳️ week4

| 플랫폼 | 문제 번호 | 문제 이름                                               | 유형      | 난이도  |
| ------ | --------- | ------------------------------------------------------- | --------- | ------- |
| BOJ    | 2346      | [풍선 터뜨리기](https://www.acmicpc.net/problem/2346)   | 자료구조  | silver3 |
| BOJ    | 10799     | [쇠막대기](https://www.acmicpc.net/problem/10799)       | 자료구조  | silver2 |
| BOJ    | 2504      | [괄호의 값](https://www.acmicpc.net/problem/2504)       | 자료구조  | gold5   |
| BOJ    | 21921     | [블로그](https://www.acmicpc.net/problem/21921)         | 투 포인터 | silver3 |
| BOJ    | 20922     | [겹치는 건 싫어](https://www.acmicpc.net/problem/20922) | 투 포인터 | silver1 |
| BOJ    | 2470      | [두 용액](https://www.acmicpc.net/problem/2470)         | 투 포인터 | gold5   |
| BOJ    | 1940      | [주몽](https://www.acmicpc.net/problem/1940)            | 투 포인터 | silver4 |
| BOJ    | 10025     | [게으른 백곰](https://www.acmicpc.net/problem/10025)    | 투 포인터 | silver3 |

### ⛳️ week5

| 플랫폼 | 문제 번호 | 문제 이름                                                           | 유형       | 난이도  |
| ------ | --------- | ------------------------------------------------------------------- | ---------- | ------- |
| BOJ    | 1010      | [다리놓기](https://www.acmicpc.net/problem/1010)                    | 동적계획법 | silver5 |
| BOJ    | 2839      | [설탕 배달](https://www.acmicpc.net/problem/2839)                   | 동적계획법 | silver4 |
| BOJ    | 1463      | [1로 만들기](https://www.acmicpc.net/problem/1463)                  | 동적계획법 | silver3 |
| BOJ    | 11053     | [가장 긴 증가하는 부분 수열](https://www.acmicpc.net/problem/11053) | 동적계획법 | silver2 |
| BOJ    | 9465      | [스티커](https://www.acmicpc.net/problem/9465)                      | 동적계획법 | silver1 |
