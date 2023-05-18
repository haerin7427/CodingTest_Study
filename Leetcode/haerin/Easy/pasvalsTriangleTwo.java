package Leetcode.haerin.Easy;
// https://leetcode.com/problems/pascals-triangle-ii/description/
// title : 119. Pascal's Triangle II
// type : DP
// time : 5m
// Created by haerin on 2023-05-16
import java.util.*;
public class pasvalsTriangleTwo {
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<List<Integer>> list = new ArrayList<>();
            
            for(int i=0; i<=rowIndex; i++){
                list.add(new ArrayList<>());
                for(int x=1; x<=i+1; x++){
                    if(x == 1 || x == i+1){
                        list.get(i).add(1);
                    }else{
                        int num = list.get(i-1).get(x-2) + list.get(i-1).get(x-1);
                        list.get(i).add(num);
                    }
                }
            }
            return list.get(rowIndex);
        }
    }
}
