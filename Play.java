import java.util.Scanner;
import java.util.ArrayList;

public class Play implements java.io.Serializable
{
    private static Player player;   //THESE NEED TO BE INITIALIZED IN THE INTRO THAT WILL ONLY RUN ONCE SOMEHOW!!! (very doable)
    private static PokemonCenter mainCharsCenter;
    private static Gym planetFitness;
    static Music pling = new Music("sound/Pling.wav");
    static Music home = new Music("sound/Home.wav");
    public Play(Player charFromIntro, PokemonCenter fromIntro)
    {
        player = charFromIntro;
        mainCharsCenter = fromIntro;
        planetFitness = new Gym();
    }

    public static void play ()
    {
        boolean isPlaying = true;
        while (isPlaying)
        {
            home.run();
            System.out.println("\f");
            System.out.println("Where do you want to go? / What do you want to do?");
            System.out.println("The:");
            System.out.println("\"Wild Grass\"");
            System.out.println("\"Pokemon Center\"");
            System.out.println("\"Gym\"");
            System.out.println("\"Save\"");
            System.out.println("\"Quit\"");
            player.printStatus();
            Scanner keyboard = new Scanner(System.in);
            String move = keyboard.nextLine();
            pling.run();
            if (move.equalsIgnoreCase("Wild Grass"))
            {
                if(player.arePokemonAlive())
                {
                    home.stop();
                    Grass homeGrass = new Grass(player);
                    homeGrass.main();
                }
                else
                {
                    System.out.println("\f");
                    System.out.println("You must have healthy pokemon to enter the wild grass! Otherwise it's unsafe! \nTip: You can heal your pokemon in the pokemon center.");
                    if (keyboard.nextLine().equals(""));
                    pling.run();
                }
            }
            else if(move.equalsIgnoreCase("Pokemon Center"))
            {
                home.stop();
                mainCharsCenter.main(); //simply goes through his arrayList of
            }
            //Pokemon and heals them
            else if(move.equalsIgnoreCase("Gym"))
            {
                home.stop();
                planetFitness.gym(player);    //very simple static class (unless we want multiple
                //gyms…) battle method in a for
            }
            //loop in a very similar matter to this method
            //(Do you want to fight the next member or leave?
            //loops through arrayList of players as its members\
            //            else if(move.equals("Lab")) //we don’t need this one… I"m thinking instead we have pokedex and bag be their own else if statements...
            //                Lab.main(); //another static class that asks you if you want to see //I DONT LIKE THIS ANYMORE WE COVERED IT IN THE POKEMONCENTERCLASS
            //your pokedex, what’s in your bag, etc. ALSO THE PLAYER SHOULD BE ABLE TO ALTER THE ORDER OF HIS POKEMON THAT HE CARRIES!!
            else if(move.equalsIgnoreCase("Save"))
            {
                isPlaying = false;
            }
            else if(move.equalsIgnoreCase("Quit"))
            {
                System.out.println("\f");
                if (verify(" you want to quit? All progress will be saved."))
                    isPlaying = false;
            }
            else
            {
                System.out.println("\f");
                System.out.println("That's not an option! Please check for typos.");
                if(keyboard.nextLine().equals(""));
                pling.run();
            }
        }
    }
    
    public static boolean verify(String question)
    {
        boolean stillVerifying = true;
        while(stillVerifying)
        {
            System.out.println("Are you sure" + question + " (Respond \"Yes\" or \"No\")");
            Scanner keyboard = new Scanner(System.in);
            String choice = keyboard.nextLine();
            pling.run();
            if (choice.equalsIgnoreCase("Yes"))
                return true;
            else if (choice.equalsIgnoreCase("No"))
                return false;
            else
                System.out.println("That's not an option! Please check for typos.");
        }
        return false; //This statement will never be reached.
    }
}