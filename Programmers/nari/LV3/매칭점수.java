// https://school.programmers.co.kr/learn/courses/30/lessons/42893
// title : 매칭 점수

import java.util.*;

public class 매칭점수 {
    class Solution {
        // 웹페이지 url
        ArrayList<String> webPage = new ArrayList<>();
        // 각 웹페이지 기본점수 및 외부 링크수
        HashMap<String, int[]> basic = new HashMap<>();
        // 각 웹페이지가 링크로 포함되어 있는 웹페이지 저장
        HashMap<String, ArrayList<String>> link = new HashMap<>();
        // 각 웹페이지의 매칭 점수
        HashMap<String, Double> score = new HashMap<>();
        
        public int solution(String word, String[] pages) {
            int answer = 0;
            double maxScore = 0;
            
            for(String page : pages) {
                String url = findWebPage(page);
                basic.put(url, new int[2]);
                connectOtherWebPage(page, url);
                findWord(page, url, word);
            }
            
            for(int i=0;i<webPage.size();i++) {
                String url = webPage.get(i);
                
                if(link.containsKey(url)) {
                    for(String linkedUrl : link.get(url)) {
                        if(!basic.containsKey(linkedUrl)) continue;

                        int[] info = basic.get(linkedUrl);
                        double d = (double) info[0] / (double) info[1];

                        score.replace(url, score.get(url) + d);
                    }
                }
                
                if(maxScore < score.get(url)) {
                    maxScore = score.get(url);
                    answer = i;
                }
            }
            
            return answer;
        }
        
        public String findWebPage(String page) {
            String urlPattern = "<meta property=\"og:url\" content=\"";
            int urlStart = page.indexOf(urlPattern) + urlPattern.length();
            int urlEnd = page.indexOf("\"/>", urlStart);
            
            String url = page.substring(urlStart, urlEnd);
            webPage.add(url);
            
            return url;
        }
        
        public void connectOtherWebPage(String page, String url) {
            String[] herf = page.split("<a href=\"");
            
            // 제일 처음 문자열 제외
            for(int i=1;i<herf.length;i++) {
                String linkedUrl = herf[i].substring(0, herf[i].indexOf("\""));
                
                if(!link.containsKey(linkedUrl)) link.put(linkedUrl, new ArrayList<>());
                
                link.get(linkedUrl).add(url);
            }
            
            int[] info = basic.get(url);
            // 제일 처음 문자열 제외
            info[1] = herf.length - 1;
            
            basic.replace(url, info);
        }
        
        public void findWord(String page, String url, String word) {
            // 검색어 word는 하나의 영어 단어로만 주어지기 때문에 문자가 아닌경우 공백으로 치환
            // 검색어를 찾을 때, 대소문자 구분은 무시하기 때문에 모든 문자 소문자로 치환
            page = page.replaceAll("[^a-zA-Z]", " ").toLowerCase();
            word = word.toLowerCase();
            
            String[] words = page.split(" ");
            int cnt = 0;
            
            for(String w : words) {
                if(w.equals(word)) cnt++;
            }
            
            int[] info = basic.get(url);
            info[0] = cnt;
            
            basic.replace(url, info);
            score.put(url, score.getOrDefault(url, (double) 0) + cnt);
        }
        
    }
}