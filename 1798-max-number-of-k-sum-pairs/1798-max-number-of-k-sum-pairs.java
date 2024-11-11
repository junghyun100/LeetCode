class Solution {
    public int maxOperations(int[] nums, int k) {
        // 이 문제는 두 수의 합이 k가 되도록 하는 쌍의 개수를 최대한 많이 찾는 것이 포인트
        // 각 숫자의 빈도수를 해시맵에 기록합니다.
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            int complement = k - num;
            if (map.getOrDefault(complement, 0) > 0) {
                count++;
                map.put(complement, map.get(complement) - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return count;
    }
}