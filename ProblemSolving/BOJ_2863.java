import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2863 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double[] arr = new double[4];
		double A = Integer.parseInt(st.nextToken());
		double B = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		double C = Integer.parseInt(st.nextToken());
		double D = Integer.parseInt(st.nextToken());
		
		arr[0] = (A / C) + (B / D);
		arr[1] = (C / D) + (A / B);
		arr[2] = (D / B) + (C / A);
		arr[3] = (B / A) + (D / C);	
		
		int turn = 0;
		double max = 0;
		for (int i = 0; i < 4; i++) {
			if (max < arr[i]) {
				max = arr[i];
				turn = i;
			}
		}
		
		bw.write(String.valueOf(turn));
		br.close();
		bw.close();
	}
}
