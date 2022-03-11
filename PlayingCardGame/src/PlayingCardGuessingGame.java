import java.util.Random;
import java.util.Scanner;

public class PlayingCardGuessingGame {

    static final Scanner SCANNER = new Scanner(System.in);
    static final Random RANDOM = new Random();

    // #region トランプの数字とか図柄
    static final int JACK_NUMBER = 11;
    static final int QUEEN_NUMBER = 12;
    static final int KING_NUMBER = 13;
    static final String JACK = "J";
    static final String QUEEN = "Q";
    static final String KING = "K";

    static final String HEART = "ハート";
    static final String DIAMOND = "ダイヤ";
    static final String SPADE = "スペード";
    static final String CLOVER = "クローバー";
    static final int HEART_NUMBER = 0;
    static final int DIAMOND_NUMBER = 1;
    static final int SPADE_NUMBER = 2;
    static final int CLOVER_NUMBER = 3;
    // #endregion
    static final String DESIGN_MESSAGE = "%d:%s\n";
    static final String CORRECT_MESSAGE = "正解!図柄は%sだよ\n";
    static final String MISTAKE_MESSAGE = "残念!%sじゃないよ\n";
    static final String QUESTION_MESSAGE = "どれだと思う?:";

    static final int ICON_UPPER_LIMIT = 4;
    static final int CARD_UPPER_LIMIT = 13;
    static final int CARD_UNDER_LIMIT = 1;

    static final int PLAYING_CARD_ICON = RANDOM.nextInt(ICON_UPPER_LIMIT);
    static final int PLAYING_CARD_NUMBER = RANDOM.nextInt(CARD_UPPER_LIMIT) + CARD_UNDER_LIMIT;
    static PlayingCardGuessingGame playingCardGuessingGame = new PlayingCardGuessingGame();

    public static void main(String[] args) {
        introMessage();
        iconQuiz();
        nextQuizMessage();
        numberQuiz();
        playingCardGuessingGame.answer(PLAYING_CARD_ICON, PLAYING_CARD_NUMBER);
    }

    static private void nextQuizMessage() {
        System.out.print("次は数字を当ててね\n");
    }

    static private void introMessage() {
        System.out.println("トランプを選んだよ");
        System.out.println("トランプの図柄を当ててね");
        System.out.printf(DESIGN_MESSAGE, HEART_NUMBER, HEART);
        System.out.printf(DESIGN_MESSAGE, DIAMOND_NUMBER, DIAMOND);
        System.out.printf(DESIGN_MESSAGE, SPADE_NUMBER, SPADE);
        System.out.printf(DESIGN_MESSAGE, CLOVER_NUMBER, CLOVER);
    }

    static private void iconQuiz() {
        int inputIconAnswer = 0;
        questionMessage();
        inputIconAnswer = SCANNER.nextInt();
        if (playingCardGuessingGame.isIconGuessing(inputIconAnswer, PLAYING_CARD_ICON)) {
            playingCardGuessingGame.iconGuessing(inputIconAnswer);
        } else {
            iconQuiz();
        }
    }

    static private void numberQuiz() {
        String inputCardNumber = "";
        questionMessage();
        inputCardNumber = SCANNER.next();
        if (!playingCardGuessingGame.isNumberGuessing(inputCast(inputCardNumber), PLAYING_CARD_NUMBER)) {
            numberQuiz();
        }
    }

    static private void questionMessage() {
        System.out.print(QUESTION_MESSAGE);
    }

    // #region 図柄が正解だった時
    private void iconGuessing(int inputIconAnswer) {
        switch (inputIconAnswer) {
            case HEART_NUMBER:
                correctMessage(HEART);
                break;
            case DIAMOND_NUMBER:
                correctMessage(DIAMOND);
                break;
            case SPADE_NUMBER:
                correctMessage(SPADE);
                break;
            case CLOVER_NUMBER:
                correctMessage(CLOVER);
                break;
        }
    }

    private void correctMessage(String icon) {
        System.out.printf(CORRECT_MESSAGE, icon);
    }
    // #endregion

    // #region 絵柄の判定
    private boolean isIconGuessing(int inputIconAnswer, final int PLAYING_CARD_ICON) {
        boolean isGuessing = false;
        if (inputIconAnswer == PLAYING_CARD_ICON) {
            isGuessing = true;
        } else {
            iconMisMessage(inputIconAnswer);
        }
        return isGuessing;
    }

    private static void iconMisMessage(int inputIconAnswer) {
        switch (inputIconAnswer) {
            case HEART_NUMBER:
                misTakeMessage(HEART);
                break;
            case DIAMOND_NUMBER:
                misTakeMessage(DIAMOND);
                break;
            case SPADE_NUMBER:
                misTakeMessage(SPADE);
                break;
            case CLOVER_NUMBER:
                misTakeMessage(CLOVER);
                break;
        }
    }
    // #endregion

    // #region 数字の判定
    private boolean isNumberGuessing(int inputNumber, final int PLAYING_CARD_NUMBER) {
        boolean isGuessing = false;
        if (inputNumber == PLAYING_CARD_NUMBER) {
            isGuessing = true;
        } else {
            mistakenNumber(inputNumber);
        }
        return isGuessing;
    }

    private static void mistakenNumber(int inputNumber) {
        switch (inputNumber) {
            case JACK_NUMBER:
                misTakeMessage(JACK);
                break;
            case QUEEN_NUMBER:
                misTakeMessage(QUEEN);
                break;
            case KING_NUMBER:
                misTakeMessage(KING);
                break;
            default:
                String input = String.valueOf(inputNumber);
                misTakeMessage(input);
                break;
        }
    }

    // #endregion
    static private void misTakeMessage(String mistakenAnswer) {
        System.out.printf(MISTAKE_MESSAGE, mistakenAnswer);
    }

    // #region 正解の時に呼び出す
    private void answer(int PLAYING_CARD_ICON, int PLAYING_CARD_NUMBER) {
        System.out.printf("正解!%sの%sだよ", answerIcon(), answerNumber());
    }

    private static String answerIcon() {
        String icon = "";
        switch (PLAYING_CARD_ICON) {
            case HEART_NUMBER:
                icon = HEART;
                break;
            case DIAMOND_NUMBER:
                icon = DIAMOND;
                break;
            case SPADE_NUMBER:
                icon = SPADE;
                break;
            case CLOVER_NUMBER:
                icon = CLOVER;
                break;
        }
        return icon;
    }

    private static String answerNumber() {
        String number = "";
        switch (PLAYING_CARD_NUMBER) {
            case JACK_NUMBER:
                number = JACK;
                break;
            case QUEEN_NUMBER:
                number = QUEEN;
                break;
            case KING_NUMBER:
                number = KING;
                break;
            default:
                number = Integer.toString(PLAYING_CARD_NUMBER);
                break;
        }
        return number;
    }
    // #endregion

    public static int inputCast(String answer) {
        int castNum = 0;
        switch (answer) {
            case JACK:
                castNum = JACK_NUMBER;
                break;
            case QUEEN:
                castNum = QUEEN_NUMBER;
                break;
            case KING:
                castNum = KING_NUMBER;
                break;
            default:
                castNum = Integer.parseInt(answer);
                break;
        }
        return castNum;
    }
}
