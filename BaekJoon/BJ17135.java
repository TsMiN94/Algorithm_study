package BaekJun;

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
 * [�������]
 * �ü� 3�� ��ġ - ������ ���¿��� �ùķ��̼����� ���� �̵�
 * ���� - 1�� ���� ����: ����� �༮, 2�� ���� ����: ����
 * ���� �ü��� �� ���� ���� Ÿ������ �� �ִ�.
 * - ù ��° �ü��� ���� �׿�������... �ι�° �ü��� ����� ��Ȳ
 * - ǥ���� �߰����� ���� �׿������� �ȵǰڱ���. ǥ�ø� �ϰ� ���� ���� �� �� ��� - List, �켱����(����)
 * - ������ �ü��� �Ÿ��� : |r1-r2| + |c1-c2|
 * ������
 * - �� ���� ������ �Ʒ��θ� �̵� - r ++
 * - ȭ�쿡 �¾� �װų� �� ������ ĭ���� �̵��ϸ� �������.
 * ������
 * - ��� ���� �����ǿ��� �������� ������.
 * 
 * [�Է»���]
 * ���� �� N, ���� �� M, �ü��� ���� �Ÿ� ���� D
 * 0�� �� ĭ, 1�� ���� �ִ� ĭ
 * [��»���]
 * �ü��� �������� ������ �� �ִ� ���� �ִ� ��
 */
public class BJ17135 {
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
        // �Է� ó�� �Ϸ�
        // �ü��� ��ġ�Ѵ�. - ������ ��� ���� ��ġ�� - >> ����
        makeCombination(3, 0, new int[3]);
        // ��� ���
        System.out.println(MAX);
    }

    // ���� �Ϸ�!! --> ���� �غ���.
    static void check(int[] position) {
        // ������� ������ ��Ƽ� ����غ���. --> List���� �������
        // map���� ���� ���� ��ƺ���.
        List<Enemy> enemies = new ArrayList<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == 1) {
                    enemies.add(new Enemy(r, c));
                }
            }
        }
        // System.out.println("�ʱ� ���� ����" + enemies);

        int deadMan = 0;
        while (true) {
            // �ü� �߻�
            for (int i = 0; i < position.length; i++) {
                // �� �༮���� ��ƺ���.
                List<Enemy> target = new ArrayList<>();
                int archer = position[i];
                // archer�� �������� ������� �Ÿ� �������� �� �� �ִ� �� Ȯ��.
                for (int e = 0; e < enemies.size(); e++) {
                    Enemy enemy = enemies.get(e);
                    // �Ÿ� ����غ���
                    enemy.d = Math.abs(archer - enemy.c) + Math.abs(R - enemy.r);
                    // Ÿ���� �Ÿ� �ȿ� �ִٰ� �ؼ� ���̸� �ȵǿ�~~~
                    if (enemy.d <= D) {
                        target.add(enemy);
                    }
                }
                // Ÿ���� �ִٸ� �����ؼ� ���� �켱 ������ ���� �𿡰� ǥ��
                if (!target.isEmpty()) {
                    Collections.sort(target);
                    target.get(0).isTargeted = true;
                }
            } // �ü����� �� �༮���� ���� �Ǿ����.

            // ���� ��� �̵�, ���� ó��
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
            } // ó�� ����..
              // ��� ���簡 ����ϸ� ����..
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
        int r, c, d;// d: �ü����� �Ÿ�
        boolean isTargeted;// ��� �������� ����

        public Enemy(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "[" + r + "," + c + ", d=" + d + "]";
        }

        @Override
        // 1�� ���� ����: ����� �༮, 2�� ���� ����: ����
        public int compareTo(Enemy o) {
            if (this.d == o.d) {
                return Integer.compare(this.c, o.c);
            } else {
                return Integer.compare(this.d, o.d);
            }
        }
    }

   
}
