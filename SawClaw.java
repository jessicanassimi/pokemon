
import java.util.ArrayList;
public class SawClaw extends Pokemon
{
    //moves SawClaw has 
    private Attack attack1, attack2, attack3, attack4;

    // All moves SawClaw can learn
    private Attack saw, chomp;

    //private ArrayList<Attack> attacks;
    private ArrayList<Attack> getUnusedSkills;
    public SawClaw()
    {
        //Name Pokemon, Type, Level, HP Base, Attack Base, Defense Base, Speed, Special Average
        super("Saw Claw", "Normal", 5, 70, 50, 82, 25, 67);
        
        getUnusedSkills = new ArrayList<Attack>();

        saw = new Attack("Saw", super.getLevel(), super.getAttackDamage(), 20, "Normal"); //starter skill
        chomp = new Attack("Chomp", super.getLevel(), super.getAttackDamage(), 27, "Normal");  //Level 10

        getUnusedSkills.add(saw);
        getUnusedSkills.add(chomp);

        getAttacks().add(saw);
        getAttacks().add(chomp);
    }

    public SawClaw(int level)
    {
        //Name Pokemon, Type, HP Base, Attack Base, Defense Base, Speed, Special Average
        super("Saw Claw", "Normal", level, 70, 50, 82, 25, 67);
        //getAttacks() = new ArrayList<Attack>(4);
        getUnusedSkills = new ArrayList<Attack>();

        saw = new Attack("Saw", super.getLevel(), super.getAttackDamage(), 20, "Normal"); //starter skill
        chomp = new Attack("Chomp", super.getLevel(), super.getAttackDamage(), 27, "Normal");  //Level 10

        getUnusedSkills.add(saw);
        getUnusedSkills.add(chomp);

        getAttacks().add(saw);
        getAttacks().add(chomp);

        automaticSkillAssign();
        evolve();
    }

    public void automaticSkillAssign()
    {
        if(getLevel() >= 10)
        {
            switchAttack(chomp);
        }
    }

    public boolean evolve()
    {
        if(getLevel() >= 10 && getName() != "Jaw Claw")
        {
            changeName("Jaw Claw");
            super.changeBase(100, 80, 112, 55, 97);
            return true;
        }
        else
        {
            return false;
        }
    }
}