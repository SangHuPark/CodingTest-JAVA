import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        sb.append((A + B) % C).append("\n");
        sb.append(((A % C) + (B % C)) % C).append("\n");
        sb.append((A * B) % C).append("\n");
        sb.append(((A % C) * (B % C)) % C).append("\n");

        System.out.println(sb);
    }
}