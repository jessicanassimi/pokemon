
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Player
{
    private ArrayList<Pokemon> pokemonList;
    private ArrayList<Pokemon> storedSpecies;
    private Location location = new Location();
    private Bag bag = new Bag();
    private int money;
    
    public Player(ArrayList<Pokemon> pokemon, Location loc)
    {
        pokemonList = pokemon;
        location = loc;
        storedSpecies = new ArrayList<Pokemon>();
        money = 0;
    }
    
    public ArrayList<Pokemon> getPokemon()
    {
        return pokemonList;
    }
    
    public ArrayList<Pokemon> getStored()
    {
        return storedSpecies;
    }
    
    public void set(int i, Pokemon newPoke)
    {
       pokemonList.set(i, newPoke);
    }
    
    public Location getLocation()
    {
        return location;
    }
    
    public Bag getBag()
    {
        return bag;
    }
    
    public void move(Location newLoc)
    {
        location = newLoc;
    }
    
    public void battle(Player opponent)
    {
        /*int index = 0;
        boolean isStillFighting = true;
        while (isStillFighting)
        {
            if(opponent.getPokemon().get(index).isDead())
            {
                opponent.release(opponent.getPokemon().get(++index));
            }
        }*/
        

        {
            if (isStillFighting())
            {
                Battle bat = new Battle(this, opponent);
                bat.main();
            }
            else
            {
                //wait till loop finishes
            }
        }
    }
    
    public boolean isStillFighting()
    {
        boolean result = false;
        for(Pokemon element: pokemonList)
        {
            if (element.getHealth() != 0)
                result = true;
        }
        return result;
    }
    
    public void addPokemon(Pokemon temp) //adds pokemon to storedSpecies when a pokemon is caught
    {
        if (storedSpecies.size() == 0)
        {
            storedSpecies.add(temp);
        }
        else
        {
            for (int i = 0; i<storedSpecies.size()-1; i++) //puts pokemon in correct alphabetical position
            {
                if(storedSpecies.get(i).getName().compareTo(temp.getName()) <= 0) //&& storedSpecies.get(i+1).getName().compareTo(temp.getName()) >= 0)
                    storedSpecies.add(i,temp);     //UNNEEDED THE FIRST TIME THE FIRST PART EVALUATES TO TRUE THE SECOND MUST EVALUATE TO TRUE AS WELL
            }
        }//copied from end of depositPokemon()
    }
    
    public void addMoney(int cash)
    {
        money += cash;
    }
    
    public void loseMoney(int cash)
    {
        money -= cash;
    }
    
    public int getMoney()
    {
        return money;
    }
    
    public boolean arePokemonAlive()
    {
        boolean alive = false;
        for(int i = 0; i<getPokemon().size(); i++)
            if(getPokemon().get(i).getHealth() != 0)
                alive = true;
        return alive;
    }
    
    public void printStatus()
    {
        System.out.println("---------Status---------");
        for(int y = 0; y < pokemonList.size(); y = y + 1)
        {
            int hold = 20 - (pokemonList.get(y).getName().length() + 9);
            System.out.print("Pokemon: ");
            System.out.print(pokemonList.get(y).getName());
            for(int z = 0; z < hold; z++)
            {
                System.out.print(" ");
            }
        }
        System.out.println(" ");
        for(int y = 0; y <  pokemonList.size(); y++)
        {
            String sizeHold1 = pokemonList.get(y).getLevel() + "";
            int hold = 20 - (sizeHold1.length() + 7);
            System.out.print("Level: ");
            System.out.print(pokemonList.get(y).getLevel());
            for(int z = 0; z < hold; z++)
            {
                System.out.print(" ");
            }
        }
        System.out.println(" ");
        for(int y = 0; y <  pokemonList.size(); y++)
        {
            String sizeHold1 = pokemonList.get(y).getHealth() + "";
            String sizeHold2 = pokemonList.get(y).getTotalHealth() + "";
            int hold = 20 - (sizeHold1.length() + sizeHold2.length() + 9);
            System.out.print("Health: ");
            System.out.print(pokemonList.get(y).getHealth());
            System.out.print("/");
            System.out.print(pokemonList.get(y).getTotalHealth());
            for(int z = 0; z < hold; z++)
            {
                System.out.print(" ");
            }
        }
        System.out.println(" ");
        for(int y = 0; y <  pokemonList.size(); y++)
        {
            String sizeHold1 = pokemonList.get(y).getExp() + "";
            String sizeHold2 = pokemonList.get(y).getTotalExp() + "";
            int hold = 20 - (sizeHold1.length() + sizeHold2.length() + 6);
            System.out.print("EXP: ");
            System.out.print(pokemonList.get(y).getExp());
            System.out.print("/");
            System.out.print(pokemonList.get(y).getTotalExp());
            for(int z = 0; z < hold; z++)
            {
                System.out.print(" ");
            }
        }
        System.out.println("\n");
    }
}
