// https://school.programmers.co.kr/learn/courses/30/lessons/12904
// title : 가장 긴 팰린드롬

public class 가장긴팰린드롬 {
    class Solution
    {
        public int solution(String s)
        {
            char[] ch = s.toCharArray();

            // 팰린드룸의 길이 -> 가장 긴 문자열 길이부터 체크
            for(int i=s.length();i>1;i--) {
                // 시작 인덱스 -> i와 j의 합이 s의 길이를 넘어선 안됨
                for(int j=0;j+i<=s.length();j++) {
                    boolean isSame = true;
                    int start = j, end = j+i-1;
                    
                    // start와 end가 같아질때까지 반복
                    while(start <= end) {
                        // 앞뒤가 다른 문자열일 경우
                        if(ch[start++] != ch[end--]) {
                            isSame = false;
                            break;
                        }
                    }
                    
                    if(isSame) return i;
                }
            }

            // 아예 존재하지 않는 경우 -> 0일 경우 테스트 케이스 실패
            return 1;
        }
    }
}