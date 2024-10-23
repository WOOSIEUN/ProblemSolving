import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3758 {
	static class Team implements Comparable<Team> {
		int id, submitCnt, lastSubmitTime, totalScore;
		int[] scores;
		
		public Team(int id, int numOfProblems) {
			this.id = id;
			this.submitCnt = 0;
			this.lastSubmitTime = 0;
			this.totalScore = 0;
			this.scores = new int [numOfProblems];
		}

		@Override
		public int compareTo(Team team) {
			if (this.totalScore == team.totalScore) {
				if (this.submitCnt == team.submitCnt) {
					return this.lastSubmitTime - team.lastSubmitTime;
				}
				return this.submitCnt - team.submitCnt;
			}
			return team.totalScore - this.totalScore;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int targetId = Integer.parseInt(st.nextToken()) - 1;
			int M = Integer.parseInt(st.nextToken());
			
			Team[] teams = new Team[N];
			for (int i = 0; i < N; i++) {
				teams[i] = new Team(i, K);
			}
			
			for (int logTime = 0; logTime < M; logTime++) {
				st = new StringTokenizer(br.readLine());
				int id = Integer.parseInt(st.nextToken()) - 1;
				int problemNo = Integer.parseInt(st.nextToken()) - 1;
				int score = Integer.parseInt(st.nextToken());
				
				teams[id].submitCnt++;
				teams[id].lastSubmitTime = logTime;
				teams[id].scores[problemNo] = Math.max(teams[id].scores[problemNo], score);	
			}

			for (int i = 0; i < N; i++) {
				teams[i].totalScore = Arrays.stream(teams[i].scores).sum();
			}
			
			Arrays.sort(teams);
			
			for (int rank = 0; rank < teams.length; rank++) {
				if (teams[rank].id == targetId) {
					sb.append(rank + 1).append("\n");
			        break;
				}
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
