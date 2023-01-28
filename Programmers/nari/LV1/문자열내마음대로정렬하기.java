// https://school.programmers.co.kr/learn/courses/30/lessons/12915
// title : 문자열 내 마음대로 정렬하기

import java.util.*;

public class 문자열내마음대로정렬하기 {
    // 테스트 케이스 12개 기준 평균 속도 약 0.4ms
    class Solution1 {
        public String[] solution(String[] strings, int n) {
            Arrays.sort(strings, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(o1.charAt(n) == o2.charAt(n))
                        return o1.compareTo(o2);
                    else return o1.charAt(n) - o2.charAt(n);
                }
            });
            
            return strings;
        }
    }

    // 테스트 케이스 12개 기준 평균 속도 약 11ms
    class Solution2 {
        public String[] solution(String[] strings, int n) {
            ArrayList<String> arr = new ArrayList<>();
            
            for (int i = 0; i < strings.length; i++) {
                arr.add(strings[i].charAt(n) + strings[i]);
            }
            
            Collections.sort(arr);
            
            String[] answer = new String[arr.size()];
            
            for (int i = 0; i < arr.size(); i++) {
                answer[i] = arr.get(i).substring(1, arr.get(i).length());
            }
            
            return answer;
        }
    }
}