// https://school.programmers.co.kr/learn/courses/30/lessons/150370
// title : 개인정보 수집 유효기간

import java.util.*;

public class 개인정보수집유효기간 {
    // 예시는 성공 -> 테스트 케이스 실패
    class Solution1 {
        public int[] solution(String today, String[] terms, String[] privacies) {
            String[] todays = today.split("\\.");
            int todayYear = Integer.parseInt(todays[0]);
            int todayMonth = Integer.parseInt(todays[1]);
            int todayDate = Integer.parseInt(todays[2]);
            HashMap<String, Integer> termsMap = new HashMap<String, Integer>();
            ArrayList<Integer> list = new ArrayList<Integer>();
            
            for(String term : terms) {
                String[] termArr = term.split(" ");
                
                termsMap.put(termArr[0], Integer.valueOf(termArr[1]));
            }
            
            for(int i=0;i<privacies.length;i++) {
                String[] privacy = privacies[i].split(" ");
                int expiredMonth = termsMap.get(privacy[1]);
                String[] dates = privacy[0].split("\\.");
                int year = Integer.parseInt(dates[0]);
                int month = Integer.parseInt(dates[1]);
                int date = Integer.parseInt(dates[2]);
                
                if(month + expiredMonth > 12) {
                    month = (month + expiredMonth) % 12;
                    year++;
                }
                else month += expiredMonth;
                
                if(date-1 == 0) {
                    if(month == 2) date = 28;
                    else if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) date = 31;
                    else date = 30;
                    
                    month--;
                }
                else date--;
                
                if(todayYear > year || todayMonth > month || todayDate > date) 
                    list.add(i+1);
            }
            
            int[] answer = new int[list.size()];
            
            for(int i=0;i<list.size();i++) {
                answer[i] = list.get(i);
            }
            
            return answer;
        }
    }

    // year과 month를 day로 변환
    class Solution2 {
        public int[] solution(String today, String[] terms, String[] privacies) {
            int todayDate = getDate(today);
            HashMap<String, Integer> termsMap = new HashMap<String, Integer>();
            ArrayList<Integer> list = new ArrayList<Integer>();
            
            for(String term : terms) {
                String[] termArr = term.split(" ");
                
                termsMap.put(termArr[0], Integer.valueOf(termArr[1]) * 28);
            }
            
            for(int i=0;i<privacies.length;i++) {
                String[] privacy = privacies[i].split(" ");
                int expiredDate = termsMap.get(privacy[1]);
                int date = getDate(privacy[0]);
                
                if(expiredDate + date <= todayDate) list.add(i+1);
            }
            
            int[] answer = new int[list.size()];
            
            for(int i=0;i<list.size();i++) {
                answer[i] = list.get(i);
            }
            
            return answer;
        }
        
        int getDate(String str) {
            String[] strs = str.split("\\.");
            
            int year = Integer.parseInt(strs[0]);
            int month = Integer.parseInt(strs[1]);
            int date = Integer.parseInt(strs[2]);
            
            return date + month * 28 + (year-2000) * 12 * 28;
        }
    }
}