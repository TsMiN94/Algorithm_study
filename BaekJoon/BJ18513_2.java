package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ18513_2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens = null;
    static int N, K;
    static long sum;  // 치킨집갯수, 집갯수, 치킨거리
    static boolean[] road;  // 해당 지점이 쓰는지 안쓰는지 위한 배열.
    static Queue<Integer[]> q = new LinkedList<>();  // 치킨거리와 집의 위치를 특정하기 위해 쓰는 큐
    final static int plus = 100000000;  // 음수를 양수화 시키기 위해서 백만을 더하기 위한 변수

    public static void main(String[] args) throws IOException {

        tokens = new StringTokenizer(input.readLine());

        N = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());

        road = new boolean[plus * 2 + 2];  // 배열을 음수로 표현이 불가능하므로 음수의 값만큼 더하여서 양수로 바꿔준다.
        // 즉, 인덱스를 plus만큼 더하여서 저장하게 된다.

        tokens = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i ++) {
            Integer tmp = Integer.parseInt(tokens.nextToken());
            q.add(new Integer[]{tmp + 1 + plus, 1});  // 큐에는 현재의 치킨집 위치의 위 아래를 저장하고
            q.add(new Integer[]{tmp - 1 + plus, 1});
            road[tmp + plus] = true;  // 해당 지점은 치킨집이 쓰고있으므로 거리는 더하지 않고 체크만 해준다.
        }

        while (true) {  // 조건에 의해 탈출할때까지 계속해서 진행
            if (K ==0){  // 만약 K가 0이 됬다면 집을 차례로 배치하였으므로 치킨거리를 출력하고 탈출.
                System.out.println(sum);
                break;
            }
            Integer[] tmp = q.remove();  // 큐에 저장된 위치와 치킨거리를 받아주고 큐에서 제거한다.
            if (road[tmp[0]] ==false){  // 만약 해당 위치가 쓰고 있지 않다면 집을 놓을 수 있다.
                K --;
                sum += tmp[1];  // 집을 놓고 치킨거리에 더해준다.
                if (tmp[0] + 1 <= plus * 2 + 1) {  // 만약 현재 위치에서 1 더한값이 배열을 벗어난다면 놓지 못하고
                    q.add(new Integer[]{tmp[0] + 1, tmp[1] + 1});  // 벗어나지 않는다면 현재 위치와 치킨거리에 각각 1을 더하여 큐에 저장한다.
                }
                if (tmp[0] - 1 >= 0) {  // 만약 현재 위치에서 1 뺀값이 배열을 벗어난다면 놓지 못하고
                    q.add(new Integer[]{tmp[0] - 1, tmp[1] + 1});  // 벗어나지 않는다면 현재 위치에는 1을 빼고 치킨거리에 1을 더하여 큐에 저장한다.
                }
                road[tmp[0]] = true;  // 해당 지점은 집을 놓음 처리한다.
            }
        }
    }
}

