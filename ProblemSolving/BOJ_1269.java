import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1269 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int lenA = Integer.parseInt(st.nextToken());
		int lenB = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> setA = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < lenA; i++) {
			setA.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		int intersection = 0;
		for (int i = 0; i < lenB; i++) {
			if (setA.contains(Integer.parseInt(st.nextToken()))) {
				intersection++;
			}
		}		
		
		bw.write(String.valueOf(lenA + lenB - (2 * intersection)));
		br.close();
		bw.close();
	}
}
