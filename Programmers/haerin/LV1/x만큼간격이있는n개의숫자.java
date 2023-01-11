// https://school.programmers.co.kr/learn/courses/30/lessons/12954
// title : x만큼 간격이 있는 n개의 숫자
// time : 3m
// 유형 : 배열
// Created by haerin on 2023/01/11
import java.util.stream.LongStream;
public class x만큼간격이있는n개의숫자 {
    class Solution {
        public long[] solution(int x, int n) {
            long[] answer = new long[n];
            answer[0] = x;
            for(int i=1; i<n; i+=1) {
                answer[i] =  answer[i-1] + x;
            }
            return answer;
        }
    }
    class Solution2 {
        public long[] solution(int x, int n) {
            long[] answer = new long[n];
            for(int i=0; i<n; i+=1) {
                // 형 변환이 없다면, x와 n 모두 max 값일때  1000만 * 1000 = 100억으로 int 범위를 초과하는 문제 발생
                answer[i] =   (long) x * (i+1); 
            }
            return answer;
        }
    }
    class Solution3 {
        public long[] solution(int x, int n) {
            return LongStream.iterate(x, i->i+x).limit(n).toArray();
        }
      }
}
