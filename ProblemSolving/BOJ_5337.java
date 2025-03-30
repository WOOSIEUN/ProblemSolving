import java.io.*;

public class BOJ_5337 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringBuilder sb = new StringBuilder();
		sb.append(".  .   .\n");
		sb.append("|  | _ | _. _ ._ _  _\n");
		sb.append("|/\\|(/.|(_.(_)[ | )(/.\n");
        
        bw.write(sb.toString());
        bw.close();
    }
}