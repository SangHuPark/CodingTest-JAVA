import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 고객의 수를 저장하는 clientCount
 * 2. 회사, 집, N명의 고객 좌표를 저장하는 company, home, 1차원 배열 client
 * 3. 최소 거리를 저장하는 minDistance
 * 4. 방문할 고객의 순서를 저장하는
 * 	4-1. 순열을 생성하며 이동한 거리에 누적을 파라미터로 넘겨준다.
 * 	4-2. 순열 생성이 완성되면 최소 거리 저장
 * 	4-3. 중간에 생성된 순열에서 현재 최소 거리를 넘으면 백트래킹
 */
public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;

    public static int clientCount;

    public static int companyRow;
    public static int companyCol;
    public static int homeRow;
    public static int homeCol;
    public static int[] clientRow;
    public static int[] clientCol;

    public static int minDistance;

    public static boolean[] visitedCheckList;

    public static void visitPermutation(int selectIdx, int beforeRow, int beforeCol, int curDistance) {
        if(selectIdx == clientCount) {
            curDistance += Math.abs(beforeRow - homeRow)
                    + Math.abs(beforeCol - homeCol);

            if(curDistance < minDistance) {
                minDistance = curDistance;
            }

            return;
        }

        if(curDistance > minDistance) {
            return;
        }

        for(int clientIdx = 0; clientIdx < clientCount; clientIdx++) {
            if(visitedCheckList[clientIdx]) {
                continue;
            }

            visitedCheckList[clientIdx] = true;
            visitPermutation(selectIdx + 1,
                    clientRow[clientIdx], clientCol[clientIdx],
                    curDistance + DISTANCE(beforeRow, beforeCol, clientRow[clientIdx], clientCol[clientIdx]));

            visitedCheckList[clientIdx] = false;
        }
    }

    public static int DISTANCE(int beforeRow, int beforeCol, int curRow, int curCol) {
        return Math.abs(beforeRow - curRow)
                + Math.abs(beforeCol - curCol);
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine().trim());

        for(int tc = 1; tc <= testCase; tc++) {
            // 1. 고객의 수를 저장하는 clientCount
            clientCount = Integer.parseInt(br.readLine().trim());

            // 2. 회사, 집, N명의 고객 좌표를 저장하는 company, home, 1차원 배열 client
            st = new StringTokenizer(br.readLine().trim());
            companyRow = Integer.parseInt(st.nextToken());
            companyCol = Integer.parseInt(st.nextToken());
            homeRow = Integer.parseInt(st.nextToken());
            homeCol = Integer.parseInt(st.nextToken());
            clientRow = new int[clientCount];
            clientCol = new int[clientCount];
            for(int idx = 0; idx < clientCount; idx++) {
                clientRow[idx] = Integer.parseInt(st.nextToken());
                clientCol[idx] = Integer.parseInt(st.nextToken());
            }

            // 3. 최소 거리를 저장하는 minDistance
            minDistance = Integer.MAX_VALUE;

            // 4. 방문할 고객 순으로 순열을 저장하는 selectClientList
            visitedCheckList = new boolean[clientCount];

            visitPermutation(0, companyRow, companyCol, 0);

            sb.append("#").append(tc).append(" ").append(minDistance).append("\n");
        }

        System.out.println(sb);
    }
}