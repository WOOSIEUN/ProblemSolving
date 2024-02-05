import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1764 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> unheardPeople = new HashSet<>();
		for (int i = 0; i < N; i++) {
			unheardPeople.add(br.readLine());
		}
		
		ArrayList<String> unheardUnseenPeople = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			
			if (unheardPeople.contains(name)) {
				unheardUnseenPeople.add(name);
			}
		}
		
		Collections.sort(unheardUnseenPeople);
		
		StringBuilder sb = new StringBuilder();
		sb.append(unheardUnseenPeople.size()).append("\n");
		for (String name : unheardUnseenPeople) {
			sb.append(name).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
