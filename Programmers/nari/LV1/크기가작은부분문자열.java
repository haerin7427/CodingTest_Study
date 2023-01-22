// https://school.programmers.co.kr/learn/courses/30/lessons/147355
// title : 크기가 작은 부분문자열

public class 크기가작은부분문자열 {
    class Solution1 {
        public int solution(String t, String p) {
            int answer = 0;
            Long[] arr = new Long[t.length()-p.length()+1];
            Long longP = Long.parseLong(p);
            
            for(int i=0;i<t.length()-p.length()+1;i++) {
                arr[i] = Long.parseLong(t.substring(i, i+p.length()));
            }
            
            for(int i=0;i<arr.length;i++) {
                if(arr[i] <= longP) answer++;
            }
            
            return answer;
        }
    }

    class Solution2 {
        public int solution(String t, String p) {
            int answer = 0;
            Long[] arr = new Long[t.length()-p.length()+1];
            Long longP = Long.parseLong(p);
            
            for(int i=0;i<t.length()-p.length()+1;i++) {
                if(Long.parseLong(t.substring(i, i+p.length())) <= longP) answer++;
            }
            
            return answer;
        }
    }
}