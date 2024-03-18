import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_12919 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String S = br.readLine();
		String T = br.readLine();
		
		bw.write(restoreString(S, T) ? "1" : "0");
		br.close();
		bw.close();
	}

	private static boolean restoreString(String s, String t) {
		boolean flag = false;
		if (s.length() == t.length()) {
            if (s.equals(t)) {
                return flag = true;
            }
            return flag = false;
        }

        if (t.charAt(t.length() - 1) == 'A') {
        	flag |= restoreString(s, t.substring(0, t.length() - 1));	
        }
        
        if (t.charAt(0) == 'B') {
	            StringBuilder sb = new StringBuilder(t.substring(1));
	            flag |= restoreString(s, sb.reverse().toString());
	    }
		
		return flag;
	}
}
