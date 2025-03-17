package tip;

public class 순열_중복허용O {
	
	static int[] arr = {1,2,3};
	static int[] num = new int[3];  
	
	public static void main(String[] args) {
		permutation(0);
	}
	
	private static void permutation(int depth) {
		
		if(depth == num.length) { 
			for(int n : num) {
				System.out.print(n + " "); 
			}
			System.out.println(); 
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			num[depth] = arr[i];
			permutation(depth+1);
		}
	}
}
