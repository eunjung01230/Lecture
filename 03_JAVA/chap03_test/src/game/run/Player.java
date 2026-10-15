package game.run;

public class Player {

    private String name;
    private Balloon balloon = new Balloon();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Balloon getBalloon() {
        return balloon;
    }

    public void up() {
        balloon.up();
    }

    public void down() {
        balloon.down();
    }

    public void attack(Player enemy) {
        int myHeight = balloon.getHeight();
        int enemyHeight = enemy.getBalloon().getHeight();

        if (myHeight == 0) {
            System.out.println("땅에서는 공격할 수 없습니다. 먼저 하늘로 떠올라야 합니다.");
        } else if (myHeight < enemyHeight) {
            System.out.println("공격 실패! [" + enemy.getName() + "]보다 낮은 곳에서는 공격할 수 없습니다.");
        } else if (myHeight == enemyHeight && Math.random() < 0.5) {
            System.out.println("[" + name + "]의 공격! ... 아깝게 빗나갔습니다! (같은 높이 : 성공 확률 50%)");
        } else {
            System.out.println("[" + name + "]의 공격! [" + enemy.getName() + "]의 풍선을 터트립니다.");
            enemy.getBalloon().pop();
        }
    }

    public void blow() {
        balloon.inflate();
    }
}
