package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/118667
// title : 두 큐 합 같게 만들기
// type : Greedy
// time : 16m
// Created by haerin on 2023-02-18
import java.util.*;
public class 두큐합같게만들기 {
    class Solution {
        public int solution(int[] queue1, int[] queue2) {
            Queue<Long> q1 = new LinkedList<>();
            Queue<Long> q2 = new LinkedList<>();
            long sum1 = 0;
            long sum2 = 0;
            for(long number : queue1){
                q1.add(number);
                sum1 += number;
            }
            for(long number : queue2){
                q2.add(number);
                sum2 += number;
            }
            
            int cnt = 0;
            while(sum1 != sum2){
                cnt += 1;
                if(sum1 > sum2){
                    long num = change(q1, q2);
                    sum1 -= num;
                    sum2 += num;
                }else{
                    long num = change(q2, q1);
                    sum2 -= num;
                    sum1 += num;
                }
                if(cnt > queue1.length * 4){
                    cnt = -1;
                    break;
                }
            }
            return cnt;
        }
        
        private long change(Queue<Long> bigQ, Queue<Long> smallQ){
            long num = bigQ.remove();
            smallQ.add(num);
            return num;
        }
    }
}
