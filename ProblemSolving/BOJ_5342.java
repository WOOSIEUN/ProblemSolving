import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_5342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, Double> itemCost = new HashMap<>();
        itemCost.put("Paper", 57.99);
        itemCost.put("Printer", 120.50);
        itemCost.put("Planners", 31.25);
        itemCost.put("Binders", 22.50);
        itemCost.put("Calendar", 10.95);
        itemCost.put("Notebooks", 11.20);
        itemCost.put("Ink", 66.95);

        double ans = 0;
        String item = null;
        while (!(item = br.readLine()).equals("EOI")) {
            ans += itemCost.get(item);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("$").append(ans);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
