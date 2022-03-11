import java.util.Random;
import java.util.Scanner;

public class PlayingCardGuessingGame {
    public static void main(String[] args) {
        PlayingCardGuessingGame playingCardGuessingGame = new PlayingCardGuessingGame();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        // 0:ハート,1:ダイヤ,2:スペード,3:クローバー
        final int PLAYING_CARD_ICON = random.nextInt(4);
        final int PLAYING_CARD_NUMBER = random.nextInt(13) + 1;
        int inputIconAnswer = 0;// 正解の範囲外で初期化
        String inputCardNumber = "";

        System.out.print("トランプを選んだよ\n");
        System.out.print("トランプの図柄を当ててね\n");
        System.out.print("0:ハート\n");
        System.out.print("1:ダイヤ\n");
        System.out.print("2:スペード\n");
        System.out.print("3:クローバー\n");
        while (true) {
            System.out.print("どれだと思う？:");
            inputIconAnswer = scanner.nextInt();
            if (playingCardGuessingGame.isIconGuessing(inputIconAnswer, PLAYING_CARD_ICON)) {
                playingCardGuessingGame.iconGuessing(inputIconAnswer);
                break;
            }
        }
        System.out.print("次は数字を当ててね\n");
        while (true) {
            System.out.print("どれだと思う?:");
            inputCardNumber = scanner.next();
            if (playingCardGuessingGame.isNumberGuessing(inputCast(inputCardNumber), PLAYING_CARD_NUMBER)) {
                break;
            }
        }
        playingCardGuessingGame.answer(PLAYING_CARD_ICON, PLAYING_CARD_NUMBER);
    }

    // #region 図柄が正解だった時
    private void iconGuessing(int inputIconAnswer) {
        switch (inputIconAnswer) {
            case 0:
                System.out.print("正解!図柄はハートだよ\n");
                break;
            case 1:
                System.out.print("正解!図柄はダイヤだよ\n");
                break;
            case 2:
                System.out.print("正解!図柄はスペードだよ\n");
                break;
            case 3:
                System.out.print("正解!図柄はクローバーだよ\n");
                break;
        }
    }
    // #endregion

    // #region 絵柄の判定
    private boolean isIconGuessing(int inputIconAnswer, final int PLAYING_CARD_ICON) {
        boolean isGuessing = false;
        if (inputIconAnswer == PLAYING_CARD_ICON) {
            isGuessing = true;
        } else {
            switch (inputIconAnswer) {
                case 0:
                    System.out.print("残念!ハートじゃないよ\n");
                    break;
                case 1:
                    System.out.print("残念!ダイヤじゃないよ\n");
                    break;
                case 2:
                    System.out.print("残念!スペードじゃないよ\n");
                    break;
                case 3:
                    System.out.print("残念!クローバーじゃないよ\n");
                    break;
            }
        }
        return isGuessing;
    }
    // #endregion

    // #region 数字の判定
    private boolean isNumberGuessing(int inputNumber, final int PLAYING_CARD_NUMBER) {
        boolean isGuessing = false;
        if (inputNumber == PLAYING_CARD_NUMBER) {
            isGuessing = true;
        } else {
            switch (inputNumber) {
                case 11:
                    System.out.print("残念!Jじゃないよ\n");
                    break;
                case 12:
                    System.out.print("残念!Qじゃないよ\n");
                    break;
                case 13:
                    System.out.print("残念!Kじゃないよ\n");
                    break;
                default:
                    System.out.printf("残念!%dじゃないよ\n", inputNumber);
                    break;
            }
        }
        return isGuessing;
    }
    // #endregion

    // #region 正解の時に呼び出す
    private void answer(int PLAYING_CARD_ICON, int PLAYING_CARD_NUMBER) {
        String icon = "";
        String number = "";
        switch (PLAYING_CARD_ICON) {
            case 0:
                icon = "ハート";
                break;
            case 1:
                icon = "ダイヤ";
                break;
            case 2:
                icon = "スペード";
                break;
            case 3:
                icon = "クローバー";
                break;
        }
        switch (PLAYING_CARD_NUMBER) {
            case 11:
                number = "J";
                break;
            case 12:
                number = "Q";
                break;
            case 13:
                number = "K";
                break;
            default:
                number = Integer.toString(PLAYING_CARD_NUMBER);
                break;
        }
        System.out.printf("正解!%sの%sだよ", icon, number);
    }
    // #endregion

    public static int inputCast(String answer) {
        int castNum = 0;
        switch (answer) {
            case "J":
                castNum = 11;
                break;
            case "Q":
                castNum = 12;
                break;
            case "K":
                castNum = 13;
                break;
            default:
                castNum = Integer.parseInt(answer);
                break;
        }
        return castNum;
    }
}
