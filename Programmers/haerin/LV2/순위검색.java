package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/72412
// title : 순위 검색
// type : HashMap & 이분탐색
// time : 53m
// Created by haerin on 2023-03-06
import java.util.*;
public class 순위검색 {
    // 효율성 테스트 실패
    class Solution {
        class Person{
            String lang;
            String position;
            String experience;
            String food;
            int score;
            Person(String l, String p, String e, String f, String s){
                this.lang = l;
                this.position = p;
                this.experience = e;
                this.food = f;
                this.score = Integer.parseInt(s);
            }
        }
        public int[] solution(String[] info, String[] query) {
            List<Person> people = new ArrayList<>();
            for(String s : info){
                String[] tmp = s.split(" ");
                people.add(new Person(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4]));
            }
            
            int[] answer = new int[query.length];
            for(int i=0; i<query.length; i++){
                String[] s = query[i].replaceAll(" and","").split(" ");
                int cnt = 0;
                for(Person p : people){
                    if((s[0].equals("-") || s[0].equals(p.lang)) && (s[1].equals("-") || s[1].equals(p.position)) && (s[2].equals("-") || s[2].equals(p.experience)) && (s[3].equals("-") || s[3].equals(p.food)) && (s[4].equals("-") || Integer.parseInt(s[4]) <= p.score)){
                        cnt+=1;
                    }
                }
                answer[i] = cnt;
            }
            return answer;
        }
    }
    // 정확성 + 효율성 테스트 통과
    class Solution2 {
        public int[] solution(String[] info, String[] query) {
            Map<String, ArrayList<Integer>> hashMap = new HashMap<>();
            
            for(String i : info){
                String[] data = i.split(" ");
                String[] langs = {data[0], "-"};
                String[] jobs = {data[1], "-"};
                String[] exps = {data[2], "-"};
                String[] foods = {data[3], "-"};
                int val = Integer.parseInt(data[4]);
                
                for(String l : langs){
                    for(String j : jobs){
                        for(String e : exps){
                            for(String f : foods){
                                String[] keyData = {l,j,e,f};
                                String key = String.join(" ",keyData);
                                ArrayList<Integer> list = hashMap.getOrDefault(key, new ArrayList<Integer>());
                                list.add(val);
                                hashMap.put(key, list);
                            }
                        }
                    }
                }
            }
            
            for(ArrayList<Integer> list : hashMap.values()){
                list.sort(null);
            }
            
            
            int[] answer = new int[query.length];
            int idx=0;
            for(String q : query){
                String[] data = q.split(" and ");
                int target = Integer.parseInt(data[3].split(" ")[1]);
                data[3] = data[3].split(" ")[0];
                
                String key = String.join(" ", data);
                
                if(hashMap.containsKey(key)){
                    ArrayList<Integer> list = hashMap.get(key);
                    int left = 0;
                    int right = list.size();
                    
                    while(left < right){
                        int mid = (left + right) / 2;
                        if(list.get(mid) >= target){
                            right = mid;
                        }else{
                            left = mid+1;
                        }
                    }
                    answer[idx] = list.size() - left;
                }
                idx+=1;
            }
            return answer;
        }
    }
}
