
public class SubSumMax{

  /**
   * Find the largest sub-matrix of all the sub-matrices
   */
  public static int SumMax(int [][] mat){
    int max_sum = mat[0][0], rows = mat.length, cols = mat[0].length, best = 0;
    int tmp[] = new int[cols];
    for(int i=0; i<cols; i++){
      Array2Zero(tmp); // tmp[cls] <-- 0
      
      for(int j=0; j<cols; j++){
        for(int k=0; k<rows; k++){
          tmp[k] += mat[k][j];
          best = Best(tmp);
        }
        if(best > max_sum)
          max_sum = best;
      }
      
    }
    return max_sum;
  }
  
  private static void Array2Zero(int arr[]){
		for(int i=0; i<arr.length; i++)
			arr[i]=0;
	}

    private static int Best(int arr[]){
      int best_max = 0, tmp_max = 0;
      for(int i=0; i<arr.length; i++){
        tmp_max += arr[i];
        if(tmp_max > best_max)
          best_max = tmp_max;
        if(tmp_max < 0)
          tmp_max = 0;
      }
      return best_max;
    }
  }
  
 /**
	 * @param arr, k
	 * Finding a continuous sub-section with a length of k
	 * Take the first K numbers and put into 'tmp' and calculate the sum of the numbers
	 * We take out the most early number and insert the next member in the original array.
	 * As well as the end of the entire array - and find the maximum required
	 * 
	 * @return max
	 */
	public static int SubMax(int arr[], int k){
		int tmp[] = new int[k];
		int max = 0;
		for(int i = 0; i < k; i++) {
			tmp[i] = arr[i];
			max += arr[i];
		}

		int max_tmp = max;
		for(int i = k; i < arr.length; i++){
			max_tmp = max_tmp + arr[i] - tmp[i % k];
			tmp[i % k] = arr[i];
			if(max_tmp > max)
				max = max_tmp;
		}
		return max;
	}
  
 /* 
  public static void main(String[] args) {

    int arr[] = {1,4,2,10,2,3,1,0,20};
    int ans = SubMax(arr, 4);
    System.out.println(ans);

    int[][] matrix = {{2,1,-3,-4,5},
                    {0,6,3,4,1},
                    {2,-2,-1,4,-5},
                    {-3,3,1,0,3}};
    System.out.println(SumMax(matrix));
  
  }
 */
}
