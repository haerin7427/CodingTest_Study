package Programmers.haerin.LV2;
// https//school.programmers.co.kr/learn/courses/30/lessons/131704
// title : 택배상자
// type : Stack
// time : 27m
// Created by haerin on 2023-02-27
import java.util.*;
public class 택배상자 {
    class Solution {
        public int solution(int[] order) {
            Stack<Integer> truck = new Stack<>();
            Stack<Integer> temp = new Stack<>();
            
            int box = 1;
            for(int o : order){
                // 보조 컨테이너 벨트 맨 앞에 있는 경우
                if(!temp.isEmpty() && temp.peek() == o){
                    truck.push(temp.pop());
                    continue;
                }
                // 컨테이너 벨트에 있는 경우
                while(box <= order.length && o != box){
                    temp.push(box);
                    box+=1;
                }
            
                if(box == o){
                    truck.push(box);
                    box += 1;
                }else{
                    break;
                }
            }
            return truck.size();
        }
    }
}
