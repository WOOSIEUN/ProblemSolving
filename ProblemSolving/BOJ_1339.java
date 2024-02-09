import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BOJ_1339 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[] numbers = new String[N];
		HashMap<Character, Integer> sumOfAlphabet = new HashMap<>();
		for (int i = 0; i < N; i++) {
			numbers[i] = br.readLine();
			
			int radix = (int) Math.pow(10, numbers[i].length() - 1);
			for (int j = 0; j < numbers[i].length(); j++) {
				sumOfAlphabet.put(numbers[i].charAt(j), sumOfAlphabet.getOrDefault(numbers[i].charAt(j), 0) + radix);
				radix /= 10;
			}
		}
		
		List<Integer> sum = new ArrayList<>(sumOfAlphabet.values());
		Collections.sort(sum, Collections.reverseOrder());
		
		int ans = 0;
		for (int i = 0, num = 9; i < sum.size(); i++, num--) {
			ans += sum.get(i) * num;
		}		
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
