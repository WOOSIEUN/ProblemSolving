import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2109 {
	static class Lecture implements Comparable<Lecture> {
		int dueDate, fee;
		
		public Lecture(int fee, int dueDate) {
			this.dueDate = dueDate;
			this.fee = fee;
		}

		@Override
		public int compareTo(Lecture lecture) {
			if (lecture.fee == this.fee) {
				return this.dueDate - lecture.dueDate;
			}
			return lecture.fee - this.fee;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		Lecture[] lectures = new Lecture [n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());	
			lectures[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));			
		}
		
		Arrays.sort(lectures);
		
		int ans = 0;
		boolean[] schedule = new boolean [10001];
		for (int i = 0; i < n; i++) {
			for (int j = lectures[i].dueDate; j > 0; j--) {
				if (!schedule[j]) {
					ans += lectures[i].fee;
					schedule[j] = true;
					break;
				}
			}
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
