package NHN2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class No1 {
    static User[] users;

    private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame) {
        users = new User[numOfAllPlayers - 1];
        char c = 'B';
        for (int i = 0; i < numOfAllPlayers - 1; i++) {
            users[i] = new User(c, 0);
            c++;
        }


        int loc = 0;
        int lastIndex = 0;

        //술래 인덱스
        int s = 0;
        User Sulae = new User('A', 1);

        for (int i = 0; i < numOfGames; i++) {
            boolean catchFlag = false;
            int offset = numOfMovesPerGame[i];

            while (Math.abs(offset) >= numOfAllPlayers - 1) {
                offset = offset / numOfAllPlayers - 1;
            }
            loc = s + offset;
            if (loc < 0) {
                loc = numOfAllPlayers - 1 + loc;
            }
            loc %= (numOfAllPlayers - 1);

            for (int j = 0; j < numOfQuickPlayers; j++) {
                if (namesOfQuickPlayers[j] == users[loc].c) {
                    Sulae.cnt++;
                    catchFlag = true;
                    break;
                }
            }
            if (catchFlag) {
                continue;
            }
            User temp = new User(users[loc].c, users[loc].cnt);
            users[loc] = new User(Sulae.c, Sulae.cnt);
            Sulae = temp;
            Sulae.cnt++;
            s = loc;
        }


        for (int i = 0; i < numOfAllPlayers - 1; i++) {
            System.out.println(users[i].c + " " + users[i].cnt);
        }
        System.out.println(Sulae.c + " " + Sulae.cnt);

    }

    private static class InputData {
        int numOfAllPlayers;
        int numOfQuickPlayers;
        char[] namesOfQuickPlayers;
        int numOfGames;
        int[] numOfMovesPerGame;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
            System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0, inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

            inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.numOfMovesPerGame = new int[inputData.numOfGames];
            String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
            for (int i = 0; i < inputData.numOfGames; i++) {
                inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
    }

    public static class User {
        char c;
        int cnt;

        public User(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }
    }
}
