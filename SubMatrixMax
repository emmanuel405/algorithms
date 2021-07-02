import java.util.Arrays;

public class SubMatrixMax {

	public static int[] SubMatrixMax(int [][] mat){
		int max_sum = mat[0][0], rows = mat.length, cols = mat[0].length, best[] = new int[3];
		int startRow = 0, endRow = 0, startCol = 0 , endCol = 0, tmpRow = 0;
		int tmp[] = new int[cols];
		for(int i=0; i<cols; i++){
			Array2Zero(tmp); // tmp[cls] <-- 0

			for(int j=i; j<cols; j++){
				for(int k=0; k<rows; k++) {
					tmp[k] += mat[k][j];
					best = Best(tmp);
				}
				if(best[2] > max_sum){
					max_sum = best[2];
					startRow = best[0];
					endRow = best[1];
					startCol = i;
					endCol = j;
				}
			}

		}
		int[] res = {startRow, endRow, startCol, endCol, max_sum};
		return res;
	}

	private static int[] Best(int [] a) {
		int bestStart = 0, bestEnd = a.length;
		int max = 0, tempMax = 0, tempStart = 0;
		int ans [] = new int [3];

		for (int i = 0; i < a.length; i++) {
			tempMax += a[i];
			if((tempMax > max) ||
					(tempMax == max && i - tempStart < bestEnd - bestStart)){
				max = tempMax;
				bestStart = tempStart;
				bestEnd = i;
			}
			if(tempMax < 0){
				tempMax = 0;
				tempStart = i + 1;
			}
		}

		ans[0] = bestStart;
		ans[1] = bestEnd;
		ans[2] = max;
		return ans;
	}

	private static void Array2Zero(int arr[]){
		for(int i=0; i<arr.length; i++)
			arr[i]=0;
	}

	public static void main(String[] args) {
		int[][] mat = {
				{-2,-5,-6,-1},
				{-1,12,10,-1},
				{-1, 7,1,-1},
				{-10,-61,-1,-1}
		};
		int res[] = SubMatrixMax(mat);
		System.out.println(Arrays.toString(res));

	}
}
