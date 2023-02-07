// https://school.programmers.co.kr/learn/courses/30/lessons/17680
// title : [1차] 캐시

import java.util.*;

public class 캐시 {
    class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            
            // LRU 알고리즘
            // 처리할 작업을 차례대로 읽으며 캐시 배열에 입력
            // 입력할 작업이 캐시에 없다면, 배열의 값을 한칸씩 뒤로 밀고 제일 앞에 입력
            // 캐시에 있다면, 값이 있는 위치 앞에서부터 차례로 뒤로 밀고 제일 앞에 입력
            ArrayList<String> list = new ArrayList<>();
            
            for(String city : cities) {
                // 대소문자 구분 X -> 모두 소문자로 변환
                city = city.toLowerCase();
                
                // ArrayList에 값이 존재할 경우
                if(list.contains(city)){
                    // Integer 값으로 넘긴 해당 요소를 지워주고, 맨 앞에 더하기
                    list.remove(city);
                    list.add(city);
                    
                    // cache hit
                    answer += 1;
                }
                // ArrayList에 값이 존재하진 않지만, size full인 경우
                else if(list.size() >= cacheSize) {
                    list.add(city);
                    // cache miss
                    answer += 5;

                    // 가장 뒤의 숫자 지우기
                    // 출력 시, 거꾸로 출력하므로 0 인덱스가 가장 마지막에 나오게 된다.
                    list.remove(0);
                }
                // ArrayList에 값이 존재하지 않고, 사이즈도 작은 경우
                else {
                    list.add(city);
                    // cache miss
                    answer += 5;
                }
                
                // Cache Hit : 캐시에 존재하고 있을 경우
                // Cache Miss : 캐시에 존재하지 않을 경우
            }
            
            return answer;
        }
    }
}