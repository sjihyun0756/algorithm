package etc;

import java.util.Arrays;

public class test {
	
	public static void main(String[] args) {
		int[][] arr = new int[5][];
		int a = 5;
		int b = 51;
		int c = 15;
		int d = 53;
		int e = 55;
		arr[0] = new int[] {a};
		arr[0] = new int[] {b};
		arr[0] = new int[] {c};
		arr[3] = new int[] {d};
		arr[1] = new int[] {e};
		
		System.out.println(Arrays.deepToString(arr));
	}
}
