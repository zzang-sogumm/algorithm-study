# 2023_09_28_BOJ_15657

15657 n과 m(8) 2023.09.28 📆

👩‍🏫 풀이

1.  틀린 풀이
    cal을 통해 중복조합 최대값 설정
    static double cal(int n, int r) {
    return factorial(n + r - 1) / (factorial(n - 1) \* factorial(r));

    }

    static double factorial(int v) {
    if (v <= 1) {
    return 1;
    } else {
    return v \* factorial(v - 1);
    }

    }
    n r을 index,num으로 설정
    rsult에 map한 값들을 저장하려고했음
    map하는게 불가능.. 0 0 0 1 0 2
    왜안되지? 멍청해졌음

        static void bt(int index, int num) {
        	while (index < max) {
        		int a=0;
        		while (num < m) {
        			result[index][num] = map[a];
        			num += 1;
        		}
        		index += 1;
        		bt(index, 0);
        	}
        }

    웬종일 이 코드만 보면서 뭐지..하고있었음

---

2.예전에 brute_force 했던것처럼, dfs 연산식을 알면 쉽게 풀 수 있는 문제

⏱️ 성능
메모리 시간 코드길이
24100 728 1007

🔍 PLUS
