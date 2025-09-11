import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_22232 {
    static class File implements Comparable<File> {
        String name, extension;

        public File(String name, String extension) {
            this.name = name;
            this.extension = extension;
        }

        @Override
        public int compareTo(File o) {
            if (name.equals(o.name)) {
                if (extensionSet.contains(extension) && !extensionSet.contains(o.extension)) {
                    return -1;
                } else if (!extensionSet.contains(extension) && extensionSet.contains(o.extension)) {
                    return 1;
                } else {
                    return extension.compareTo(o.extension);
                }
            }
            return name.compareTo(o.name);
        }
    }

    static HashSet<String> extensionSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        File[] files = new File[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), ".");
            files[i] = new File(st.nextToken(), st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            extensionSet.add(br.readLine());
        }

        Arrays.sort(files);

        StringBuilder sb = new StringBuilder();
        for (File file : files) {
            sb.append(file.name).append(".").append(file.extension).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
