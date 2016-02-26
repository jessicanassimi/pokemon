import java.util.ArrayList;
public class Psyduck extends Pokemon
{
    //Four moves that Squirtle has
    private Attack attack1, attack2, attack3, attack4;

    // All moves Squirtle can learn
    private Attack scratch, waterGun;

    //private ArrayList<Attack> attacks;
    private ArrayList<Attack> getUnusedSkills;
    public Psyduck()
    {
        super("Psyduck","Water", 5, 50, 52, 48, 55, 60);
        //getAttacks() = new ArrayList<Attack>(4);
        getUnusedSkills = new ArrayList<Attack>();
        //health = 44;
        //attackDamage = 48;
        //defense = 65;
        //speed = 43;
        //special = 50;
        scratch = new Attack("Scratch", super.getLevel(), super.getAttackDamage(), 40, "Normal"); //starter skill
        waterGun = new Attack("Water Gun", super.getLevel(), super.getAttackDamage(), 40, "Water");  //Level 8
        

        getUnusedSkills.add(scratch);
        getUnusedSkills.add(waterGun);

        getAttacks().add(scratch);
    }

    public Psyduck(int level)
    {
        super("Psyduck","Water", 5, 50, 52, 48, 55, 60);
        //getAttacks() = new ArrayList<Attack>(4);
        getUnusedSkills = new ArrayList<Attack>();
        //health = 44;
        //attackDamage = 48;
        //defense = 65;
        //speed = 43;
        //special = 50;
        scratch = new Attack("Scratch", super.getLevel(), super.getAttackDamage(), 40, "Normal"); //starter skill
        waterGun = new Attack("Water Gun", super.getLevel(), super.getAttackDamage(), 40, "Water");  //Level 8
        

        getUnusedSkills.add(scratch);
        getUnusedSkills.add(waterGun);

        getAttacks().add(scratch);
        
        automaticSkillAssign();
        evolve();
    }

    public void automaticSkillAssign()
    {
        if(getLevel() >= 8)
        {
            switchAttack(waterGun);
        }
    }
  
    public boolean evolve()
    {
        return false;
    }
}