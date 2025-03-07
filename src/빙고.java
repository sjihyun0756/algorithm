import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 빙고 {
	static int[][] arr = new int[5][5];
	static int cnt = 0;

//	static boolean[][] 
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 받았고

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				check(num);
				if (cnt >= 3) {
					System.out.println(num);
					return;
				}
			}
		}

	}

	static void check(int n) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (arr[i][j] == n) {
					arr[i][j] = 0;
					a(i, j);
				}
			}
		}
	}

	static void a(int i, int j) {
		
		if (i + j == 4) {
			int sum1 = 0;
			sum1 += arr[0][4];
			sum1 += arr[1][3];
			sum1 += arr[2][2];
			sum1 += arr[3][1];
			sum1 += arr[4][0];
			if (sum1 == 0) cnt++;
		}
		

		if (i == j) {
			int sum2 = 0;
			for (int d = 0; d < 5; d++) {
				sum2 += arr[d][d];
			}
			if(sum2==0) cnt++;
		}

		int sum3 = 0;
		breakPoint:
		for (int d = 0; d < 5; d++) {
			if(arr[i][d] != 0) break breakPoint;
			cnt++;
		}

		int sum4 = 0;
		breakPoint:
		for (int d = 0; d < 5; d++) {
			if(arr[i][d] != 0) break breakPoint;
			cnt++;
		}
	}
}
