package etc;
import java.util.*;
import java.io.*;

public class test {
    public static void main(String[] args) {
    	int n = 5;
    	for (int mask = 0; mask < (1 << n); mask++) {
    		System.out.println(mask);
    	    for (int i = 0; i < n; i++) {
    	        if ((mask & (1 << i)) != 0) {
    	            System.out.print(i + " "); // i번째 원소가 선택됨
    	        }
    	    }
    	    System.out.println("-".repeat(20));
    	}
    }
}