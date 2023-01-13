// https://school.programmers.co.kr/learn/courses/30/lessons/81301
// title : 숫자 문자열과 영단어

public class 숫자문자열과영단어 {
    // 테스트 케이스 10개 기준 평균 속도 약 0.17ms
    class Solution1 {
        public int solution(String s) {
            StringBuilder answer_str = new StringBuilder();
            StringBuilder chars = new StringBuilder();
            
            // 0부터 9 까지의 수를 글자 수 제한을 하지 않고 검사하는 패턴
            if(s.matches("(^[0-9]*$)")) return Integer.parseInt(s);
            else {
                for(int i=0;i<s.length();i++) {
                    // chars StringBuilder가 문자로 변환했을 때, 일치하는 숫자가 있는지 확인
                    String str = stringToNumber(chars.toString());
                    if(!str.equals("")) {
                        answer_str.append(str);
                        chars.setLength(0);
                    }
                    
                    // 현재 문자가 숫자인지 확인
                    if(Character.isDigit(s.charAt(i))) answer_str.append(s.charAt(i));
                    else chars.append(s.charAt(i));
                }
                
                if(chars.length() != 0) 
                    answer_str.append(stringToNumber(chars.toString()));
                
                return Integer.parseInt(answer_str.toString());
            }
            
            // StringBuilder 초기화 방법
            // new StringBuilder()를 또 써서 초기화하는 방법 -> 객체를 또 생성하는 것이므로 그만큼 시간 소모
            // sb.delete() 메소드를 사용하는 방법 -> delete 작업을 시행해야 되기 때문에 시간 소모
            // sb.setLength(0); 길이를 0으로 설정하는 방법
        }
        
        String stringToNumber(String str) {
            switch (str) {
                case "zero": return "0";
                case "one": return "1";
                case "two": return "2";
                case "three": return "3";
                case "four": return "4";
                case "five": return "5";
                case "six": return "6";
                case "seven": return "7";
                case "eight": return "8";
                case "nine": return "9";
                default: return "";
            }
        }
    }

    // 테스트 케이스 10개 기준 평균 속도 약 0.42ms
    class Solution2 {
        public int solution(String s) {
            // String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
            String[] alphabets = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

            for(int i=0;i<alphabets.length;i++){
                // s = s.replaceAll(alphabets[i], digits[i]);
                s = s.replaceAll(alphabets[i], Integer.toString(i));
            }

            return Integer.parseInt(s);
        }
    }
}