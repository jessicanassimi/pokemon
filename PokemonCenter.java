
/**
 * Write a description of class PokemonCenter here.
 * 
 * @author (Mohit Sani) 
 * @version (5/16/14)
 */

import java.util.ArrayList;
import java.util.Scanner;

public class PokemonCenter
{
    private static Player tanny; //static because every Pokemon Center in our game will treat our main character
    //private static ArrayList<Pokemon> storedSpecies;// = new ArrayList<Pokemon>(); //every Pokemon Center MUST allow you to access all your pokemon!!!
    private static Scanner keyboard = new Scanner(System.in);
    private static Music pokeCenter = new Music("sound/Pokemon Center.wav");
    private static Music pling = new Music("sound/Pling.wav");
    public PokemonCenter(Player mainCharacter)
    {
        tanny = mainCharacter;
        //storedSpecies = tanny.getStored();
    }

    public static void main()
    {
        pokeCenter.run();
        System.out.println("\f");
        boolean isStillThere = true;
        while (isStillThere)
        {
            System.out.println("What do you want to do?");
            System.out.println("\"Deposit Pokemon\"");
            System.out.println("\"Withdraw Pokemon\"");
            System.out.println("\"Heal Pokemon\"");
            System.out.println("\"Release Pokemon\"");
            System.out.println("\"Buy Items\"");
            System.out.println("\"Sell Items\"");
            System.out.println("\"Leave\"");
            tanny.printStatus();
            String choice = keyboard.nextLine();
            if (choice.equalsIgnoreCase("Deposit Pokemon"))
            {
                pling.run();
                depositPokemon();
                //which pokemon would you like to deposit... print with index numbers as in other method (battle?)
                //and set health to full (pokemonName.fullHealth();)
            }
            else if (choice.equalsIgnoreCase("Withdraw Pokemon"))
            {
                pling.run();
                //check if you have a full stash (6 pokemon in your private arraylist... if not pokemonList.add(pokemonName)
                withdrawPokemon();
            }
            else if (choice.equalsIgnoreCase("Heal Pokemon"))
            {
                pling.run();
                pokeCenter.stop();
                heal();
            }
            else if (choice.equalsIgnoreCase("Release Pokemon"))
            {
                pling.run();
                releasePokemon();
            }
            else if (choice.equalsIgnoreCase("Buy Items"))
            {
                pling.run();
                buy();
            }
            else if(choice.equalsIgnoreCase("Sell Items"))
            {
                pling.run();
                sell();
            }            
            else if (choice.equalsIgnoreCase("Leave"))
            {
                pling.run();
                pokeCenter.stop();
                isStillThere = false;
            }
            else
            {
                System.out.println("\f");
                System.out.println("That's not an option! Please check for typos. (Press Enter to Continue)");
                
                if (keyboard.nextLine().equals(""));
                pling.run();
                System.out.println("\f");
            }
        }
        pokeCenter.stop();
    }

    public static void heal() //heals pokemon mainCharacter is carrying //we have to switch all tanny to mainCharacter
    {
        Music recovery = new Music("sound/Recovery.wav");
        recovery.run();
        System.out.println("\f");
        for(Pokemon element:tanny.getPokemon())
        {
            element.fullHealth();
        }
        System.out.println("Please wait while your pokemon heal(Press Enter to Continue)");
        if (keyboard.nextLine().equals(""));
        pling.run();
        System.out.println("Your pokemon are fresh and ready to go!(Press Enter to Continue)");
        tanny.printStatus();
        if (keyboard.nextLine().equals(""));
        pling.run();
        recovery.stop();
        pokeCenter.run();
        System.out.println("\f");
    }

