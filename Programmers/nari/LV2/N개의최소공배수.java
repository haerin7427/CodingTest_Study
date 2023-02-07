// https://school.programmers.co.kr/learn/courses/30/lessons/12953
// title : N개의 최소공배수

public class N개의최소공배수 {
    class Solution {
        public int solution(int[] arr) {
            int answer = arr[0];
            
            // 2개의 자연수를 받아 최대공약수를 받기 위해 2부터 두 자연수 중 작은 자연수까지 모두 나누어보면서 가장 큰 공약수를 구할 수 있다. -> 시간복잡도 O(N)
            // 유클리드 호제법이란 알고리즘 -> 시간복잡도 O(logN)
            for(int i=1;i<arr.length;i++) {
                int gcd = gcd(answer, arr[i]);
                
                answer = answer*arr[i] / gcd;
            }
            
            return answer;
        }
        
        int gcd(int n1, int n2){
            if(n2 == 0) return n1;
            else return gcd(n2, n1 % n2);
        }
    }
}