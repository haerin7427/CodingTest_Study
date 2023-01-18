// https://school.programmers.co.kr/learn/courses/30/lessons/12940
// title : 최대공약수와 최소공배수

public class 최대공약수와최소공배수 {
    class Solution {
        public int[] solution(int n, int m) {
            int[] answer = new int[2];
            
            answer[0] = gcd(n, m);
            answer[1] = n*m / answer[0];
            
            return answer;
        }
        
        // 유클리드 호제법을 사용해서 최대공약수 구하는 방법
        int gcd(int a, int b) {
            if (b==0) return a;
            else return gcd(b, a%b);
            
            // return b==0 ? a : gcd(b, a%b);
        }
        
        // 최대공약수
        // 유클리드 호제법 : x, y의 최대공약수는 y, r의 최대공약수와 같다는 원리
        // 계속해서 x값에는 y값을 대입하고 
        // y값에는 r값을 대입하다보면 
        // 언젠가는 r이 0이 되는데 이때에 y값에 있는 값이 최대공약수
        // a=10, b=15 -> 10%15=10 -> 15%10=5 -> 10%5=0 -> 최대공약수=5
        
        // 최소공배수 : 두 자연수의 곱 / 최대공약수
    }
}