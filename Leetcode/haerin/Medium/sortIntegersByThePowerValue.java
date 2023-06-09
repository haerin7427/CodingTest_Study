package Leetcode.haerin.Medium;
// https://leetcode.com/problems/sort-integers-by-the-power-value/description/
// title : 1387. Sort Integers by The Power Value
// type : sort
// time : 11m
// Created by haerin on 2023-06-07
import java.util.*;
public class sortIntegersByThePowerValue {
    class Solution {
        class Number implements Comparable<Number>{
            int num;
            int count;
    
            Number(int n, int c) {
                this.num = n; 
                this.count = c;
            }
    
            @Override
            public int compareTo(Number o) {
                return this.count - o.count;
            }
        }
        public int getKth(int lo, int hi, int k) {
            List<Number> list = new ArrayList<>();
            for(int i=lo; i<=hi; i++){
                int cnt = makeOne(i);
                list.add(new Number(i, cnt));
            }
            Collections.sort(list);
            return list.get(k-1).num;
        }
    
        private int makeOne(int number) {
            int cnt = 0;
            while(number != 1) {
                if(number % 2 == 0){
                    number /= 2;
                }else {
                    number = number * 3 + 1;
                }
                cnt += 1;
            }
            return cnt;
        }
    }
}
