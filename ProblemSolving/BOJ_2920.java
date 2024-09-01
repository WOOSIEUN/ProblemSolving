import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] notes = new int [8];
		for (int i = 0; i < notes.length; i++) {
			notes[i] = Integer.parseInt(st.nextToken());
		}
		
		bw.write(findType(notes));
		br.close();
		bw.close();
	}

	private static String findType(int[] notes) {
		if (isAscending(notes)) {
			return "ascending";
		} else if (isDescending(notes)) {
			return "descending";
		} else {
			return "mixed";
		}
	}

	private static boolean isDescending(int[] notes) {
		for (int i = 0; i < notes.length; i++) {
			if (notes[i] != notes.length - i) {
				return false;
			}
		}
		return true;
	}

	private static boolean isAscending(int[] notes) {
		for (int i = 0; i < notes.length; i++) {
			if (notes[i] != i + 1) {
				return false;
			}
		}
		return true;
	}
}
