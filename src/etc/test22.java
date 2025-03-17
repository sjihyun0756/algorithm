package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class test22 {
	public static void main(String[] args) throws IOException {
		Map<String,Integer> map = new HashMap<>();
		map.put("A", 1);
		if(map.get("A") ==1) System.out.println(true);
		System.out.println(map.get("B"));
		
	}
}
