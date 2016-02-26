
/**
 * Build's player's bag.
 * 
 * @author (Mohit Sani) 
 * @version (5/18/14)
 */
public class Bag
{
    private int regPokeballs;
    private int proPokeballs;
    private int weakMedicine;
    private int strongMedicine;

    public Bag() //really didn't have to be written...
    {
        regPokeballs = 0;
        proPokeballs = 0;
        weakMedicine = 0;
        strongMedicine = 0;
    }

    public void addRegPokeball()
    {
        regPokeballs++;
    }
    
    public void addRegPokeball(int balls)
    {
        regPokeballs = regPokeballs + balls;
    }

    public void addProPokeball()
    {
        proPokeballs++;
    }

    public void addWeakMedicine()
    {
        weakMedicine++;
    }
    
    public void addWeakMedicine(int medicine)
    {
        weakMedicine = weakMedicine + medicine;
    }

    public void addStrongMedicine()
    {
        strongMedicine++;
    }
    
    public void subRegPokeballs()
    {
        regPokeballs = regPokeballs - 1;
    }
    
    public void subProPokeballs()
    {
        proPokeballs = proPokeballs - 1;
    }
    
    public void subWeakMedicine()
    {
        weakMedicine = weakMedicine - 1;
    }
    
    public void subStrongMedicine()
    {
        strongMedicine = strongMedicine - 1;
    }

    public int getRegPokeballs()
    {
        return regPokeballs;
    }

    public int getProPokeballs()
    {
        return proPokeballs;
    }
    
    public int getWeakMedicine()
    {
        return weakMedicine;
    }
    
    public int getStrongMedicine()
    {
        return strongMedicine;
    }
}
