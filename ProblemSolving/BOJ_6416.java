import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_6416 {
	
	static HashMap<Integer, Integer> parent; //<child, parent cnt>
	static boolean isRoot = false, isNParent = false;
	static int i, j, nodeCnt, edgeCnt, caseCnt = 0;;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while (true) {
			parent = new HashMap<Integer, Integer>();
			nodeCnt = edgeCnt = 0;
			isRoot = isNParent = false;
			caseCnt++;
			while(true) {
				while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
				i = Integer.parseInt(st.nextToken());
				j = Integer.parseInt(st.nextToken());
				if (i <= 0 && j <= 0) break;
				parent.put(i, parent.getOrDefault(i, 0));
				parent.put(j, parent.getOrDefault(j, 0) + 1);
				edgeCnt++;
			}
			if(i == -1 && j == -1) break;
			for (Integer node : parent.keySet()) {
				nodeCnt++;
				int curCnt = parent.get(node);
				if (curCnt == 0) isRoot = true;
			    if (parent.get(node) > 1) {
			    	isNParent = true;
			    	break;
			    }
			}
			if(nodeCnt==0 || (isRoot && !isNParent && nodeCnt == edgeCnt + 1)) sb.append("Case ").append(caseCnt).append(" is a tree.\n");
			else sb.append("Case ").append(caseCnt).append(" is not a tree.\n");			
		}		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}
