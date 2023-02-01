package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/12941
// title : 최솟값 만들기
// type : 정수
// time : 3m
// Created by haerin on 2023-01-31
import java.util.*;
public class 최솟값만들기 {
    class Solution{
        public int solution(int []A, int []B){
            int answer = 0;
            Arrays.sort(A);
            Arrays.sort(B);
            for(int i=0; i<A.length; i++){
                answer += A[i] * B[B.length-1-i];
            }

            return answer;
        }
    }
}
