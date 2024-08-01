import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2661 {
	
	static String goodSequence;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		makeGoodSequence(new String(), N);
		
		bw.write(goodSequence);
		br.close();
		bw.close();
	}

	private static void makeGoodSequence(String sequence, int N) {
		if (goodSequence != null) {
			return;
		}
		
		if (sequence.length() == N) {
			goodSequence = new String(sequence);
			return;
        }
		
		for (int num = 1; num <= 3; num++) {			
            if (isGoodSequence(sequence + num)) {
            	makeGoodSequence(sequence + num, N);
            }
        }
	}
	
	private static boolean isGoodSequence(String sequence) {
		for (int i = 1; i <= sequence.length() / 2; i++) {
			String left = sequence.substring(sequence.length() - i * 2, sequence.length() - i);
            String right = sequence.substring(sequence.length() - i, sequence.length());
			if (left.equals(right)) {
				return false;
			}
        }		
        return true;
	}
}
