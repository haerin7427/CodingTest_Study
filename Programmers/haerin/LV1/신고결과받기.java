// https://school.programmers.co.kr/learn/courses/30/lessons/92334
// title : 신고 결과 받기
// type : Map, Set
// time : 18m
// Created by haerin on 2023-02-09
import java.util.*;
public class 신고결과받기 {
    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            // key : 신고 당한 사람, value : key를 신고한 사람 리스트
            HashMap<String, List<String>> map = new HashMap<>();
            for(String s : report) {
                String[] str = s.split(" ");
                List<String> list = map.getOrDefault(str[1], new ArrayList<>());
                if(!list.contains(str[0])){
                    list.add(str[0]);
                    map.put(str[1], list);
                }
            }
            
            // key : 신고한 사람, value : 메일을 받을 횟수
            HashMap<String, Integer> mailCnt = new HashMap<>();
            for(String key : map.keySet()){
                List<String> list = map.get(key);
                if(list.size() >= k){
                    for(String name : list){
                        mailCnt.put(name, mailCnt.getOrDefault(name, 0)+1);
                    }
                }
            }
            
            // id_list 순서대로 각 이용자가 메일 받을 횟수 정리
            int[] answer = new int[id_list.length];
            for(int i=0; i<answer.length; i++){
                answer[i] = mailCnt.getOrDefault(id_list[i],0);
            }
            return answer;
        }
    }
    class Solution2 {
        public int[] solution(String[] id_list, String[] report, int k) {
            // key : 신고 당한 사람, value : key를 신고한 사람 리스트
            HashMap<String, Set<String>> map = new HashMap<>();
            for(String s : report) {
                String[] str = s.split(" ");
                
                Set<String> set = map.getOrDefault(str[1], new HashSet<>());
                set.add(str[0]);
                map.put(str[1], set);
            }
            
            // key : 신고한 사람, value : 메일을 받을 횟수
            HashMap<String, Integer> mailCnt = new HashMap<>();
            for(String key : map.keySet()){
                Set<String> set = map.get(key);
                if(set.size() >= k){
                    for(String name : set){
                        mailCnt.put(name, mailCnt.getOrDefault(name, 0)+1);
                    }
                }
            }
            
            // id_list 순서대로 각 이용자가 메일 받을 횟수 정리
            int[] answer = new int[id_list.length];
            for(int i=0; i<answer.length; i++){
                answer[i] = mailCnt.getOrDefault(id_list[i],0);
            }
            return answer;
        }
    }
}
