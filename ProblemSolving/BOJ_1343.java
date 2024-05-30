import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1343 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		boolean available = true;
		char[] board = br.readLine().toCharArray();
		for (int i = 0; i < board.length; i++) {
			if (board[i] == 'X') {
				if (i < board.length - 3 && board[i + 1] == 'X' && board[i + 2] == 'X' && board[i + 3] == 'X') {
					board[i] = 'A';
					board[i + 1] = 'A';
					board[i + 2] = 'A';
					board[i + 3] = 'A';
				} else if (i < board.length - 1 && board[i + 1] == 'X') {
					board[i] = 'B';
					board[i + 1] = 'B';
				} else {
					available = false;
					break;
				}
			}
		}

		bw.write(available ? String.valueOf(board) : "-1");
		br.close();
		bw.close();
	}
}
