package game.run;

public class Balloon {

    private int height = 0;     // 높이 (0~5)
    private int count = 3;      // 풍선 개수
    private int inflateCount = 0;   // 이번 판에 풍선을 분 횟수 (최대 2)

    public void up() {
        if (height == 5) {
            System.out.println("이미 최대 높이입니다. 더 이상 올라갈 수 없습니다.");
        } else {
            height++;
            System.out.println("높이 " + height + "(으)로 상승했습니다.");
        }
    }

    public void down() {
        if (height == 0) {
            System.out.println("이미 땅에 있습니다. 더 이상 내려갈 수 없습니다.");
        } else {
            height--;
            System.out.println("높이 " + height + "(으)로 하강했습니다.");
        }
    }

    public void inflate() {
        if (height != 0) {
            System.out.println("풍선은 땅에서만 불 수 있습니다.");
        } else if (count == 3) {
            System.out.println("이미 풍선이 3개입니다. 더 불 수 없습니다.");
        } else if (inflateCount == 2) {
            System.out.println("풍선 불기는 한 판에 2번까지만 할 수 있습니다.");
        } else {
            count++;
            inflateCount++;
            System.out.println("풍선을 불었습니다. 현재 풍선 " + count + "개 (남은 불기 " + (2 - inflateCount) + "번)");
        }
    }

    public void pop() {
        if (count == 0) {
            return;
        }

        count--;
        System.out.println("펑! 풍선이 터졌습니다. 남은 풍선 " + count + "개");

        if (count == 0) {
            height = 0;
            System.out.println("풍선이 모두 터져 땅으로 추락했습니다!");
        }
    }

    public int getHeight() {
        return height;
    }

    /* 남은 풍선 개수를 알려줘라 */
    public int getCount() {
        return count;
    }
}
