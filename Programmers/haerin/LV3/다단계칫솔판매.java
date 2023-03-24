package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/77486
// title : 다단계 칫솔 판매
// type : HashMap
// time : 22m
// Created by haerin on 2023-03-24
import java.util.*;
public class 다단계칫솔판매 {
    class Solution {
        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            Map<String, Integer> profit = new HashMap<>();
            Map<String, String> tree = new HashMap<>();
            for(int i=0; i<enroll.length; i++){
                profit.put(enroll[i], 0);
                tree.put(enroll[i], referral[i]);
            }
            
            for(int s=0; s<seller.length; s++){
                String person = seller[s];
                int money = 100 * amount[s];
                int myProfit = money - (int)(money*0.1);
                profit.put(person, profit.get(person) + myProfit);
                while(!tree.get(person).equals("-")){
                    person = tree.get(person);
                    money *= 0.1;
                    if(money < 10){
                        myProfit = money;
                        profit.put(person, profit.get(person) + myProfit);
                        break;
                    }else{
                        myProfit = money - (int)(money*0.1);
                        profit.put(person, profit.get(person) + myProfit);
                    }
                }
            }
            
            int[] answer = new int[enroll.length];
            for(int i=0; i<enroll.length; i++){
                answer[i] = profit.get(enroll[i]);
            }
            return answer;
        }
    }
}
