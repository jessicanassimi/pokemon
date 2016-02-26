import java.util.ArrayList;
public class Pidgey extends Pokemon
{
    //Four moves that Pidgey has
    private Attack attack1, attack2, attack3, attack4;

    // All moves Pidgey can learn
    private Attack tackle, gust, quickattack, twister, wingattack, airslash, hurricane;

    //private ArrayList<Attack> attacks;
    private ArrayList<Attack> getUnusedSkills;
    public Pidgey()
    {
        super("Pidgey","Normal/Flying", 5, 40, 45, 40, 56, 35);
        //getAttacks() = new ArrayList<Attack>(4);
        getUnusedSkills = new ArrayList<Attack>();
        //health = 44;
        //attackDamage = 48;
        //defense = 65;
        //speed = 43;
        //special = 50;
        tackle = new Attack("Tackle", super.getLevel(), super.getAttackDamage(), 50, "Normal"); //starter skill
        gust = new Attack("Gust", super.getLevel(), super.getAttackDamage(), 40, "Flying");  //Level 9
        quickattack = new Attack("Quick Attack", super.getLevel(), super.getAttackDamage(), 40, "Normal");  //Level 13
        twister = new Attack("Twister", super.getLevel(), super.getAttackDamage(), 40, "Dragon");  //Level 21
        wingattack = new Attack("Wing Attack",super.getLevel(), super.getAttackDamage(), 60,"Flying");  //Level 33
        airslash = new Attack("Air Slash", super.getLevel(), super.getAttackDamage(), 75, "Flying");  //Level 49 getUnusedSkills.add(tackle);
        hurricane = new Attack("Hurricane", super.getLevel(), super.getAttackDamage(), 120, "Flying");  //Level 53 getUnusedSkills.add(tackle);
        
        
        getUnusedSkills.add(gust);
        getUnusedSkills.add(quickattack);
        getUnusedSkills.add(twister);
        getUnusedSkills.add(wingattack);
        getUnusedSkills.add(airslash);
        getUnusedSkills.add(hurricane);

        getAttacks().add(tackle);
    }

    public Pidgey(int level)
    {
        super("Pidgey","Normal/Flying", 5, 40, 45, 40, 56, 35);
        //getAttacks() = new ArrayList<Attack>(4);
        getUnusedSkills = new ArrayList<Attack>();
        //health = 44;
        //attackDamage = 48;
        //defense = 65;
        //speed = 43;
        //special = 50;
        tackle = new Attack("Tackle", super.getLevel(), super.getAttackDamage(), 50, "Normal"); //starter skill
        gust = new Attack("Gust", super.getLevel(), super.getAttackDamage(), 40, "Flying");  //Level 9
        quickattack = new Attack("Quick Attack", super.getLevel(), super.getAttackDamage(), 40, "Normal");  //Level 13
        twister = new Attack("Twister", super.getLevel(), super.getAttackDamage(), 40, "Dragon");  //Level 21
        wingattack = new Attack("Wing Attack",super.getLevel(), super.getAttackDamage(), 60,"Flying");  //Level 33
        airslash = new Attack("Air Slash", super.getLevel(), super.getAttackDamage(), 75, "Flying");  //Level 49 getUnusedSkills.add(tackle);
        hurricane = new Attack("Hurricane", super.getLevel(), super.getAttackDamage(), 120, "Flying");  //Level 53 getUnusedSkills.add(tackle);

        getUnusedSkills.add(gust);
        getUnusedSkills.add(quickattack);
        getUnusedSkills.add(twister);
        getUnusedSkills.add(wingattack);
        getUnusedSkills.add(airslash);
        getUnusedSkills.add(hurricane);

        getAttacks().add(tackle);
        automaticSkillAssign();
        evolve();
    }

    public void automaticSkillAssign()
    {
        if(getLevel() >= 9)
        {
            switchAttack(gust);
        }
        if(getLevel() >=  13)
        {
            switchAttack(quickattack);
        }
        if(getLevel() >= 21)
        {
            switchAttack(twister);
        }
        if(getLevel() >= 33)
        {
            switchAttack(wingattack);
        }
        if(getLevel() >= 49)
        {
            switchAttack(airslash);
        }
         if(getLevel() >= 53)
        {
            switchAttack(hurricane);
        }
    }

    public boolean evolve()
    {
        if(getLevel() >= 36 && !getName().equals("Pidgeot"))
        {
            changeName("Pidgeot");
            changeBase(83, 80, 75, 101, 70);
            return true;
        }
        else if(getLevel() >= 18 && getLevel() <= 36 && !getName().equals("Pidgeotto"))
        {
            changeName("Pidgeotto");
            changeBase(63, 60, 55, 71, 50);
            return true;
        }
        else
        {
            return false;
        }
    }
}