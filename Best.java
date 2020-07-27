import java.util.Arrays;

public class Best {

    /**
     *
     * @param start, end, value
     * where I want to start the array, where ending, and the array -> a
     * @example:
     *	  [7,-7, 3, 9, -15, 2]
     * @result:
     * 	  [2, 3, 12]
     * 	  index 2 to 3 the value of sum = 12
     *
     * **and with the minimum length**
     * @example:
     *    [4, 2, -15 ,1 ,2, 3, -100]
     * @result:
     *    [0, 1, 6]
     *    index 0 to 1 the value of sum = 6
     * @return ans = > [index start, index end, value]
     */
    public static int[] Best(int start, int end ,int [] a) {
        int ans [] = new int [3];
        int sum = 0;

        // I have only one number
        if(start == end) {
            ans[0] = ans[1] = start;
            ans[2] = a[start];
            return ans;
        }

        if(a[start] >= 0) {
            sum = a[start];
            ans[0] = ans[1] = start;
        }

        int help = sum;
        int idx_min = -1;
        for (int i = start + 1; i < end; i++) {
            help += a[i];

            if(help <= 0) {
                help = 0;
                idx_min = i;
            }
            else {
                if(sum == help) {
                    if(ans[1] - ans[0] > i - idx_min + 1){
                        ans[0] = idx_min + 1;
                        ans[1] = i;
                    }
                }
                else if(sum < help) {
                    ans[0] = idx_min + 1;
                    ans[1] = i;
                    sum = help;
                }
            }
        }
        ans[2] = sum;
        return ans;
    }

    /**
     *
     * @param a
     * same but know, we get an array and we looked him like circle.
     * we put the array number in the diag if matrix
     * if i<j:
     * matrix[i][j] = matrix[j][j] + matrix[i][j-1]
     *
     * else: (i>j)
     * ans[i,j] = all - ans[i-1,j+1]
     * @example:
     *	  [7, -9, 2, 1]
     * @result:
     * 	  []
     *
     *  7
     *    -9
     *        2
     *           1
     * @return ans
     */
    public static int[][] Best_circle(int a[]) {
        int matrix[][] = new int[a.length][a.length];
        int sumAllNum = 0;
        for (int i = 0; i < a.length ; i++) {
            matrix[i][i] = a[i];
            sumAllNum += a[i];
        }

        // the up triangle
        for(int i = 0; i < a.length; i++) {
            for(int j = i; j < a.length; j++) {
                if(i < j)
                    matrix[i][j] = matrix[j][j] + matrix[i][j-1];
            }
        }

        for (int i = 1; i < a.length; i++)
            for (int j = 0; j < i; j++)
                matrix[i][j] = sumAllNum - matrix[j][i-1];

        return matrix;
    }


/*
  public static void main(String[] args) {
 		int [] arr = {7, -9, 2, 1};
		int matrix[][] = Best_circle(arr);
		for(int i=0; i<arr.length; i++)
			System.out.println(Arrays.toString(matrix[i]));

        int[][] matrix = {{2,1,-3,-4,5},{0,6,3,4,1},{2,-2,-1,4,-5},{-3,3,1,0,3}};
        for(int i=0; i<matrix.length; i++)
            System.out.println(Arrays.toString(matrix[i]));

        System.out.println("");
        int[] ans = BigSubMatrix(matrix);
        System.out.println(Arrays.toString(ans));

    }
*/
}
