package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/81303
// title : 표 편집
// type : 구현
// time : 50m, 20m
// Created by haerin on 2023-04-01, 2023-04-02
import java.util.*;
public class 표편집 {
    class Solution {
        public String solution(int n, int k, String[] cmd) {
            Stack<Integer> remove_order = new Stack<Integer>();
            int table_size = n;
            for(int i=0; i<cmd.length; i++) {
                char c = cmd[i].charAt(0);
                if(c=='D')
                    k+=Integer.parseInt(cmd[i].substring(2));
                else if(c=='U')
                    k-=Integer.parseInt(cmd[i].substring(2));
                else if(c=='C') {
                    remove_order.add(k);
                    table_size--;
                    if(k==table_size)
                        k--;
                }
                else if(c=='Z') {
                    if(remove_order.pop()<=k)
                        k++;
                    table_size++;
                }
            }
            StringBuilder builder = new StringBuilder();
            for(int i=0; i<table_size; i++)
                builder.append("O");
            while(!remove_order.isEmpty())
                builder.insert(remove_order.pop().intValue(), "X");
            String answer=builder.toString();
            return answer;
        }
    }
    class Solution2 {
        public String solution(int n, int k, String[] cmd) {
            Stack<Integer> removeCell = new Stack<>();
            int selectedCell = k;
            int tableSize = n;
            
            for(String c : cmd){            
                if(c.charAt(0) == 'U'){
                    selectedCell -= Integer.parseInt(c.substring(2));
                }else if(c.charAt(0) == 'D'){
                    selectedCell += Integer.parseInt(c.substring(2));
                }else if(c.charAt(0) == 'C'){
                    removeCell.add(selectedCell);
                    tableSize -= 1;
                    if(tableSize == selectedCell){
                        selectedCell -= 1;
                    }
                }else if(c.charAt(0) == 'Z'){
                    if(removeCell.pop() <= selectedCell){
                        selectedCell += 1;
                    }
                    tableSize += 1;
                }
            }
            
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<tableSize; i++){
                sb.append("O");
            }
            while(!removeCell.isEmpty()){
                sb.insert(removeCell.pop().intValue(),"X");
            }
            return sb.toString();
        }
    }
}
