import java.util.Scanner;

public class Player extends Character {
    Scanner myScan = new Scanner(System.in);

    int mana;
    boolean stunned;
    int stunnedTime;

    Player(int mana, int dmg) {
        this.mana = mana;
        this.dmg = dmg;
        stunned = false;
    }

    void turn(Enemy opponent) {
        if (stunned) {
            System.out.println("Player is stunned!");
            stunnedTime++;
            if (stunnedTime == 2) stunned = false;
        } else {

            boolean acceptableAns = false;
            do {
                System.out.println("What do you want to do? [attack] / [heal] / [mana attack]");
                String ans = myScan.nextLine();
                switch (ans.toLowerCase()) {
                    case "attack":
                        attack(opponent);
                        acceptableAns = true;
                        break;
                    case "heal":
                        heal();
                        acceptableAns = true;
                        break;
                    case "mana attack":
                        manaAttack(opponent);
                        acceptableAns = true;
                        break;
                    default:
                        System.out.println("Not acceptable command, try again");
                        break;
                }
            } while (!acceptableAns);
        }
        mana += 10;
    }

    private void manaAttack(Enemy opponent) {
        System.out.println("This is a Mana attack ");
        opponent.hp -= dmg * 2;
        mana -= 40;
        System.out.println("Enemy has " + opponent.hp + "hp");
    }

    private void heal() {
        System.out.println("Player healed");
        this.hp += 10;
        System.out.println("Player has " + this.hp + "hp");
    }

    private void attack(Enemy opponent) {
        System.out.println("This is an attack ");
        opponent.hp -= dmg;
        System.out.println("Enemy has " + opponent.hp + "hp");
    }

}
