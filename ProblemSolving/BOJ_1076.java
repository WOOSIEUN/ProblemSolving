import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, Integer> resistanceIndex = new HashMap<String, Integer>(){{
            put("black", 0);
            put("brown", 1);
            put("red", 2);
            put("orange", 3);
            put("yellow", 4);
            put("green", 5);
            put("blue", 6);
            put("violet", 7);
            put("grey", 8);
            put("white", 9);
        }};

        HashMap<String, Integer> resistanceValue = new HashMap<String, Integer>(){{
            put("black", 1);
            put("brown", 10);
            put("red", 100);
            put("orange", 1000);
            put("yellow", 10000);
            put("green", 100000);
            put("blue", 1000000);
            put("violet", 10000000);
            put("grey", 100000000);
            put("white", 1000000000);
        }};

        long ans = resistanceIndex.get(br.readLine()) * 10 + resistanceIndex.get(br.readLine());
        ans *= resistanceValue.get(br.readLine());

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
