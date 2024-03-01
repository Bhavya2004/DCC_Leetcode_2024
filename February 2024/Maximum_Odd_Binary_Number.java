class Solution {
    public String maximumOddBinaryNumber(String s) {
        int len = s.length();
        int count = 0;

        for(char c : s.toCharArray()) {
            if(c == '1'){
                count++;
            }
        }

        StringBuilder res = new StringBuilder();

        if(count >= 1){
            count--;
            for(int i = 0; i < len - 1; i++) {
                if(i < count){
                    res.append('1');
                }
                else{
                    res.append('0');
                }
            }
            res.append('1');
        }

        return res.toString();
    }
}