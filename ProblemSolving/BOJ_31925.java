import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_31925 {
	static class Participant {
		String name;
		int score;
		
		public Participant(String name, int score) {
			this.name = name;
			this.score = score;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		List<Participant> students = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			
			if (st.nextToken().equals("hewhak")|| st.nextToken().equals("winner")) {
				continue;
			}
			
			int shake = Integer.parseInt(st.nextToken());
			if (0 < shake && shake < 4) {
				continue;
			}
			
			students.add(new Participant(name, Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(students, (p1, p2) -> p1.score - p2.score);
		
		List<Participant> participants = students.subList(0, students.size() > 10 ? 10 : students.size());
		Collections.sort(participants, (p1, p2) -> p1.name.compareTo(p2.name));
		
		StringBuilder sb = new StringBuilder();
		sb.append(participants.size()).append("\n");
		for (Participant participant : participants) {
			sb.append(participant.name).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
