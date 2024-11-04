class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        // 조합을 초기화합니다.
        int[] comb = new int[k];
        for (int i = 0; i < k; i++) {
            comb[i] = i + 1;
        }
        
        while (comb[0] <= n - k + 1) {
            // 현재 조합을 결과 리스트에 추가
            List<Integer> combination = new ArrayList<>();
            for (int x : comb) {
                combination.add(x);
            }
            result.add(combination);

            // 다음 조합을 생성
            int i = k - 1;
            while (i >= 0 && comb[i] == n - k + i + 1) { // 하나씩 줄여나가는 방식은 어떤가?
                i--;
            }
            if (i >= 0) {
                comb[i]++;
                for (int j = i + 1; j < k; j++) {
                    comb[j] = comb[j - 1] + 1;
                }
            } else {
                break;
            }
        }
        
        return result;
    }
}