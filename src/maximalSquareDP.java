public class maximalSquareDP {

    public int maximalSquare(char[][] matrix)
    {
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int max_side = 0;
        for(int i = 1 ; i < dp.length ; i++)
        {
            for(int j = 1 ; j < dp[0].length ; j++)
            {
                if(matrix[i - 1][j - 1] == '0')
                    dp[i][j] = 0;
                else
                {
                    int min = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    dp[i][j] = min + 1;
                }
                max_side = Math.max(max_side, dp[i][j]);
            }
        }
        return max_side * max_side;
    }

    public static void main(String[] args) {
        maximalSquareDP maximalSquare = new maximalSquareDP();
    }
}
