package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/86971
// title : 전력망을 둘로 나누기
// type : 완전탐색(bfs)
// time : 12m
// Created by haerin on 203-03-01
import java.util.*;
public class 전력망을둘로나누기 {
    class Solution {
        public int solution(int n, int[][] wires) {
            int answer = n;
            
            for(int y=0; y<wires.length; y++){
                Queue<Integer> q = new LinkedList<>();
                boolean[] isCheck = new boolean[n];
                int sum = 0;

                isCheck[y] = true;
                q.add(wires[y][1]);
                while(!q.isEmpty()){
                    sum += 1;
                    int now = q.remove();
                    for(int i=0; i<wires.length; i++){
                        if(y == i || isCheck[i]) continue;
                        if(wires[i][0] == now){
                            isCheck[i] = true;
                            q.add(wires[i][1]);
                        }else if(wires[i][1] == now){
                            isCheck[i] = true;
                            q.add(wires[i][0]);
                        }
                    }
                }
                
                if(answer > Math.abs(sum - (n-sum))){
                    answer = Math.abs(sum - (n-sum));
                }
            }
            return answer;
        }
    }
}
