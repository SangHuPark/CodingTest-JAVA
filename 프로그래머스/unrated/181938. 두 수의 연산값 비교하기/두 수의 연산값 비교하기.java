class Solution {
    public int solution(int a, int b) {
        /* int sum = Integer.parseInt(new StringBuilder()
                                    .append(a).append(b).toString());
        
        return Math.max(sum, 2 * a * b); */
        
        return Math.max(Integer.parseInt(String.valueOf(a)+String.valueOf(b))
                        , 2 * a * b);
    }
}