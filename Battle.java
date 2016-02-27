
/**
FIX ATTACK * Write a description of class Battle here.
 * 
 * @author (Mohit Sani) 
 * @version (5/16/14)
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Battle
{
    private static Pokemon currentPoke;
    private static int currentPokeIndex;
    private static Pokemon currentOppPoke;
    private static int currentOppPokeIndex;
    private static Player tanny;
    private static Player opp;
    private static Music pling = new Music("sound/Pling.wav");
    private static Scanner keyboard = new Scanner(System.in);
    private static boolean isStillFighting;

    static Music battle = new Music("sound/Battle.wav");
    public Battle(Player player, Player opposer)
    {
        tanny = player;
        opp = opposer;
        currentPoke = tanny.getPokemon().get(0);
        currentPokeIndex = 0;
        currentOppPoke = opp.getPokemon().get(0);
        currentOppPokeIndex = 0;
        isStillFighting = true;
    }

    public static void main() //initiates wild fights
    {
        battle.run();
        boolean first = true;
        System.out.println("\f");
        if(first)
        {
            System.out.println("You bumped into " + currentOppPoke.aAn() + " level: " + currentOppPoke.getLevel() + " " + currentOppPoke.getName() + "!");
            System.out.println(currentOppPoke.getName() + " has a total health of: " + currentOppPoke.getTotalHealth());
            System.out.println("Go " + currentPoke.getName() + "!");
            System.out.println("------------------------");
            //System.out.println(currentPoke);
            //System.out.println(" ");
            first = false;
        }
        while(isStillFighting)
        {
            if(!first)
            {
                System.out.println("Pokemon: " + currentOppPoke.getName() + "\n" + "Health: " + currentOppPoke.getHealth() + "/" + currentOppPoke.getTotalHealth() +"\n" + "Level: " + currentOppPoke.getLevel());
                System.out.println(" ");
                System.out.println(currentPoke);
                System.out.println("------------------------");
                first = false;
            }
            System.out.println("What would you like to do?");
            System.out.println("\"Attack\"");
            System.out.println("\"Switch Pokemon\"");
            System.out.println("\"Bag\"");
            System.out.println("\"Run\"");
            System.out.println("------------------------");
            String choice = keyboard.nextLine();
            pling.run();
            if (choice.equalsIgnoreCase("Attack"))
                attack();
            else if(choice.equalsIgnoreCase("Switch Pokemon"))
                swap();
            else if(choice.equalsIgnoreCase("Bag"))
                bag();
            else if(choice.equalsIgnoreCase("Run"))
                run();
            else
            {
                System.out.println("That's not an option! Check for typos. (Press Enter to Continue)");
                if(keyboard.nextLine().equals(""));
                pling.run();
                System.out.println("\f");
            }

            first = false;
        }
    }

    public static void attack()
    {
        boolean isAttacking = true;
        while(isAttacking)
        {
            System.out.println("\f");
            System.out.println("Which attack would you like to choose?");
            System.out.println("Enter the number next to the attack to choose that attack.");
            System.out.println("If you would like to cancel enter -1..");
            int choice = setNum("attack");
            if (choice == -1)
            {
                pling.run();
                isAttacking = false;
                System.out.println("\f");
            }
            else if(choice >= 0 && choice <=3)
            {
                pling.run();
                System.out.println("\f");
                currentOppPoke.takeDamage(currentPoke.getAttack(choice, currentOppPoke));
                System.out.println("Opponent " + currentOppPoke.getName() + "'s health is now " + currentOppPoke.getHealth() + "/" + currentOppPoke.getTotalHealth() + ".");
                if(!opp.arePokemonAlive())
                {
                    if(keyboard.nextLine().equals(""));
                    battle.stop();
                    Music victory = new Music("sound/Victory.wav");
                    victory.run();

                    System.out.println("\f");
                    System.out.println("You have just defeated " + currentOppPoke.getName());
                    if(keyboard.nextLine().equals(""));
                    pling.run();
                    System.out.println("The battle is over. All opposing pokemon fainted.");
                    currentPoke.addExp(currentOppPoke);
                    if(keyboard.nextLine().equals(""));
                    pling.run();
                    System.out.println("Your pokemon gained exp by defeating another pokemon!");
                    if(keyboard.nextLine().equals(""));
                    pling.run();
                    {
                        victory.stop();
                    }

                    isStillFighting = false;
                }
                else if(currentOppPoke.getHealth() == 0)
                {
                    currentOppPokeIndex++;
                    currentOppPoke = opp.getPokemon().get(currentOppPokeIndex);
                    System.out.println("The opposing pokemon fainted!");
                    System.out.println(currentOppPoke.getName() + " was released to replace him!");
                    currentPoke.addExp(currentOppPoke);
                    System.out.println("Your pokemon gained exp by defeating another pokemon!");
                }
                else   //opposite pokemon attacks:
                    oppAttack();
                isAttacking = false;
            }
            else
            {
                System.out.println("That number is invalid. Try a different one! Enter to continue.");
                if(keyboard.nextLine().equals(""));
                pling.run();
                System.out.println("\f");
            }
        }
    }

    public static int setNum(String methodName)
    {
        boolean isTrying = true;
        int testChoice = -1;
        while(isTrying)
        {
            testChoice = -1;
            try
            {
                if(methodName.equalsIgnoreCase("swap"))
                {
                    System.out.println("\f");
                    System.out.println("Which pokemon would you like to deploy?");
                    System.out.println("Enter the number next to the pokemon to choose that pokemon.");
                    System.out.println("If you would like to cancel enter -1.");
                    for (int i = 0; i<tanny.getPokemon().size();i++)
                        System.out.println(i + " - " + tanny.getPokemon().get(i).getName() + " " + tanny.getPokemon().get(i).getHealth() + "/" + tanny.getPokemon().get(i).getTotalHealth());
                }
                else if(methodName.equalsIgnoreCase("attack"))
                {
                    System.out.println(currentPoke.returnAttacks());
                }
                testChoice = Integer.parseInt(keyboard.nextLine());
                isTrying = false;
            } catch(Exception e)
            {
                System.out.println("You did not enter a number! Please try again. Enter to continue.");
                if(keyboard.nextLine().equals(""));
                pling.run();
            }
        }
        return testChoice;
    }

    public static void swap()
    {
        boolean moved = false;
        while (!moved)
        {
            int choice = setNum("swap");
            if (choice == -1)
            {
                System.out.println("\f");
                moved = true;
            }
            else
            {
                if(!(choice >= 0 && choice < tanny.getPokemon().size()))
                {
                    System.out.println("That number is invalid. Try a different one! Enter to continue.");
                    if(keyboard.nextLine().equals(""));
                    pling.run();
                    System.out.println("\f");
                }
                else if (tanny.getPokemon().get(choice).getHealth() == 0)
                {
                    System.out.println("That pokemon has fainted! It can't fight! Enter to continue.");
                    if(keyboard.nextLine().equals(""));
                    pling.run();
                    System.out.println("\f");
                    moved = true;
                }
                else if (choice == currentPokeIndex)
                {
                    System.out.println("That pokemon is already fighting! Enter to continue.");
                    if(keyboard.nextLine().equals(""));
                    pling.run();
                    System.out.println("\f");
                }
                else 
                {
                    currentPoke = tanny.getPokemon().get(choice);
                    currentPokeIndex = choice;
                    moved = true;
                    oppAttack();
                }
            }
        }
    }

    public static void bag()
    {
        System.out.println("\f");        
        System.out.println("What would you like to use?");
        System.out.println("\"Regular Pokeball\" - " + tanny.getBag().getRegPokeballs());
        System.out.println("\"Professional Pokeball\" - " + tanny.getBag().getProPokeballs());
        System.out.println("\"Weak Medicine\" - " + tanny.getBag().getWeakMedicine());
        System.out.println("\"Strong Medicine\" - " + tanny.getBag().getStrongMedicine());
        System.out.println("\"Cancel\"");
        String choice = keyboard.nextLine();
        pling.run();
        if (choice.equalsIgnoreCase("Regular Pokeball"))
        {
            if (tanny.getBag().getRegPokeballs() > 0)
                useRegPokeball();
            else
            {
                System.out.println("You don't have any regular pokeballs to use! (Press Enter to Continue)");
                if(keyboard.nextLine().equals(""));
                pling.run();
                System.out.println("\f");
            }
        }
        else if (choice.equalsIgnoreCase("Professional Pokeball"))
        {
            if (tanny.getBag().getProPokeballs() > 0)
                useProPokeball();
            else
            {
                System.out.println("You don't have any professional pokeballs to use! (Press Enter to Continue)");
                if(keyboard.nextLine().equals(""));
                pling.run();
                System.out.println("\f");
            }
        }
        else if (choice.equalsIgnoreCase("Weak Medicine"))
        {
            if (tanny.getBag().getWeakMedicine() > 0)
            {
                useWeakMedicine();
            }
            else
            {
                System.out.println("You don't have any weak medicine to use! (Press Enter to Continue)");
                if(keyboard.nextLine().equals(""));
                pling.run();
                System.out.println("\f");
            }
        }
        else if (choice.equalsIgnoreCase("Strong Medicine"))
        {
            if (tanny.getBag().getStrongMedicine() > 0)
            {
                useStrongMedicine();
            }
            else
            {
                System.out.println("You don't have any strong medicine to use! (Press Enter to Continue)");
                if(keyboard.nextLine().equals(""));
                pling.run();
                System.out.println("\f");
            }
        }
        else if (choice.equalsIgnoreCase("Cancel"))
        {
            System.out.println("\f");
            pling.run();
            //goes back to main() while loop
        }
        else
        {
            System.out.println("That's not an option! Check for typos.");
            if(keyboard.nextLine().equals(""));
            pling.run();
            System.out.println("\f");
        }
    }

    public static void useRegPokeball()
    {

        if (tanny.getBag().getRegPokeballs() !=  0)
        {
            if (Math.random() < .20)
            {
                tanny.getBag().subRegPokeballs();
                battle.stop();
                System.out.println("\f");
                System.out.println("You have just caught a " + currentOppPoke.getName());
                if(keyboard.nextLine().equals(""));
                pling.run();
                System.out.println("The Pokemon is now among your stored pokemon! (Press Enter to Continue)");
                if(keyboard.nextLine().equals(""));
                pling.run();
                tanny.addPokemon(currentOppPoke);
                isStillFighting = false;
            }
            else
            {
                tanny.getBag().subRegPokeballs();
                System.out.println("\f");
                System.out.println("The pokeball failed to capture the wild pokemon! (Press Enter to Continue)");
                if(keyboard.nextLine().equals(""));
                pling.run();
                System.out.println("\f");
            }
        }
        else
        {
            System.out.println("\f");
            if(keyboard.nextLine().equals(""));
            pling.run();
            System.out.println("You have no regular pokeballs to use! (Press Enter to Continue)");
            System.out.println("\f");
        }
    }

    public static void useProPokeball()
    {
        if (tanny.getBag().getProPokeballs() != 0)
        {
            if (Math.random() < .50)
            {
                tanny.getBag().subProPokeballs();
                battle.stop();
                System.out.println("\f");
                System.out.println("You have just caught a " + currentOppPoke.getName());
                if(keyboard.nextLine().equals(""));
                pling.run();
                System.out.println("The Pokemon is now among your stored pokemon! (Press Enter to Continue)");
                if(keyboard.nextLine().equals(""));
                pling.run();
                tanny.addPokemon(currentOppPoke);
                isStillFighting = false;
            }
            else
            {
                tanny.getBag().subProPokeballs();
                System.out.println("\f");
                System.out.println("The pokeball failed to capture the wild pokemon! (Press Enter to Continue)");
                if(keyboard.nextLine().equals(""));
                pling.run();
                System.out.println("\f");
            }
        }
        else
        {
            System.out.println("\f");
            if(keyboard.nextLine().equals(""));
            pling.run();
            System.out.println("You have no pro pokeballs to use! (Press Enter to Continue)");
            System.out.println("\f");
        }
    }

    public static void useWeakMedicine()
    {
        if (tanny.getBag().getWeakMedicine() != 0)
            currentPoke.addHealth(10);
        else
        {
            System.out.println("\f");
            System.out.println("You have no weak medicine to use!");
            if(keyboard.nextLine().equals(""));
            pling.run();
            System.out.println("\f");

        }
    }

    public static void useStrongMedicine()
    {
        if (tanny.getBag().getStrongMedicine() != 0)
            currentPoke.addHealth(25);
        else
        {
            System.out.println("\f");
            System.out.println("You have no strong medicine to use!");
            if(keyboard.nextLine().equals(""));
            pling.run();
            System.out.println("\f");
        }
    }

    public static void run()
    {
        // MUST CHECK IF IT'S WILD OR NOT!!!!!!! // fixed with alternate gym battle method
        if (Math.random() < .5)
        {
            System.out.println("You escaped safely. (Press Enter to Continue)");
            if (keyboard.nextLine().equals(""));
            pling.run();
            isStillFighting = false;
            battle.stop();
            System.out.println("\f");
        }
        else
        {
            System.out.println("You failed to escape from the pokemon! (Press Enter to Continue)");
            if (keyboard.nextLine().equals(""));
            pling.run();
            System.out.println("\f");
        }
        if(isStillFighting)
            oppAttack();
        System.out.println("\f");
    }

    public static void oppAttack()
    {
        if(currentOppPoke.getHealth() > 0)
        {
            double attacksDivided = 1.0/currentOppPoke.getAttacks().size();
            double prob = Math.random();
            if(prob < attacksDivided)
            {
                currentPoke.takeDamage(currentOppPoke.getAttack(0,currentPoke));
                System.out.println("The opposing " + currentOppPoke.getName() + " used " + currentOppPoke.getAttacks().get(0).getName() + "!");
            }
            else if(prob < 2*attacksDivided)
            {
                currentPoke.takeDamage(currentOppPoke.getAttack(1,currentPoke));
                System.out.println("The opposing " + currentOppPoke.getName() + " used " + currentOppPoke.getAttacks().get(1).getName() + "!");
            }
            else if(prob < 3*attacksDivided)
            {
                currentPoke.takeDamage(currentOppPoke.getAttack(2,currentPoke));
                System.out.println("The opposing " + currentOppPoke.getName() + " used " + currentOppPoke.getAttacks().get(2).getName() + "!");
            }
            else
            {
                currentPoke.takeDamage(currentOppPoke.getAttack(3,currentPoke));
                System.out.println("The opposing " + currentOppPoke.getName() + " used " + currentOppPoke.getAttacks().get(3).getName() + "!");
            }
            System.out.println("Your " + currentPoke.getName() + "'s health is now " + currentPoke.getHealth() + "/" + currentPoke.getTotalHealth() + ".");
            System.out.println("------------------------");
        }
        if(!tanny.arePokemonAlive())
        {
            System.out.println("The battle is over. The all of your pokemon fainted.");
            isStillFighting = false;
        }
        else if (currentPoke.getHealth() == 0)
        {
            System.out.println("You're pokemon fainted!");
            if(keyboard.nextLine().equals(""));
            System.out.println("Choose another pokemon.");
            swap();
        }
    }

    /*public static boolean allPokemonAlive()
    {
    int x = 0;
    int y = 0;
    while(x < tanny.getPokemon().size())
    {
    if(tanny.getPokemon().get(x).getHealth() <= 0)
    {
    y = y + 1;
    }
    x = x + 1;
    }
    if(y == x)
    {
    return false;
    }
    else
    {
    return true;
    }
    }
    public static boolean arePokemonAlive(Player eitherPlayer)
    {
    boolean alive = true;
    for(int i = 0; i<eitherPlayer.getPokemon().size(); i++)
    if(eitherPlayer.getPokemon().get(i).getHealth() == 0)
    alive = false;
    return alive;
    }*/

    public static void playerBattle() //initiates fights against other players (only difference is you can't run or catch pokemon)
    {
        boolean first = true;
        battle.run();
        if(first)
        {
            System.out.println("Your opponent released " + currentOppPoke.aAn() + " " + currentOppPoke.getName() + "!");
            System.out.println(currentOppPoke.getName() + " has a total health of: " + currentOppPoke.getTotalHealth());
            System.out.println("Go " + currentPoke.getName() + "!");
            System.out.println("------------------------");
            first = false;
        }
        String choice;
        while(isStillFighting)
        {
            if(!first)
            {
                System.out.println(currentOppPoke);
                System.out.println(" ");
                System.out.println(currentPoke);
                System.out.println("------------------------");
                first = false;
            }

            System.out.println("What would you like to do?");
            System.out.println("\"Attack\"");
            System.out.println("\"Switch Pokemon\"");
            System.out.println("\"Bag\"");
            System.out.println("\"Run\"");
            choice = keyboard.nextLine();
            pling.run();
            if (choice.equalsIgnoreCase("Attack"))
                attack();
            else if(choice.equalsIgnoreCase("Switch Pokemon"))
                swap();
            else if(choice.equalsIgnoreCase("Bag"))
                playerBag();
            else if(choice.equalsIgnoreCase("Run"))
            {
                System.out.println("What are you trying to do Willis");
                if(keyboard.nextLine().equals(""));
                pling.run();
                System.out.println("You can't run from a battle with another player!");
                if(keyboard.nextLine().equals(""));
                pling.run();
                System.out.println("\f");
            }
            else
            {
                System.out.println("That's not an option! Check for typos. (Press Enter to Continue)");
                if(keyboard.nextLine().equals(""));
                pling.run();
                System.out.println("\f");
            }
        }
    }

    public static void playerBag()
    {
        System.out.println("\f");
        System.out.println("What would you like to use?");
        System.out.println("\"Regular Pokeball\" - " + tanny.getBag().getRegPokeballs());
        System.out.println("\"Professional Pokeball\" - " + tanny.getBag().getProPokeballs());
        System.out.println("\"Weak Medicine\" - " + tanny.getBag().getWeakMedicine());
        System.out.println("\"Strong Medicine\" - " + tanny.getBag().getStrongMedicine());
        System.out.println("\"Cancel\"");
        String choice = keyboard.nextLine();
        pling.run();
        if (choice.equalsIgnoreCase("Regular Pokeball"))
        {
            System.out.println("\f");
            System.out.println("What are you trying to do Willis");
            if(keyboard.nextLine().equals(""));
            pling.run();
            System.out.println("You can't catch someone else's pokemon!");
            if(keyboard.nextLine().equals(""));
            pling.run();
            System.out.println("\f");
        }
        else if (choice.equalsIgnoreCase("Professional Pokeball"))
        {
            System.out.println("\f");
            System.out.println("What are you trying to do Willis");
            if(keyboard.nextLine().equals(""));
            pling.run();
            System.out.println("You can't catch someone else's pokemon!");
            if(keyboard.nextLine().equals(""));
            pling.run();
            System.out.println("\f");
        }
        else if (choice.equalsIgnoreCase("Weak Medicine"))
        {
            if (tanny.getBag().getWeakMedicine() > 0)
            {
                System.out.println("You have used a weak medicine");
                if(keyboard.nextLine().equals(""));
                pling.run();
                useWeakMedicine();
            }
            else
            {
                System.out.println("\f");
                System.out.println("What are you trying to do Willis");
                if(keyboard.nextLine().equals(""));
                System.out.println("You don't have any weak medicine to use!");
                if(keyboard.nextLine().equals(""));
                pling.run();
                System.out.println("\f");
            }
        }
        else if (choice.equalsIgnoreCase("Strong Medicine"))
        {
            if (tanny.getBag().getStrongMedicine() > 0)
            {
                System.out.println("You have used a strong medicine");
                if(keyboard.nextLine().equals(""));
                pling.run();
                useStrongMedicine();
            }
            else
            {
                System.out.println("\f");
                System.out.println("What are you trying to do Willis");
                if(keyboard.nextLine().equals(""));
                System.out.println("You don't have any Strong medicine to use!");
                if(keyboard.nextLine().equals(""));
                pling.run();
                System.out.println("\f");
            }
        }
        else if (choice.equalsIgnoreCase("Cancel"))
        {
            pling.run();
            System.out.println("\f");
        }
        else
        {
            System.out.println("That's not an option! Check for typos. (Press Enter to Continue)");
            if(keyboard.nextLine().equals(""));
            pling.run();
            System.out.println("\f");
        }
    }
}