    public static void depositPokemon()
    {
        if (tanny.getPokemon().size() == 1)
        {   
            System.out.println("\f");
            System.out.println("You only have one pokemon! You can't make any deposits! You'll be empty handed! (Press Enter to Continue)");
            if(keyboard.nextLine().equals(""));
            pling.run();
            System.out.println("\f");
        }
        else
        {
            System.out.println("\f");
            System.out.println("Which pokemon would you like to deposit?");
            System.out.println("Enter the number next to the pokemon to choose that pokemon.");
            System.out.println("If you would like to cancel enter -1.");
            for (int i = 0; i<tanny.getPokemon().size();i++)
                System.out.println(i + " - " + tanny.getPokemon().get(i).getName());
            int choice = Integer.parseInt(keyboard.nextLine());
            if(choice == -1)
            {
                pling.run();
                System.out.println("\f");
            }
            else if (choice > tanny.getPokemon().size() || choice < 0)
            {
                pling.run();
                System.out.println("Please put valid choice (Press Enter to Continue)");
                if(keyboard.nextLine().equals(""));
                pling.run();
                System.out.println("\f");
            }
            else
            {
                pling.run();
                Pokemon temp = tanny.getPokemon().remove(choice);
                if (tanny.getStored().size() == 0)
                {
                    tanny.getStored().add(temp);
                }
                else
                {
                    for (int i = 0; i<tanny.getStored().size()-1; i++) //puts pokemon in correct alphabetical position
                    {
                        if(tanny.getStored().get(i).getName().compareTo(temp.getName()) <= 0) //&& storedSpecies.get(i+1).getName().compareTo(temp.getName()) >= 0)
                            tanny.getStored().add(i,temp);     //UNNEEDED THE FIRST TIME THE FIRST PART EVALUATES TO TRUE THE SECOND MUST EVALUATE TO TRUE AS WELL
                    }
                }
                System.out.println("\f");
            }
        }
    }

    public static void withdrawPokemon()
    {
        if(tanny.getStored().size() == 0)
        {
            System.out.println("\f");
            System.out.println("You don't have any stored pokemon to withdraw! (Press Enter to Continue)");
            if (keyboard.nextLine().equals(""));
            pling.run();
            System.out.println("\f");
        }
        else if (tanny.getPokemon().size() == 6)
        {
            System.out.println("\f");
            System.out.println("You cannot carry more than six pokemon at a time! (Press Enter to Continue)");
            if (keyboard.nextLine().equals(""));
            pling.run();
            System.out.println("\f");
        }
        else
        {
            System.out.println("\f");
            System.out.println("Which pokemon would you like to withdraw?");
            System.out.println("Enter the number next to the pokemon to choose that pokemon.");
            System.out.println("If you would like to cancel enter -1.");
            for (int i = 0; i<tanny.getStored().size();i++)
                System.out.println(i + " - " + tanny.getStored().get(i).getName());
            int choice = Integer.parseInt(keyboard.nextLine());
            if (choice == -1)
            {
                pling.run();
                System.out.println("\f");
            }
            else if(choice > tanny.getStored().size() || choice < 0)
            {
                pling.run();
                System.out.println("\f");
                System.out.println("Please input a valid choice (Press Enter to Continue)");
                if (keyboard.nextLine().equals(""));
                pling.run();
                System.out.println("\f");
            }
            else
            {
                Pokemon temp = tanny.getStored().remove(choice);
                tanny.getPokemon().add(temp);
                System.out.println("\f");
            }
        }
    }

    public static void releasePokemon() //releases this pokemon back into wild (gets rid of it)
    {
        System.out.println("\f");
        if(tanny.getStored().size() == 0)
        {
            System.out.println("\f");
            System.out.println("You don't have any stored pokemon to release!");
            if (keyboard.nextLine().equals(""));
            pling.run();
            System.out.println("Remember - You can only release stored pokemon!");
            if (keyboard.nextLine().equals(""));
            pling.run();
            System.out.println("\f");
        }
        else
        {
            System.out.println("Which pokemon would you like to release?");
            System.out.println("Enter the number next to the pokemon to choose that pokemon.");
            System.out.println("If you would like to cancel enter -1.");
            for (int i = 0; i<tanny.getStored().size();i++)
                System.out.println(i + " - " + tanny.getStored().get(i).getName());
            int choice = Integer.parseInt(keyboard.nextLine());
            if (choice == -1)
            {
                System.out.println("\f");
                pling.run();
            }
            else if(choice > tanny.getStored().size() || choice < 0)
            {
                System.out.println("\f");
                System.out.println("Please Input a Valid Choice (Press Enter to Continue)");
                if (keyboard.nextLine().equals(""));
                pling.run();
                System.out.println("\f");
            }
            else
            {
                pling.run();
                tanny.getStored().remove(choice);
                System.out.println("\f");
            }
        }//parts copied from withdrawPokemon
    }

