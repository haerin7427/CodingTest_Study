// https://school.programmers.co.kr/learn/courses/30/lessons/42890
// title : 후보키

public class 후보키 {
    class Solution {
        HashSet<String> set = new HashSet<>();
        
        public int solution(String[][] relation) {
            // 후보키로 묶을 수 있는 튜플 갯수
            for(int i=1;i<=relation[0].length;i++) {
                boolean[] selected = new boolean[relation[0].length];
                
                dfs(relation, 0, 0, i, selected);
            }
            
            // 후보키의 개수 리턴
            return set.size();
        }
        
        void dfs(String[][] relation, int idx, int cnt, int max, boolean[] selected) {
            // 후보키를 최대로 묶은 경우
            if(cnt == max) {
                // 선택된 튜플들의 index를 string으로 -> 최대 길이 8이기 때문에 두자릿수 없어 가능
                StringBuilder sb = new StringBuilder();
                
                for (int i=0;i<selected.length;i++) {
                    if(selected[i]) sb.append(i);
                }
                
                // 선택된 튜플들의 집합이 후보키로 사용 가능한 경우
                if(isPossible(relation, sb.toString(), selected))
                    set.add(sb.toString());
                
                return;
            }

            // 현재 index가 총 튜플 갯수를 넘어간 경우
            if(idx >= selected.length) return;

            selected[idx] = true;
            dfs(relation, idx+1, cnt+1, max, selected);

            selected[idx] = false;
            dfs(relation, idx+1, cnt, max, selected);
        }
        
        boolean isPossible(String[][] relation, String cols, boolean[] selected) {
            // 최소성
            for(String s : set) {
                boolean flag = true; 
                
                for(int i=0;i<s.length();i++) {
                    String str = Character.toString(s.charAt(i));
                    
                    // 하나라도 포함되어 있지 않은 경우
                    if(!cols.contains(str)) {
                        flag = false;
                        break;
                    }
                }

                // 최소성을 만족하지 못하는 경우
                if(flag) return false;
            }

            HashSet<String> keys = new HashSet<>();
            int[] name = new int[cols.length()];
            int idx = 0;
            
            // 선택된 튜플 배열에 저장
            for(int i=0;i<selected.length;i++) {
                if(selected[i]) name[idx++] = i;
            }

            // 값의 중복이 있는지 확인. 중복된 값이 있다면 후보키로 사용될 수 없음
            for(int i=0;i<relation.length;i++) {
                StringBuilder key = new StringBuilder();
                
                for (int j=0;j<name.length;j++) {
                    key.append(relation[i][name[j]]);
                }
                
                // 중복인 경우
                if(!keys.add(key.toString())) return false; 
            }

            return true;
        }
    }
}