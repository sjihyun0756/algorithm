package tip;

public class 순열 {
	
	static int[] arr = {1,2}; //너가 뽑을 수 있는 숫자들이 들어있는 배열
	static int[] num = new int[4];  //너가 뽑아야하는 숫자 만큼의 배열
	
	//ex) 숫자 1,2,3,4,5,6 중에서 숫자 2개를 뽑아야한다면
	// arr에는1,2,3,4,5,6이 들어있어야하고, num배열의 크기는 2어야함
	
	public static void main(String[] args) {
		perm(0);
	}
	
	private static void perm(int depth) {
		
		if(depth == num.length) { //depth== 여기 들어가야할 숫자는 num의 크기와 같음, 즉 너가 뽑아야하는 수 만
			for(int n : num) {
				System.out.print(n + " "); //만들어진 순열 출력하려고 하는 거임
			}
			System.out.println(); 
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			num[depth] = arr[i];
			perm(depth+1);
		}
	}
}
