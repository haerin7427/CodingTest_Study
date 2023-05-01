package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/42895
// title : N으로표현
// type : DFS, DP
// time : 25m
// Creatd by haerin on 2023-04-13, 2023-05-01
import java.util.*;
public class N으로표현 {
    class Solution {
        private int min = Integer.MAX_VALUE;
        
        public int solution(int N, int number) {
            dfs(0, N, number, 0);
            return min == Integer.MAX_VALUE ? -1 : min;
        }

        // depth : N 사용횟수, current : 현재 숫자
        public void dfs(int depth, int N, int number, int current) {
            if (depth > 8) { // 문제 제한 사항 : 최대 사용 횟수 = 8
                return;
            }
            
            if (number == current) {
                min = Math.min(depth, min);
                return;
            }
            
            int temp = 0;
                
            for (int i = 0; i < 8; i++) {
                if (depth + i < 8) {
                    temp = temp * 10 + N; // N, NN, NNN 등 반복문을 통해 사용

                    // 사칙 연산을 통해 모든 케이스 확인
                    dfs(depth + i + 1, N, number, current + temp);
                    dfs(depth + i + 1, N, number, current - temp);
                    dfs(depth + i + 1, N, number, current / temp);
                    dfs(depth + i + 1, N, number, current * temp);     
                }      
            }
        }
    }

    class Solution2 {
        public int solution(int N, int number) {
            if(N == number) return 1;
            
            // n은 최대 8번까지 사용할 수 있으므로 인덱스 8까지 배열 생성
            // setArr[i] 에는 N을 i번 사용해서 만들 수 있는 숫자 저장 (중복을 피하기 위해 자료구조 Set 사용)
            Set<Integer>[] setArr = new Set[9];
            int t = N;
            for(int i = 1; i < 9; i++) {
                setArr[i] = new HashSet<>();
                setArr[i].add(t);
                t = t * 10 + N;
            }
            
            // N을 i번 사용하여 사칙 연산을 통해 만들 수 있는 수 확인
            for(int i = 1; i < 9; i++) {
                for(int j = 1; j < i; j++) {
                    for(Integer a : setArr[j]) { // a = j번 사용해서 만들 수 있는 수
                        for(Integer b : setArr[i - j]) {
                            // b = (i-j)번 사용해서 만들 수 있는 수
                            
                            // a와 b를 사칙연산한 수 = i번 사용해서 만들 수 있는 수 구하기
                            setArr[i].add(a + b);
                            setArr[i].add(a - b);
                            setArr[i].add(b - a);
                            setArr[i].add(a * b);
                            if(b != 0) {
                                setArr[i].add(a / b);
                            }
                            if(a != 0) {
                                setArr[i].add(b / a);
                            }
                        }
                    }
                }
            }
            
            // number가 없으면 9번이상 사용해야하는 수로 판단하여 -1 return
            int answer = -1;
            for(int i = 1; i < 9; i++) {
                if(setArr[i].contains(number)) {
                    answer = i;
                    break;
                }
            }
            return answer;
        }
    }
}
