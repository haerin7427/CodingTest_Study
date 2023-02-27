package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/135807
// title : 숫자 카드 나누기
// type : 유클리드 호제법
// time : 13m
// Created by haerin on 2023-02-27
public class 숫자카드나누기 {
    class Solution {
        public int solution(int[] arrayA, int[] arrayB) {
            
            int numA=arrayA[0], numB=arrayB[0];
            for(int i=1; i<arrayA.length; i++){
                numA = gcd(Math.max(numA, arrayA[i]), Math.min(numA, arrayA[i]));
                numB = gcd(Math.max(numB, arrayB[i]), Math.min(numB, arrayB[i]));
            }
            
            int answer = Math.max(getNumber(numA, arrayB), getNumber(numB, arrayA));
            return answer;
        }
        
        public int getNumber (int num, int[] arr){
            for(int i=num; i>1; i--){
                if(num%i!=0) continue;
                
                boolean flag = true;
                for(int j=0; j<arr.length; j++){
                    if(arr[j] % num == 0){
                        flag = false;
                        break;
                    }
                }
                if(flag) return i;
            }
            return 0;
        }
        
        public int gcd (int max, int min){
            int a = max;
            int b = min;
            int r = a%b;
            while(r != 0){
                a = b;
                b = r;
                r = a % b;
            }
            return b;
        }
    }
}
