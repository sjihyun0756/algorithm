package etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class testtt {
	public static void main(String[] args) {
		List<int[]> list = new ArrayList<>();
		
		list.add(new int[] {1,2});
		list.add(new int[] {2,3});
		list.add(new int[] {4,5});
		list.add(new int[] {4,6});
		
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(Arrays.toString(list.get(i)));
			System.out.println(list.get(i)[0]);
		}
		
		String[][] arr = new String[3][3];
		for(int i=0; i<arr.length; i++) {
			Arrays.fill(arr[i], "9");
		}
		
		for(int i=0; i<arr.length; i++)
			System.out.println(Arrays.toString(arr[i]));
	}

}