    public static void buy()
    {
        boolean isShopping = true;
        while(isShopping)
        {
            System.out.println("\f");
            System.out.println("What would you like to buy?");
            System.out.println("------------------------");
            System.out.println("Money: " + tanny.getMoney());
            System.out.println("\"Regular Pokeball\"");
            System.out.println("\"Professional Pokeball\"");
            System.out.println("\"Weak Medicine\"");
            System.out.println("\"Strong Medicine\"");
            System.out.println("\"Leave\"");
            System.out.println("------------------------");
            String choice = keyboard.nextLine();
            int quantity;

            /*if (choice.equals("Regular Pokeball"))
            {
            tanny.getBag().addRegPokeball();
            }
            else if (choice.equals("Professional Pokeball"))
            {
            tanny.getBag().addProPokeball();
            }
            else if (choice.equals("Weak Medicine"))
            tanny.getBag().addWeakMedicine();
            else if (choice.equals("Strong Medicine"))
            tanny.getBag().addStrongMedicine();
            else if (choice.equals("Leave"))
            //main(); goes back because of loop anyways
            isShopping = false;
            else
            System.out.println("That's not an option! Please check for typos.");*/
            if(choice.equalsIgnoreCase("Regular Pokeball"))
            {
                pling.run();
                System.out.println("This pokeball costs 50 PokeDollars.");
                System.out.println("You have " + tanny.getMoney() + " PokeDollars");

                System.out.println("How many would you like to buy? (Enter a number)");
                quantity = keyboard.nextInt();
                keyboard.nextLine();

                if (tanny.getMoney() >= 50 * quantity)
                {
                    pling.run();
                    if (verify("you want to buy this product"))
                    {
                        pling.run();
                        for(int i = 0; i < quantity; i++)
                        {
                            tanny.getBag().addRegPokeball();
                        }
                        tanny.loseMoney(50 * quantity);
                    }
                }
                else
                {
                    System.out.println("\f");
                    System.out.println("You don't have enough PokeDollars!");
                    if (keyboard.nextLine().equals(""));
                    pling.run();
                    System.out.println("Tip: You can find money by walking through Wild Grass.");
                    if (keyboard.nextLine().equals(""));
                    pling.run();
                }
            }
            else if(choice.equalsIgnoreCase("Professional Pokeball"))
            {
                pling.run();
                System.out.println("This pokeball costs 100 PokeDollars.");
                System.out.println("You have " + tanny.getMoney() + " PokeDollars");

                System.out.println("How many would you like to buy? (Enter a number)");
                quantity = keyboard.nextInt();
                keyboard.nextLine();

                if (tanny.getMoney() >= 100 * quantity)
                {
                    pling.run();
                    if (verify("you want to buy this product"))
                    {
                        pling.run();
                        for(int i = 0; i < quantity; i++) tanny.getBag().addProPokeball();
                        tanny.loseMoney(100 * quantity);
                    }
                }
                else
                {
                     System.out.println("\f");
                    System.out.println("You don't have enough PokeDollars!");
                    if (keyboard.nextLine().equals(""));
                    pling.run();
                    System.out.println("Tip: You can find money by walking through Wild Grass.");
                    if (keyboard.nextLine().equals(""));
                    pling.run();
                }
            }
            else if(choice.equalsIgnoreCase("Weak Medicine"))
            {
                pling.run();
                System.out.println("This medicine costs 50 PokeDollars.");
                System.out.println("You have " + tanny.getMoney() + " PokeDollars");

                System.out.println("How many would you like to buy? (Enter a number)");
                quantity = keyboard.nextInt();
                keyboard.nextLine();

                if (tanny.getMoney() >= 50 * quantity)
                {
                    pling.run();
                    if (verify("you want to buy this product"))
                    {
                        pling.run();
                        for(int i = 0; i < quantity; i++) tanny.getBag().addWeakMedicine();
                        tanny.loseMoney(50 * quantity);
                    }
                }
                else
                {
                    System.out.println("\f");
                    System.out.println("You don't have enough PokeDollars!");
                    if (keyboard.nextLine().equals(""));
                    pling.run();
                    System.out.println("Tip: You can find money by walking through Wild Grass.");
                    if (keyboard.nextLine().equals(""));
                    pling.run();
                }
            }
            else if(choice.equalsIgnoreCase("Strong Medicine"))
            {
                pling.run();
                System.out.println("This pokeball costs 100 PokeDollars.");
                System.out.println("You have " + tanny.getMoney() + " PokeDollars");

                System.out.println("How many would you like to buy? (Enter a number)");
                quantity = keyboard.nextInt();
                keyboard.nextLine();

                if (tanny.getMoney() >= 100 * quantity)
                {
                    pling.run();
                    if (verify("you want to buy this product"))
                    {
                        pling.run();
                        for(int i = 0; i < quantity; i++) tanny.getBag().addStrongMedicine();
                        tanny.loseMoney(100 * quantity);
                    }
                }
                else
                {
                    System.out.println("\f");
                    System.out.println("You don't have enough PokeDollars!");
                    if (keyboard.nextLine().equals(""));
                    pling.run();
                    System.out.println("Tip: You can find money by walking through Wild Grass.");
                    if (keyboard.nextLine().equals(""));
                    pling.run();
                }
            }
            else if (choice.equalsIgnoreCase("Leave"))
            {   
                System.out.println("\f");
                pling.run();
                isShopping = false;
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
    // FIX SELL TO LOOK LIKE BUY()
    public static void sell()
    {
        boolean isShopping = true;
        while(isShopping)
        {
            System.out.println("\f");
            System.out.println("What would you like to sell?");
            System.out.println("------------------------");
            System.out.println("You have:");
            System.out.println("\"Regular Pokeball\": " + tanny.getBag().getRegPokeballs());
            System.out.println("\"Professional Pokeball\": " + tanny.getBag().getProPokeballs());
            System.out.println("\"Weak Medicine\": " + tanny.getBag().getWeakMedicine());
            System.out.println("\"Strong Medicine\": " + tanny.getBag().getStrongMedicine());
            System.out.println("\"Leave\"");
            System.out.println("------------------------");
            String choice = keyboard.nextLine();
            int quantity;

            if(choice.equalsIgnoreCase("Regular Pokeball"))
            {
                pling.run();
                System.out.println("This pokeball costs 25 PokeDollars.");
                System.out.println("You have " + tanny.getMoney() + " PokeDollars");

                System.out.println("How many would you like to sell? (Enter a number)");
                quantity = keyboard.nextInt();
                keyboard.nextLine();

                if (quantity <= tanny.getBag().getRegPokeballs())
                {
                    pling.run();
                    if(verify("you want to sell this product"))
                    {
                        pling.run();
                        tanny.addMoney(quantity * 25);
                        for(int i = 0; i < quantity; i++) tanny.getBag().subRegPokeballs();
                        System.out.println("You now have " + tanny.getMoney() + " PokeDollars");
                    }
                }  
                else
                {
                     System.out.println("\f");
                    System.out.println("You don't have enough PokeDollars!");
                    if (keyboard.nextLine().equals(""));
                    pling.run();
                    System.out.println("Tip: You can find money by walking through Wild Grass.");
                    if (keyboard.nextLine().equals(""));
                    pling.run();
                }
            }
            else if(choice.equalsIgnoreCase("Professional Pokeball"))
            {
                pling.run();
                System.out.println("This pokeball costs 50 PokeDollars.");
                System.out.println("You have " + tanny.getMoney() + " PokeDollars");

                System.out.println("How many would you like to sell? (Enter a number)");
                quantity = keyboard.nextInt();
                keyboard.nextLine();

                if (quantity <= tanny.getBag().getProPokeballs())
                {
                    pling.run();
                    if(verify("you want to sell this product"))
                    {
                        pling.run();
                        tanny.addMoney(quantity * 50);
                        for(int i = 0; i < quantity; i++) tanny.getBag().subProPokeballs();
                        System.out.println("You now have " + tanny.getMoney() + " PokeDollars");
                    } 
                }
                else
                {
                    System.out.println("\f");
                    System.out.println("You don't have enough PokeDollars!");
                    if (keyboard.nextLine().equals(""));
                    pling.run();
                    System.out.println("Tip: You can find money by walking through Wild Grass.");
                    if (keyboard.nextLine().equals(""));
                    pling.run();
                }
            }
            else if(choice.equalsIgnoreCase("Weak Medicine"))
            {
                pling.run();
                System.out.println("This medicine costs 25 PokeDollars");
                System.out.println("You have " + tanny.getMoney() + " PokeDollars");

                System.out.println("How many would you like to sell? (Enter a number)");
                quantity = keyboard.nextInt();
                keyboard.nextLine();

                if (quantity <= tanny.getBag().getWeakMedicine())
                {
                    pling.run();
                    if(verify("you want to sell this product"))
                    {
                        pling.run();
                        tanny.addMoney(quantity * 25);
                        for(int i = 0; i < quantity; i++) tanny.getBag().subWeakMedicine();
                        System.out.println("You now have " + tanny.getMoney() + " PokeDollars");
                    } 
                }
                else
                {
                    System.out.println("\f");
                    System.out.println("You don't have enough PokeDollars!");
                    if (keyboard.nextLine().equals(""));
                    pling.run();
                    System.out.println("Tip: You can find money by walking through Wild Grass.");
                    if (keyboard.nextLine().equals(""));
                    pling.run();
                }
            }
            else if (choice.equalsIgnoreCase("Strong Medicine"))
            {
                pling.run();
                System.out.println("This medicine sells for 50 Pokedolars.");
                System.out.println("You have " + tanny.getMoney() + " PokeDollars");

                System.out.println("How many would you like to sell? (Enter a number)");
                quantity = keyboard.nextInt();
                keyboard.nextLine();

                if (quantity <= tanny.getBag().getWeakMedicine())
                {
                    pling.run();
                    if(verify("you want to sell this product"))
                    {
                        pling.run();
                        tanny.addMoney(quantity * 50);
                        for(int i = 0; i < quantity; i++) tanny.getBag().subStrongMedicine();
                        System.out.println("You now have " + tanny.getMoney() + " PokeDollars");
                    } 
                } 
                else
                {
                     System.out.println("\f");
                    System.out.println("You don't have enough PokeDollars!");
                    if (keyboard.nextLine().equals(""));
                    pling.run();
                    System.out.println("Tip: You can find money by walking through Wild Grass.");
                    if (keyboard.nextLine().equals(""));
                    pling.run();
                }
            }
            else if (choice.equalsIgnoreCase("Leave"))
            {
                System.out.println("\f");
                pling.run();
                isShopping = false;
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

    //Commented out because i didnt know if it was really needed or not BUT SERIOUSLY LOOK AT WHAT YOU ARE DOING WITH THIS CODE
    //public ArrayList<Pokemon> getStored()
    //{
    //    return tanny.getStored();
    //}

    public static boolean verify(String question)
    {
        boolean stillVerifying = true;
        while(stillVerifying)
        {
            System.out.println("Are you sure " + question + "? (Respond \"Yes\" or \"No\")");
            String choice = keyboard.nextLine();
            if (choice.equalsIgnoreCase("Yes"))
                return true;
            else if (choice.equalsIgnoreCase("No"))
                return false;
            else
                System.out.println("That's not an option! Please check for typos.");
        }
        return false; //This statement will never be reached.
    }

    /*public boolean verifyPrice(String choice)
    {
    if(choice.equals("Regular Pokeball"))
    {
    System.out.println("This pokeball costs 50 PokeDollars.");
    if (verify("you want to buy this product?"))
    {
    tanny.getBag().addRegPokeball();
    tanny.loseMoney(50);
    }
    }
    else if(choice.equals("Professional Pokeball"))
    {
    System.out.println("This pokeball costs 100 PokeDollars.");
    if (verify("you want to buy this product?"))
    {
    tanny.getBag().addRegPokeball();
    tanny.loseMoney(50);
    }
    }
    else if(choice.equals("Weak Medicine"))
    {
    System.out.println("This medicine costs 50 PokeDollars");
    if (verify("you want to buy this product?"))
    {
    tanny.getBag().addRegPokeball();
    tanny.loseMoney(50);
    }
    }
    else if (choice.equals("Strong Medicine"))
    {
    System.out.println("This medicine costs 100 Pokedolars.");
    if (verify("you want to buy this product?"))
    {
    tanny.getBag().addRegPokeball();
    tanny.loseMoney(50);
    }
    }
    else if (choice.equals("Leave"))
    {
    isShopping = false;
    }
    else
    System.out.println("That's not an option! Please check for typos.");
    }*/

    /*public static void doNothin()
    {
    //yeah... seriously...
    }*/
}
