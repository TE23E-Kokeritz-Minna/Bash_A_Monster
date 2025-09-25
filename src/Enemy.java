import java.util.Random;

public class Enemy extends Character {
    Random randomGenerator = new Random();

    Enemy(int dmg) {
        this.dmg = dmg;
    }

    public void turn(Player opponent) {
        int choice = randomGenerator.nextInt(3);
        switch (choice) {
            case 0:
                attack(opponent);
                break;
            case 1:
                heal();
                break;
            case 2:
                stun(opponent);
                break;
            default:
                System.out.println("huh?");
                break;
        }

    }

    private void stun(Player opponent) {
        System.out.println("Enemy stunned player");
        opponent.stunned = true;
        opponent.stunnedTime = 0;
    }

    private void heal() {
        System.out.println("Enemy healed");
        this.hp += 10;
        System.out.println("Enemy has " + this.hp + "hp");
    }

    private void attack(Player opponent) {
        System.out.println("Enemy attacked");
        opponent.hp -= dmg;
        System.out.println("Player has " + opponent.hp + "hp");
    }

}
