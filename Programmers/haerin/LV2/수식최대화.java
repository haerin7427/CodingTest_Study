package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/67257
// title : 수식 최대화
// type : 구현
// time : 49m
// Created by haerin on 2023-03-10
import java.util.*;
public class 수식최대화 {
    class Solution {
        private String[] op = {"+", "-", "*"};
        private List<List<String>> priorityList = new ArrayList<>();
        
        public long solution(String expression) {
            dfs(new ArrayList<>());

            long answer = 0;
            for(List<String> priority : priorityList){

                Queue<String> expressionQueue = splitNumOp(expression);
                
                for(String OP : priority){
                    if(!expressionQueue.contains(OP)) continue;
                    
                    Queue<String> tmp = new LinkedList<>();
                    long a = Long.parseLong(expressionQueue.remove());
                    while(!expressionQueue.isEmpty()){
                        String operator = expressionQueue.remove();
                        if(operator.equals(OP)){
                            long b = Long.parseLong(expressionQueue.remove());
                            if(OP.equals("*")){
                                a *= b;
                            }else if(OP.equals("-")){
                                a -= b;
                            }else if(OP.equals("+")){
                                a += b;
                            }
                        }else{
                            tmp.add(Long.toString(a));
                            tmp.add(operator);
                            a = Long.parseLong(expressionQueue.remove());
                        }
                    }
                    tmp.add(Long.toString(a));
                    expressionQueue = tmp;
                }
                
                long result = Math.abs(Long.parseLong(expressionQueue.remove()));
                answer = Math.max(answer, result);
            }
            return answer;
        }
        
        public Queue<String> splitNumOp(String expression){
            Queue<String> q = new LinkedList<>();
            int s=0;
            for(int i=0; i<expression.length(); i++){
                if(expression.charAt(i) > '9' || expression.charAt(i) < '0'){
                    q.add(expression.substring(s,i));
                    q.add(expression.substring(i,i+1));
                    s = i+1;
                }
            }
            q.add(expression.substring(s));
            return q;
        }
        
        
        
        public void dfs(List<String> tmp){
            if(tmp.size() == op.length){
                priorityList.add(new ArrayList<>(tmp));
                return;
            }
            for(int i=0; i<op.length; i++){
                if(!tmp.contains(op[i])){
                    tmp.add(op[i]);
                    dfs(tmp);
                    tmp.remove(tmp.size()-1);
                }
            }
        }
    }
}
