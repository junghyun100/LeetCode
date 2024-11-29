class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int operations = 0;

        // 배열을 순회하면서 3개의 연속된 요소를 뒤집는 작업 수행
        for (int i = 0; i < n - 2; i++) {
            // 현재 요소가 0이면, 3개의 요소를 뒤집는다
            if (nums[i] == 0) {
                operations++;
                // 3개의 요소를 뒤집기
                nums[i] ^= 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
            }
        }
        // 모든 요소가 1인지 확인
        for (int num : nums) {
            if (num == 0) {
                return -1; // 1로 만들 수 없는 경우
            }
        }
        return operations; // 최소 작업 수 반환
    }
}