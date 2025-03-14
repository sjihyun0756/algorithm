/*
package tip;

public class 부분집합 {
	//이 방식으로 할 경우 공집합은 따로 추가해줘야함
	static int[] arr = {1,2,3,4,5,6};
	static int[] num;
	
	public static void main(String[] args) {
		for(int i =1; i<arr.length; i++) {
			num = new int[i];
			subset(0, -1);
		}
	}
	
	private static void subset(int depth, int last) {
		
		if(depth == num.length) { 
			for(int n : num) {
				System.out.print(n + " "); 
			}
			System.out.println(); 
			return;
		}
		
		for(int i=last+1; i<arr.length; i++) {
			num[depth] = arr[i];
			subset(depth+1, i);
		}
	}
}
*/

package tip;

public class 부분집합 {
	
	static int[] arr = {1, 2, 3, 4, 5, 6};
	static boolean[] visit = new boolean[arr.length]; 
	
	public static void main(String[] args) {
		subset(0);
	}
	
	private static void subset(int index) {
		if (index == arr.length) { 
			for (int i = 0; i < arr.length; i++) {
				if (visit[i]) {  
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		
		visit[index] = false;
		subset(index + 1);
		
		visit[index] = true;
		subset(index + 1);
	}
}
