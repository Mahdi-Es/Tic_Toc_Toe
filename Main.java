import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer> player1Position = new ArrayList<>();
    static ArrayList<Integer> player2Position = new ArrayList<>();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        char[][] gameDooz = {{' ', '|', ' ', '|', ' '},
                {'-', '-', '-', '-', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '-', '-', '-', '-'},
                {' ', '|', ' ', '|', ' '}};

        while (true) {
            int player1 = input.nextInt();

            while (player1Position.contains(player1) || player2Position.contains(player1)) {
                System.out.println("'player:' please choose another num!!");
                player1 = input.nextInt();
            }
            isPlace(gameDooz, player1, "player1");
            isPrint(gameDooz);

            String result = isCheckWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

            int player2 = input.nextInt();

            while (player1Position.contains(player2) || player2Position.contains(player2)) {
                player2 = input.nextInt();
            }
            isPlace(gameDooz, player2, "player2");

            isPrint(gameDooz);

            result = isCheckWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

        }
        input.close();


    }

    public static String isCheckWinner() {

        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> botttomRow = Arrays.asList(7, 8, 9);
        List<Integer> topCol = Arrays.asList(1, 4, 7);
        List<Integer> midCol = Arrays.asList(2, 5, 8);
        List<Integer> bottomCol = Arrays.asList(3, 6, 9);
        List<Integer> cross1 = Arrays.asList(1, 5, 9);
        List<Integer> cross2 = Arrays.asList(3, 5, 7);

        List<List> winner = new ArrayList<>();
        winner.add(topRow);
        winner.add(midRow);
        winner.add(botttomRow);
        winner.add(topCol);
        winner.add(midCol);
        winner.add(bottomCol);
        winner.add(cross1);
        winner.add(cross2);
        for (List l : winner) {
            if (player1Position.containsAll(l)) {
                return "Player1 win!";
            } else if (player2Position.containsAll(l)) {
                return "player2 is win!!";
            } else if (player1Position.size() + player2Position.size() == 9) {
                return "fuck of!!";
            }
        }
        return "";
    }

    public static void isPrint(char[][] gameDooz) {
        for (char[] row : gameDooz) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }

    }

    public static void isPlace(char[][] gameDooz, int pos, String user) {
        char symbol = ' ';
        if (user.equals("player1")) {
            symbol = '*';
            player1Position.add(pos);
        } else if (user.equals("player2")) {
            symbol = 'o';
            player2Position.add(pos);
        }
        switch (pos) {
            case 1:
                gameDooz[0][0] = symbol;
                break;
            case 2:
                gameDooz[0][2] = symbol;
                break;
            case 3:
                gameDooz[0][4] = symbol;
                break;
            case 4:
                gameDooz[2][0] = symbol;
                break;
            case 5:
                gameDooz[2][2] = symbol;
                break;
            case 6:
                gameDooz[2][4] = symbol;
                break;
            case 7:
                gameDooz[4][0] = symbol;
                break;
            case 8:
                gameDooz[4][2] = symbol;
                break;
            case 9:
                gameDooz[4][4] = symbol;
                break;
            default:
                break;
        }

    }
}