public class max_island {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int[][] checked = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                maxArea = Math.max(findMax(i,j,checked,grid),maxArea);
            }
        }
        return maxArea;
    }
    private int findMax(int i, int j, int[][] checked, int[][] grid){
        int max = 0;
        while(checked[i][j] == 0 && grid[i][j] == 1){
            max+=1;
            checked[i][j] = 1;

            if(i+1 < grid.length)
                max += findMax(i+1,j,checked,grid);

            if(j+1 < grid[0].length)
                max += findMax(i,j+1,checked,grid);

            if(i-1>=0)
                max += findMax(i-1,j,checked,grid);

            if(j-1>=0)
                max +=findMax(i,j-1,checked,grid);

        }
        return max;
    }

    public static void main(String[] args) {
        max_island maxIsland = new max_island();
    }
}
