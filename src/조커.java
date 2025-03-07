import java.util.Arrays;
import java.util.Scanner;

public class 조커 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int zeros = 0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] == 0) zeros++;
		}
		Arrays.sort(arr);
		int result = 1;
//		System.out.println(zeros);
//		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < N; i ++) {
			if (arr[i] == 0) {
				result = Math.max(zeros, result);
				continue;
			}
			int len = 1;
			int tmp = zeros;
			for (int j = i+1; j < N; j++) {
				if (arr[j] - arr[j-1] == 0) continue;
				if (arr[j] - arr[j-1] == 1) {
					len++;
				}
				else if (arr[j] - arr[j-1] - 1 <= tmp) {
					tmp -= arr[j] - arr[j-1] - 1;
					len += arr[j] - arr[j-1];
				}
				else break;
			}
			len += tmp;
			result = Math.max(len, result);
		}
		System.out.println(result);
	}
}
