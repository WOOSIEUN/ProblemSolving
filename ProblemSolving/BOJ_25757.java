import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_25757 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int numOfPlayers = getNumOfPlayers(st.nextToken().charAt(0));
		
		HashSet<String> playedPlayers = new HashSet<>();
		
		int gameCnt = 0;
		int playerCnt = 0;
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			
			if (playedPlayers.contains(name)) {
				continue;
			}
			
			playedPlayers.add(name);
			if (++playerCnt == numOfPlayers) {
				gameCnt++;
				playerCnt = 0;
			}
		}
		
		bw.write(String.valueOf(gameCnt));
		br.close();
		bw.close();
	}
	
	private static int getNumOfPlayers(char game) {
		if (game == 'Y') {
			return 1;
		} else if (game == 'F') {
			return 2;
		} else {
			return 3;
		}
	}
}
