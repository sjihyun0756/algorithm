package etc;

public class Solution {
	public static void main(String[] args) {
		int a = 3;
		int b = 1;
		int n = 20;
		int answer = 0, remain = 0;  
        while(true){
            int quotient = n/a;
            int remainder = n%a;
            answer += quotient*b;    
            if(remainder !=0) quotient += remainder;  
            n=quotient;
            if(n<a) break;
        }
        System.out.println(answer);
	}
}
