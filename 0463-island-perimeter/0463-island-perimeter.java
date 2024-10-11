class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols]; // 방문 여부를 저장하는 배열
        int perimeter = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    perimeter += dfs(grid, visited, i, j);
                }
            }
        }
        return perimeter;
    }

    private int dfs(int[][] grid, boolean[][] visited, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;

        visited[row][col] = true;

        int[] dy = {-1, 0, 1, 0}; // 상하좌우 이동을 위한 배열
        int[] dx = {0, -1, 0, 1};

        for (int i = 0; i < 4; i++) {
            int ny = row + dy[i];
            int nx = col + dx[i];

            if (ny >= 0 && ny < rows && nx >= 0 && nx < cols) {
                if (grid[ny][nx] == 1) {
                    if (!visited[ny][nx]) {
                        perimeter += dfs(grid, visited, ny, nx);
                    }
                } else { // 인접한 칸이 물일 경우
                    perimeter++;
                }
            } else { // 맵을 벗어난 경우
                perimeter++;
            }
        }
        return perimeter;
    }
}