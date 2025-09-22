class Solution {
    public String convert(String s, int numRows) {
                // 특수 케이스: numRows가 1이거나 문자열이 numRows보다 짧은 경우
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        
        // 각 행을 위한 StringBuilder 배열 생성
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        
        int currentRow = 0;
        boolean goingDown = false;
        
        // 각 문자를 적절한 행에 배치
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            
            // 첫 번째 행이나 마지막 행에 도달하면 방향 전환
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            
            // 다음 행으로 이동
            currentRow += goingDown ? 1 : -1;
        }
        
        // 모든 행을 연결하여 결과 생성
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        
        return result.toString();
    }
}