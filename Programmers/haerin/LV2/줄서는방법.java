package Programmers.haerin.LV2;
import java.util.*;
// https://school.programmers.co.kr/learn/courses/30/lessons/12936
// title : 줄 서는 방법
// type : ...
// time : ...
// Created by haerin on 2023-02-23
public class 줄서는방법 {
    class Solution {
        public int[] solution(int n, long k) {
            List<Integer> list = new ArrayList<>(); 
            for(int i=1; i<=n; i++) {
                list.add(i);
            }
            
            int[] answer = new int[n];
            k -= 1; 
            int index=0;
            for(int i=n; i>0; i--){
                long temp = fact(i-1);
                int a = (int) (k/temp);
                answer[index++]= list.get(a);
                list.remove(a);
                k = k%temp;
            }
            return answer;
        }
        
        public long fact(int n){
            long num = 1;
            for(int i=n; i>0; i--){
                num*=i;
            }
            return num;
        }
    }
}
