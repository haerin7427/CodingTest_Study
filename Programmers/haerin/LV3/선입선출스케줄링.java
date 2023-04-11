package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/12920
// title : 선입 선출 스케줄링
// type : 이분탐색
// time : 52m
// Created by haerin on 2023-04-10
public class 선입선출스케줄링 {
    // 효율성 테스트 실패
    class Solution {
        public int solution(int n, int[] cores) {
            if(n < cores.length){
                return n;
            }
            n -= cores.length;
            int time = 1;
            int lastCore = cores.length;
            while(n > 0){
                for(int c=0; c<cores.length; c++){
                    if(time % cores[c] == 0){
                        n -=1;
                        lastCore = c+1;
                        if(n == 0){
                            break;
                        }
                    }
                }
                time += 1;
            }
            return lastCore;
        }
    }
    // 효율성 테스트 통과 : 이분탐색으로 n을 넘지 않은 최대한의 작업물 진입 시점과 수량을 구하는 것이 포인트
    class Solution2 {
        public int solution(int n, int[] cores) {
            // 코어 수가 작업보다 많을 경우 작업의 갯수가 마지막 작업을 처리하는 코어 번호
            if(n < cores.length){
                return n;
            }
            
            int max = n * 10000; // 최대 작업 시간
            int min = 0; // 최소 작업 시간
            
            int time = 0; // n을 넘지 않은 최대 작업량의 진입 시간
            long completedWork = 0; // 변수 time 시점까지 진입한 총 작업 개수
            
            while(min <= max){
                int mid = (max + min) / 2 + (max + min) % 2 ;
                long countWork = calculate(mid, cores);
                if(countWork >= n){
                    max = mid-1;
                    
                }else{
                    min = mid+1;
                    time = mid;     
                    completedWork = countWork; 
                }
            }
            
            n -= completedWork; // 이미 진입한 작업 수 제외
            time += 1; // 마지막 작업 시간
            int answer = 0; // 마지막 작업을 처리하는 코어 번호
            for(int i = 0; i < cores.length; i++){
                if (time % cores[i] == 0) { // 작업물 진입 가능한 코어
                    n--;
                    if (n == 0) {
                        answer = i+1;
                        break;
                    }
                }
            }
            return answer;
            
        }

        // 해당 시간에 진입한 작업물 수량 구하기
        private long calculate(int time, int[] cores){
            long cnt = cores.length; // 0시에 모든 코어에 작업물이 들어가므로
            for(int c : cores){
                cnt += (time / c);
            }
            return cnt;
        }
    }
}
