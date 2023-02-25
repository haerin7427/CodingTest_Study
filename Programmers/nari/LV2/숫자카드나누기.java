// https://school.programmers.co.kr/learn/courses/30/lessons/135807
// title : 숫자 카드 나누기

public class 숫자카드나누기 {
    class Solution {
        public int solution(int[] arrayA, int[] arrayB) {
            int gcdA = arrayA[0];
            int gcdB = arrayB[0];
            
            // arrayA의 길이 = arrayB의 길이
            // 각 array의 최대공약수 구하기
            for(int i=1;i<arrayA.length;i++) {
                gcdA = gcd(gcdA, arrayA[i]);
                gcdB = gcd(gcdB, arrayB[i]);
            }
            
            // 나누어 떨어지는 값이 있으면 0, 아니면 gcd 값
            int divisorA = isDivisor(gcdA, arrayB) ? 0 : gcdA;
            int divisorB = isDivisor(gcdB, arrayA) ? 0 : gcdB;

            // 가장 큰 양의 정수를 return
            return divisorA > divisorB ? divisorA : divisorB;
        }
        
        int gcd(int num1, int num2) {
            if(num2 == 0) return num1;
            else return gcd(num2, num1 % num2);
        }
        
        boolean isDivisor(int gcd, int[] array) {
            for(int arr : array) {
                if(arr % gcd == 0) return true;
            }
            
            return false;
        }
    }
}