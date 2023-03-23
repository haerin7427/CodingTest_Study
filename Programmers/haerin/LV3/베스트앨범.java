package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/42579
// title : 베스트앨범
// type : HashMap
// time : 45m
// Created by haerin on 2023-03-23
import java.util.*;
public class 베스트앨범 {
    class Solution {
        class Music {
            int index;
            int plays;
            
            Music(int i, int p){
                index = i;
                plays = p;
            }
        }
        public int[] solution(String[] genres, int[] plays) {
            Map<String, List<Music>> map = new HashMap<>();
            HashMap<String, Integer> num = new HashMap<>();
            for(int i=0; i<plays.length; i++){
                if(!num.containsKey(genres[i])){
                    List<Music> list = new ArrayList<>();
                    list.add(new Music(i, plays[i]));
                    map.put(genres[i], list);
                }else{
                    map.get(genres[i]).add(new Music(i, plays[i]));
                }
                num.put(genres[i], num.getOrDefault(genres[i],0)+plays[i]);       
            }
            
            // 장르별 재생횟수를 기준으로 내림차순 정렬
            List<String> keySet = new ArrayList(num.keySet());
            Collections.sort(keySet, (s1, s2) -> num.get(s2) - (num.get(s1)));
            
            List<Integer> ans = new ArrayList<>();
            for(String genre : keySet){
                List<Music> musicList = map.get(genre);
                
                Collections.sort(musicList, new Comparator<Music>(){
                    @Override
                    public int compare(Music m1, Music m2){
                        if(m1.plays != m2.plays){
                            return m2.plays - m1.plays;
                        }else{
                            return m1.index - m2.index;
                        }
                    }
                });
                ans.add(musicList.get(0).index);
                if(musicList.size()>1)
                    ans.add(musicList.get(1).index);
            }
            
            int[] answer = new int[ans.size()];
            int idx = 0;
            for(Integer index : ans){
                answer[idx++] = index;
            }
            return answer;
        }
    }
}
