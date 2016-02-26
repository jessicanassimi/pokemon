
/**
 * Write a description of class Grass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Grass
{
    private static Player tanny;
    private static Pokemon cpuPokemon;
    private static int cpuPokemonIndex;
    private static ArrayList<Pokemon> pokemon;
    private static boolean isInGrass;
    private static Scanner keyboard = new Scanner(System.in);
    private static Music pling = new Music("sound/Pling.wav");
    private static Music grass = new Music("sound/Grass.wav");
    
    public Grass(Player mainCharacter)
    {
        tanny = mainCharacter;
        pokemon = new ArrayList<Pokemon>();
        initializeCPU();
        isInGrass = true;
    }

    public static void main()
    {
        grass.run();
        while (isInGrass)
        {
            tanny.getLocation().print();
            System.out.println("Do you want to go: \"Left\", \"Right\", \"Up\", or \"Down\"?");
            System.out.println("Enter \"Leave\" if you want to leave.");
            String choice = keyboard.nextLine();
            if (choice.equalsIgnoreCase("Left"))
            {
                pling.run();
                if(tanny.getLocation().isLeft())
                    System.out.println("You can't move out of the grid!");
                else
                {
                    tanny.getLocation().moveLeft();
                    tanny.getLocation().print();
                    checkMove();
                }
            }
            else if (choice.equalsIgnoreCase("Right"))
            {
                pling.run();
                if(tanny.getLocation().isRight())
                    System.out.println("You can't move out of the grid!");
                else
                {
                    tanny.getLocation().moveRight();
                    tanny.getLocation().print();
                    checkMove();
                }
            }
            else if (choice.equalsIgnoreCase("Up"))
            {
                pling.run();
                if(tanny.getLocation().isTop())
                    System.out.println("You can't move out of the grid!");
                else
                {
                    tanny.getLocation().moveUp();
                    tanny.getLocation().print();
                    checkMove();
                }
            }
            else if (choice.equalsIgnoreCase("Down"))
            {
                pling.run();
                if(tanny.getLocation().isBottom())
                    System.out.println("You can't move out of the grid!");
                else
                {
                    tanny.getLocation().moveDown();
                    tanny.getLocation().print();
                    checkMove();
                }
            }
            else if (choice.equalsIgnoreCase("Leave"))
            {
                pling.run();
                grass.stop();
                isInGrass = false;
            }
            else
            {
                System.out.println("\f");
                System.out.println("That's not an option! Please check for typos.");
                if (keyboard.nextLine().equals(""));
                pling.run();
            }
        }
    }

    public static void initializeCPU()
    {
        /*if (cpuPokemon != null)
        {
        pokemon.remove(cpuPokemonIndex);
        }*/
        //o better initializing of level (make it random past a little higher)

        pokemon = new ArrayList<Pokemon>();
        pokemon.add(new Squirtle((int)(Math.random()*tanny.getPokemon().get(0).getLevel() + 2)));
        pokemon.add(new Charmander((int)(Math.random()*tanny.getPokemon().get(0).getLevel() + 2)));
        pokemon.add(new Bulbasaur((int)(Math.random()*tanny.getPokemon().get(0).getLevel() + 2)));
        pokemon.add(new PikaChu((int)(Math.random()*tanny.getPokemon().get(0).getLevel() + 2)));
        pokemon.add(new Useless((int)(Math.random()*tanny.getPokemon().get(0).getLevel() + 2)));
        pokemon.add(new Oddish((int)(Math.random()*tanny.getPokemon().get(0).getLevel() + 2)));
        pokemon.add(new Jigglypuff((int)(Math.random()*tanny.getPokemon().get(0).getLevel() + 2)));
        pokemon.add(new Psyduck((int)(Math.random()*tanny.getPokemon().get(0).getLevel() + 2)));
        pokemon.add(new SawClaw((int)(Math.random()*tanny.getPokemon().get(0).getLevel() + 2)));
        pokemon.add(new Psyduck((int)(Math.random()*tanny.getPokemon().get(0).getLevel() + 2)));
        pokemon.add(new Weedle((int)(Math.random()*tanny.getPokemon().get(0).getLevel() + 2)));
        pokemon.add(new Caterpie((int)(Math.random()*tanny.getPokemon().get(0).getLevel() + 2)));
        pokemon.add(new Pidgey((int)(Math.random()*tanny.getPokemon().get(0).getLevel() + 2)));
        //We want to leave the pokemon ArrayList UNTOUCHED... we have to prevent aliasing by using the new keyword...
        //cpuPokemon = pokemon.get(cpuPokemonIndex); This for instance, creates flaws by altering the list of pokemon.
        ///OOOORRRRRRRRRRR we can use the line above and then just reinitialize the pokemon ArrayList after each battle!
        //which is much better since we can't know which pokemon to recreate in the cpuPokemon due to randomnes...
        //cpuPokemon = new 

        cpuPokemonIndex = (int)(Math.random() * pokemon.size());
        cpuPokemon = pokemon.get(cpuPokemonIndex);
    }

    public static void checkMove()
    {
        if(Math.random() < .5)
        {
            grass.stop();
            ArrayList<Pokemon> singlePoke = new ArrayList<Pokemon>();
            singlePoke.add(cpuPokemon);
            Player temp = new Player(singlePoke, new Location());
            tanny.battle(temp);
            //AddPostBattleAdditionsHere!!!!!!!!!!!!!!!!!!!!!
            if (!tanny.arePokemonAlive())
            {
                System.out.println("You have no healthy pokemon. It is unsafe for you in the wild grass.");
                System.out.println("You have been taken back home for your own protection");
                System.out.println("and so you can heal your pokemon.");
                isInGrass = false;
                if(keyboard.nextLine().equals(""));
            }
            initializeCPU();
            tanny.getLocation().print();
        }
        else if(Math.random() > .9)
        {
            System.out.println("You found 100 PokeDollars!");
            tanny.addMoney(100);
        }
    }
}