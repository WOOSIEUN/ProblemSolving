import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_15080 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer start = new StringTokenizer(br.readLine(), " : ");
		StringTokenizer end = new StringTokenizer(br.readLine(), " : ");
		
		int time = (Integer.parseInt(end.nextToken()) - Integer.parseInt(start.nextToken())) * 3600;
		time += (Integer.parseInt(end.nextToken()) - Integer.parseInt(start.nextToken())) * 60;
		time += (Integer.parseInt(end.nextToken()) - Integer.parseInt(start.nextToken()));
		
		bw.write(String.valueOf(time < 0 ? time + 24 * 3600 : time));
		br.close();
		bw.close();
	}
}
