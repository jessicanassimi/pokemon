import java.util.ArrayList;
public class Jigglypuff extends Pokemon
{
    //Four moves that Jigglypuff has
    private Attack attack1, attack2, attack3, attack4;

    // All moves Jigglypuff can learn
    private Attack pound, doubleSlap, bodySlam, doubleEdge;

    //private ArrayList<Attack> attacks;
    private ArrayList<Attack> getUnusedSkills;
    public Jigglypuff()
    {
        super("Jigglypuff","Normal", 5, 115, 45, 20, 20, 25);
        //getAttacks() = new ArrayList<Attack>(4);
        getUnusedSkills = new ArrayList<Attack>();
        //health = 44;
        //attackDamage = 48;
        //defense = 65;
        //speed = 43;
        //special = 50;
        pound = new Attack("Pound", super.getLevel(), super.getAttackDamage(), 40, "Normal"); //starter skill
        doubleSlap = new Attack("Bubble", super.getLevel(), super.getAttackDamage(), 15, "Normal");  //Level 8
        bodySlam = new Attack("Water Gun", super.getLevel(), super.getAttackDamage(), 85, "Normal");  //Level 15
        doubleEdge = new Attack("Bite", super.getLevel(), super.getAttackDamage(), 120, "Normal");  //Level 22

        getUnusedSkills.add(pound);
        getUnusedSkills.add(doubleSlap);
        getUnusedSkills.add(bodySlam);
        getUnusedSkills.add(doubleEdge);

        getAttacks().add(pound);
    }

    public Jigglypuff(int level)
    {
        super("Jigglypuff","Normal", level, 115, 45, 20, 20, 25);
        //attacks = new ArrayList<Attack>(4);
        getUnusedSkills = new ArrayList<Attack>();

        pound = new Attack("Pound", super.getLevel(), super.getAttackDamage(), 40, "Normal"); //starter skill
        doubleSlap = new Attack("Bubble", super.getLevel(), super.getAttackDamage(), 15, "Normal");  //Level 8
        bodySlam = new Attack("Water Gun", super.getLevel(), super.getAttackDamage(), 85, "Normal");  //Level 15
        doubleEdge = new Attack("Bite", super.getLevel(), super.getAttackDamage(), 120, "Normal");  //Level 22

        getUnusedSkills.add(pound);
        getUnusedSkills.add(doubleSlap);
        getUnusedSkills.add(bodySlam);
        getUnusedSkills.add(doubleEdge);

        getAttacks().add(pound);

        automaticSkillAssign();
        evolve();
    }

    public void automaticSkillAssign()
    {
        if(getLevel() >= 24)
        {
            switchAttack(doubleSlap);
        }
        if(getLevel() >=  34)
        {
            switchAttack(bodySlam);
        }
        if(getLevel() >= 39)
        {
            switchAttack(doubleEdge);
        }
     }
  
    public boolean evolve()
    {
        return false;
    }
}