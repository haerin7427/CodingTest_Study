package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/12953
// title : N개의 최소공배수
// type : 정수
// time : 9m, 15m, 9m
// Created by haerin on 2023-02-08, 2023-02-12, 2023-02-19
public class N개의최소공배수 {
    class Solution {
        public int solution(int[] arr) {
            int max = arr[0];
            for(int n : arr) {
                if(max < n) {
                    max = n;
                }
            }
            
            int answer = -1;
            int num = max;
            while(answer < 0) {
                Boolean flag = true;
                for(int n : arr) {
                    if(num % n != 0) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    answer = num;
                }
                num += 1;
            }
            return answer;
        }
    }
    // 유클리드 호제법 알고리즘 사용
    class Solution2 {
        public int solution(int[] arr) {
            int answer = arr[0];
            for(int i=1; i<arr.length; i++) {
                int gcd = getGdc(answer, arr[i]);
                answer = answer * arr[i] / gcd;
            }
            return answer;
        }
        
        public int getGdc(int a, int b) {
            int devidend = Math.max(a,b);
            int devisor = Math.min(a,b);
            
            while(devidend % devisor != 0) {
                int r = devidend % devisor;
                devidend = devisor;
                devisor = r;
            }
            return devisor;
        }
    }
    class Solution3 {
        public int solution(int[] arr) {
            int answer = arr[0];
            for(int i=1; i<arr.length; i++){
                answer = answer * arr[i] / get(answer, arr[i]);
            }
            return answer;
        }
        private int get(int num1, int num2){
            int a = Math.max(num1, num2);
            int b = Math.min(num1, num2);
            
            while(a % b != 0){
                int r = a % b;
                a = b;
                b = r;
            }
            return b;
        }
    }
}
