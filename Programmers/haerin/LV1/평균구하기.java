// https://school.programmers.co.kr/learn/courses/30/lessons/12944
// title : 평균구하기
// time : 1m
// Created by haerin on 2023/01/09
import java.util.*;
public class 평균구하기 {
    class Solution {
        public double solution(int[] arr) {
            double sum = 0;
            for(int num : arr) {
                sum += num;
            }
            double answer = sum / arr.length;
            return answer;
        }
    }
    // Stream이 속도는 훨씬 느림
    class Solution2 {
        public double solution(int[] arr) {
            return Arrays.stream(arr).average().getAsDouble();
        }
    }
}
