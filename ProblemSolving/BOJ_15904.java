import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_15904 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] target = {'U', 'C', 'P', 'C'};
		char[] line = br.readLine().toCharArray();
		
		boolean abbreviable = false;
		for (int targetIdx = 0, lineIdx = 0; lineIdx < line.length; lineIdx++) {
			if (target[targetIdx] == line[lineIdx]) {
				if (++targetIdx == target.length) {
					abbreviable = true;
					break;
				}
			}
		}
		
		bw.write(abbreviable ? "I love UCPC" : "I hate UCPC");
		br.close();
		bw.close();
	}
}
