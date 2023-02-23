// https://school.programmers.co.kr/learn/courses/30/lessons/49993
// title : 스킬트리

public class 스킬트리 {
    class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            
            for(String skill_tree : skill_trees) {
                String[] tree = skill_tree.split("");
                // 0번째 skill부터 count
                int step = 0;
                // skill 순서대로 check 되었는지
                boolean check = true;
                
                for(String t : tree) {
                    // 순서에 없는 다른 skill일 경우
                    if(skill.indexOf(t) == -1) continue;
                    // step번째에 맞는 skill을 배웠는지 확인
                    else if(skill.indexOf(t) == step) step++;
                    // step번째에 맞지 않은 skill을 배운 경우
                    else {
                        check = false;
                        break;
                    }
                }

                if(check) answer++;
                else check = true;
            }
            
            return answer;
        }
    }
}