// https://school.programmers.co.kr/learn/courses/30/lessons/82612
// title : 부족한 금액 계산하기

public class 부족한금액계산하기 {
    class Solution1 {
        public long solution(int price, int money, int count) {
            long answer = 0;
            
            for(int i=1;i<=count;i++) {
                answer += price*i;
            }

            return answer-money>0 ? answer-money : 0 ;
        }
    }

    class Solution2 {
        public long solution(long price, int money, int count) {
            // price int에서 long으로 형 변환
            // 등차수열 합공식 r(n(n+1))/2 -> r=차수 n=count
            return Math.max(price * (count * (count + 1) / 2) - money, 0);
        }
    }
}