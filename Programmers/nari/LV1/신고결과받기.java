// https://school.programmers.co.kr/learn/courses/30/lessons/92334
// title : 신고 결과 받기

import java.util.*;

public class 신고결과받기 {
    class Solution1 {
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];
            // id_list를 index와 같이 저장
            HashMap<String, Integer> listMap = new HashMap<>();
            // 누가 누구를 신고했는지
            HashMap<String, HashSet<String>> idMap = new HashMap<>();
            // 누가 몇번 신고 받았는지
            HashMap<String, Integer> reportCountMap = new HashMap<>();
            
            for(int i=0;i<id_list.length;i++) {
                listMap.put(id_list[i], i);
            }
            
            for(String r : report) {
                String[] split = r.split(" ");
                
                // idMap에 이미 존재하는지 
                if(idMap.containsKey(split[0])) {
                    if(!idMap.get(split[0]).contains(split[1])) {
                        if(reportCountMap.containsKey(split[1])) 
                            reportCountMap.put(split[1], reportCountMap.get(split[1])+1);
                        else reportCountMap.put(split[1], 1);
                    }
                    
                    idMap.get(split[0]).add(split[1]);
                }
                else {
                    HashSet<String> set = new HashSet<String>();
                    set.add(split[1]);
                    idMap.put(split[0], set);
                    
                    if(reportCountMap.containsKey(split[1])) 
                        reportCountMap.put(split[1], reportCountMap.get(split[1])+1);
                    else reportCountMap.put(split[1], 1);
                }
            }
            
            for(String key : reportCountMap.keySet()) {
                int count = reportCountMap.get(key);
                
                if(count < k) continue;
                
                for(String key2 : idMap.keySet()) {
                    HashSet<String> set = idMap.get(key2);
                    
                    if(set.contains(key)) answer[listMap.get(key2)]++;
                }
            }
            
            return answer;
        }
    }

    // 객체 지향
    class User{
        String name;
        HashSet<String> reportList;
        HashSet<String> reportedList;
        
        public User(String name) {
            this.name = name;
            reportList = new HashSet<>();
            reportedList = new HashSet<>();
        }
    }

    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];
            ArrayList<User> users = new ArrayList<>();
            HashMap<String, Integer> suspendedList = new HashMap<>(); //<이름>
            HashMap<String, Integer> idIdx = new HashMap<>(); // <이름, 해당 이름의 User 클래스 idx>
            
            for(int i=0;i<id_list.length;i++) {
                idIdx.put(id_list[i], i);
                users.add(new User(id_list[i]));
            }
            
            for(String r : report) {
                String[] str = r.split(" ");
                users.get(idIdx.get(str[0])).reportList.add(str[1]);
                users.get(idIdx.get(str[1])).reportedList.add(str[0]);
            }
            
            for(User user : users) {
                if(user.reportedList.size() >= k) suspendedList.put(user.name, 1);
            }
            
            for(User user : users) {
                for(String nameReport : user.reportList) {
                    if(suspendedList.get(nameReport) != null) 
                        answer[idIdx.get(user.name)]++;
                }
            }
            
            return answer;
        }
    }
}