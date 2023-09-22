import java.util.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        Boolean bool = direction.equals("right") ? true : false;
        int length = numbers.length - 1;
        
        if (bool) {
            answer[0] = numbers[length];
            for (int i = 0; i < length; i++) {
                answer[i+1] = numbers[i];
            }
        } else {
            answer[length] = numbers[0];
            for (int i = 0; i < length; i++) {
                answer[i] = numbers[i+1];
            }
        }
        
        return answer;
    }
}