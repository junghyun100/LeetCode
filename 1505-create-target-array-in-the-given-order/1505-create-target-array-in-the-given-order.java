class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> target = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            target.add(index[i], nums[i]);
        }
        int[] intArray = new int[target.size()];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = target.get(i);
        }
        return intArray;
    }
}