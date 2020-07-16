import java.util.Arrays;

public class Min_Max {

/**
 * Find min and max of array => O(n)
 * [n = length of array] 
 */
	public static int[] MinAndMax(int arr[]) {
		int [] ans = new int [2];
		int min, max;
		min = arr[1];
		max = arr[0];
		if (arr[0] < arr[1]) {
			min = arr[0];
			max = arr[1];
		}
		
		for (int i=3; i<arr.length; i=i+2) { // 2j, 2j+1
				if(arr[i] < arr[i-1]) {
					if(arr[i] < min) min = arr[i];
					if(arr[i-1] > max) max = arr[i-1]; 
				}
				else {
					if(arr[i-1] < min) min = arr[i-1];
					if(arr[i] > max) max = arr[i];
				}
		}
		
		if(arr.length%2 == 1) {
			if(arr[arr.length-1] > max) max = arr[arr.length-1];
			else if (arr[arr.length-1] < min) min = arr[arr.length-1];
		}
		ans[0] = min;
		ans[1] = max;
		return ans;
	}
	
	public static void main(String args[]) {
		int arr[] = {1,5,15,4,9,52,6,65,85,33,22,45,75};
		System.out.println("Should be => 1,85: "+Arrays.toString(MinAndMax(arr)));
	}

}
