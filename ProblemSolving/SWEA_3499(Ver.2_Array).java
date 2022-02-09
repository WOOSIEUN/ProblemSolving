import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3499 {
	static int N,separate;
	static String [] str; 
	static String result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			str = new String[N];
			separate = (N%2==0?N/2:N/2+1);
			for (int i = 0; i < N; i++)
				str[i] = st.nextToken();
			result = "";
			for (int i = 0; i < N/2; i++) {
				result += str[i]+" ";
				result += str[i+separate]+" ";
			}
			if(separate != N/2) result += str[separate-1]+" ";
			System.out.printf("#%d %s\n", t, result);
		}
		br.close();
	}
}
