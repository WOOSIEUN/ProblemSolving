import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_3495 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		double area = 0;
		
		for(int i = 0; i < H; i++) {
            int curLine = 0;
			char[] line = br.readLine().toCharArray();
			
            for (int j = 0; j < W; j++) {
                char c = line[j];
                
                if (c == '/' || c == '\\') {
                    area += 0.5;
                    curLine++;
                }
                
                if (c == '.' && curLine % 2 == 1) {
                    area++;
                }
            }
        }
		
		bw.write(String.valueOf((int) area));
		br.close();
		bw.close();
	}
}
