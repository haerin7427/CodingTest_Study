// https://school.programmers.co.kr/learn/courses/30/lessons/87377
// title : 교점에 별 만들기

import java.util.*;

public class 교점에별만들기 {
    class Solution {
        public String[] solution(int[][] line) {
            // 두 직선의 교점을 구하는 식
            // 1. Ax+By+E=0 -> x= -(By+E)/A
            // 2. Cx+Dy+F=0 -> x= -(Dy+F)/C
            //   ==> 1, 2번 식을 통해 (By+E)*C = (Dy+F)*A
            //                    (BC-AD)*y = (AF-CE)
            //                            y = (AF-CE)/(BC-AD)
            // 같은 방법으로 x도 구하기 가능
            
            // x = (BF-ED)/(AD-BC)
            // y = (EC-AF)/(AD-BC)
            
            // [0] = x, [1] = y
            HashSet<long[]> set= new HashSet<>();
            long x = 0, y = 0;
            long minx= Long.MAX_VALUE, miny= Long.MAX_VALUE;
            long maxx= Long.MIN_VALUE, maxy= Long.MIN_VALUE;
            
            // 두 개의 직선에서 교점 구하기
            for(int i=0;i<line.length-1;i++) {
                long a = line[i][0];
                long b = line[i][1];
                long e = line[i][2];
                
                for(int j=i+1;j<line.length;j++) {
                    long c = line[j][0];
                    long d = line[j][1];
                    long f = line[j][2];
                    
                    long adbc = a*d - b*c;
                    // 비교대상 직선과 평행할 경우
                    if(adbc == 0) continue; 
                    
                    long bfed = b*f - e*d;
                    // x가 정수가 아닐 경우
                    if(bfed % adbc != 0) continue; 
                    
                    long ecaf = e*c - a*f;
                    // y가 정수가 아닐 경우
                    if(ecaf % adbc != 0) continue; 
                    
                    // 두 직선들의 교점
                    x = bfed / adbc;
                    y = ecaf / adbc;
                    set.add(new long[]{x, y});
                    
                    // 구한 교점으로 x의 최댓값과 최솟값, y의 최댓값과 최솟값 갱신
                    minx = Math.min(minx, x);
                    miny = Math.min(miny, y);
                    maxx = Math.max(maxx, x);
                    maxy = Math.max(maxy, y);
                }
            }
            
            // 구한 교점들을 넣을 판의 height, width
            long height = maxy - miny + 1;
            long width = maxx - minx + 1;
            String[] answer = answer= new String[(int)height];
            
            StringBuilder sb= new StringBuilder();
            for(int i=0;i<width;i++) {
                sb.append(".");
            }
            
            // answer는 ...으로 초기화
            Arrays.fill(answer, sb.toString());
            
            long nx = 0, ny = 0;
            
            // set에 넣어뒀던 교점들을 반복하면서 answer에 "*" 별 넣기
            for(long[] p : set) {
                ny = maxy - p[1];
                nx = p[0] - minx;
                
                answer[(int)ny] = answer[(int)ny].substring(0, (int)nx) + "*" + answer[(int)ny].substring((int)nx+1);
            }
            
            return answer;
        }
    }
}