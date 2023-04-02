// https://school.programmers.co.kr/learn/courses/30/lessons/176963
// title : 추억 점수

public class 추억점수 {
    class Solution {
        public int[] solution(String[] name, int[] yearning, String[][] photo) {
            int[] answer = new int[photo.length];
            
            for(int i=0;i<photo.length;i++) {
                for(String nameInPhoto : photo[i]) {
                    for(int j=0;j<name.length;j++) {
                        if(nameInPhoto.equals(name[j])) {
                            answer[i] += yearning[j];
                            break;
                        }
                    }
                }
            }
            
            return answer;
        }
    }
}