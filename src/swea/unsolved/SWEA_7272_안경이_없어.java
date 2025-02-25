package swea.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class SWEA_7272_안경이_없어 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Character>[] list = new ArrayList[3];
		
		for(int i=0; i<list.length; i++) {
			list[i]= new ArrayList<>();
		}
		
		String hole0 = "CEFGHIJKLMNSTUVWXYZ";
		for(int i=0; i<hole0.length(); i++) {
			list[0].add(hole0.charAt(i));
		}
		
		String hole1 = "ADOPQR";
		for(int i=0; i<hole1.length(); i++) {
			list[1].add(hole1.charAt(i));
		}
		list[2].add('B');
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc =1; tc<=5; tc++) {		
			st = new StringTokenizer(br.readLine());
			String check1 = st.nextToken();
			String check2 = st.nextToken();
			
			for(int i=0; i<check1.length(); i++) {
				
			}
		}
	}
}
