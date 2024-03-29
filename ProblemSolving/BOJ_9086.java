import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_9086 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
            String line = br.readLine();
            sb.append(line.charAt(0)).append(line.charAt(line.length() -1)).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}