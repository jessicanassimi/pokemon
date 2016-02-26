import java.util.ArrayList;
import java.util.Scanner;

public class Intro implements java.io.Serializable
{
    private static Scanner keyboard = new Scanner (System.in);
    public static void main()
    {
        Play game = Retrieve.deserializePlay();

        if(game == null)
        {
            Music intro = new Music("sound/Intro.wav");
            Music Pling = new Music("sound/Pling.wav");
            intro.run();
            //Pokemon squirtle = new Squirtle();
            ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>();
            //pokemonList.add(squirtle);
            Player tanny = new Player(pokemonList, new Location());
            PokemonCenter center = new PokemonCenter(tanny);
            game = new Play(tanny, center);
            tanny.getBag().addRegPokeball(5);
            tanny.getBag().addWeakMedicine(2);
            System.out.println("\f");
            System.out.println("Hello! Welcome to the pokemon center! Press enter to continue.");
            if (keyboard.nextLine().equals(""));
            {
                Pling.run();
                System.out.println("My name is Professor Cubinski! (press enter)");
            }

            if (keyboard.nextLine().equals(""));
            {
                Pling.run();
                System.out.println("This world is widely inhabited by creatures known as pokemon.");  
            }

            if (keyboard.nextLine().equals(""));
            {
                Pling.run();
                System.out.println("We humans live alongside pokemon,\nat times as friendly playmates, and at other times as cooperative workmates.\nAnd sometimes, we band together and battle others like us.");         
            }

            if (keyboard.nextLine().equals(""));
            {
                Pling.run();
                System.out.println("But despite our closeness,\nwe don't know everything about pokemon.");        
            }

            if (keyboard.nextLine().equals(""));
            {
                Pling.run();
                System.out.println("In fact, there are many, many secrets surrounding pokemon.");                    
            }

            if (keyboard.nextLine().equals(""));
            {
                Pling.run();
                System.out.println("To unravel pokemon mysteries, I've devoted my life to research.\nThat's what I do.");                        
            }

            if (keyboard.nextLine().equals(""));
            {
                Pling.run();
                System.out.println("But I need your help.");                        
            }

            System.out.println("First, you must choose your initial pokemon. Type the name of the pokemon you would like to start with:\nSquirtle\nCharmander\nBulbasaur\n");
            boolean goodChoice = false;
            String choice = keyboard.nextLine();
            while(!goodChoice)
            {
                if (choice.equalsIgnoreCase("Squirtle"))
                {
                    Pling.run();
                    pokemonList.add(new Squirtle());
                    System.out.println("Now, you are ready to begin your own adventure with your new Squirtle! (type \"Woohoo!\")");
                    goodChoice = true;
                }
                else if (choice.equalsIgnoreCase("Charmander"))
                {
                    Pling.run();
                    pokemonList.add(new Charmander());
                    System.out.println("Now, you are ready to begin your own adventure with your new Charmander! (type \"Woohoo!\")");
                    goodChoice = true;
                }
                else if (choice.equalsIgnoreCase("Bulbasaur"))
                {
                    Pling.run();
                    pokemonList.add(new Bulbasaur());
                    System.out.println("Now, you are ready to begin your own adventure with your new Bulbasour! (type \"Woohoo!\")");
                    goodChoice = true;
                }
                else if(choice.equalsIgnoreCase("test"))
                {
                    Pling.run();
                    pokemonList.add(new Charmander(40));
                    pokemonList.add(new Useless());
                    pokemonList.add(new SawClaw(30));
                    System.out.println("You found our easter egg! Very clever. *VIC WAS HERE*");
                    goodChoice = true;
                }
                else
                {
                    Pling.run();
                    System.out.println("That's not a choice! Please type the name of one of these pokemon.");
                    choice = keyboard.nextLine();
                }
            }

            if (keyboard.nextLine().equals(""));
            {
                Pling.run();
                System.out.println("Take courage, and leap into the world of pokemon where dreams, adventure, and friendships await!");
            }
            intro.stop();
        }

        game.play();
        Saving.serializePlay(game);
    }
}