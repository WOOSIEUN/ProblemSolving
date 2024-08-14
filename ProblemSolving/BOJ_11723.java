import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_11723 {
	static class Set {
		private HashSet<Integer> set;
		
		public Set() {
			set = new HashSet<>();
		}
		
		public void add(int x) {
			set.add(x);
		}
		
		public void remove(int x) {
			set.remove(x);
		}
		
		public boolean check(int x) {
			return set.contains(x);
		}
		
		public void toggle(int x) {
			if (set.contains(x)) {
				set.remove(x);
			} else {
				set.add(x);
			}
		}
		
		public void all() {
			for (int i = 1; i <= 20; i++) {
				set.add(i);
			}
		}
		
		public void empty() {
			set.clear();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Set set = new Set();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			if (cmd.equals("all")) {
				set.all();
			} else if (cmd.equals("empty")) {
				set.empty();
			} else {
				int x = Integer.parseInt(st.nextToken());
				if (cmd.equals("add")) {
					set.add(x);
				} else if (cmd.equals("remove")) {
					set.remove(x);
				} else if (cmd.equals("check")) {
					sb.append(set.check(x) ? 1 : 0).append("\n");
				} else if (cmd.equals("toggle")) {
					set.toggle(x);
				}
			}			
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
