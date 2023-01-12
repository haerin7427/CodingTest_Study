// https://school.programmers.co.kr/learn/courses/30/lessons/70128
// title : 내적
// time : 3m
// 유형 : 배열
// Created by haerin on 2023/01/11
import java.util.stream.IntStream;
public class 내적 {
    class Solution {
        public int solution(int[] a, int[] b) {
            int sum = 0;
            for(int idx = 0; idx < a.length; idx+=1) {
                sum += (a[idx] * b[idx]);
            }
            return sum;
        }
    }
    class Solution2 {
        public int solution(int[] a, int[] b) {
            return IntStream.range(0, a.length).map(idx -> a[idx]*b[idx]).sum();
        }
    }
}
