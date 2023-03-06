// https://school.programmers.co.kr/learn/courses/30/lessons/72412
// title : 순위 검색

import java.util.*;

public class 순위검색 {
    // for문 3개 사용
    // 정확성 테스트 통과 - 효율성 테스트 시간초과
    class Solution1 {
        public int[] solution(String[] info, String[] query) {
            int[] answer = new int[query.length];
            
            for(int i=0;i<query.length;i++) {
                String[] split = query[i].split(" ");
                boolean check = true;
                int cnt = 0;
                
                for(String in : info) {
                    int scoreCnt = 0;
                    
                    for(String s : split) {
                        if(s.equals("and")) continue;
                        else if(s.equals("-")) {
                            scoreCnt++;
                            continue;
                        }
                        
                        // 코딩테스트 점수 판별
                        if(scoreCnt == 4) {
                            int score = Integer.parseInt(s);
                            String[] infos = in.split(" ");
                            int infoScore = Integer.parseInt(infos[4]);
                            
                            // 해당 점수보다 작을 경우
                            if(score > infoScore) {
                                check = false;
                                break;
                            }
                        }
                        // 그외 나머지 판별
                        else if(!in.contains(s)) {
                            check = false;
                            break;
                        }
                        
                        scoreCnt++;
                    }
                    
                    if(check) cnt++;
                    else check = true;
                }
                
                answer[i] = cnt;
            }
            
            return answer;
        }
    }

    // hash map 사용
    class Solution2 {
        public int[] solution(String[] info, String[] query) {
            int[] answer = new int[query.length];
            
            // 1. info를 기반으로 hashMap 만들기
            HashMap<String, ArrayList<Integer>> map = new HashMap<>();
            
            for(String i : info) {
                String[] data = i.split(" ");
                
                String[] languages = { data[0], "-" };
                String[] jobs = { data[1], "-" };
                String[] exps = { data[2], "-" };
                String[] foods = { data[3], "-" };
                Integer score = Integer.parseInt(data[4]);
                
                for(String lang : languages)
                    for(String job : jobs)
                        for(String exp : exps)
                            for(String food : foods) {
                                String[] keyData = { lang, job, exp, food };
                                String key = String.join(" ", keyData);
                                ArrayList<Integer> list = map.getOrDefault(key, new ArrayList<Integer>());

                                list.add(score);
                                map.put(key, list);
                            }
            }
            
            // 2. 각 hash map의 value를 오름차순 정렬하기
            for(ArrayList<Integer> list : map.values())
                list.sort(null);
            
            // 3. query 조건에 맞는 지원자를 가져오기
            int idx = 0;
            
            for(String q : query) {
                String[] data = q.split(" and ");
                String[] sub = data[3].split(" ");
                int target = Integer.parseInt(sub[1]);
                
                data[3] = sub[0];
                String key = String.join(" ", data);

                if(map.containsKey(key)) {
                    ArrayList<Integer> list = map.get(key);
                    
                    // 4. lower-bound / 하한선 찾기
                    int left = 0;
                    int right = list.size();
                    while(left < right) {
                        int mid = (left + right) / 2;
                        
                        // list의 중간을 잘라서 target의 점수와 비교
                        if (list.get(mid) >= target)
                            right = mid;
                        else
                            left = mid + 1;
                    }

                    answer[idx] = list.size() - left;
                }
                
                idx++;
            }
            
            return answer;
        }
    }
}