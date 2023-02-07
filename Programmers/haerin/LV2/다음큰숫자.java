package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/12911
// title : 다음 큰 숫자
// type : 숫자
// time : 15m
// Created by haerin on 2023-02-07
public class 다음큰숫자 {
    // 정확성 테스트 통과했으나, 효율성 테스트에서 시간초과
    class Solution {
        public int solution(int n) {
            int cntOne = Integer.toBinaryString(n).replaceAll("[^1]","").length();
            int num = n+1;
            while(Integer.toBinaryString(num).replaceAll("[^1]","").length() != cntOne) {
                num += 1;
            }
            return num;
        }
    }
    // 효율성 테스트 통과, 테스트케이스 평균 속도 0.023ms
    class Solution2 {
        public int solution(int n) {
            int cntOne = getCntOne(n);
            int num = n+1;
            while(getCntOne(num) != cntOne) {
                num += 1;
            }
            return num;
        }
        
        private int getCntOne (int number) {
            int cnt = 1;
            while(number > 1) {
                if(number % 2 == 1){
                    cnt += 1;
                }
                number /= 2;
            }
            return cnt;
        }
    }
    // 테스트케이스 평균 속도 0.019ms
    class Solution3 {
        public int solution(int n) {
            int cntOne = Integer.bitCount(n);
            int num = n+1;
            while(Integer.bitCount(num) != cntOne) {
                num += 1;
            }
            return num;
        }
    }
}
