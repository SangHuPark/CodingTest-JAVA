import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [ init() ]
 * 1. 2차원 배열의 크기 N, 1차원 배열의 인덱스 K 입력
 *
 * [ findByBinarySearch(left, right) ]
 * 2. 이진탐색을 이용한 B[k] 찾기
 *  2-1. 임의의 mid 설정
 *  2-2. mid 를 기준으로 행을 돌면서 작거나 같은 원소의 개수를 누적
 *  2-3. 누적합이 K 보다 작다면 left 를 mid + 1 로 이동
 *      2-3-1. K 보다 크거나 같다면 right 를 mid 로 이동
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, k;

    public static void findByBinarySearch(long left, long right) {
        if(left >= right) {
            System.out.println(left);
            return;
        }

        long mid = (left + right) / 2;
        long curElementCount = 0;

        for (int row = 1; row <= N; row++) {
            curElementCount += Math.min(mid / row, N);
        }

        if(k <= curElementCount) {
            findByBinarySearch(left, mid);
        }
        else {
            findByBinarySearch(mid + 1, right);
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        findByBinarySearch(1, k);
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine().trim());
        k = Integer.parseInt(br.readLine().trim());
    }
}