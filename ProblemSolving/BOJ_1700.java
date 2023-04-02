import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1700 {
	
	static int N, K;
	static int[] schedule, plugs;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		plugs = new int [N];
		schedule = new int [K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			schedule[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < K; i++) {
			if (isPlugged(schedule[i])) {
				continue;
			}
			if (plugItemToEmptyPlug(schedule[i])) {
				continue;
			}
			plugs[getLastNeededPlug(i)] = schedule[i];
			ans++;
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
	
	public static boolean isPlugged(int targetItem) {
		for (int pluggedItem : plugs) {
			if (pluggedItem == targetItem) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean plugItemToEmptyPlug(int targetItem) {
		for (int i = 0; i < N; i++) {
			if (plugs[i] == 0) {
				plugs[i] = targetItem;
				return true;
			}
		}
		return false;
	}
	
	public static int getLastNeededPlug(int curScheduleIdx) {
		int plugIdx = -1, lastNeededCnt = -1;
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for(int j = curScheduleIdx + 1; j < K; j++) {
				if (plugs[i] == schedule[j]) {
					break;
				}
				cnt++;
			}
			if (cnt > lastNeededCnt) {
				plugIdx = i;
				lastNeededCnt = cnt;
			}
		}
		return plugIdx;
	}
}
