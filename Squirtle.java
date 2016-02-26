import java.util.ArrayList;
public class Squirtle extends Pokemon
{
    //Four moves that Squirtle has
    private Attack attack1, attack2, attack3, attack4;

    // All moves Squirtle can learn
    private Attack tackle, bubble, waterGun, bite, skullBash, hydroPump;

    //private ArrayList<Attack> attacks;
    private ArrayList<Attack> getUnusedSkills;
    public Squirtle()
    {
        super("Squirtle","Water", 5, 44, 48, 65, 43, 50);
        //getAttacks() = new ArrayList<Attack>(4);
        getUnusedSkills = new ArrayList<Attack>();
        //health = 44;
        //attackDamage = 48;
        //defense = 65;
        //speed = 43;
        //special = 50;
        tackle = new Attack("Tackle", super.getLevel(), super.getAttackDamage(), 35, "Normal"); //starter skill
        bubble = new Attack("Bubble", super.getLevel(), super.getAttackDamage(), 20, "Water");  //Level 8
        waterGun = new Attack("Water Gun", super.getLevel(), super.getAttackDamage(), 40, "Water");  //Level 15
        bite = new Attack("Bite", super.getLevel(), super.getAttackDamage(), 60, "Normal");  //Level 22
        skullBash = new Attack("Skull Bash",super.getLevel(), super.getAttackDamage(), 100,"Normal");  //Level 35
        hydroPump = new Attack("Hydro Pump", super.getLevel(), super.getAttackDamage(), 120, "Water");  //Level 42

        getUnusedSkills.add(tackle);
        getUnusedSkills.add(bubble);
        getUnusedSkills.add(waterGun);
        getUnusedSkills.add(bite);
        getUnusedSkills.add(skullBash);
        getUnusedSkills.add(hydroPump);

        getAttacks().add(tackle);
    }

    public Squirtle(int level)
    {
        super("Squirtle","Water",level, 44, 48, 65, 43, 50);
        //attacks = new ArrayList<Attack>(4);
        getUnusedSkills = new ArrayList<Attack>();

        tackle = new Attack("Tackle", super.getLevel(), super.getAttackDamage(), 35, "Normal"); //starter skill
        bubble = new Attack("Bubble", super.getLevel(), super.getAttackDamage(), 20, "Water"); //Level 8
        waterGun = new Attack("Water Gun", super.getLevel(), super.getAttackDamage(), 40, "Water"); //Level 15
        bite = new Attack("Bite", super.getLevel(), super.getAttackDamage(), 60, "Normal"); //Level 22
        skullBash = new Attack("Skull Bash",super.getLevel(), super.getAttackDamage(), 100,"Normal"); //Level 35
        hydroPump = new Attack("Hydro Pump", super.getLevel(), super.getAttackDamage(), 120, "Water"); //Level 42

        getUnusedSkills.add(tackle);
        getUnusedSkills.add(bubble);
        getUnusedSkills.add(waterGun);
        getUnusedSkills.add(bite);
        getUnusedSkills.add(skullBash);
        getUnusedSkills.add(hydroPump);

        getAttacks().add(tackle);

        automaticSkillAssign();
        evolve();
    }

    public void automaticSkillAssign()
    {
        if(getLevel() >= 8)
        {
            switchAttack(bubble);
        }
        if(getLevel() >=  15)
        {
            switchAttack(waterGun);
        }
        if(getLevel() >= 22)
        {
            switchAttack(bite);
        }
        if(getLevel() >= 35)
        {
            switchAttack(skullBash);
        }
        if(getLevel() >= 42)
        {
            switchAttack(hydroPump);
        }
    }
  
    public boolean evolve()
    {
        if(getLevel() >= 36 && !getName().equals("Blastoise"))
        {
            changeName("Blastoise");
            changeBase(79, 83, 100, 78, 90);
            return true;
        }
        else if(getLevel() >= 16 && getLevel() <= 35 && !getName().equals("Wartortle"))
        {
            changeName("Wartortle");
            changeBase(59, 63, 80, 58, 72);
            return true;
        }
        else
        {
            return false;
        }
    }
}