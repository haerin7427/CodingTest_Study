// https://school.programmers.co.kr/learn/courses/30/lessons/17682
// title : [1차] 다트 게임

public class 다트게임 {
    class Solution {
        public int solution(String dartResult) {
            int[] dart = new int[3];
            int cnt = 0;
            StringBuilder sb = new StringBuilder();
            
            for(int i=0;i<dartResult.length();i++) {
                char c = dartResult.charAt(i);
                
                if(Character.isDigit(c)) sb.append(c);
                else if(c == 'S' || c == 'D' || c == 'T') {
                    int n = Integer.parseInt(sb.toString());
                    
                    dart[cnt++] = (int) Math.pow(n, pow(c));
                    
                    sb.setLength(0);
                }
                else {
                    if(c == '*') {
                        dart[cnt-1] *= 2;
                        
                        if(cnt-2 >= 0) dart[cnt-2] *= 2; 
                    }
                    else dart[cnt-1] *= (-1);
                }
            }
            
            return dart[0] + dart[1] + dart[2];
        }
        
        int pow(char c) {
            if(c == 'S') return 1;
            else if(c == 'D') return 2;
            else return 3;
        }
    }
}