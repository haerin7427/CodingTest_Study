package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/42893
// title : 매칭 점수
// type : 정규식
// time : 54m
// Created by haerin on 2023-04-18
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class 매칭점수 {
    class Solution {
        class Webpage {
            private String url;
            private int index;
            private List<String> linkUrl = new ArrayList<>();
            private double basicPoint;
            private double LinkPoint;
            
            Webpage(String url, int idx){
                this.url = url;
                this.index = idx;
            }
        }
        public int solution(String word, String[] pages) {
            Pattern home_url_pattern = Pattern.compile("<meta property=\"og:url\" content=\"(\\S*)\"");
            Pattern url_pattern = Pattern.compile("<a href=\"https://(\\S*)\"");
            Pattern word_pattern = Pattern.compile("\\b(?i)"+word+"\\b");
            Matcher url_matcher, word_matcher, home_url_matcher;
            
            Map<String, Integer> hashmap = new HashMap<>();
            
            List<Webpage> list = new ArrayList<>();
            int answer = 0;
            int index = 0;
            String home_url = "";
            for(String page : pages){
                url_matcher = url_pattern.matcher(page);
                home_url_matcher = home_url_pattern.matcher(page);
    
                if(home_url_matcher.find()){
                    home_url = home_url_matcher.group().split("=")[2].replaceAll("\"", "");
                }
                hashmap.put(home_url, index);
                Webpage nowPage = new Webpage(home_url, index);
                 while(url_matcher.find()) {
                    nowPage.linkUrl.add(url_matcher.group().split("\"")[1]);
                }
                
                
                String body = page.split("<body>")[1].split("</body>")[0].replaceAll("[0-9]", " ");
                word_matcher = word_pattern.matcher(body);
                double word_cnt = 0.0;
                while(word_matcher.find())
                    word_cnt++;
    
                nowPage.basicPoint = word_cnt;
                nowPage.LinkPoint = 0.0;
                
                list.add(nowPage);            
                index += 1;
            }
            
            for(Webpage w : list){
                if(w.linkUrl.size() > 0){
                    double point = w.basicPoint / w.linkUrl.size();
                    for(String url : w.linkUrl){
                        if(hashmap.get(url) != null)
                            list.get(hashmap.get(url)).LinkPoint += point;
                    }
                }
            }
            
            Collections.sort(list, new Comparator<Webpage>(){
                @Override
                public int compare(Webpage o1, Webpage o2){
                    if(o1.basicPoint + o1.LinkPoint == o2.basicPoint + o2.LinkPoint){
                        return o1.index - o2.index;
                    }else{
                        if((o2.basicPoint + o2.LinkPoint) - (o1.basicPoint + o1.LinkPoint) > 0){
                            return 1;
                        }else{
                            return -1;
                        }
                    }
                }
            });
            return list.get(0).index;
        }
    }
}
