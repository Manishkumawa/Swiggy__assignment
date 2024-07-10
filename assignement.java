

import java.util.Random;
// defining the class Player 
class Player {
    int health;
    int strength;
    int attack;
    //  defining the constructor for the player who have the attribute  health ,strength ,attack 
    public Player(int health, int strength, int attack) {
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }
}
// from here Start the game 
public class MagicalArena {
    static Random random = new Random();

    public static int rollDie() {
        return random.nextInt(6) + 1;  // achieving the random dice number from 1 to 6 
    }
        //defining the fight function which take the two player attacker ,defender 
    public static void fight(Player attacker, Player defender) {
        int attackRoll = rollDie();
        int defenseRoll = rollDie();

        int attackDamage = attacker.attack * attackRoll;
        int defenseStrength = defender.strength * defenseRoll;

        int damageTaken = Math.max(0, attackDamage - defenseStrength);
        defender.health -= damageTaken;

        System.out.println("Attacker rolls " + attackRoll + ", Defender rolls " + defenseRoll);
        System.out.println("Attack damage: " + attackDamage + ", Defense strength: " + defenseStrength);
        System.out.println("Defender health reduced by " + damageTaken + " to " + defender.health + "\n");
    }
    // here is main function of game
    public static void main(String[] args) {
        Player playerA = new Player(50, 5, 10); //player A parameter 50,5,10 (health ,strength ,attack)
        Player playerB = new Player(100, 10, 5);
        //player B parameter  (100 ,10 ,5) are the health ,strength ,attack 
        //the game is continue while the health of player A is greater than Player B
        while (playerA.health > 0 && playerB.health > 0) {
            if (playerA.health < playerB.health) {
                fight(playerA, playerB);
                if (playerB.health <= 0) {
                    System.out.println("Player A wins ");
                    break;
                }
                fight(playerB, playerA);
                if (playerA.health <= 0) {
                    System.out.println("Player B wins ");
                    break;
                }
            } else {
                fight(playerB, playerA);
                if (playerA.health <= 0) {
                    System.out.println("Player B wins ");
                    break;
                }
                fight(playerA, playerB);
                if (playerB.health <= 0) {
                    System.out.println("Player A wins ");
                    break;
                }
            }
        }
    }
}