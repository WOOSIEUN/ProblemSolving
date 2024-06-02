import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_6600 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while (true){
			String line = br.readLine();
		    if (line == null) {
		    	break;
		    }			

			st = new StringTokenizer(line);		    
		    double x1 = Double.parseDouble(st.nextToken());
			double y1 = Double.parseDouble(st.nextToken());
			double x2 = Double.parseDouble(st.nextToken());
			double y2 = Double.parseDouble(st.nextToken());
			double x3 = Double.parseDouble(st.nextToken());
			double y3 = Double.parseDouble(st.nextToken());

			double hypotenuse = Math.hypot(x3 - x2, y3 - y2);
			double ax = x2 - x1;
			double ay = y2 - y1;
			double bx = x3 - x1;
			double by = y3 - y1;
			double theta = Math.acos((ax * bx + ay * by) / Math.hypot(ax, ay) / Math.hypot(bx, by));
			sb.append(String.format("%.2f", hypotenuse / Math.sin(theta) * Math.PI)).append('\n');		    
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
