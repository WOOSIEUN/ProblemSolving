import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1546 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		double sum = 0;
        double max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {        	
            int num = Integer.parseInt(st.nextToken());
            max = Math.max(max, num);
            sum += num;
        }
        
		bw.write(String.valueOf(sum / max * 100 / N));
		br.close();
		bw.close();
	}
}
