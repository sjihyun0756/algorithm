package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253_좋다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		//숫자가 5개라면(-1 2 1 1)
		int left = 0, cnt =0, right =0; //3번째 숫자 : 인덱스 2 // length = 4
		for(int i = arr.length-1; i>1; i--) {
			int test = arr[i];
			right = i-1; 
			left = 0;
			
			while(left<right) {
				if(arr[left]+arr[right] == test) {
					cnt++;
					break;
				}else if(arr[left]+arr[right] > test) {
					right--;				
				}else if(arr[left]+arr[right] < test) {
					left++;
				}
			}
		}
		System.out.println(cnt);
	}
}