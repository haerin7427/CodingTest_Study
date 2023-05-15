package Leetcode.haerin.Easy;
// https://leetcode.com/problems/pascals-triangle/description/
// title : 118. Pascal's Triangles
// type : DP
// time : 5m
// Created by haerin on 2023-05-15
import java.util.*;;
public class pascalsTriangle {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> answer = new ArrayList<>();
            for(int i=1; i<=numRows; i++){
                List<Integer> list = new ArrayList<>();
                for(int x=0; x<i; x++){
                    if(x == 0 || x == i-1){
                        list.add(1);
                    }else{
                        int num = answer.get(i-2).get(x-1) + answer.get(i-2).get(x);
                        list.add(num);
                    }
                }
                answer.add(list);
            }
            return answer;
        }
    }
}
