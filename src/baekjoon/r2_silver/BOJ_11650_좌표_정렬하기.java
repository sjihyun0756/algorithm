package baekjoon.r2_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


class Point{
	int x;
	int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class BOJ_11650_좌표_정렬하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Point[] points = new Point[N];
//		for (int i = 0; i < N; i++) {
//		    points[i] = new Point(0, 0);  //미리 객체를 생성하는 방법 
//		}
//		
//		for(int i=0; i<N; i++) {
//			st = new StringTokenizer(br.readLine());
//			points[i].x = Integer.parseInt(st.nextToken());
//			points[i].y = Integer.parseInt(st.nextToken());
//		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points[i] = new Point(x,y);
		}
		
		Arrays.sort(points, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if(o1.x != o2.x) return Integer.compare(o1.x, o2.x);
				return Integer.compare(o1.y, o2.y);
			}
		});
		
		for(int i=0; i<N; i++) {
			sb.append(points[i].x).append(" ").append(points[i].y).append("\n");
		}
		System.out.println(sb);
		
		
	}
}
