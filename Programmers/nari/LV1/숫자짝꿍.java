// https://school.programmers.co.kr/learn/courses/30/lessons/131128
// title : 숫자 짝꿍

import java.util.*;

public class 숫자짝꿍 {
    // 테스트 케이스 11~15 - 시간 초과
    class Solution1 {
        public String solution(String X, String Y) {
            ArrayList<Character> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            
            for(int i=0;i<X.length();i++) {
                char x = X.charAt(i);
                
                for(int j=0;j<Y.length();j++) {
                    char y = Y.charAt(j);
                    
                    if(x == y) {
                        list.add(x);
                        Y = Y.replaceFirst(Character.toString(y), "");
                        break;
                    }
                }
            }
            
            if(list.size() == 0) return "-1";
            else {
                int cnt = Collections.frequency(list, '0');
                
                if(cnt == list.size()) return "0";
                else {
                    Collections.sort(list, Collections.reverseOrder());
                    
                    for(char c : list) {
                        sb.append(c);
                    }
                    return sb.toString();
                }
            }
        }
    }

    // 테스트 케이스 11~15 - 시간 초과
    class Solution2 {
        public String solution(String X, String Y) {
            String[] str = {"9", "8", "7", "6", "5", "4", "3", "2", "1", "0"};
            ArrayList<String> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            
            for(String s : str) {
                while(X.contains(s) && Y.contains(s)) {
                    sb.append(s);
                    X = X.replaceFirst(s, "");
                    Y = Y.replaceFirst(s, "");
                }
            }
            
            if(sb.length() == 0) return "-1";
            else {
                String answer = sb.toString();
                answer = answer.replaceAll("0", "");
                
                if(answer.length() == 0) return "0";
                else return sb.toString();
            }
        }
    }

    class Solution3 {
        public String solution(String X, String Y) {
            StringBuilder sb = new StringBuilder();
            int[] x = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] y = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            
            for(int i=0;i<X.length();i++) {
            x[Character.getNumericValue(X.charAt(i))]++;
            }
            
            for(int i=0;i<Y.length();i++) {
            y[Character.getNumericValue(Y.charAt(i))]++;
            }
            
            for(int i=9;i>=0;i--) {
                for(int j=0;j<Math.min(x[i], y[i]);j++) {
                    sb.append(i);
                }
            }
            
            if(sb.length() == 0) return "-1";
            else if(sb.indexOf("0") == 0) return "0";
            else return sb.toString();
        }
    }
}