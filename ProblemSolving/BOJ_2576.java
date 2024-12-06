import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2576 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		final int numOfNums = 7;
		int sum = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < numOfNums; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (num % 2 == 0) {
				continue;
			}
			
			sum += num;
			min = Math.min(min, num);
		}
		
		StringBuilder sb = new StringBuilder();
		if (min == Integer.MAX_VALUE) {
			sb.append(-1);
		} else {
			sb.append(sum).append("\n").append(min);
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
