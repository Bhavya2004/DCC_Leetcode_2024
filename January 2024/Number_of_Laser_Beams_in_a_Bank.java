
// class Solution {
//     public int numberOfBeams(String[] bank) {
//         int m = bank.length;
//         int n = bank[0].length();
//         int count = 0;
        
//         for (int j = 0; j < n; j++) {
//             boolean hasDevice = false;
//             for (int i = 0; i < m; i++) {
//                 if (bank[i].charAt(j) == '1') {
//                     if (hasDevice) {
//                         count++;
//                         break;
//                     }
//                     hasDevice = true;
//                 }
//             }
//         }
        
//         return count;
//     }
// }
class Solution {
    public int numberOfBeams(String[] bank) {
        int prevRowCount = 0;
        int total=0;

        for(String row : bank) {
            int curRowCount = calc(row);
            if(curRowCount==0) 
                continue;

            total += curRowCount * prevRowCount;
            prevRowCount = curRowCount;
        }
        return total;
    }

    private int calc(String s) {
        int count = 0;
        for(char c : s.toCharArray()) 
            count += c - '0';

        return count;
    }
}