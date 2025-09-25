public class Main {

    public static void main(String[] args) {
        System.out.println("Bash that Monster!");

        Player p1 = new Player(20, 30);
        Enemy o1 = new Enemy(20);

        System.out.println("player has " + p1.hp + " hp");
        System.out.println("enemy has " + o1.hp + " hp");
        for (int i = 0; i < 3; i++) {
            p1.turn(o1);
            System.out.println("player has" + p1.mana + " mana");
            System.out.println(" ");
            o1.turn(p1);
        }

        //TODO: fix user interface, operates on a while loop not for loop.
    }
}