// https://school.programmers.co.kr/learn/courses/30/lessons/42888
// title : 오픈채팅방

import java.util.*;

public class 오픈채팅방 {
    // arraylist(string + " " + string 구조로 저장), hashmap 사용
    class Solution1 {
        public String[] solution(String[] record) {
            // 정보 + " " + id
            ArrayList<String> info = new ArrayList<>();
            // id, name
            HashMap<String, String> name = new HashMap<>();
            
            for(String r : record) {
                String[] str = r.split(" ");
                
                if(str[0].equals("Enter")) {
                    info.add(str[0] + " " + str[1]);
                    name.put(str[1], str[2]);
                }
                else if(str[0].equals("Leave")) {
                    info.add(str[0] + " " + str[1]);
                }
                else if(str[0].equals("Change")) {
                    name.put(str[1], str[2]);
                }
            }
            
            String[] answer = new String[info.size()];
            
            for(int i=0;i<info.size();i++) {
                String[] str = info.get(i).split(" ");
                
                if(str[0].equals("Enter")) {
                    answer[i] = name.get(str[1]) + "님이 들어왔습니다.";
                }
                else {
                    answer[i] = name.get(str[1]) + "님이 나갔습니다.";
                }
            }
            
            return answer;
        }
    }

    // arraylist(Info 객체로 저장), hashmap 사용
    class Solution2 {
    //     private class User {
    //         public String userId;
    //         public String name;

    //         public User(String userId, String name) {
    //             this.userId = userId;
    //             this.name = name;
    //         }
    //     }
        
        private class Info {
            public char info;
            public String userId;

            public Info(char info, String userId) {
                this.info = info;
                this.userId = userId;
            }
        }
        
        public String[] solution(String[] record) {
            ArrayList<Info> infoList = new ArrayList<>();
            // id, name
            HashMap<String, String> name = new HashMap<>();
            
            for(String r : record) {
                String[] str = r.split(" ");
                
                if(str[0].equals("Enter")) {
                    infoList.add(new Info(str[0].charAt(0), str[1]));
                    name.put(str[1], str[2]);
                }
                else if(str[0].equals("Leave")) {
                    infoList.add(new Info(str[0].charAt(0), str[1]));
                }
                else if(str[0].equals("Change")) {
                    name.put(str[1], str[2]);
                }
            }
            
            String[] answer = new String[infoList.size()];
            
            for(int i=0;i<infoList.size();i++) {
                Info information = infoList.get(i);
                
                if(information.info == 'E') {
                    answer[i] = name.get(information.userId) + "님이 들어왔습니다.";
                }
                else {
                    answer[i] = name.get(information.userId) + "님이 나갔습니다.";
                }
            }
            
            return answer;
        }
    }
}