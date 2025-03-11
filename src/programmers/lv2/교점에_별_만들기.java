package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 교점에_별_만들기 {
	static List<int[]> points;
	static int[][] line;
	
    private static boolean 평행검사(int[] line, int[] line2){
        if(line[0]*line2[1]-line[1]*line2[0] ==0) return true; //평행임
        else return false; //평행 아님, 교점 있음
    }
    
    private static void find교점(int line1[], int line2[]){
        double x = (double)( line1[1]*line2[2] - line1[2]*line2[1] ) / ( line1[0]*line2[1] - line1[1]*line2[0] );
        double y = (double)( line1[2]*line2[0] - line1[0]*line2[2] ) / ( line1[0]*line2[1] - line1[1]*line2[0] );
        
        System.out.println("double x : " + x + "       double y : " + y);
        if(x== Math.ceil(x) && y == Math.ceil(y)) {
            points.add(new int[] {(int) x,(int) y});
        }
    }
    public static void main(String[] args) {
    	line = new int[][] {{2,-1,4},{-2,-1,4},{0,-1,1},{5,-8,-12},{5,8,12}};
        int size = line.length;
        points = new ArrayList<>();
        for(int i=0; i<size-1; i++){
            for(int j=i+1; j<size; j++){
                //평행검사
                if(!평행검사(line[i], line[j])) find교점(line[i], line[j]);
            }
        }    
        int width =0;
        int height = 0; 
        for(int i=0; i<points.size(); i++){
            width = Math.max(width, points.get(i)[0]) - Math.min(width, points.get(i)[0]);
            height = Math.max(width, points.get(i)[1]) - Math.min(width, points.get(i)[1]);
        }
        
        char[][] result = new char[width][height];
        for(int i=0; i<width; i++) {
        	for(int j=0; j<height; j++) {
        		result[i][j] = '.';
        	}
        }
        
        for(int i=0; i<points.size(); i++) {
        	System.out.println(Arrays.toString(points.get(i)));
        }
        
//        for(int i=0; i<points.size(); i++){
//            int x = points.get(i)[0];
//            int y = points.get(i)[1];
//            result[x][y] = '*'; //확인용 숫자 1
//        }
//        
//        for(int i=0; i<points.size(); i++){
//            System.out.println(Arrays.toString(result[i]));
//        } 
	}
}
