class Solution {
    public String intToRoman(int num) {
        int [] integer = {1000,900,500,400,100,90,50,40,10,9,5,4,1}; // descending order because first to check for highest possible number in num
        String [] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        StringBuilder sb = new StringBuilder(); // to update string
        
        for (int i = 0; i<integer.length; i++) {
            while (num >= integer[i]) {
                sb.append(roman[i]);
                num = num - integer[i];
            }
        }
        return sb.toString(); // get output in string format
    }
}