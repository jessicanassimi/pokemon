
import java.util.ArrayList;

public abstract class Pokemon     
{
    private String pokemon, type;
    private int totalHealth, attackDamage, defense, speed, special; //maximum value, used to find out the total amount of health in order to fully heal
    private int battleHealth; //, newAttackDmage, newDefense, newSpeed, newSpecial; *Values changes throughout the battle*
    private int baseHealth, baseAttackDamage, baseDefense, baseSpeed, baseSpecial; //Stats that all of the same pokemon have used to calculate the amount of health, attackDamage, defense etc. as the pokemon level up
    private int evHealth, evAttackDamage, evDefense, evSpeed, evSpecial; //gained every time player pokemon defeats a opponent, increases skills to calculate the amount of 
    private int ivHealth, ivAttackDamage, ivDefense, ivSpeed, ivSpecial; //random number from 1 - 15 every pokemon is born with which makes some pokemon more superior to another by luck
    private int totalexp, exp, level; //just like health the totalexp tells how much exp is needed to level up
    private ArrayList<Attack> attacks = new ArrayList<Attack>(4); //the attacks that the pokemon is going to have
    private ArrayList<Attack> unusedSkills = new ArrayList<Attack>();
    //private Attack attack1, attack2, attack3, attack4; //the attacks
    public Pokemon(String inputPokemon, String inputType, int inputLevel, int inputBaseHealth, int inputBaseAttackDamage, int inputBaseDefense, int inputBaseSpeed, int inputBaseSpecial)
    {
        ivHealth = (int)(Math.random() * 15);
        ivAttackDamage = (int)(Math.random() * 15);
        ivDefense = (int)(Math.random() * 15);
        ivSpeed = (int)(Math.random() * 15);
        ivSpecial = (int)(Math.random() * 15);
        pokemon = inputPokemon;
        level = inputLevel;
        type = inputType;
        exp = 0;
        totalexp = (int)Math.pow(level, 3);
        baseHealth = inputBaseHealth;
        baseAttackDamage = inputBaseAttackDamage;
        baseDefense = inputBaseDefense;
        baseSpeed = inputBaseSpeed;
        baseSpecial = inputBaseSpecial;
        totalHealth = (int)(((ivHealth + inputBaseHealth + (Math.sqrt(evHealth) / 8) + 50) * inputLevel) / 50 + 10); //tested right amount of HP
        battleHealth = totalHealth;
        attackDamage = (int)(((ivAttackDamage + baseAttackDamage + (Math.sqrt(evAttackDamage) / 8)) * level) / 50 + 5);
        defense = (int)(((ivDefense + baseDefense + (Math.sqrt(evDefense) / 8 )) * level) / 50 + 5);
        speed = (int)(((ivSpeed + baseSpeed + (Math.sqrt(evSpeed) / 8 )) * level) / 50 + 5);
        special = (int)(((ivSpecial + baseSpecial + (Math.sqrt(evSpecial / 8)) * level)) / 50 + 5);
    }
    
    public void changeName(String name)
    {
        pokemon = name;
    }

    public String getName()
    {
        return pokemon;
    }

    public String aAn()
    {
        String firstLetter = getName().substring(0,1);
        if(firstLetter == "a" || firstLetter == "e" || firstLetter == "i" || firstLetter == "o" || firstLetter == "u")
            return "an";
        else
            return "a";
    }
    
    public int getLevel()
    {
        return level;
    }

    public String getType()
    {
        return type;
    }
    
    public void changeBase(int inputBaseHealth, int inputAttackDamage, int inputBaseDefense, int inputBaseSpeed, int inputBaseSpecial)
    {
        baseHealth = inputBaseHealth;
        baseAttackDamage = inputAttackDamage;
        baseDefense = inputBaseDefense;
        baseSpeed = inputBaseSpeed;
        baseSpecial = inputBaseSpecial; 
    }

    public void levelup() //every time a pokemon levels up get the EV from the opponent pokemon base stats
    {
        level++;
        exp = 0;
        totalexp = (int)Math.pow(level, 3);
        //every level can create a status that shows how much stats has leveled up
        totalHealth = (int)(((ivHealth + baseHealth + (Math.sqrt(evHealth) / 8) + 50) * level) / 50 + 10); //tested right amount of HP
        attackDamage = (int)(((ivAttackDamage + baseAttackDamage + (Math.sqrt(evAttackDamage) / 8)) * level) / 50 + 5);
        defense = (int)(((ivDefense + baseDefense + (Math.sqrt(evDefense) / 8 )) * level) / 50 + 5);
        speed = (int)(((ivSpeed + baseSpeed + (Math.sqrt(evSpeed) / 8 )) * level) / 50 + 5);
        special = (int)(((ivSpecial + baseSpecial + (Math.sqrt(evSpecial / 8)) * level)) / 50 + 5);
    }

