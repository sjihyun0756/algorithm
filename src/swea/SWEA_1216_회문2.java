package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SWEA_1216_회문2 {
	
	static List<Integer> idxCheck(String input, int num) throws IOException {
		List<Integer> idxList = new ArrayList<>();
		
		String[] checkArr = {"AAA","ABA","ACA",
							"BAB","BBB","BCB",
							"CAC","CBC","CCC",
							"AA","BB","CC"};
		
		if(num ==0) {//홀수일경우
			for(int i=0; i<checkArr.length-3; i++) {
				int idx = input.indexOf(checkArr[i]);
				while(idx != -1) {
					idxList.add(idx+1);
					idx = input.indexOf(input,idx+1);
				}
			}
		}
		else {//짝수일경우
			for(int i=checkArr.length-3; i<checkArr.length; i++) {
				int idx = input.indexOf(checkArr[i]);
				while(idx != -1) {
					idxList.add(idx);
					idx = input.indexOf(input,idx+1);
				}
			}
		}
		return idxList;
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc<= 1; tc++) { //수정
			List<Integer> idxListOdd = new ArrayList<>();
			int T = Integer.parseInt(br.readLine());
			
			char[][] arr = new char[100][100];  //수정
			String[] arrList = new String[200]; //수정
			for(int i=0; i<100; i++) { //수정
				arr[i] = br.readLine().toCharArray();
				arrList[i] = String.valueOf(arr[i]);
			}
			
			
			
			for(int j=0; j<100; j++) { //수정
				char[] arr2 = new char[100]; //수정
				for(int i=0; i<100; i++) { //수정
					arr2[i] = arr[i][j]; //수정
					arrList[100+j] = new String(arr2); //수정
				}
			}
						
			int max1 = 0;
			int max2 = 0;
			
//			for(int i=0; i<arrList.length; i++) {
//				System.out.println(arrList[i]);
//			}
			
			
			
			//가로
			for(int i=0; i<200; i++) {//수정 
//				System.out.println("########################################################" +i +"  이다!!!!!!!!!!!!!!!!!!!");
//				max1 = 0;
//				System.out.println(String.valueOf(arr[0])); //cbcabbac
				idxListOdd = idxCheck(arrList[i],0);
//				System.out.println("idxListOdd::::::::::"+idxListOdd);
				
				//홀수일 경우
				for(Integer c : idxListOdd) {
//					System.out.println("현재 c는 " + c);
					int d = 1;
					int cnt = 1;
					while(0<=c-d && c+d<100) { //수정
//						System.out.println("while문을 " + cnt +"번째 돌고 있당");
						cnt++;
						if(arr[i%100][c-d] == arr[i%100][c+d]) { //수정
//							System.out.println("d 들어옴 :::::: c: "+c+"     d::::::::::" + d);
							d++;
//							System.out.println(d);
						}else if(arr[i%100][c-d] != arr[i%100][c+d]){ //수정
							break;
						}
//						System.out.println("현재 여기까지의 max1:::::"+max1);
						
						max1 = Math.max(max1, 2*(d-1)+1);
					}
				}
//				System.out.println("max : " +max);
				
				
				
				//짝수일경우
//				max2 = 0;
				List<Integer> idxListEven = new ArrayList<>();
				idxListEven = idxCheck(arrList[i],1);
//				System.out.println("idxListEven::::::::::"+idxListEven);
				
				for(Integer c : idxListEven) {
//					System.out.println("현재 c는 " + c);
					int d = 1;
					int cnt2 = 1;
					while(0<=c-d && (c+1)+d<100) { //수정
//						System.out.println("while문을 " + cnt2 +"번째 돌고 있당");
						cnt2++;
						if(arr[i%100][c-d] == arr[i%100][(c+1)+d]) {
//							System.out.println("d 들어옴 :::::: c: "+c+"     d::::::::::" + d);
							d++;
//							System.out.println(d);
						}else if(arr[i%100][c-d] != arr[i%100][(c+1)+d]){
							break;
						}
//						System.out.println("현재 여기까지의 max2:::::"+max2);
						max2 = Math.max(max2, 2+(d-1)*2);
					}
				}
//				System.out.println("max : " +max2);
				
//				System.out.println(Arrays.deepToString(arr));
				
				
			}

		System.out.println("최종 max : " + Math.max(max1, max2));	
		}
		
		
	}

}
