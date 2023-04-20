package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/138475#
// title : 억억단을 외우자
// type : DP ?? 
// time : 50m
// Created by haerin on 2023-04-20
import java.util.*;
public class 억억단을외우자 {
    // 정확성 80점 (9, 10번 테스트케이스 시간초과)
    class Solution {
        public int[] solution(int e, int[] starts) {
            int[] answer = new int[starts.length];
            int[] cnt = new int[5000001];
            
            for(int i=0; i<starts.length; i++){
                int s = starts[i];
                int maxCnt = 0;
                int maxValue = 0;
                
                for(int j=s; j<=e; j++){
                    if(cnt[j] == 0){
                        cnt[j] = 1;
                        for(int d=2; d < Math.sqrt(j); d++){
                            if(j % d == 0){
                                cnt[j] += 1;
                            }
                        }
                        cnt[j] *= 2;
                        cnt[j] += (Math.sqrt(j) % 1 == 0) ? 1 : 0;
                    }
                    
                    if(cnt[j] > maxCnt){
                        maxCnt = cnt[j];
                        maxValue = j;
                    }
                }
                answer[i] = maxValue;
            }
            return answer;
        }
    }
    // 통과
    class Solution2 {
        class Number {
            int num; // 숫자
            int cnt; // 약수의 개수
            Number(int n, int c){
                this.num = n;
                this.cnt = c;
            }
        }
        public int[] solution(int e, int[] starts) {
            
            Number[] cnt = new Number[e+1];
            for(int i=0; i<cnt.length; i++){
                cnt[i] = new Number(i, 0);
            }
            // e를 넘지 않는 자연수 n의 배수를 찾아 1씩 증가시켜 약수의 개수를 늘려간다
            for(int n=1; n<=e; n++){
                for(int j=n; j<=e; j+=n){
                    cnt[j].cnt += 1;
                }
            }

            // 약수의 개수 기준 내림차순, 동일할 시 숫자의 크기 오름차순으로 정렬
            Arrays.sort(cnt, new Comparator<Number>(){
                @Override
                public int compare(Number a, Number b){
                    if(a.cnt != b.cnt){
                        return b.cnt - a.cnt;
                    }else{
                        return a.num - b.num;
                    }
                }
            });
            
            // 숫자 n의 크기가 s <= n >= e 인 수를 찾는다
            int[] answer = new int[starts.length];
            for(int i=0; i<starts.length; i++){
                int s = starts[i];
                
                for(int j=0; j<cnt.length; j++){
                    if(s <= cnt[j].num && cnt[j].num <= e){
                        answer[i] = cnt[j].num;
                        break;
                    }
                }
                
            }
            return answer;
        }
    }
}
