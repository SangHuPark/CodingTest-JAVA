class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
//         int patIdx = pat.length();
        
//         for (int i = 0; i <= myString.length() - pat.length(); i++) {
//             if (myString.substring(i, patIdx).contains(pat))
//                 answer++;
//             patIdx++;
//         }
        
        for(int i = 0; i < myString.length(); i++) {
            if(myString.substring(i).startsWith(pat)){
                answer++;
            }
        }
        
        return answer;
    }
}