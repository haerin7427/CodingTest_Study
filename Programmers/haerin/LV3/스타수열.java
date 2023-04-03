package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/70130
// title : 스타 수열
// type : 구현
// time : 29m
// Created by haerin on 2023-04-03
public class 스타수열 {
    class Solution {
        public int solution(int[] a) {
            if(a.length < 2){
                return 0; // 부분 수열의 길이는 2이상의 짝수이므로 스타 수열을 만들 수 없으므로 : 리턴 0
            }else if(a.length < 4){
                return 2; // 길이가 2인 부분수열만 만들 수 있고 그 수열은 항상 스타 수열이 될 수 있으므로 : 리턴 2
            }
            
            // 숫자 별 수열에 포함된 횟수를 저장
            int[] aCount = new int[a.length];
            for(int num : a){
                aCount[num] += 1;
            }
            
            int n = 0; // 숫자 i를 교집합의 원소으로 가질 때, 만들어지는 집합의 최대 개수
            for(int i=0; i<aCount.length; i++){
                if(aCount[i] == 0) continue; // 수열에 숫자가 없으면 원소로 사용 불가능
                if(aCount[i] <= n) continue; // 숫자의 등장 횟수가 n보다 작으면 더 길이가 긴 스타수열을 만들 수 없음

                int cnt = 0; // 숫자 i가 원소로 사용된 횟수
                for(int j=0; j<a.length-1; j++){ 
                    if(a[j] != i && a[j+1] != i) continue; // i를 원소로 가지지 않는 집합은 있을 수 없음
                    if(a[j] == a[j+1]) continue; // 집합 내 동일한 원소가 있을 수 없음
                    
                    // 위 두 조건을 통과하면 집합을 만들 수 있으므로 cnt, j 값 조정
                    cnt += 1; j += 1;
                }
                // 집합의 최대 수로 업데이트
                n = Math.max(n, cnt);
            }
            return n*2;
        }
    }
}
