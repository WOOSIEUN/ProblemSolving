import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2812 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		Deque<Character> answer = new ArrayDeque<>();
		
		int numOfDeletion = 0;
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String input = br.readLine();
		for (char c : input.toCharArray()) {
			while (numOfDeletion < K && !answer.isEmpty() && c > answer.getLast()) {
				answer.removeLast();
				numOfDeletion++;
			}
			answer.addLast(c);
		}
		
		while (answer.size() > K - numOfDeletion) {
			sb.append(answer.removeFirst());
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
