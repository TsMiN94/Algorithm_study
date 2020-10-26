package NHN2020;

import java.util.Arrays;
import java.util.Scanner;

public class No2 {
    private static void solution(int day, int width, int[][] blocks) {
        int answer = 0;
        int[] map = new int[width];

        for (int i = 0; i < day; i++) {
            for (int j = 0; j < width; j++) {
                map[j] += blocks[i][j];
            }
            System.out.println();
            System.out.println(Arrays.toString(map));

            for (int j = 0; j < width; j++) {
                if (j > 0 && j < width - 1) {
                    int pre = map[j - 1];
                    int cur = map[j];
                    int len = 0, next = 0, temp = cur;

                    if (pre > cur) {
                        for (int k = j + 1; k < width - 1; k++) {
                            next = map[k];
                            len++;
                            if (temp > next) {
                                temp = next;
                            } else if (temp < next) break;
                        }
                    }
                    int max = 0;
                    if (j + len < width) {
                        max = Math.min(pre, next);
                        for (int k = j; k < j + len; k++) {
                            answer += (max - map[k]);
                            map[k] += max - map[k];
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static class InputData {
        int day;
        int width;
        int[][] blocks;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.blocks = new int[inputData.day][inputData.width];
            for (int i = 0; i < inputData.day; i++) {
                String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
                for (int j = 0; j < inputData.width; j++) {
                    inputData.blocks[i][j] = Integer.parseInt(buf[j]);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.day, inputData.width, inputData.blocks);
    }

}
