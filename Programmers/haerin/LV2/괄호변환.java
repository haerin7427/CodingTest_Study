package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/60058
// title : 괄호 변환
// type : 구현
// time : 53m
// Created by haerin on 2023-03-01
import java.util.*;
public class 괄호변환 {
    class Solution {
        public String solution(String p) {
            if(p.equals("")) return "";
            if(isCorrect(p)) return p;
            
            return stringSplit(p);
        }
        
        public String stringSplit(String w){
            
            if(w.equals("")) return "";
            if(isCorrect(w)) return w;
            
            StringBuilder u = new StringBuilder();
            StringBuilder v = new StringBuilder();
            
            for(int i=2; i<=w.length(); i++){
                if(isSame(w.substring(0,i))) {
                    u.append(w.substring(0,i));
                    v.append(w.substring(i));
                    break;
                }
            }
            
            if(isCorrect(u.toString())){
                u.append(stringSplit(v.toString()));
                return u.toString();  
            }else{
                StringBuilder sb = new StringBuilder();
    
                sb.append("(");
                sb.append(stringSplit(v.toString()));
                sb.append(")");
                sb.append(reverse(u.toString()));
    
                return sb.toString();
            }
        }
        
        public String reverse (String u){
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i<u.length()-1;i++){
                if(u.charAt(i) == '(') {
                    sb.append(")");
                } else {
                    sb.append("(");
                }
            }
            return sb.toString();
        }
        
        public boolean isSame(String s1){
            int len1 = s1.replaceAll("[(]","").length();
            int len2 = s1.replaceAll("[)]","").length();
            return len1 == len2;
        }
        
        public boolean isCorrect(String s){
            Stack<Character> stack = new Stack<>();
            
            if(s.charAt(0) == ')'){
                return false;
            }
            stack.push(s.charAt(0));
            for(int i=1; i<s.length(); i++){
                if(s.charAt(i) == ')'){
                    if(!stack.isEmpty() && stack.peek() == '(')
                        stack.pop();
                    else
                        return false;
                }else{
                    stack.push(s.charAt(i));
                }
            }
            return true;
        }
    }
}
