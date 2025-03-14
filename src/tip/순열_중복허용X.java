package tip;

public class 순열_중복허용X {
	
	static int[] arr = {1,2,3,4,5,6};
	static int[] num = new int[3];  
	static boolean[] visit = new boolean[arr.length];
	
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
			if(visit[i]) continue;
			visit[i] = true;
			num[depth] = arr[i];
			permutation(depth+1);
			visit[i] = false;
		}
	}
}
