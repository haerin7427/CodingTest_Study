package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/42747
// title : H-Index
// type : 정렬
// time : 23m
// Created by haerin on 2023-02-06
import java.util.*;
public class hIndex {
    class Solution {
        public int solution(int[] citations) {
            Arrays.sort(citations);
            int ans = 0;
            
            for(int h = citations[citations.length-1]; h>0; h--) {
                int cnt = citations.length;
                for(int i = citations.length-1; i >= 0; i--){
                    if(citations[i] < h) {
                        cnt -= (i+1);
                        break;
                    }
                }
                
                if(cnt >= h) {
                    ans = h;
                    break;
                }
            }
            
            return ans;
        }
    }
    class Solution2 {
        public int solution(int[] citations) {
            Arrays.sort(citations);
            int ans = 0;
            
            for(int i=0 ; i<citations.length; i++) {
                int h = citations.length - i;
                if(citations[i] >= h) {
                    ans = h;
                    break;
                }
            }
            return ans;
        }
    }
}
