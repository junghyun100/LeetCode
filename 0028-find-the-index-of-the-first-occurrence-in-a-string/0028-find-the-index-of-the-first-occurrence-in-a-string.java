class Solution {
    public int strStr(String haystack, String needle) {
        // 엣지 케이스
        if (needle.isEmpty()) return 0;
        if (haystack.length() < needle.length()) return -1;
        
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        
        // haystack의 각 위치에서 needle과 매칭 시도
        for (int i = 0; i <= haystackLen - needleLen; i++) {
            int j = 0;
            // needle의 각 문자와 비교
            while (j < needleLen && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            // 모든 문자가 일치하면 시작 인덱스 반환
            if (j == needleLen) {
                return i;
            }
        }
        return -1;
    }
}