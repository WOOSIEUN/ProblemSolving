import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1358 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        int ans = 0;
        int radius = H / 2, radiusSquare = radius * radius;
		
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int playerX = Integer.parseInt(st.nextToken());
            int playerY = Integer.parseInt(st.nextToken());
            
            if (isInRange(playerX, X, W + X) && isInRange(playerY, Y, H + Y)) {
            	ans++;
                continue;
            }

            if (radiusSquare >= getSquaredDist(playerX, playerY, X, Y + radius) || radiusSquare >= getSquaredDist(playerX, playerY, X + W, Y + radius)) {
            	ans++;
                continue;
            }
        }
        
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
	
	private static int getSquaredDist(int fromX, int fromY, int toX, int toY) {
		return (int) (Math.pow(Math.abs(fromX - toX), 2) + Math.pow(Math.abs(fromY - toY), 2));
	}
	
	private static boolean isInRange(int target, int start, int end) {
		return start <= target && target <= end;
	}
}
