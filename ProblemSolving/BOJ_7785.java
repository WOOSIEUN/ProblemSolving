import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_7785 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		HashSet<String> company = new HashSet<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String cmd = st.nextToken();
			
			if (cmd.equals("enter")) {
				company.add(name);
			} else {
				company.remove(name);
			}
		}
		
		ArrayList<String> names = new ArrayList<>(company);
		Collections.sort(names, Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for (String name : names) {
			sb.append(name).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
