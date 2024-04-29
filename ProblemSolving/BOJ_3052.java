import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class BOJ_3052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashSet<Integer> remains = new HashSet<>();
		for (int i = 0; i < 10; i++) {
			remains.add(Integer.parseInt(br.readLine()) % 42);
		}
		
		bw.write(String.valueOf(remains.size()));
		br.close();
		bw.close();
	}
}