    public ArrayList<Attack> getAttacks()
    {
        return attacks;
    }
    
    public ArrayList<Attack> getUnusedSkills()
    {
        return unusedSkills;
    }
    
    //public abstract int getAttack(int choice, Pokemon opponent);

    //public abstract String returnAttacks();
    
    public abstract void automaticSkillAssign();
    
    public abstract boolean evolve();
    
    public void switchAttack(Attack newAttack) //used to switch out new skills that are gainned 
    {
        if(attacks.size() < 4)
        {
            attacks.add(newAttack);
        }
        else
        {
            attacks.remove(0);
            attacks.add(newAttack);
        }
    }

    public void switchAttack(Attack newAttack, String removeAttack) //used to switch out new skills that are gainned 
    {
        if(attacks.size() < 4)
        {
            attacks.add(newAttack);
        }
        else
        {
            for(int x = 0; x < attacks.size(); x = x + 1)
            {
                if(attacks.get(x).toString().equals(removeAttack))
                {
                    attacks.remove(x);
                    attacks.add(newAttack);
                }
            }
        }
    }
    
    public int getAttack(int choice, Pokemon opponent)
    {
        if(choice < 0 || choice > getAttacks().size())
        {
            return -1;
        }
        else
        {
            int hold = attacks.get(choice).skillDamage(opponent);
            if(hold < 0)
            {
                takeDamage(hold * -1);
                return hold * -1;
            }
            else
            {
                return hold;
            }
        }
    }
    
    public String returnAttacks()
    {
        String list = "";
        for (int i = 0; i<attacks.size(); i++)
        {
            list += i + " - " + attacks.get(i).getName() + "\n";
        }
        return list;
    }
    
    public boolean takeDamage(int damage) //functions as isAlive when calle poke.takeDamage(0);
    {
        battleHealth -= damage;
        if(battleHealth <= 0)
        {
            battleHealth = 0;
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public int getAttackDamage()
    {
        return (int)(((ivAttackDamage + baseAttackDamage + (Math.sqrt(evAttackDamage) / 8)) * level) / 50 + 5);
    }

    public int getDefense()
    {
        return (int)(((ivDefense + baseDefense + (Math.sqrt(evDefense) / 8 )) * level) / 50 + 5);
    }

    public int speed()
    {
        return (int)(((ivSpeed + baseSpeed + (Math.sqrt(evSpeed) / 8 )) * level) / 50 + 5);
    }

    public int special()
    {
        return (int)(((ivSpecial + baseSpecial + (Math.sqrt(evSpecial / 8)) * level)) / 50 + 5);
    }

    public int getHealth()
    {
        return battleHealth;
    }

    public void fullHealth()
    {
        battleHealth = totalHealth;
    }
    
    public int getTotalHealth()
    {
        return totalHealth;
    }
    
    public void addHealth(int health)
    {
        battleHealth = battleHealth + health;
        if(battleHealth > totalHealth)
        {
            fullHealth();
        }
    }
    
    //needed to be executed at the end of every pokemon dies
    public void addExp(Pokemon opponent)
    {
        exp = 2 * (exp + opponent.getAttackDamage() + opponent.getDefense() + opponent.speed() + opponent.special());
        if(exp >= totalexp)
        {
            levelup();
        }
    }

    public int getExp()
    {
        return exp;
    }
    
    public int getTotalExp()
    {
        return totalexp;
    }

    public int getBaseHealth()
    {
        return baseHealth;
    }

    public int getBaseAttackDamage()
    {
        return baseAttackDamage;
    }

    public int getBaseDefense()
    {
        return baseDefense;
    }

    public int getBaseSpeed()
    {
        return baseSpeed;
    }

    public int getBaseSpecial()
    {
        return baseSpecial;
    }

    //must be used after every fight *EV has a limit of 65535*
    public void increaseEV(Pokemon pokemon)
    {
        evHealth = evHealth + pokemon.getHealth();
        evAttackDamage = evAttackDamage + pokemon.getBaseAttackDamage();
        evDefense = evDefense + pokemon.getBaseDefense();
        evSpeed = evSpeed + pokemon.getBaseSpeed();
        evSpecial = evSpecial + pokemon.getBaseSpecial();
        if(evHealth >= 65535)
        {
            evHealth = 65535;
        }
        if(evAttackDamage >= 65535)
        {
            evAttackDamage = 65535;
        }
        if(evDefense >= 65535)
        {
            evDefense = 65535;
        }
        if(evSpeed >= 65535)
        {
            evSpeed = 65535;
        }
        if(evSpecial >= 65535)
        {
            evSpecial = 65535;
        }
    }

    public String toString()
    {
        return "Pokemon: " + pokemon + "\n" + "Health: " + battleHealth + "/" + totalHealth +"\n" + "Level: " + level + "\n" + "Exp: " + exp + "/" + totalexp;
    }
}
