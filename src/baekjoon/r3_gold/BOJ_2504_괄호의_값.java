package baekjoon.r3_gold;

import java.io.*;
import java.util.*;

public class BOJ_2504_괄호의_값 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		boolean isOkay = true;
		Stack<String> s = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			String input = String.valueOf(str.charAt(i));
			
			if(s.isEmpty()) {
				if(input.equals("]") || input.equals(")")) {
					isOkay = false;
					break;
				}
				s.push(input);
				
			}else if(input.equals(")")) {
				String inside = s.peek();
				
				if(inside.equals("(")) {
					s.pop();
					
					if(!s.isEmpty() && (!s.peek().equals("[") && !s.peek().equals("("))) { //숫자임 
						s.push(String.valueOf(Integer.parseInt(s.pop()) + 2));
					}else {
						s.push("2");
					}
				}else if(inside.equals("[")) {
					isOkay = false;
					break;
					
				}else { //숫자일 경우 
					String num = String.valueOf(Integer.parseInt(inside) * 2);
					s.pop();
					if(!s.isEmpty() && s.peek().equals("(")) s.pop();
					else {
						isOkay = false;
						break;
					}
					
					if(!s.isEmpty() && (!s.peek().equals("[") && !s.peek().equals("("))) { //숫자임 
						s.push(String.valueOf(Integer.parseInt(s.pop()) + Integer.parseInt(num)));
					}else {
						s.push(num);
					}
				}
				
			}else if(input.equals("]")) {
				String inside = s.peek();
				
				if(inside.equals("[")) {
					s.pop();
					
					if(!s.isEmpty() && (!s.peek().equals("[") && !s.peek().equals("("))) { //숫자임 
						s.push(String.valueOf(Integer.parseInt(s.pop()) + 3));
					}else {
						s.push("3");
					}
				}else if(inside.equals("(")) {
					isOkay = false;
					break;
					
				}else { //숫자일 경우 
					String num = String.valueOf(Integer.parseInt(inside) * 3);
					s.pop();
					if(!s.isEmpty() && s.peek().equals("[")) s.pop();
					else {
						isOkay = false;
						break;
					}
					
					if(!s.isEmpty() && (!s.peek().equals("[") && !s.peek().equals("("))) { //숫자임 
						s.push(String.valueOf(Integer.parseInt(s.pop()) + Integer.parseInt(num)));
					}else {
						s.push(num);
					}
				}
				
			}else s.push(input);
//			System.out.println(i+"번째 스택  : " + s);
		}
		if (isOkay && s.size() == 1 && !s.peek().equals("(")  && !s.peek().equals("[")  && !s.peek().equals(")") && !s.peek().equals("]")) {
			System.out.println(s.pop());
		} else {
			System.out.println(0);
		}
//		System.out.println((isOkay && s.size() ==1) ? s.pop() : 0);
	}
}