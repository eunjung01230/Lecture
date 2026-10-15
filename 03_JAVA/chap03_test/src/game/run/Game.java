package game.run;

public class Game {

    private Player player1;
    private Player player2;
    private int turn = 1;       // 1 = 1P 차례, 2 = 2P 차례

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        System.out.println("===============");
        System.out.println("풍선 싸움 게임을 시작합니다!");
        System.out.println("상대보다 높이 올라가서 풍선을 터트리세요!");
    }

    public Player getCurrentPlayer() {
        if (turn == 1) {
            return player1;
        }
        return player2;
    }

    public Player getOpponent() {
        if (turn == 1) {
            return player2;
        }
        return player1;
    }

    public void printStatus() {
        printPlayerStatus(player1);
        printPlayerStatus(player2);
    }

    private void printPlayerStatus(Player player) {
        Balloon balloon = player.getBalloon();
        System.out.println("[" + player.getName() + "] 높이 : " + balloon.getHeight()
                + " / 풍선 : " + balloon.getCount() + "개");
    }

    public boolean isOver() {
        return player1.getBalloon().getCount() == 0
                || player2.getBalloon().getCount() == 0;
    }

    public void printWinner() {
        Player winner;
        if (player1.getBalloon().getCount() == 0) {
            winner = player2;
        } else {
            winner = player1;
        }
        System.out.println("===============");
        System.out.println("게임 종료! 승자는 [" + winner.getName() + "] 입니다!");
    }

    public void nextTurn() {
        if (turn == 1) {
            turn = 2;
        } else {
            turn = 1;
        }
    }
}
