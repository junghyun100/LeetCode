class Solution {
    public String decodeAtIndex(String s, int k) {
        long length = 0; // 디코딩된 문자열의 전체 길이
        
        // 디코딩된 문자열의 전체 길이 계산
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                length *= (c - '0'); // 숫자인 경우, 현재 길이에 곱하기
            } else {
                length++; // 문자면 길이 1 증가
            }
        }

        // 역방향 탐색을 통해 k번째 문자 찾기
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            k %= length; // k를 현재 길이 안으로 조정

            // k가 0이고 현재 문자가 알파벳이면 해당 문자가 답
            if (k == 0 && Character.isLetter(c)) {
                return String.valueOf(c);
            }
            if (Character.isDigit(c)) {
                length /= (c - '0');
            } else {
                length--;
            }
        }

        return ""; // 유효하지 않은 경우 (도달하지 않음)
    }
}
