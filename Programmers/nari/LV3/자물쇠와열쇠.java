// https://school.programmers.co.kr/learn/courses/30/lessons/60059
// title : 자물쇠와 열쇠

public class 자물쇠와열쇠 {
    // 회전할 때마다 새로운 배열 만들어서 계산
    class Solution1 {
        public boolean solution(int[][] key, int[][] lock) {
            int m = key.length, n = lock.length;
            // key와 lock이 처음으로 겹치는 부분
            int point = key.length - 1;
            
            // (key와 lock이 처음으로 겹치는 부분 + lock의 길이)까지
            for(int x=0;x<point+n;x++) {
                for(int y=0;y<point+n;y++) {
                    
                    // key를 시계방향으로 90도 회전 -> 90도로 4번 회전 가능
                    for(int r=0;r<4;r++) {
                        // 확장 배열
                        int[][] newLock = new int[n + m * 2][n + m * 2];
                        
                        // 확장시킨 배열(newLock)에 lock 표시
                        for(int i=0;i<n;i++) {
                            for(int j=0;j<n;j++) {
                                newLock[i + point][j + point] = lock[i][j];
                            }
                        }
                        
                        // newLock에 key 더하기
                        match(newLock, key, r, x, y);
                        
                        // key로 lock을 열 수 있는지 판단
                        if(check(newLock, point, n)) return true;
                    }
                }
            }
            
            return false;
        }
        
        void match(int[][] newLock, int[][] key, int rot, int x, int y) {
            int len = key.length;
            
            for(int i=0;i<len;i++) {
                for(int j=0;j<len;j++) {
                    // 한 번도 회전하지 않은 경우
                    if(rot == 0) newLock[x + i][y + j] += key[i][j];
                    // 시계방향으로 90도 회전한 경우
                    else if(rot == 1) newLock[x + i][y + j] += key[j][len - i - 1];
                    // 시계방향으로 180도 회전한 경우
                    else if(rot == 2) 
                        newLock[x + i][y + j] += key[len - i - 1][len- j - 1];
                    // 시계방향으로 270도 회전한 경우
                    else newLock[x + i][y + j] += key[len - j - 1][i];
                }
            }
        }
        
        boolean check(int[][] newLock, int point, int len) {
            for(int i=0;i<len;i++) {
                for(int j=0;j<len;j++) {
                    // 1이 아닌 경우 = 열쇠의 돌기 부분과 자물쇠의 홈 부분이 정확히 일치하지 않음
                    if(newLock[point + i][point + j] != 1) return false;
                }
            }
            
            return true;
        }
    }

    // 회전할 때 마다 덧셈뺄셈, key 배열 직접 회전 -> 값 수정
    class Solution2 {
        public boolean solution(int[][] key, int[][] lock) {
            int m = key.length, n = lock.length;

            // 확장시킬 배열 길이 = lock의 길이 + (key의 길이*2) - 2
            // lock과 key가 2칸 겹치므로 -2
            int len = n + (m * 2) - 2;
            int[][] map = new int[len][len];
            
            // 확장시킨 배열에 lock 표시
            // key의 길이-1 -> 1칸 겹치니까
            for(int i=m-1;i<m+n-1;i++) {
                for(int j=m-1;j<m+n-1;j++) {
                    // m-1부터 시작했기 때문에 index 구하기 위해선 빼기
                    map[i][j] = lock[i-(m-1)][j-(m-1)];
                }
            }
            
            // 90도로 4번 회전 가능
            for(int i=0;i<4;i++) {
                // key로 lock을 열 수 있는 경우
                if(check(map, key, n)) return true;

                // 시계방향 90도 회전
                rotate(key); 
            }
            
            return false;
        }
        
        boolean check(int[][] map, int[][] key, int lockLen) {
            int keyLen = key.length;
            int mapLen = map.length;
            
            for(int i=0;i<mapLen-keyLen+1;i++) {
                for(int j=0;j<mapLen-keyLen+1;j++) {
                    
                    // map에 key 더하기
                    for(int a=0;a<keyLen;a++) {
                        for(int b=0;b<keyLen;b++) {
                            map[i+a][j+b] += key[a][b];
                        }
                    }
                    
                    // lock 부분이 전부 1이 됐는지 확인
                    boolean flag = true;
                    
                    for(int a=keyLen-1;a<keyLen+lockLen-1;a++) {
                        for(int b=keyLen-1;b<keyLen+lockLen-1;b++){
                            // 1이 아닌 경우, 홈 부분이 정확히 일치하지 않음
                            if(map[a][b] != 1) { 
                                flag = false;
                                break;
                            }
                        }
                        
                        if(!flag) break;
                    }
                    
                    // 전부 1인 경우, 홈 부분이 정확히 일치
                    if(flag) return true;
                    
                    // map에서 key 빼기 -> map 원상 복귀
                    for(int a=0;a<keyLen;a++) {
                        for(int b=0;b<keyLen;b++) {
                            map[i+a][j+b] -= key[a][b];
                        }
                    }
                }
            }
            
            return false;
        }
        
        // 시계 방향 90도 회전
        void rotate(int[][] key) {
            int len = key.length;
            int[][] temp = new int[len][len];
            
            for(int i=0;i<len;i++) {
                for(int j=0;j<len;j++) {
                    temp[i][j] = key[len-j-1][i];
                }
            }
            
            for(int i=0;i<len;i++) {
                for(int j=0;j<len;j++) {
                    key[i][j] = temp[i][j];
                }
            }
            
        }
    }
}