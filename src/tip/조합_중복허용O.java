package tip;

public class 조합_중복허용O {
	
	static int[] arr = {1,2,3,4,5,6};
	static int[] num = new int[3];  
	
	public static void main(String[] args) {
		combination(0, 0);
	}
	
	private static void combination(int depth, int last) {
		
		if(depth == num.length) { 
			for(int n : num) {
				System.out.print(n + " "); 
			}
			System.out.println(); 
			return;
		}
		
		for(int i=last; i<arr.length; i++) {
			num[depth] = arr[i];
			combination(depth+1, i);
		}
	}
}



