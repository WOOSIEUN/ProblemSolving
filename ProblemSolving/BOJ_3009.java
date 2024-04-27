import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_3009 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int xPoints[] = new int[3];
        int yPoints[] = new int[3];
        
        for(int i = 0; i < 3; i++) {
        	st = new StringTokenizer(br.readLine());
        	xPoints[i] = Integer.parseInt(st.nextToken());
        	yPoints[i] = Integer.parseInt(st.nextToken());
        }
		
		bw.write(findPoint(xPoints) + " " + findPoint(yPoints));
		br.close();
		bw.close();
	}
	
	static int findPoint(int[] points){
        if (points[0] == points[1]){
            return points[2];
        } else {
            return points[0] == points[2] ? points[1] : points[0];
        }
    }
}
