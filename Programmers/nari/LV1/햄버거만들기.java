// https://school.programmers.co.kr/learn/courses/30/lessons/133502
// title : 햄버거 만들기

import java.util.*;

public class 햄버거만들기 {
    // 시간초과
    class Solution1 {
        public int solution(int[] ingredient) {
            int answer = 0;
            StringBuilder sb = new StringBuilder(Arrays.toString(ingredient).replaceAll("[^0-9]",""));

            while(sb.indexOf("1231") != -1) {
                int idx = sb.indexOf("1231");
                
                sb.delete(idx, idx+4);
                
                answer++;
            }
            
            return answer;
        }
    }

    // stack 사용 -> 제일 느림
    class Solution2 {
        public int solution(int[] ingredient) {
            int answer = 0;
            Stack burger = new Stack();
            
            for(int i : ingredient) {
                if(i == 1 && // 현재 재료가 빵이고,
                    burger.size() >= 3 && // burger에 재료가 3개 이상 쌓여있고,
                    burger.lastIndexOf(3) == burger.size()-1 && // burger에 3(고기)이 등장하는 마지막 index가 직전 재료이고,
                    burger.lastIndexOf(2) == burger.size()-2 && // burger에 2(야채)가 등장하는 마지막 index가 전전 재료이고,
                    burger.lastIndexOf(1) == burger.size()-3 // burger에 1(빵)이 등장하는 마지막 index가 전전전 재료이면
                ) {
                    answer++;
                    burger.pop();
                    burger.pop();
                    burger.pop();
                    // 재료 제거
                }
                else burger.add(i);
            }

            return answer;
        }
    }

    // int[] 사용 -> 첫번째로 빠름
    class Solution3 {
        public int solution(int[] ingredient) {
            int answer = 0;
            int[] burger = new int[ingredient.length];
            int idx = 0;
            
            for(int i : ingredient) {
                if(i == 1 &&
                    idx >= 3 &&
                    burger[idx-1] == 3 &&
                    burger[idx-2] == 2 &&
                    burger[idx-3] == 1
                ) {
                    idx -= 3;
                    answer++;
                }
                else burger[idx++] = i;
            }
            
            return answer;
        }
    }

    // ArrayList 사용 -> 두번째로 빠름
    class Solution4 {
        public int solution(int[] ingredient) {
            int answer = 0;
            ArrayList<Integer> burger = new ArrayList<Integer>();
            int idx = 0;
            
            for(int i : ingredient) {
                if(i == 1 &&
                idx >= 3 &&
                burger.get(idx-1) == 3 &&
                burger.get(idx-2) == 2 &&
                burger.get(idx-3) == 1
                ) {
                    burger.remove(idx-1);
                    burger.remove(idx-2);
                    burger.remove(idx-3);
                    idx -= 3;
                    answer++;
                }
                else {
                    burger.add(i);
                    idx++;
                }
            }
            
            return answer;
        }
    }
}