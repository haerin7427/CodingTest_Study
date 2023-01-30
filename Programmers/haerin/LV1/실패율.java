// https://school.programmers.co.kr/learn/courses/30/lessons/42889
// title : 실패율
// time : 22m
// type : 정렬
// Created by haerin on 2023-01-30
import java.util.*;
public class 실패율 {
    class Solution {
        class STAGE {
            int stage_num;
            int total_cnt=0;
            int fail_cnt=0;
            float fail_rate;
        }
        public int[] solution(int N, int[] stages) {
            STAGE[] info = new STAGE[N];
            for(int i=0; i<info.length; i++){
                info[i] = new STAGE();
                info[i].stage_num = i+1;
            }
            for(int now : stages) {
                int limit = now < N ? now : N;
                for(int i=0; i<limit; i++) {
                    info[i].total_cnt += 1;
                }
                if(now <= N) {
                    info[now-1].fail_cnt += 1;
                }
            }
            for(int i=0; i<info.length; i++){
                info[i].fail_rate = (float) info[i].fail_cnt / info[i].total_cnt;
            }
            Arrays.sort(info, new Comparator<STAGE>(){
                @Override
                public int compare(STAGE s1, STAGE s2){
                    if(s1.fail_rate < s2.fail_rate) {
                        return 1;
                    } else if (s1.fail_rate > s2.fail_rate) {
                        return -1;
                    } else {
                        return Integer.compare(s1.stage_num, s2.stage_num);
                    }
                }
            });
            int idx=0;
            int[] answer = new int[N];
            for(STAGE s : info) {
                answer[idx++] = s.stage_num;
            }
            return answer;
        }
    }
}
