package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/12987
// title : 숫제 게임
// type : 정렬
// time : 9m
// Created by haerin on 2023-03-22
import java.util.*;
public class 숫자게임 {
    class Solution {
        public int solution(int[] A, int[] B) {
            Arrays.sort(A);
            Arrays.sort(B);
            
            int idx = B.length-1;
            int answer = 0;
            for(int i=A.length-1; i>=0; i--){
                if(A[i] >= B[idx]){
                    int rIdx = 0;
                    while(B[rIdx] == -1 ){
                        rIdx += 1;
                    }
                    B[rIdx] = -1;
                }else{
                    answer +=1; 
                    idx -= 1;
                }
            }
            return answer;
        }
    }
    class Solution2 {
        public int solution(int[] A, int[] B) {
            Arrays.sort(A);
            Arrays.sort(B);
            
            int answer = 0;
            for(int i=A.length-1, j=B.length-1; i>=0; i--){
                if(A[i] < B[j]){
                    answer +=1; 
                    j -= 1;
                }
            }
            return answer;
        }
    }
}
