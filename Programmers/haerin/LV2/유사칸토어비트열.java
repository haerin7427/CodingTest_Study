package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/148652
// title : 유사 칸토어 비트열
// type : 재귀
// time : ...
// Created by haerin on 2023-03-09
public class 유사칸토어비트열 {
    // 시간 초과 발생
    class Solution {
        public int solution(int n, long l, long r) {
            String bitString = "1";
            
            for(int i=1; i<=n; i++){
                bitString = bitString.replaceAll("1", "a").replaceAll("0", "b").replaceAll("a", "11011").replaceAll("b", "00000");
            }
            int a = (int)(l-1);
            int answer = bitString.substring(a,(int)r).replaceAll("0","").length();
            return answer;
        }
    }
    // 규칙을 이용해서 해결
    // 1. n=0 : 1
    // 2. n=1 : 1/1/0/1/1 => 4 (1의 개수)
    // 3. n=2 : 4/4/0/4/4 => 16 (1의 개수)
    // 4. n=3 : 16/16/0/16/16 => 64 (1의 개수)
    class Solution2 {
        public int solution(int n, long l, long r) {
            return countOne(n, l, r,1);
        }
        // idx는 전체 비트열에서 현재 비트열의 첫 번째 비트 순서
        public int countOne(int n, long start, long end, long idx) {
            if(n==0){
                return 1;
            }
            
            long sectionSize = (long)Math.pow(5,n-1); // n번째 비트열을 5로 나눈 섹션 길이
            int num = 0;
            for(int i=0; i<5; i++){
                long sectionStartNum = idx+sectionSize*i;
                long sectionEndNum = idx+sectionSize*(i+1)-1;
                if(i == 2 || end < sectionStartNum || sectionEndNum < start) continue;
                num += countOne(n-1, start, end, sectionStartNum);
            }
            return num;
        }
    }
}
