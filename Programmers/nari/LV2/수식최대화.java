// https://school.programmers.co.kr/learn/courses/30/lessons/67257
// title : [카카오 인턴] 수식 최대화

import java.util.*;

public class 수식최대화 {
    class Solution {
        long answer = 0;
        // 숫자 담을 리스트
        ArrayList<Long> numList = new ArrayList<>();
        // 연산자 담을 리스트
        ArrayList<Character> opList = new ArrayList<>();
        // 순열로 만든 연산자 담을 배열 
        char[] permOp = new char[3]; 
        boolean[] visited = new boolean[3]; 
        
        public long solution(String expression) {
            StringBuilder nums = new StringBuilder();
            
            // 숫자와 연산자 구분
            for (char c : expression.toCharArray()) {
                if (c == '+' || c == '-' || c == '*') {
                    opList.add(c);
                    numList.add(Long.valueOf(nums.toString()));
                    nums = new StringBuilder();
                } 
                else nums.append(c);
            }
            
            numList.add(Long.valueOf(nums.toString()));
            
            //순열 만들기
            perm(0);
            
            return answer;
        }
        
        void perm(int depth) {
            Character[] op = {'+', '-', '*'};
            
            // 연산자 갯수 3
            if(depth == 3) {
                priority();
                return;
            }

            for(int i=0;i<3;i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    permOp[depth] = op[i];
                    perm(depth + 1);  
                    visited[i] = false;
                }
            }
        }
        
        // 연산자 우선순위
        void priority() {
            // 연산자 우선 순위에 따른 값을 얻기 위해 List 복사 
            ArrayList<Character> op = new ArrayList<>();
            op.addAll(opList);
            
            ArrayList<Long> num = new ArrayList<>();
            num.addAll(numList);
            
            // 연산자 갯수 3
            for(int i=0;i<3;i++) {
                // 현재 우선순위 연산자
                char curOp = permOp[i]; 
                
                for(int j=0;j<op.size();j++) {
                    // 현재 우선순위에 맞는 연산자일 경우
                    if(op.get(j) == curOp) {  
                        long n1 = num.get(j);
                        long n2 = num.get(j+1);
                        long result = cal(n1, n2, curOp);
                    
                        // 계산 완료된 숫자, 연산자 삭제
                        num.remove(j+1);
                        num.remove(j);
                        op.remove(j); 
        
                        num.add(j, result);
                
                        j--;
                    }
                }
            }
            
            answer = Math.max(answer, Math.abs(num.get(0)));
        }
        
        long cal(long n1, long n2, char op) {
            long result = 0;
            
            switch(op) {
                case '+' :
                    result = n1 + n2;
                    break;
                case '-' :
                    result = n1 -n2;
                    break;
                case '*' :
                    result = n1 * n2;
                    break;
            }
            
            return result;
        }
    }
}