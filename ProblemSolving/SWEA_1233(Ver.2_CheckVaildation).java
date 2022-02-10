import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1233 {
	static int vaild, N;
	static char tmp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder result = new StringBuilder();
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			vaild = 1;
			N = Integer.parseInt(br.readLine());
			for (int i = 1; i < N+1; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				tmp = st.nextToken().charAt(0);
				if(st.hasMoreTokens()) {
					if ('0' <= tmp && tmp <= '9') 
						vaild = 0;
				} else {
					if ('0' > tmp && tmp > '9') 
						vaild = 0; 
				}
			}
			result.append("#"+t+" "+vaild+"\n");
		}
		bw.write(result.toString());
		br.close();
		bw.close();
	}
}