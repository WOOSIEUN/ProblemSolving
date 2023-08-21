import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_7662 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int k = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> treeMap = new TreeMap<>();
	        for (int i = 0; i < k; i++) {
	        	st = new StringTokenizer(br.readLine());
	        	char cmd = st.nextToken().charAt(0);
	            int num = Integer.parseInt(st.nextToken());
	            
	            if (cmd == 'I') {
	            	treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
	            } else if (!treeMap.isEmpty()) {
	            	int key = (num == -1 ? treeMap.firstKey() : treeMap.lastKey());
					int cnt = treeMap.get(key);
	                if (cnt == 1){
	                    treeMap.remove(key);
	                } else {                
	                    treeMap.put(key, cnt - 1);
	                }
	            }
	        }

	        if (treeMap.isEmpty()) {
	        	sb.append("EMPTY\n");
	        } else {
	        	sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append("\n");
	        }
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
