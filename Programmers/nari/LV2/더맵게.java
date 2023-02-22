// https://school.programmers.co.kr/learn/courses/30/lessons/42626
// title : 더 맵게

import java.util.*;
import java.util.stream.Collectors;

public class 더맵게 {
    // ArrayList 사용 - 효율성 테스트 시간 초과
    class Solution1 {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            int newScoville = 0;
            ArrayList<Integer> list = new ArrayList<>();

            // scoville int 배열을 array list로 변환 
            for(int i : scoville) {
                list.add(i);
            }
            
            // 오름차순 정렬
            Collections.sort(list);
            
            // list의 최솟값이 원하는 스코빌 지수 K보다 작을 경우
            while(list.get(0) < K) {
                // scoville 길이보다 많이 반복했을 경우, 스코빌 지수를 K 이상으로 만들 수 없다고 판단
                // list의 size가 2보다 작으면 비교할 수 없다.
                if(answer > scoville.length || list.size() < 2) {
                    answer = -1;
                    break;
                }
                
                newScoville = list.get(0) + (list.get(1) * 2);
                
                list.remove(0);
                // 가장 작은 수가 remove되면서 2번쨰 작은 수가 index 0번째가 됨
                list.remove(0);
                list.add(newScoville);
                Collections.sort(list);
                answer++;
            }
            
            return answer;
        }
    }

    // PriorityQueue 사용
    // 효율성 테스트에서 stream이 더 빠르다.
    // 기존 테스트 케이스에서는 for문으로 넣어주는게 더 빠르다
    class Solution2 {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            int newScoville = 0;
            PriorityQueue<Integer> queue = Arrays.stream(scoville)
                .boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));
            // PriorityQueue<Integer> queue = new PriorityQueue<>();

            // scoville int 배열을 queue로 변환 
            // for(int i : scoville) {
            //     queue.add(i);
            // }
            
            // queue 첫번째 원소가 원하는 스코빌 지수 K보다 작을 경우
            while(queue.peek() < K) {
                // scoville 길이보다 많이 반복했을 경우, 스코빌 지수를 K 이상으로 만들 수 없다고 판단
                // queue의 size가 2보다 작으면 비교할 수 없다.
                if(answer > scoville.length || queue.size() < 2) {
                    answer = -1;
                    break;
                }
                
                int first = queue.poll(), second = queue.poll();
                
                newScoville = first + (second * 2);

                queue.add(newScoville);
                answer++;
            }
            
            return answer;
        }
    }
}