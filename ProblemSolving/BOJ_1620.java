import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		HashMap<Integer, String> numToName = new HashMap<>();
		HashMap<String, Integer> nameToNum = new HashMap<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {
			String name = br.readLine();
			numToName.put(i, name);
			nameToNum.put(name, i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String query = br.readLine();
			
			if ('A' <= query.charAt(0) && query.charAt(0) <= 'Z') {
				sb.append(nameToNum.get(query)).append("\n");
			} else {
				sb.append(numToName.get(Integer.parseInt(query))).append("\n");
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
