    	while (r < x - n) {
    		int temp = 0;
    		for (int i = r; i < r + n; i++) {
    			temp += day[i];
    		}
    		if (visit == temp)
    			cnt++;
    		else if (visit < temp) {
    			visit = temp;
    			cnt = 1;
    		}
    		r++;
    	}

시간초과 코드 ;;

# 2023_09_03_BOJ_21921

21921 블로그 2023.09.03 📆

👩‍🏫 풀이

1. 처음 배우는 투포인터로 푸는 문제
2. 그냥 for문으로하고 경계만 정해주면 되네? 쉽잖아?

## -> 시간초과

1. l, r 즉 좌측, 우측 포인터를 두고 차이를 유지시키며 해당 값을 더해주면 됨.

⏱️ 성능
메모리 시간 코드길이
34940 384 1060

- 🔍 PLUS
  근데 왜 시간초과가 뜨는거지요? while문 두번이나 while 안에 for나 똑같지않나?
