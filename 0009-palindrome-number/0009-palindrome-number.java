class Solution {
    public boolean isPalindrome(int x) {
        String intToString = String.valueOf(x);
        for (int i = 0; i < intToString.length()/2; i++) {
            if(intToString.charAt(i) != intToString.charAt(intToString.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}