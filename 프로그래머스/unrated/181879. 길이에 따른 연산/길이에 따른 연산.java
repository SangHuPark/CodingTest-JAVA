class Solution {
    public int solution(int[] num_list) {
//         int temp = num_list[0];
        
//         if (num_list.length > 10) {
//             for (int i = 1; i < num_list.length; i++)
//                 temp += num_list[i];
//         } else {
//             for (int i = 1; i < num_list.length; i++)
//                 temp *= num_list[i];
//         }
        
//         return temp;
        
        int temp = num_list.length > 10 ? 0 : 1;
        
        for (int i = 0; i < num_list.length; i++) {
            if (num_list.length > 10)
                temp += num_list[i];
            else
                temp *= num_list[i];
        }
        
        return temp;
    }
}