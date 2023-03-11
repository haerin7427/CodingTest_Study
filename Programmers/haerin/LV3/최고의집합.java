package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/12938
// title : 최고의 집합
// type : 수
// time : 51m
// Created by haerin on 2023-03-11
import java.util.*;
public class 최고의집합 {
    // 시간 초과
    class Solution {
        public int[] tmp;
        public List<int[]> multiSetList = new ArrayList<>();
        public int[] solution(int n, int s) {
            tmp = new int[n];
            recursion(n, s, 0);
            if(multiSetList.size() == 0){
                return new int[]{-1};
            }

            Collections.sort(multiSetList, new Comparator<int[]>(){
                @Override
                public int compare(int[] o1, int[] o2){
                    int a=1,b=1;
                    for(int i=0; i<o1.length; i++){
                        a *= o1[i];
                        b *= o2[i];
                    }
                    return b-a;
                }
            });
            int[] answer = multiSetList.get(0);
            return answer;
        }
        
        public void recursion(int n, int s, int idx){
            if(idx == n){
                int sum = 0;
                for(int num : tmp){
                    sum += num;
                }
                if(sum == s){
                    int[] t = new int[n];
                    System.arraycopy(tmp, 0, t, 0, n);
                    multiSetList.add(t);
                }
                return;
            }
            
            for(int i=1; i<10; i++){
                tmp[idx] = i;
                recursion(n, s, idx+1);
            }
        }
    }
    // 통과
    class Solution2 {
        public int[] solution(int n, int s) {
            if(n > s) return new int[]{-1};
            
            int[] answer = new int[n];
            for(int i=0; i<n; i++){
                answer[i] = s/n;
            }
            for(int i=0; i<s%n; i++){
                answer[i] += 1;
            }
            Arrays.sort(answer);
            return answer;
        }
    }
}
