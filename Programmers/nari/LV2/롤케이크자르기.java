// https://school.programmers.co.kr/learn/courses/30/lessons/132265
// title : 롤케이크 자르기

import java.util.*;

public class 롤케이크자르기 {
    // HashSet + HashMap 사용
    class Solution1 {
        public int solution(int[] topping) {
            int answer = 0;
            // 철수 토핑
            HashSet<Integer> a = new HashSet<>();
            // 동생 토핑
            HashMap<Integer, Integer> b = new HashMap<>();
            
            // 동생 토핑 map에 전부 저장
            for(int t : topping) {
                b.put(t, b.getOrDefault(t, 0) + 1);
            }
            
            for(int t : topping) {
                // 철수가 동생 토핑 하나 가져가기
                a.add(t);
                b.put(t, b.get(t)-1);
                
                // 동생 토핑 중에서 갯수가 0일 경우, 삭제
                if(b.get(t) == 0) b.remove(t);

                // 토핑이 공평하게 나눠졌을 경우
                if (a.size() == b.size()) answer++;
            }
            
            return answer;
        }
    }

    // HashSet만 사용 -> 시간 초과
    // Set 객체는 R-B Tree로 구현되어 있어 연산에 O(logN)의 시간이 걸림
    // for문 안에서 계속적인 객체 생성이 있다면, 시간복잡도는 O(반복 횟수 * logN)이 가지게 되어 시간초과 발생
    class Solution2 {
        public int solution(int[] topping) {
            int answer = 0;
            
            for(int i=1;i<topping.length;i++) {
                // 철수 토핑
                HashSet<Integer> a = new HashSet<>();
                // 동생 토핑
                HashSet<Integer> b = new HashSet<>();
                
                for(int j=0;j<i;j++) {
                    a.add(topping[j]);
                    
                    // 남은 갯수가 a hashset에 담긴 수보다 작을 경우
                    if(a.size() > topping.length-i) break;
                }
                
                if(a.size() > topping.length-i) continue;
                
                for(int j=i;j<topping.length;j++) {
                    b.add(topping[j]);
                    
                    // b hashset의 크기가 a hashset의 크기보다 클 경우
                    if(b.size() > a.size()) break;
                }
                
                // 토핑이 공평하게 나눠졌을 경우
                if(a.size() == b.size()) answer++;
            }
            
            return answer;
        }
    }
}