import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_17609 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String target = br.readLine();
			sb.append(getTypeOfString(target, 0, target.length() - 1, 0)).append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	private static int getTypeOfString(String target, int start, int end, int type) {
		while (start < end) {
			if (target.charAt(start) != target.charAt(end)) {
				if (type == 0) {
					if (getTypeOfString(target, start + 1, end, 1) == 2 && getTypeOfString(target, start, end - 1, 1) == 2) {
						return 2;
					} else {
						return 1;
					}
				} else {
					return 2;
				}
			} else {
				start++;
				end--;
			}
		}
		return 0;
	}
}
