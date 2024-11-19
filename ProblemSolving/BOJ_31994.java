import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_31994 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String maxLecture = "";
		int max = 0;
		for (int i = 0; i < 7; i++) {
			st = new StringTokenizer(br.readLine());
			String lecture = st.nextToken();
			int participant = Integer.parseInt(st.nextToken());
			
			if (max < participant) {
				max = participant;
				maxLecture = lecture;
			}
		}
		
		bw.write(maxLecture);
		br.close();
		bw.close();
	}
}
