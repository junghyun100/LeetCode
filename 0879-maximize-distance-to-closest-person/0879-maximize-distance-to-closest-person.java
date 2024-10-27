class Solution {
    public int maxDistToClosest(int[] seats) {
        int maxDistance = 0;
        int prev = -1;  // 처음 앉은 사람이 없는 상태는 -1로 초기화
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (prev == -1) {
                    // 첫 번째 사람 전까지의 빈 좌석
                    maxDistance = i;
                } else {
                    // 두 사람 사이의 좌석들(최대거리)
                    maxDistance = Math.max(maxDistance, (i - prev) / 2);
                }
                prev = i;
            }
        }
        // 마지막 사람이 앉은 자리 뒤의 빈 좌석 처리
        maxDistance = Math.max(maxDistance, seats.length - 1 - prev);       
        return maxDistance;
    }
}