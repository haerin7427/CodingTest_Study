// https://school.programmers.co.kr/learn/courses/30/lessons/12980
// title : 점프와 순간 이동

public class 점프와순간이동 {
    public class Solution {
        public int solution(int n) {
            int ans = 0;
            
            // K 칸을 앞으로 점프
            // (현재까지 온 거리) x 2 에 해당하는 위치로 순간이동
            
            // 순간이동을 하면 건전지 사용량이 줄지 않지만, 
            // 앞으로 K 칸을 점프하면 K 만큼의 건전지 사용
            
            // 건전지 사용량을 줄이기 위해 점프로 이동하는 것은 최소로
            
            while(n != 0) {
                // 2로 나눠지면 순간이동 가능
                if(n%2 == 0) n /= 2;
                else {
                    n--;
                    ans++;
                    // 1칸 전진해서 그 다음에 순간이동 할 수 있도록
                    // 1칸 전진이지만, n에서 시작했기 때문에 n--
                }
            }

            return ans;
        }
    }
}