package etc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class word빈도수 {
		public static void main(String[] args) throws IOException {
			
			Map<String, Integer> check = new HashMap<>();
			BufferedReader br = new BufferedReader(new FileReader("./word.txt"));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String input = st.nextToken();
			while(input != null) {
				String word = st.nextToken();
				if(!check.containsKey(word.toUpperCase())) { //없다면
					check.put(word,1);
				}else {
					check.put(word, check.get(word)+1);
				}
				System.out.println(word);
			}
			
			//System.out.println(check);
			

		
	}

}
