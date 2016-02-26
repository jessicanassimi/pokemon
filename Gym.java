
/**
 * Simulates Gym.
 * 
 * @author (Mohit Sani) 
 * @version (6/3/14)
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Gym
{
    private static Player ellen;
    private static Player vic;
    private static Player aidan;
    private static Player jess;
    private static boolean isEllenDefeated;
    private static boolean isVicDefeated;
    private static boolean isAidanDefeated;
    private static boolean isJessDefeated;
    private static boolean isStillFighting;
    private static Scanner keyboard = new Scanner(System.in);
    private static Music pling = new Music("sound/Pling.wav");
    private static Player tanny;
    //public Gym(Play mainChar)
    //{
    public Gym()
    {
        isEllenDefeated = false;
        isVicDefeated = false;
        isAidanDefeated = false;
        isJessDefeated = false;
    }

    public static void gym(Player mainChar)
    {
        ArrayList<Pokemon> ellensList = new ArrayList<Pokemon>(3);
        Pokemon ellenSquirt = new Squirtle(5);
        //Pokemon ellenRad = new Oddish(7);
        Pokemon ellenBulb = new Bulbasaur(10);
        ellensList.add(ellenSquirt);
        //ellensList.add(ellenRad);
        ellensList.add(ellenBulb);
        ellen = new Player(ellensList, new Location());

        ArrayList<Pokemon> vicsList = new ArrayList<Pokemon>(2);
        Pokemon vicBulb = new Bulbasaur(15);
        Pokemon vicChar = new Charmander(13);
        vicsList.add(vicBulb);
        vicsList.add(vicChar);
        vic = new Player(vicsList, new Location());

        ArrayList<Pokemon> aidansList = new ArrayList<Pokemon> (4);
        Pokemon aidanChar = new Charmander(25);
        Pokemon aidanPsy = new Psyduck(20);
        Pokemon aidanUse = new Useless(1);
        aidansList.add(aidanChar);
        aidansList.add(aidanPsy);
        aidansList.add(aidanUse);
        aidan = new Player(aidansList, new Location());

        ArrayList<Pokemon> jessList = new ArrayList<Pokemon> (2);
        Pokemon jessPika = new PikaChu(35);
        Pokemon jessPuff = new Jigglypuff(30);
        jessList.add(jessPika);
        jessList.add(jessPuff);
        jess = new Player(jessList, new Location());

        isStillFighting = true;

        tanny = mainChar;
        //}

        //public static void gym()
        //{
        System.out.println("\f");
        System.out.println("Welcome to the gym!(Press Enter to Continue)");
        if (keyboard.nextLine().equals(""));
        pling.run();
        System.out.println(" ");
        if(!isEllenDefeated)
        {
            while(isStillFighting)
            {
                System.out.println("Would you like to battle the first gym leader, Ellen? (Respond \"Battle\" or \"Leave\")");
                if(yesno())
                {
                    System.out.println("\f");
                    Battle bat = new Battle(tanny, ellen);
                    bat.playerBattle();
                    if(!ellen.arePokemonAlive())
                    {
                        System.out.println("\f");
                        isEllenDefeated = true;
                        System.out.println("Congratulations, you've defeated Ellen!");
                        isStillFighting = false;
                    }
                    else
                    {
                        System.out.println("\f");
                        //doNothing... battle class should return you home...
                    }
                }
                else
                {
                    isStillFighting = false;
                }
            }
        }
        if(isEllenDefeated && !isVicDefeated)
        {
            isStillFighting = true;
            while(isStillFighting)
            {
                System.out.println("Would you like to battle the second gym leader, Vic THE DREAM CRUSHER? (Respond \"Battle\" or \"Leave\")");
                if(yesno())
                {
                    System.out.println("\f");
                    Battle bat = new Battle(tanny, vic);
                    bat.playerBattle();
                    if(!vic.arePokemonAlive())
                    {
                        System.out.println("\f");
                        isVicDefeated = true;
                        System.out.println("Congratulations, you've defeated Vic THE DREAM CRUSHER");
                        if (keyboard.nextLine().equals(""));
                        pling.run();
                        System.out.println("I WANT MY MOMMY !!!!!");
                        if (keyboard.nextLine().equals(""));
                        pling.run();
                        System.out.println("\f");
                        isStillFighting = false;
                    }
                    else
                    {
                        System.out.println("\f");
                        //doNothing... battle class should return you home...
                    }
                }
                else
                    isStillFighting = false;
            }
        }
        if(isVicDefeated && !isAidanDefeated)
        {
            isStillFighting = true;
            while(isStillFighting)
            {
                System.out.println("Would you like to battle the third gym leader, Aidan? (Respond \"Battle\" or \"Leave\")");
                if(yesno())
                {
                    Battle bat = new Battle(tanny, aidan);
                    bat.playerBattle();
                    if(!aidan.arePokemonAlive())
                    {
                        isAidanDefeated = true;
                        System.out.println("Congratulations, you've defeated Aidan!");
                        isStillFighting = false;
                    }
                    else
                    {
                        //doNothing... battle class should return you home...
                    }
                }
                else
                    isStillFighting = false;
            }
        }
        if(isAidanDefeated && !isJessDefeated)
        {
            isStillFighting = true;
            while(isStillFighting)
            {
                System.out.println("Would you like to battle the last gym leader, Jess? (Respond \"Battle\" or \"Leave\")");
                if(yesno())
                {
                    Battle bat = new Battle(tanny, jess);
                    bat.playerBattle();
                    if(!jess.arePokemonAlive())
                    {
                        isJessDefeated = true;
                        System.out.println("Congratulations, you've defeated Jess!");
                        isStillFighting = false;
                    }
                    else
                    {
                        //doNothing... battle class should return you home...
                    }
                }
                else
                    isStillFighting = false;
            }
        }
        if(isJessDefeated)
        {
            System.out.println("You have beaten every single gym leader!");
            System.out.println("Congratulations, you are the king of the universe!");
            System.out.println("You actually had the patience to beat this game!");
        }
    }

    public static boolean yesno()
    {
        boolean stillVerifying = true;
        while(stillVerifying)
        {
            String choice = keyboard.nextLine();
            pling.run();
            if (choice.equalsIgnoreCase("Battle"))
                return true;
            else if (choice.equalsIgnoreCase("Leave"))
                return false;
            else
                System.out.println("That's not an option! Please check for typos.");
        }
        return false; //This statement will never be reached.
    }

}
