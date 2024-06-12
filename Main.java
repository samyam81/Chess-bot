import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random(System.currentTimeMillis());
        Chess c = new Chess("ArasDasDas", Chess.WHITE_BOT_DIFFICULTY, "Kobbie", Chess.BLACK_BOT_DIFFICULTY);
        if (Chess.AGAINST_BOT) {
            do {
                c.printBoard();
                if (Chess.TWO_BOTS) {
                    while (c.botsTurn())
                        ;
                } else {
                    if (Chess.BOT_IS_WHITE) {
                        while (true) {
                            if (!c.botsTurn())
                                break;
                            if (!c.playersTurn())
                                break;
                        }
                    } else {
                        while (true) {
                            if (!c.playersTurn())
                                break;
                            if (!c.botsTurn())
                                break;
                        }
                    }
                }
            } while (c.gameOver());
            System.exit(0);
        }
        Scanner scanner = new Scanner(System.in);
        do {
            c.printBoard();
            while (c.playersTurn(scanner))
                ;
        } while (c.gameOver());
    }
}
