public class Attack 
{
    private String name;
    private int attackPower;
    private int level;
    private int basePower;//ex http://bulbapedia.bulbagarden.net/wiki/Squirt...
    private String yourType;
    private int totalPP, pp;
    public Attack(String attackName,int inputLevel, int inputAttackPower, int inputBasePower, String inputYourType)
    {
        name = attackName;
        level = inputLevel;
        attackPower = inputAttackPower;
        basePower = inputBasePower;
        yourType = inputYourType;
    }

    public double typeMultiplier(Pokemon opponent)
    {
        //Fire effective against Grass, Fire weak to Water
        //Water effective aginst Fire, Water weak to Grass
        //Grass effective against Water, Grass weak to Fire
        if(yourType.equals(opponent.getType()))
        {
            System.out.println("Not Effective");
            return 0.5;
        }
        else if(yourType.equals( "Normal" ))
        {
            if(opponent.getType().equals("Rock"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
            else if( opponent.getType().equals("Steel"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
        }
        else if(yourType.equals( "Fire" ))
        {
            if( opponent.getType().equals("Water"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
            else if(opponent.getType().equals("Grass"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if(opponent.getType().equals("Ice"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if(opponent.getType().equals("Bug"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if(opponent.getType().equals("Rock"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
            else if(opponent.getType().equals("Dragon"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
            else if(opponent.getType().equals("Steel"))
            {
                System.out.println("Super Effective");
                return 2;
            }
        }        
        else if(yourType.equals("Water") )
        {
            if( opponent.getType().equals("Fire"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if( opponent.getType().equals("Grass"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
            else if(opponent.getType().equals("Ground"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
            else if(opponent.getType().equals("Rock"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if(opponent.getType().equals("Dragon"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
        }
        else if(yourType.equals("Grass"))
        {
            if(opponent.getType().equals("Fire"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
            else if( opponent.getType().equals("Water"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if(opponent.getType().equals("Poison"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
            else if(opponent.getType().equals("Ground"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if(opponent.getType().equals("Flying"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
            else if(opponent.getType().equals("Bug"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
            else if(opponent.getType().equals("Rock"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if(opponent.getType().equals("Dragon"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
            else if(opponent.getType().equals("Steel"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
        }
        else if(yourType.equals("Electric"))
        {
            if(opponent.getType().equals("Water"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if(opponent.getType().equals("Grass"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
            else if(opponent.getType().equals("Flying"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if(opponent.getType().equals("Dragon"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
        }
        else if(yourType.equals("Ice"))
        {
            if(opponent.getType().equals("Fire"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
            else if(opponent.getType().equals("Water"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
            else if(opponent.getType().equals("Grass"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if(opponent.getType().equals("Ground"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if(opponent.getType().equals("Flying"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if(opponent.getType().equals("Dragon"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if(opponent.getType().equals("Steel"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
        }
        else if(yourType.equals("Fighting"))
        {
            if(opponent.getType().equals("Normal"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if(opponent.getType().equals("Ice"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if(opponent.getType().equals("Poison"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
            else if(opponent.getType().equals("Flying"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
            else if(opponent.getType().equals("Psychic"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
            else if(opponent.getType().equals("Bug"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
            else if(opponent.getType().equals("Rock"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if(opponent.getType().equals("Dark"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if(opponent.getType().equals("Steel"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if(opponent.getType().equals("Fairy"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
        }
        else if(yourType.equals("Poison"))
        {  
            if(opponent.getType().equals("Grass"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if(opponent.getType().equals("Ground"))
            {
                System.out.println("Not Effective");
                return 0.5; 
            }
            else if(opponent.getType().equals("Rock"))
            {
                System.out.println("Not Effective");
                return 0.5; 
            }
            else if(opponent.getType().equals("Ghost"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
            else if(opponent.getType().equals("Fairy"))
            {
                System.out.println("Super Effective");
                return 2; 
            }
        }
        else if(yourType.equals("Ground"))
        {  
            if(opponent.getType().equals("Fire"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if(opponent.getType().equals("Grass"))
            {
                System.out.println("Not Effective");
                return 0.5; 
            }
            else if(opponent.getType().equals("Electric"))
            {
                System.out.println("Super Effective");
                return 2; 
            }
            else if(opponent.getType().equals("Poison"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if(opponent.getType().equals("Bug"))
            {
                System.out.println("Not Effective");
                return 0.5; 
            }
            else if(opponent.getType().equals("Rock"))
            {
                System.out.println("Super Effective");
                return 2; 
            }
            else if(opponent.getType().equals("Steel"))
            {
                System.out.println("Super Effective");
                return 2; 
            }
        }
        else if(yourType.equals("Flying"))
        {  
            if(opponent.getType().equals("Grass"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if(opponent.getType().equals("Electric"))
            {
                System.out.println("Not Effective");
                return 0.5; 
            }
            else if(opponent.getType().equals("Fighting"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if(opponent.getType().equals("Bug"))
            {
                System.out.println("Super Effective");
                return 2; 
            }
            else if(opponent.getType().equals("Rock"))
            {
                System.out.println("Not Effective");
                return 0.5; 
            }
            else if(opponent.getType().equals("Steel"))
            {
                System.out.println("Not Effective");
                return 0.5; 
            }
        }
        else if(yourType.equals("Psychic"))
        {  
            if(opponent.getType().equals("Fighting"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if(opponent.getType().equals("Poison"))
            {
                System.out.println("Super Effective");
                return 2; 
            }
            else if(opponent.getType().equals("Steel"))
            {
                System.out.println("Not Effective");
                return 0.5; 
            }
        }
        else if(yourType.equals("Bug"))
        {  
            if(opponent.getType().equals("Fire"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
            else if(opponent.getType().equals("Grass"))
            {
                System.out.println("Super Effective");
                return 2; 
            }
            else if(opponent.getType().equals("Fighting"))
            {
                System.out.println("Not Effective");
                return 0.5; 
            }
            else if(opponent.getType().equals("Poison"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
            else if(opponent.getType().equals("Flying"))
            {
                System.out.println("Not Effective");
                return 0.5; 
            }
            else if(opponent.getType().equals("Psychic"))
            {
                System.out.println("Super Effective");
                return 2; 
            }
            else if(opponent.getType().equals("Ghost"))
            {
                System.out.println("Not Effective");
                return 0.5; 
            }
            else if(opponent.getType().equals("Dark"))
            {
                System.out.println("Super Effective");
                return 2; 
            }
            else if(opponent.getType().equals("Steel"))
            {
                System.out.println("Not Effective");
                return 0.5; 
            }
            else if(opponent.getType().equals("Fairy"))
            {
                System.out.println("Not Effective");
                return 0.5; 
            }
        }
        else if(yourType.equals("Rock")) 
        {
            if(opponent.getType().equals("Fire"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if (opponent.getType().equals("Ice"))
            {
                System.out.println("Super Effective");
                return 2; 
            }
            else if (opponent.getType().equals("Fighting"))
            {
                System.out.println("Not Effective");
                return 0.5; 
            }
            else if (opponent.getType().equals("Ground"))
            {
                System.out.println("Not Effective");
                return 0.5; 
            }
            else if (opponent.getType().equals("Flying"))
            {
                System.out.println("Super Effective");
                return 2; 
            }
            else if (opponent.getType().equals("Bug"))
            {
                System.out.println("Super Effective");
                return 2; 
            }
            else if (opponent.getType().equals("Steel"))
            {
                System.out.println("Not Effective");
                return 0.5; 
            }
        }
        else if(yourType.equals("Ghost")) 
        {
            if(opponent.getType().equals("Psychic"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if (opponent.getType().equals("Dark"))
            {
                System.out.println("Not Effective");
                return 0.5; 
            }
        }
        else if(yourType.equals("Dragon")) 
        {
            if (opponent.getType().equals("Steel"))
            {
                System.out.println("Not Effective");
                return 0.5; 
            }
        }
        else if(yourType.equals("Dark")) 
        {
            if(opponent.getType().equals("Fighting"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
            else if (opponent.getType().equals("Psychic"))
            {
                System.out.println("Super Effective");
                return 2; 
            }
            else if (opponent.getType().equals("Ghost"))
            {
                System.out.println("Super Effective");
                return 2; 
            }
            else if (opponent.getType().equals("Fairy"))
            {
                System.out.println("Not Effective");
                return 0.5; 
            }
        }
        else if(yourType.equals("Steel")) 
        {
            if(opponent.getType().equals("Fire"))
            {
                System.out.println("Not Effective");
                return 0.5;
            }
            else if (opponent.getType().equals("Water"))
            {
                System.out.println("Not Effective");
                return 0.5; 
            }
            else if (opponent.getType().equals("Electric"))
            {
                System.out.println("Not Effective");
                return 0.5; 
            }
            else if (opponent.getType().equals("Ice"))
            {
                System.out.println("Super Effective");
                return 2; 
            }
            else if (opponent.getType().equals("Rock"))
            {
                System.out.println("Super Effective");
                return 2; 
            }
            else if (opponent.getType().equals("Fairy"))
            {
                System.out.println("Super Effective");
                return 2; 
            }
        }
        else if(yourType.equals("Fairy")) 
        {

            if (opponent.getType().equals("Fire"))
            {
                System.out.println("Not Effective");
                return 0.5;    
            }
            else if (opponent.getType().equals("Fighting"))
            {
                System.out.println("Super Effective");
                return 2; 
            }
            else if(opponent.getType().equals("Poison"))
            {
                System.out.println("Super Effective");
                return 2;
            }
            else if (opponent.getType().equals("Dragon"))
            {
                System.out.println("Super Effective");
                return 2;    
            }
            else if (opponent.getType().equals("Dark"))
            {
                System.out.println("Super Effective");
                return 2;    
            }
            else  if (opponent.getType().equals("Steel"))
            {
                System.out.println("Not Effective");
                return 0.5;    
            }
        }
        return 1;
    }

    public int skillDamage(Pokemon opponent)
    {
        int sixteen = (int)(Math.random()*16);
        int C = 1;
        if (sixteen == 0)
        {
            System.out.println("Critical Hit");
            C = 2;
        }
        int random = (int)(Math.random()*39) + 217;
        return (int)(((((level * 0.4 * C) + 2) * attackPower * basePower / 50 / opponent.getDefense()) + 2) * typeMultiplier(opponent) * random / 255);
    }

    public String getName() // returns attack name
    {
        return name;
    }
}