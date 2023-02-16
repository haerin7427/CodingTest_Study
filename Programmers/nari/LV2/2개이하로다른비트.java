// https://school.programmers.co.kr/learn/courses/30/lessons/77885
// title : 2개 이하로 다른 비트

public class 2개이하로다른비트 {
    // 테스트 케이스 10, 11 시간 초과
    class Solution1 {
        public long[] solution(long[] numbers) {
            long[] answer = new long[numbers.length];
            
            for(int i=0;i<numbers.length;i++) {
                String binary = Long.toBinaryString(numbers[i]);
                long next = numbers[i] + 1;
                
                while(true) {
                    String nextBinary = Long.toBinaryString(next);
                    int diffCnt = 0;
                    
                    if(binary.length() != nextBinary.length()) {
                        binary = String.format("%1$" + nextBinary.length() + "s", binary).replace(' ', '0');
                    }
                    
                    for(int j=0;j<binary.length();j++) {
                        char ch1 = binary.charAt(j);
                        char ch2 = nextBinary.charAt(j);
                        
                        if(ch1 != ch2) {
                            diffCnt++;
                            
                            if(diffCnt > 3) break;
                        }
                    }
                    
                    if(diffCnt < 3) {
                        answer[i] = next;
                        break;
                    }
                    
                    next++;
                }
            }
            
            return answer;
        }
    }

    class Solution2 {
        public long[] solution(long[] numbers) {
            long[] answer = new long[numbers.length];
            
            for(int i=0;i<numbers.length;i++) {
                // 짝수인 경우 +1만 해주면 된다.
                if(numbers[i] % 2 == 0) answer[i] = numbers[i] + 1;
                else {
                    StringBuilder sb = new StringBuilder();
                    String binary = Long.toBinaryString(numbers[i]);
                    
                    // 0이 포함되지 않았을 때, 두번째 자리에 0을 추가
                    if(!binary.contains("0")) {
                        sb.append("10");
                        sb.append(binary.substring(1).replace("0", "1"));
                    }
                    // 0이 포함됐을 때, 마지막 0을 1로 바꿔주고 그 다음 1을 0으로 바꾸기
                    else {
                        int lastZeroIdx = binary.lastIndexOf("0");
                        int firstOneIdx = binary.indexOf("1", lastZeroIdx);

                        // 마지막 0 앞까지 자른 다음에 그 뒤에 1을 붙이기
                        sb.append(binary.substring(0, lastZeroIdx)).append("1");

                        // 1 뒤에 0을 붙이기 -> 마지막 0은 1이, 1은 0이 된다.
                        sb.append("0");

                        // 마지막 1의 자리 이후 값들 붙이기
                        sb.append(binary.substring(firstOneIdx+1));
                    }
                    
                    answer[i] = Long.parseLong(sb.toString(), 2);
                }
            }
            
            return answer;
        }
    }

    class Solution3 {
        public long[] solution(long[] numbers) {
            long[] answer = numbers.clone();
            
            for(int i=0;i<answer.length;i++) {
                answer[i]++;
                answer[i] += (answer[i]^numbers[i]) >>> 2;
            }
            
            return answer;
        }
    }
}