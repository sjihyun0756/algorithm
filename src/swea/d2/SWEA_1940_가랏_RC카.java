package swea.d2;

import java.io.*;

public class SWEA_1940_가랏_RC카 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int speed = 0, distance = 0;

            for (int i = 0; i < N; i++) {
                String[] command = br.readLine().split(" ");
                int type = Integer.parseInt(command[0]);

                if (type == 1) {
                    speed += Integer.parseInt(command[1]);
                } else if (type == 2) {
                    speed -= Integer.parseInt(command[1]);
                    if (speed < 0) speed = 0;
                }
                distance += speed; 
            }
            sb.append("#"+tc+" "+distance).append("\n");
        }
        System.out.println(sb);
    }
}
