import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_3107 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String ip = br.readLine();
		if (ip.contains("::")) {
			ip = ip.replace("::", ":zero:");
		}
		
		StringTokenizer st = new StringTokenizer(ip, ":");
		List<String> originalList = new ArrayList<>();
		while (st.hasMoreTokens()) {
			originalList.add(st.nextToken());
		}
		List<String> zeroAddedList = new ArrayList<>();
		for(int i = 0; i < originalList.size(); i++) {
			StringBuilder sb = new StringBuilder();
			String group = originalList.get(i);
			
			while (group.length() + sb.length() < 4) {
				sb.append("0");
			}
			
			zeroAddedList.add(sb.append(group).toString());
		}
		
		StringBuilder sb = new StringBuilder();
		for (int zeroAddedIdx = 0; zeroAddedIdx < zeroAddedList.size(); zeroAddedIdx++) {
			String group = zeroAddedList.get(zeroAddedIdx);
			if (group.equals("zero")) {
				int zeroGroupLen = 8 - zeroAddedList.size() + 1;
				while (zeroGroupLen-- > 0) {
					sb.append("0000:");
				}
			}else {
				sb.append(group).append(":");
			}
		}
		
		bw.write(sb.deleteCharAt(sb.length() - 1).toString());
		br.close();
		bw.close();
	}
}
