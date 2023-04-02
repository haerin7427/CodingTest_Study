package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/60061
// title : 기둥과 보 설치
// type : 구현
// time : 1h + ...
// Created by haerin on 2023-04-02
import java.util.*;
public class 기둥과보설치 {
    // 1차 시도 실패 : 14.4점
    class Solution {
        class Structure {
            int y;
            int x;
            int type;
            
            Structure(int y, int x, int type){
                this.y = y;
                this.x = x;
                this.type = type;
            }
            
            Structure(int y, int x){
                this.y = y;
                this.x = x;
            }
            
            boolean isSameStructure(int y, int x, int type){
                return (this.y == y && this.x == x && this.type == type);
            }
            
            boolean isSamePoint(int y, int x){
                return (this.y == y && this.x == x);
            }
        }
        public int[][] solution(int n, int[][] build_frame) {
            List<Structure> structureList = new ArrayList<>();
            List<Structure> pointList = new ArrayList<>();
            
            for(int[] b : build_frame){
                int y = b[1];
                int x = b[0];
                int type = b[2];
                int isBuild = b[3];
                
                if(isBuild == 0){
                    for(Structure s : structureList){
                        if(s.isSameStructure(y, x, type)){
                            structureList.remove(s);
                            boolean flag = true;
                            if(type == 0 && !isRemove1(structureList, y, x)){
                                structureList.add(new Structure(y,x,type));
                            }else if(type == 1 && !isRemove2(structureList, y, x)){
                                structureList.add(new Structure(y,x,type));
                            }
                            break;
                        }
                    }
                    continue;
                }
                
                if(type == 0 && isPossible1(structureList, y, x)){
                    structureList.add(new Structure(y,x,type));
                }else if(type == 1 && isPossible2(structureList, y, x)){
                    structureList.add(new Structure(y,x,type));
                }
            }
            
            Collections.sort(structureList, new Comparator<Structure>(){
                @Override
                public int compare(Structure o1, Structure o2){
                    if(o1.x != o2.x){
                        return o1.x - o2.x;
                    }else
                        return o1.y - o2.y;
                }
            });
            
            int[][] answer = new int[structureList.size()][3];
            for(int i=0; i<answer.length; i++){
                answer[i][0] = structureList.get(i).x;
                answer[i][1] = structureList.get(i).y;
                answer[i][2] = structureList.get(i).type;
            }
            return answer;
        }
        
        // 기둥을 설치할 수 있는 지 확인
        public boolean isPossible1(List<Structure> structureList, int y, int x){
            // 바닥 위에 있는 경우
            if(y == 0) return true;
            
            for(Structure s : structureList){
                // 다른 기둥 위에 있는 경우
                if(s.type == 0 && s.y+1 == y && s.x == x){
                    return true;
                }
                // 보의 한쪽 끝 부분 위에 있는 경우
                if(s.type == 1 && s.y == y && (s.x == x || s.x+1 == x)){
                    return true;
                }
            }
            return false;
        }
        
        // 보를 설치할 수 있는 지 확인
        public boolean isPossible2(List<Structure> structureList, int y, int x){
            // 바닥에 설치 불가
            if(y == 0) return false;
            
            boolean[] flag = new boolean[2];
            for(Structure s : structureList){
                // 한 쪽 끝 부분이 기둥 위에 있는 경우
                if(s.type == 0 && s.y+1 == y && (s.x == x || s.x == x+1)){
                    return true;
                }
                // 보의 앞 끝이 다른 보와 연결되어 있는 경우 
                if(s.type == 1 && s.y == y && s.x+1 == x){
                    flag[0] = true;
                }
                // 보의 뒤 끝이 다른 보와 연결되어 있는 경우 
                if(s.type == 1 && s.y == y && s.x == x+1){
                    flag[1] = true;
                }
                if(flag[0] && flag[1])
                    return true;
            }
            return false;
        }
        
        // 기둥을 지울 수 있는 지 확인
        public boolean isRemove1(List<Structure> structureList, int y, int x){
            for(Structure s : structureList){
                if(s.type == 0 && s.y == y+1 && s.x == x){
                    return false;
                }else{
                    if(s.y == y && (s.x == x || s.x == x-1)){
                        if(!isPossible1(structureList, s.y, s.x)){
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        
         // 보를 지울 수 있는 지 확인
        public boolean isRemove2(List<Structure> structureList, int y, int x){
            for(Structure s : structureList){
                if(s.type == 1){
                    if(s.y == y && (s.x == x+1 || s.x == x-1)){
                        if(!isPossible2(structureList, s.y, s.x))
                            return false;
                    }
                }else{
                    if(s.y == y && (s.x == x || s.x == x+1)){
                        if(!isPossible1(structureList, s.y, s.x))
                            return false;
                    }
                }
            }
            return true;
        }
    }
}
