class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int index = 0; index < nums.length; index++) {
            map.put(nums[index], index);
        }
        for (int index = 0; index < nums.length; index++) {
            Integer secondIndex = map.get(target - nums[index]);
            if (secondIndex != null && secondIndex != index)
                return new int[] {index, secondIndex};
        }
        return null;
    }
}