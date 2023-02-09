package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/12980
// title : 점프와 순간이동
// type : 숫자
// time : 7m
// Created by haerin on 2023-02-09
import java.util.*;
public class 점프와순간이동 {
    public class Solution {
        public int solution(int n) {
            int ans = 0;
            
            while(n != 0){
                if(n % 2 == 0){
                    n /= 2;
                }else {
                    n = (n-1) / 2;
                    ans += 1;
                }
            }
    
            return ans;
        }
    }
}
