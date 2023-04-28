// https://school.programmers.co.kr/learn/courses/30/lessons/1830
// title : 브라이언의 고민

import java.util.*;

public class 브라이언의고민 {
    class Solution {
        public String solution(String sentence) {
            StringBuilder answer = new StringBuilder();
            // HashMap과 달리 입력 순서 보장
            // key : 소문자, value : 해당 소문자의 위치
            LinkedHashMap<Character, ArrayList<Integer>> lowerCount = new LinkedHashMap<>();
            
            try {
                int len = sentence.length();

                // 소문자의 각 종류 / 위치 파악
                for(int i=0;i<len;i++) {
                    char c = sentence.charAt(i);

                    // 소문자인 경우
                    if(Character.isLowerCase(c)) {
                        // 해당 문자가 map에 존재하지 않는 경우
                        if(!lowerCount.containsKey(c))
                            lowerCount.put(c, new ArrayList<Integer>());
                        
                        lowerCount.get(c).add(i);
                    }
                }

                int stringIdx = 0;
                int lastStartIdx = -1, lastEndIdx = -1;
                int lastStartWordIdx = -1, lastEndWordIdx = -1;
                
                for(char c : lowerCount.keySet()) {
                    ArrayList<Integer> temp = lowerCount.get(c);
                    
                    int count = temp.size();
                    int startIdx = temp.get(0), endIdx = temp.get(count-1);
                    // 사용한 규칙 번호
                    int rule = 0;
                    int startWordIdx = 0, endWordIdx = 0;
                    

                    // 소문자 수가 1개 거나 3개 이상인 경우 -> 글자 사이마다 넣는 경우
                    if(count == 1 || count >= 3) {
                        for(int i=1;i<count;i++) {
                            // 해당 문자의 간격이 2를 넘어가면 x
                            if(temp.get(i) - temp.get(i-1) != 2) return "invalid";
                        }
                        
                        rule = 1;
                    }
                    // 소문자 수가 2개인 경우 -> 단어 앞뒤에 넣는 경우
                    else if(count == 2) {
                        int distance = endIdx - startIdx;

                        // 간격이 2고,
                        // 이전에 사용한 문자의 start index보다 크고, end index보다 작은 경우
                        // 시작 지점이 느린데, 더 빨리 끝난다? -> 글자 사이에 소문자 2개만 들어가는 경우
                        if(distance == 2 && (startIdx > lastStartIdx && endIdx < lastEndIdx)) rule = 1;
                        // 간격이 2와 같거나 큰 경우
                        else if(distance >= 2) rule = 2;
                        // 연속된 소문자 x
                        else return "invalid";
                    }

                    // 규칙 1일 경우, 단어 start index와 end index 구하기
                    if(rule == 1) {
                        // 기호 위치에서 앞뒤로 한칸 이동
                        startWordIdx = startIdx - 1;
                        endWordIdx = endIdx + 1;

                        // 이전 시작 지점보다 느리고, 더 빨리 끝나는 경우 -> 이전 단어 안에 포함되어 있는 경우
                        if(lastStartWordIdx < startWordIdx && lastEndWordIdx > endWordIdx) {
                            // 이전 단어의 start, end index와의 각 차가 2인 경우
                            //     -> 규칙 2인 경우 -> 해당 단어는 이미 포함
                            if(startIdx - lastStartIdx == 2 && lastEndIdx - endIdx == 2) continue;
                            // 위 경우가 아닌 경우 -> 중복 사용
                            else return "invalid";
                        }
                    }
                    // 규칙 2일 경우, 단어 start index와 end index 구하기
                    else if(rule == 2) {
                        startWordIdx = startIdx;
                        endWordIdx = endIdx;
                        
                        // 이전 단어 사이에 위치한 경우 -> 중복 사용
                        if(lastStartWordIdx < startWordIdx && lastEndWordIdx > endWordIdx) return "invalid";
                    }

                    // 단어의 범위가 맞지 않은 경우
                    if(lastEndWordIdx >= startWordIdx) return "invalid";

                    // 소문자 등장 이전에 존재하던 앞의 단어 추가
                    if(stringIdx < startWordIdx) {
                        answer.append(makeWord(sentence, stringIdx, startWordIdx-1));
                        answer.append(" ");
                    }
                    
                    answer.append(makeWord(sentence, startWordIdx, endWordIdx));
                    answer.append(" ");
                    
                    lastStartWordIdx = startWordIdx;
                    lastEndWordIdx = endWordIdx;
                    lastStartIdx = startIdx;
                    lastEndIdx = endIdx;
                    stringIdx = endWordIdx + 1;
                }
                
                // 뒤에 남는 단어들도 더하기
                if(stringIdx < len) {
                    answer.append(makeWord(sentence, stringIdx, len-1));
                }
            }
            catch (Exception e) {
                return "invalid";
            }
            
            return answer.toString().trim();
        }
        
        public String makeWord(String sentence, int start, int end) {
            String word = sentence.substring(start, end+1);
            
            return word.replaceAll("[a-z]","");
        }
    }
}