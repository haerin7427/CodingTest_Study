package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/42839
// title : 소수 찾기
// type : dfs
// time : ...
// Created by haerin on 2023-02-21
import java.util.*;
public class 소수찾기 {
    class Solution {
        ArrayList<Integer> arr = new ArrayList<>();
        boolean[] check = new boolean[7];
        
        public int solution(String numbers) {
            int answer = 0;
            for(int i=0; i<numbers.length(); i++){
                dfs(numbers,"",i+1);
            }
            
            for(int i=0; i<arr.size(); i++){
                if(isPrime(arr.get(i))) answer++;              
            }
            
            return answer;
        }
        private void dfs(String str, String t, int len) {
                if(t.length() == len){
                    int num = Integer.parseInt(t);
                    if(!arr.contains(num)){
                        arr.add(num);
                    }
                }
            
                for(int i=0; i<str.length(); i++){
                    if(!check[i]){
                        check[i] = true;
                        t += str.charAt(i);
                        dfs(str, t, len);
                        check[i] = false;
                        t = t.substring(0, t.length()-1);
                    }
                }
            
        }
        private boolean isPrime(int n) {
            if(n<2) return false;
            
            for(int i=2; i<=Math.sqrt(n); i++) {
                if(n % i == 0) return false;
            }
            
            return true;
        }
    }
}
