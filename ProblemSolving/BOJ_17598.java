import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        final int numOfAnimals = 9;
        int lion = 0;
        for (int i = 0; i < numOfAnimals; i++) {
            lion += (br.readLine().equals("Lion") ? 1 : 0);
        }

        bw.write(lion > (int) numOfAnimals / 2 ? "Lion" : "Tiger");
        br.close();
        bw.close();
    }
}