import java.util.Arrays;
import java.util.Stack;

/**
* Each organ has a stack in which it stores the person standing in front of it who is smaller than him,
* After finding the maximum we check who is the second maximum of the loser
* in front of him and everyone in his stack -> and he will be the second maximum
*/

public class Max_Max {

	static class Node{
		int data;
		Stack<Integer> st;

		public Node(){
			this.data = 0;
			st = new Stack<Integer>();
		}

		public Node(int data) {
			this.data = data;
			st = new Stack<Integer>();
		}
	}

	public static void main(String[] args) {
		Node [] arr = new Node[8];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Node ((int)(Math.random()*100));
			System.out.println(arr[i].data);
		}

		int ans[] = new int [2];
		ans = Max1_Max2(arr);
		System.out.println(Arrays.toString(ans));
	}


	/** 
	 * @param l
	 * { 1 -> 9 -> 5 -> 15 -> 66 -> 4 -> 3 -> 10 -> 20}
	 * { 9 -> 15 -> 66 -> 10 -> 20}
	 * { 15 -> 66 -> 20}
	 *  
	 * @return 2Nodes => max1, max2
	 */
	public static int[] Max1_Max2(Node[] arr) {
		int ans[] = new int[2];
		int index_max = -1, max2 = 0;
		if (arr.length < 2) return null;

		else {
			for(int i=1; i<arr.length; i=i+2) {
				if(arr[i-1].data < arr[i].data) {
					arr[i].st.push(arr[i-1].data);
					if(index_max!=-1) {
						if(arr[index_max].data < arr[i].data) 
							index_max = i;
					}else{
						index_max = i;
					}
					System.out.println(index_max);
				}
				else {
					arr[i-1].st.push(arr[i].data);
					if(index_max!=-1) {
						if(arr[index_max].data < arr[i-1].data) 
							index_max = i-1;
					}else{
						index_max = i-1;
					}
				}
			} // for

		} // else
		if(arr.length%2 == 1) {
			if(arr[arr.length-1].data < arr[index_max].data) {
				arr[index_max].st.push(arr[arr.length-1].data);
			}
			else {
				arr[arr.length-1].st.push(arr[index_max].data);
				index_max = arr.length-1;
			}
		}
		ans[0] = arr[index_max].data;

		max2 = arr[index_max].st.pop();
		int tmp = 0;
		while(!arr[index_max].st.isEmpty()) {
			tmp = arr[index_max].st.pop();
			if(tmp>max2) max2 = tmp;
		}

		ans[1] = max2;
		return ans;

	}

}
