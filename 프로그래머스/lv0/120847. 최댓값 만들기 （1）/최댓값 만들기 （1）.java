import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        // Integer[] answer = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        // Arrays.sort(answer, Collections.reverseOrder());
        // return answer[0] * answer[1];
        
        int leng = numbers.length - 1;
        Arrays.sort(numbers);
        return numbers[leng] * numbers[leng - 1];
    }
}