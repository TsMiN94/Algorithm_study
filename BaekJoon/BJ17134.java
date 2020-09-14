import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author itsmeyjc
 * @since 2020. 8. 7
 * @see
 * @mem
 * @time
 * @caution
 * 
 * [고려사항]
 * 궁수 3명 배치 - 조합의 상태에서 시뮬레이션으로 적군 이동
 * 적군 - 1차 정렬 기준: 가까운 녀석, 2차 정렬 기준: 왼쪽
 * 여러 궁수가 한 명의 적을 타겟팅할 수 있다.
 * - 첫 번째 궁수가 쏴서 죽여버리면... 두번째 궁수가 못쏘는 상황
 * - 표적을 발견하자 마자 죽여버리면 안되겠구나. 표시만 하고 턴이 종료 될 때 쏘기 - List, 우선순위(정렬)
 * - 적군과 궁수의 거리는 : |r1-r2| + |c1-c2|
 * 적군은
 * - 한 턴이 끝나면 아래로만 이동 - r ++
 * - 화살에 맞아 죽거나 맨 마지막 칸으로 이동하면 사라진다.
 * 게임은
 * - 모든 적이 격자판에서 없어지면 끝난다.
 * 
 * [입력사항]
 * 행의 수 N, 열의 수 M, 궁수의 공격 거리 제한 D
 * 0은 빈 칸, 1은 적이 있는 칸
 * [출력사항]
 * 궁수의 공격으로 제거할 수 있는 적의 최대 수
 */
public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int R, C, D;
    static int[][] map;
    static int MAX;

    public static void main(String[] args) throws IOException {
      
        tokens = new StringTokenizer(input.readLine(), " ");

        R = Integer.parseInt(tokens.nextToken());
        C = Integer.parseInt(tokens.nextToken());
        D = Integer.parseInt(tokens.nextToken());
        map = new int[R][C];
        for (int r = 0; r < R; r++) {
            tokens = new StringTokenizer(input.readLine(), " ");
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(tokens.nextToken());
            }
        }
        /*        for(int [] row: map) {
            System.out.println(Arrays.toString(row));
        }*/
        // 입력 처리 완료
        // 궁수를 배치한다. - 순서와 상관 없이 배치됨 - >> 조합
        makeCombination(3, 0, new int[3]);
        // 결과 출력
        System.out.println(MAX);
    }

    // 조합 완료!! --> 공격 해보기.
    static void check(int[] position) {
        // 병사들의 정보만 모아서 사용해보자. --> List에서 병사관리
        // map에서 병사 정보 모아보자.
        List<Enemy> enemies = new ArrayList<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == 1) {
                    enemies.add(new Enemy(r, c));
                }
            }
        }
        // System.out.println("초기 병사 정보" + enemies);

        int deadMan = 0;
        while (true) {
            // 궁수 발사
            for (int i = 0; i < position.length; i++) {
                // 쏠 녀석들을 모아보자.
                List<Enemy> target = new ArrayList<>();
                int archer = position[i];
                // archer가 적군들을 대상으로 거리 기준으로 쏠 수 있는 지 확인.
                for (int e = 0; e < enemies.size(); e++) {
                    Enemy enemy = enemies.get(e);
                    // 거리 계산해보기
                    enemy.d = Math.abs(archer - enemy.c) + Math.abs(R - enemy.r);
                    // 타겟이 거리 안에 있다고 해서 죽이면 안되요~~~
                    if (enemy.d <= D) {
                        target.add(enemy);
                    }
                }
                // 타겟이 있다면 정렬해서 가장 우선 순위가 높은 놈에게 표시
                if (!target.isEmpty()) {
                    Collections.sort(target);
                    target.get(0).isTargeted = true;
                }
            } // 궁수들이 쏠 녀석들이 결정 되었어요.

            // 실제 쏘고 이동, 종료 처리
            for (int e = 0; e < enemies.size(); e++) {
                Enemy enemy = enemies.get(e);
                if (enemy.isTargeted) {
                    enemies.remove(enemy);
                    e--;
                    deadMan++;
                } else if (enemy.r == R - 1) {
                    enemies.remove(enemy);
                    e--;
                } else {
                    enemy.r++;
                }
            } // 처리 종료..
              // 모든 병사가 사망하면 종료..
            if (enemies.size() == 0) {
                break;
            }
        }
        MAX = Math.max(MAX, deadMan);
    }

    static void makeCombination(int r, int start, int[] temp) {
        if (r == 0) {
            check(temp);
            return;
        }
        for (int i = start; i < C; i++) {
            temp[r - 1] = i;
            makeCombination(r - 1, i + 1, temp);
        }
    }

    static class Enemy implements Comparable<Enemy> {
        int r, c, d;// d: 궁수와의 거리
        boolean isTargeted;// 사망 가능한지 여부

        public Enemy(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "[" + r + "," + c + ", d=" + d + "]";
        }

        @Override
        // 1차 정렬 기준: 가까운 녀석, 2차 정렬 기준: 왼쪽
        public int compareTo(Enemy o) {
            if (this.d == o.d) {
                return Integer.compare(this.c, o.c);
            } else {
                return Integer.compare(this.d, o.d);
            }
        }
    }

   
}
