package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/161988
// title : 연속 펄스 부분 수열의 합
// type : DP
// time : 17m
// Created by haerin on 2023-03-28
import java.util.*;
public class 연속펄스부분수열의합 {
    class Solution {
        public long solution(int[] sequence) {
            long[] startWithPlusDP = new long[sequence.length]; // 1로 시작하는 펄스 수열을 곱합 결과
            long[] startWithMinusDP = new long[sequence.length]; // -1로 시작하는 펄스 수열을 곱한 결과
            startWithPlusDP[0] = sequence[0];
            startWithMinusDP[0] = (-1) * sequence[0];
            
            for(int i=1; i<startWithPlusDP.length; i++){
                if(i%2 == 0){
                    startWithPlusDP[i] = Math.max(startWithPlusDP[i-1]+sequence[i], sequence[i]);
                    startWithMinusDP[i] = Math.max(startWithMinusDP[i-1]+sequence[i]*(-1), sequence[i]*(-1));
                }else{
                    startWithPlusDP[i] = Math.max(startWithPlusDP[i-1]+sequence[i]*(-1), sequence[i]*(-1));
                    startWithMinusDP[i] = Math.max(startWithMinusDP[i-1]+sequence[i], sequence[i]);
                }
            }

            Arrays.sort(startWithPlusDP);
            Arrays.sort(startWithMinusDP);
            
            return Math.max(startWithPlusDP[sequence.length-1], startWithMinusDP[sequence.length-1]);
        }
    }
}
