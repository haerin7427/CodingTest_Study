package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/92342
// title : 양궁대회
// type : 구현 - 완탐
// time : 40m
// Created by haerin on 2023-03-05
import java.util.*;
public class 양궁대회 {
    class Solution {
        public int[] solution(int n, int[] info) {
            int[] answer = new int[11];
            int[] temp = new int[11];
            int maxDiff = 0;
            // 비트 부분집합 10자리 필요 : 1을 왼쪽으로 10번 shift한 수 전까지 확인
            for(int subset=1; subset < (1 << 10); subset++){
                int ryan=0, apeach=0, cnt=0;
                for(int i=0; i<10; i++){
                    if((subset & (1 << i)) != 0){
                        ryan += (10-i);
                        temp[i] = info[i]+1;
                        cnt += temp[i];
                    } else {
                        temp[i] = 0;
                        if(info[i] > 0){
                            apeach += (10-i);
                        }
                    }
                }
                
                if(cnt > n) continue;
                temp[10] = n - cnt;
                if(ryan - apeach == maxDiff){
                    for(int i=10; i>=0; i--){
                        if(temp[i] > answer[i]) {
                            answer = Arrays.copyOf(temp, temp.length);
                            break;
                        }else if(temp[i] < answer[i]) {
                            break;
                        }
                    }                
                }else if(ryan - apeach > maxDiff){
                    maxDiff = ryan - apeach;
                    answer = Arrays.copyOf(temp, temp.length);
                }
            }
            
            if(maxDiff == 0)
                return new int[]{-1};
            
            return answer;
        }
    }
}
