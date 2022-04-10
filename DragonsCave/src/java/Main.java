import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DragonsCave dragonsCave = new DragonsCave();

        System.out.println("You are in a land full of dragons. In front of you, ");
        System.out.println("you see two caves. In one cave, the dragon  is friendly");
        System.out.println("and will share his treasure with you. The other dragon");
        System.out.println("is greedy and hungry and will eat you on sight.");
        System.out.println("Which cave will you go into? (1 or 2)");

        try {
            dragonsCave.getUserChoice();
        } catch (Exception e) {
            throw e;
        }

        if (dragonsCave.getChoice() == 1) {
            System.out.println("You approach the cave...");
            System.out.println("It is dark and spooky...");
            System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
            System.out.println("Gobbles you down in one bite!");

            return;
        }
        
        System.out.println("You approach the cave...");
        System.out.println("It is dark and spooky...");
        System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
        System.out.println("Loudly exclaims");
        System.out.println("\"You are brave to be exploring down here!");
        System.out.println("Take my treasure as a reward, traveller!\"");
    }
}
