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
	public static int[] Best(int [] a) {
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

		/**
	 *
	 * @param a
	 *
	 * @example:
	 *	  [7, -9, 2, 1]
	 * @result:
	 * 	  [2, 1, 10]
	 *
	 * @return ans = > [index start, index end, max]
	 */
	public static int[] BestCycle(int a[]) {
		int neg[] = new int[a.length];
		int sumAllNum = 0;
		for (int i = 0; i < a.length; i++){
			sumAllNum += a[i];
			neg[i] = -1 * a[i];
		}
		int[] bestSimple = Best(a);
		int[] bestNeg = Best(neg);

		int sumBest = bestSimple[2],
		sumCycle = bestNeg[2] + sumAllNum,
		sizeBest = bestSimple[1] - bestSimple[0] + 1, // end - start + 1
		sizeCycle = a.length - (bestNeg[1] + bestNeg[0]) + 1; // end - start + 1

		int[] ans = new int[3];
		if((sumBest > sumCycle) ||
				(sumBest == sumCycle && sizeBest <= sizeCycle)){
			ans[0] = bestSimple[0]; ans[1] = bestSimple[1];
			int sum = 0;
			for (int i = 0; i < sizeBest; i++)
				sum += a[bestSimple[0] + i];
			ans[2] = sum;
		}
		else{
			ans[0] = bestNeg[1] + 1; ans[1] = bestNeg[0] - 1;
			int sum = 0;
			for (int i = 0; i < sizeCycle; i++)
				sum += a[(bestNeg[1] + i + 1) % a.length];
			ans[2] = sum;
		}
		return ans;
	}

/*
  public static void main(String[] args) {
	int [] arr = {7,-7, 3, 9, -15, 2};
	int [] ans = Best(arr);
	System.out.println(Arrays.toString(ans));

	int [] arr = {7, -9, 2, 1};
	int res[] = BestCycle(arr);
	System.out.println(Arrays.toString(res));

	int [] arr1 = {7, -7, 1, -8, 1};
	int res1[] = BestCycle(arr1);
	System.out.println(Arrays.toString(res1));
	
    }
*/
}
