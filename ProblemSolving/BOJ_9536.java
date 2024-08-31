import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_9536 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 0; t < T; t++) {			
			ArrayList<String> animalSounds = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			
			int len = st.countTokens();
			for (int i = 0; i < len; i++) {
				animalSounds.add(st.nextToken());
			}
			
			String line = null;
			HashSet<String> soundSet = new HashSet<> ();
			while (!(line = br.readLine()).equals("what does the fox say?")) {
				st = new StringTokenizer(line);
				st.nextToken();
				st.nextToken();
				soundSet.add(st.nextToken());
			}
			
			for (int i = 0; i < animalSounds.size(); i++) {
				if (soundSet.contains(animalSounds.get(i))) {
					continue;
				}
				sb.append(animalSounds.get(i)).append(" ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
