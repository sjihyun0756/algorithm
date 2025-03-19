package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

public class BOJ_1181_단어정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		TreeSet<String> set = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() != o2.length()) return Integer.compare(o1.length(), o2.length());
				
				return o1.compareTo(o2);
			}
		});
		
		//comparator
		//Return 값이 음수면 o1,o2순
		//string에서 길이 비교 Integer.compare(o1.length(), o2.length())
		//string에서 사전준 비교 o1.compareTo(o2);
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			set.add(input);
		}
		
		for(String out : set) {
			sb.append(out).append("\n");
		}
		
		System.out.println(sb);
	}

}

/*
        // 문자열 길이 기준으로 정렬하되, 길이가 같으면 사전순 정렬
        Comparator<String> lengthThenAlphabeticalComparator = (s1, s2) -> {
            if (s1.length() != s2.length()) {
                return Integer.compare(s1.length(), s2.length()); // 길이 기준 정렬
            }
            return s1.compareTo(s2); // 길이가 같으면 사전순 정렬
        };

        // TreeSet 생성 (Comparator 적용)
        TreeSet<String> treeSet = new TreeSet<>(lengthThenAlphabeticalComparator);

        // 값 추가
        treeSet.add("banana");
        treeSet.add("kiwi");
        treeSet.add("apple");
        treeSet.add("pear");
        treeSet.add("grape");
        treeSet.add("cherry");

        // 결과 출력
        for (String s : treeSet) {
            System.out.println(s);
        }
    }
}
*/
