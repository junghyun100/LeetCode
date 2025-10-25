class Solution {
public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // 백트래킹
        // 문자열을 하나씩 만들어가면서, 유효하지 않은 경우 미리 제거
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, String current, int open, int close, int n) {
        // 문자열 길이가 2n이 되면 완성
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }
        
        // 여는 괄호를 추가할 수 있는 경우
        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }
        
        // 닫는 괄호를 추가할 수 있는 경우
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }
}