package game.run;

import java.util.Scanner;

public class Application {

    /* comment. 프로그램 요구사항 작성
     *   주제 : 풍선을 타고 상대방의 풍선을 터트리는 게임 (콘솔 턴제 게임)
     *   1. 게임은 플레이어 2명(1P, 2P)이 번갈아 가며 한 턴씩 진행한다.
     *   2. 플레이어는 처음에 풍선 3개를 단 채 땅(높이 0)에서 대기한다.
     *   3. 플레이어는 자기 턴에 상승, 하강, 공격, 풍선 불기 중 한 가지 행동만 할 수 있다.
     *   4. 플레이어가 상승하면 높이가 1 올라간다. 이미 최대 높이(5)라면 더 이상 올라갈 수 없다고 안내한다.
     *   5. 플레이어가 하강하면 높이가 1 내려간다. 이미 땅에 있다면 더 이상 내려갈 수 없다고 안내한다.
     *   6. 플레이어가 공격할 때 자신이 상대방보다 높이 있다면 상대방의 풍선 1개를 터트린다.
     *   7. 공격할 때 상대방과 높이가 같다면 50% 확률로 풍선을 터트리고, 상대방보다 낮다면 공격에 실패했다고 안내한다.
     *   8. 땅에 있는 플레이어는 공격할 수 없다. 먼저 하늘로 떠올라야 한다.
     *   9. 플레이어는 땅에 있을 때만 풍선을 불어 1개 추가할 수 있다. 이미 풍선이 3개라면 더 불 수 없으며, 풍선 불기는 한 판에 2번까지만 할 수 있다.
     *   10. 풍선이 터지면 풍선 개수가 1 줄어들고, 남은 풍선 개수를 안내한다.
     *   11. 풍선이 모두 터진 플레이어는 땅으로 추락하고, 더 이상 행동할 수 없다.
     *   12. 한 플레이어의 풍선이 모두 터지면 게임은 끝나고 승자를 안내한다.
     *  */

    /* comment. 은/는 , 이/가 <- 이 키워드 앞 단어가 대부분 클래스 후보이다.
     *   여기서 필요한 객체는 게임, 플레이어, 풍선 객체이다.
     *   게임이 수신할 수 있는 메세지는 게임이 해야 할 일과 동일하다.
     *   1. 게임을 시작해라
     *   2. 턴을 넘겨라
     *   3. 승패를 판정해라
     *   4. 게임을 종료해라
     *   플레이어가 수신할 수 있는 메세지는 플레이어가 해야 할 일과 동일하다.
     *   1. 상승해라
     *   2. 하강해라
     *   3. 상대방을 공격해라
     *   4. 풍선을 불어라
     *   풍선이 수신할 수 있는 메세지는 풍선이 해야 할 일과 동일하다.
     *   1. 떠올라라
     *   2. 내려가라
     *   3. 부풀어라 (풍선 개수 증가)
     *   4. 터져라 (풍선 개수 감소)
     *   5. 남은 풍선 개수를 알려줘라
     *  */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Player player1 = new Player("1P");
        Player player2 = new Player("2P");
        Game game = new Game(player1, player2);
        

        game.start();


        while (true) {
            Player now = game.getCurrentPlayer();     // 이번 턴 플레이어
            Player enemy = game.getOpponent();        // 상대방

            System.out.println("===============");
            game.printStatus();                       // 두 플레이어 높이/풍선 개수 출력
            System.out.println(now.getName() + "의 차례입니다.");
            System.out.println("1. 상승");
            System.out.println("2. 하강");
            System.out.println("3. 공격");
            System.out.println("4. 풍선 불기");
            System.out.println("9. 게임 종료");
            System.out.print("행동을 선택하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1: now.up();
                break;
                case 2: now.down();
                break;
                case 3: now.attack(enemy);
                break;
                case 4: now.blow();
                break;
                case 9: System.out.println("게임을 종료합니다."); return;
                default: System.out.println("잘못된 번호입니다."); continue;  // 턴 안 넘김
            }

            if (game.isOver()) {      // 누군가 풍선 0개?
                game.printWinner();
                break;                // 반복 종료 -> 프로그램 종료
            }

            game.nextTurn();
        }
    }
}
