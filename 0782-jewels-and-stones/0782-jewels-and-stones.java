class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        // 보석은 유니크
        Set<Character> Set = new HashSet<>();
        for (char jewel : jewels.toCharArray()) {
            Set.add(jewel);
        }
        // 보석은 셋트가 아니었음.. 
        int count = 0;
        for (char stone : stones.toCharArray()) {
            if (Set.contains(stone)) {
                count++;
            }
        }
        return count; 
    }
}