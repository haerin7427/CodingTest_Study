// https://school.programmers.co.kr/learn/courses/30/lessons/42895
// title : N으로 표현

import java.util.*;

public class N으로표현 {
    class Solution1 {
        public int solution(int N, int number) {
            ArrayList<Set<Integer>> list = new ArrayList<>();
            
            // 최솟값이 8보다 크면, -1 return이기 때문에 그 이상은 확인할 필요 X
            for(int i=0;i<8;i++) {
                list.add(new HashSet<>());
            }
            // 1개만 사용할 경우 -> 자기 자신
            list.get(0).add(N);
            
            for(int i=0;i<8;i++) {
                Set<Integer> set = list.get(i);
                
                // N을 (i+1)번 이어붙인 경우
                set.add(Integer.parseInt(String.valueOf(N).repeat(i+1)));

                // 이전 단계의 결과를 서로 사칙연산한 결과
                // [N을 1개 사용한 경우] union [(i+1) - 1개 사용한 경우]
                // [N을 2개 사용한 경우] union [(i+1) - 2개 사용한 경우]
                // ...
                for(int j=0;j<i;j++) {
                    for(int a : list.get(j)) {
                        for(int b : list.get(i-1-j)) {
                            set.add(a + b);
                            set.add(a - b);
                            set.add(a * b);
                            
                            if(b != 0) set.add(a / b);
                        }
                    }
                }

                // 가장 작은 경우를 구하기 -> 작은 수부터 시작이니까 바로 return
                if(set.contains(number)) return i+1;
            }
            
            return -1;
        }
    }

    class Solution2 {
        public int solution(int N, int number) {
            if(N == number) return 1;
                
            ArrayList<HashSet<Integer>> list = new ArrayList<>();
            
            list.add(new HashSet<>());
            list.get(0).add(N);
            
            for(int i=1;i<8;i++) {
                list.add(new HashSet<>());
                HashSet<Integer> set = list.get(i);
                
                set.add(Integer.parseInt(Integer.toString(N).repeat(i+1)));
                
                // 2 = 1 + 1
                // 3 = 1 + 2, 2 + 1
                // 4 = 1 + 3, 2 + 2, 3 + 1
                
                // i=6인 경우
                // (0번 - 5번, 1번 - 4번, 2번 - 3번, 3번 - 2번, 4번 - 1번, 5번 - 0번) 비교
                for(int j=0;j<i;j++) {
                    HashSet<Integer> aSet = list.get(j);
                    HashSet<Integer> bSet = list.get((i-1) - j);
                    
                    for(int a : aSet) {
                        for(int b : bSet) {
                            set.add(a + b);
                            set.add(a - b);
                            set.add(a * b);
                            if(b != 0) set.add(a / b);
                        }
                    }
                }
                
                if(set.contains(number)) return i+1;
            }

            return -1;
        }
    }
}