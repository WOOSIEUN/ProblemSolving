import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;

public class BOJ_4358 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		TreeMap<String, Integer> trees = new TreeMap<>();
		
		int numOfTrees = 0;
		String tree = "";
		for (;;numOfTrees++) {
		    if ((tree = br.readLine()) == null) {
		    	break;
		    }
		    trees.put(tree, trees.getOrDefault(tree, 0) + 1);
		}
		
		StringBuilder sb = new StringBuilder();
		for (String key : trees.keySet()) {
			sb.append(key).append(" ").append(String.format("%.4f", (double) trees.get(key) / numOfTrees * 100)).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
