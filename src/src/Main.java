

public class Main {

    public static int goldMine(int[][] gold) {

        	        if (gold == null || gold.length == 0) {
            	            return 0;
            	        }
        	        int n = gold.length;
        	        int m = gold[0].length;
        
        	        int[][] collectedGold = new int[n][m];
        	        for (int i = 0; i < n; i++) {
            	            for (int j = 0; j < m; j++) {
                	                collectedGold[i][j] = 0;
                	            }
            	        }
        	        int right, rightUp, rightDown;
        	        for (int column = m - 1; column >= 0; column--) {
            	            for (int row = 0; row < n; row++) {
									if (column == m - 1)
                	                	right = 0;
									else
										right = collectedGold[row][column + 1];

                	                if(row == 0 || column == m - 1)
										rightUp = 0;
                	                else
										rightUp = collectedGold[row - 1][column + 1];
									if(row == n - 1 || column == m - 1)
                	                	rightDown = 0;
									else
										rightDown = collectedGold[row + 1][column + 1];

                	                collectedGold[row][column] = gold[row][column]
                	                        + Math.max(rightUp, Math.max(right, rightDown));
                	            }
            	        }
        	        int max = 0;
        	        for (int i = 0; i < n; i++)
            	            max = Math.max(max, collectedGold[i][0]);
        	        return max;
    }

    private static int getBestGoldRecursively(int[][] gold, int row, int column){
		if (column >= gold[0].length || row >= gold.length  || row < 0) return 0;

		int rightUp = getBestGoldRecursively(gold, row+1, column+1);
		int right = getBestGoldRecursively(gold, row, column+1);
		int rightDown = getBestGoldRecursively(gold, row-1, column+1);

        return gold[row][column] + Math.max(right, Math.max(rightDown, rightUp));
    }
    private static int goldMineRecursively(int[][] gold){
    	if(gold == null) return 0;
    	int maxGold = 0;
    	for(int row = 0, size = gold.length; row < size; row++ ){
    		maxGold =Math.max(maxGold, getBestGoldRecursively(gold, row, 0));
    	}
    	return maxGold;
	}
    public static void main(String[] args) {


        int [][] gold_mine = {
                {5, 1, 1, 7000, 5},
                {9, 5, 1, 1, 0},
                {0, 10, 2, 3, 3},
                {10, 6, 5, 22, 6} };


        System.out.println(goldMine(gold_mine));
		System.out.println(goldMineRecursively(gold_mine));
    }


}
