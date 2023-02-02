// https://school.programmers.co.kr/learn/courses/30/lessons/118666
// title : 성격 유형 검사하기

public class 성격유형검사하기 {
    class Solution {
        public String solution(String[] survey, int[] choices) {
            StringBuilder answer = new StringBuilder();
            // RT | CF | JM | AN
            // 음수-양수
            int[] type = new int[4];
            
            for(int i=0;i<survey.length;i++) {
                int s = score(choices[i]);
                
                if(survey[i].equals("RT")) type[0] += s;
                else if(survey[i].equals("TR")) type[0] -= s;
                else if(survey[i].equals("CF")) type[1] += s;
                else if(survey[i].equals("FC")) type[1] -= s;
                else if(survey[i].equals("JM")) type[2] += s;
                else if(survey[i].equals("MJ")) type[2] -= s;
                else if(survey[i].equals("AN")) type[3] += s;
                else if(survey[i].equals("NA")) type[3] -= s;
            }
            
            if(type[0] <= 0) answer.append("R");
            else answer.append("T");
            
            if(type[1] <= 0) answer.append("C");
            else answer.append("F");
            
            if(type[2] <= 0) answer.append("J");
            else answer.append("M");
            
            if(type[3] <= 0) answer.append("A");
            else answer.append("N");
            
            return answer.toString();
        }
        
        int score(int n) {
            switch(n) {
                case 1: return -3;
                case 2: return -2;
                case 3: return -1;
                case 4: return 0;
                case 5: return 1;
                case 6: return 2;
                case 7: return 3;
                default : return 0;
            }
        }
    }
}