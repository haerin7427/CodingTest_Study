// https://school.programmers.co.kr/learn/courses/30/lessons/17686
// title : [3차] 파일명 정렬

import java.util.*;

public class 파일명정렬 {
    // 런타임 에러
    class Solution1 {
        public String[] solution(String[] files) {
            String[] answer = new String[files.length];
            String[][] part = new String[files.length][3];
            int idx = 0;
            
            for(String file : files) {
                int numStart = -1, numEnd = -1;
                boolean isNumFirst = true;
                
                for(int i=0;i<file.length();i++) {
                    // 숫자일 때
                    if(Character.isDigit(file.charAt(i))) {
                        // 처음 숫자 나오는 index
                        if(isNumFirst) {
                            numStart = i;
                            isNumFirst = false;
                        }
                    }
                    else if(!isNumFirst) {
                        numEnd = i;
                        break;
                    }
                }
                
                part[idx][0] = file.substring(0, numStart);
                part[idx][1] = file.substring(numStart, numEnd);
                part[idx++][2] = file.substring(numEnd);
            }
            
            Arrays.sort(part, (o1, o2) -> {
                // 소문자 변환 후, head 사전순 정렬
                if(o1[0].toLowerCase().compareTo(o2[0].toLowerCase()) > 0) {
                    return 1;
                }
                else if(o1[0].toLowerCase().compareTo(o2[0].toLowerCase()) < 0) {
                    return -1;
                } 
                else {
                    // head가 동일할 때, number 오름차순 정렬
                    if(Integer.parseInt(o1[1]) > Integer.parseInt(o2[1])) {
                        return 1;
                    }
                    else if(Integer.parseInt(o1[1]) < Integer.parseInt(o2[1])) {
                        return -1;
                    }
                    else return 0;
                }
            });
            
            for(int i=0;i<files.length;i++) {
                answer[i] = part[i][0] + part[i][1] + part[i][2];
            }
            
            return answer;
        }
    }

    class Solution2 {
        public String[] solution(String[] files) {
            Arrays.sort(files, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    String[] file1 = detach(s1);
                    String[] file2 = detach(s2);
                    
                    int headValue = file1[0].compareTo(file2[0]);
                    
                    if(headValue == 0) {
                        int num1 = Integer.parseInt(file1[1]);
                        int num2 = Integer.parseInt(file2[1]);
                        
                        return num1 - num2;
                    } 
                    else return headValue;
                }
                
                private String[] detach(String str) {
                    StringBuilder head = new StringBuilder();
                    StringBuilder number = new StringBuilder();
                    StringBuilder tail = new StringBuilder();
                    int idx = 0;
                    
                    // head -> 숫자 발견하면 break;
                    for(;idx<str.length();idx++) {
                        char ch = str.charAt(idx);
                        if(ch >= '0' && ch <= '9') break;
                        head.append(ch);
                    }
                    
                    // number -> 숫자가 아니면 break;
                    for(;idx<str.length();idx++) {
                        char ch = str.charAt(idx);
                        if(!(ch >= '0' && ch <= '9')) break;
                        number.append(ch);
                    }
                    
                    // 남은 모든 문자열
                    for( ; idx < str.length() ; ++idx) {
                        char ch = str.charAt(idx);
                        tail.append(ch);
                    }
                    
                    String[] file = {head.toString().toLowerCase(), number.toString(), tail.toString()};
                    
                    return file;
                }
            });
            
            return files;
        }
    }
}