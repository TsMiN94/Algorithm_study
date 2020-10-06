package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class BJ14891 {
    static int gear[][] = new int[4][8];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            String g = br.readLine();
            for (int j = 0; j < 8; j++)
                gear[i][j] = g.charAt(j) - '0';
        }
        int s = Integer.parseInt(br.readLine());
        for (int i = 0; i < s; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearIdx = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            move(gearIdx - 1, dir);
        }
        int point = 1;
        for (int i = 0; i < 4; i++) {
            if (gear[i][0] == 1)
                answer += point;
            point *= 2;
        }
        System.out.println(answer);
    }

    private static void move(int gearIdx, int dir) {
        int leftGearIdx = gearIdx - 1;
        int rightGearIdx = gearIdx + 1;
        boolean rFlag = false, lFlag = false;
        int d[] = new int[4];
        rFlag = canRightRotate(gearIdx);
        lFlag = canLeftRotate(gearIdx);

        d[gearIdx] = dir;

        int leftDir = 0, rightDir = 0;
        if (dir == 1) {
            leftDir = -1;
            rightDir = -1;
        } else {
            leftDir = 1;
            rightDir = 1;
        }
        while (lFlag && leftGearIdx >= 0) {
            if (leftDir == 1) {
                lFlag = canRightRotate(leftGearIdx);
                d[leftGearIdx] = leftDir;
            } else {
                lFlag = canLeftRotate(leftGearIdx);
                d[leftGearIdx] = leftDir;
            }
            if (lFlag) leftGearIdx--;
            leftDir *= -1;
        }

        while (rFlag && rightGearIdx < 4) {
            if (rightDir == 1) {
                rFlag = canRightRotate(rightGearIdx);
                d[rightGearIdx] = rightDir;
            } else {
                rFlag = canLeftRotate(rightGearIdx);
                d[rightGearIdx] = rightDir;
            }
            if (rFlag) rightGearIdx++;
            rightDir *= -1;
        }

        for (int i = 0; i < 4; i++) {
            if (d[i] == 0) continue;
            if (d[i] == 1) {
                rotateRight(i);
            } else {
                rotateleft(i);
            }
        }
    }

    private static boolean canRightRotate(int gearIdx) {
        int curGearRightTeath = gear[gearIdx][2];
        if (gearIdx + 1 < 4 && curGearRightTeath != gear[gearIdx + 1][6]) {
            return true;
        } else return false;
    }

    private static boolean canLeftRotate(int gearIdx) {
        int curGearLeftTeath = gear[gearIdx][6];
        if (gearIdx - 1 >= 0 && curGearLeftTeath != gear[gearIdx - 1][2]) {
            return true;
        } else return false;
    }

    private static void rotateRight(int gearIdx) {
        int temp = gear[gearIdx][7];
        for (int i = 7; i > 0; i--) {
            gear[gearIdx][i] = gear[gearIdx][i - 1];
        }
        gear[gearIdx][0] = temp;
    }

    private static void rotateleft(int gearIdx) {
        int temp = gear[gearIdx][0];
        for (int i = 1; i < 8; i++) {
            gear[gearIdx][i - 1] = gear[gearIdx][i];
        }
        gear[gearIdx][7] = temp;
    }
}
