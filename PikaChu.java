import java.util.ArrayList;
public class PikaChu extends Pokemon
{
    private Attack attack1, attack2, attack3, attack4;

    private Attack thunderShock, quickAttack, slam, thunderbolt, thunder;

    //private ArrayList<Attack> attacks;
    private ArrayList<Attack> getUnusedSkills;
    public PikaChu()
    {
        super("Pika Chu","Electric", 5, 35, 55, 30, 90, 50);
        //attacks = new ArrayList<Attack>(4);
        getUnusedSkills = new ArrayList<Attack>();

        thunderShock = new Attack("Thunder Shock", super.getLevel(), super.getAttackDamage(), 40, "Electric");
        quickAttack = new Attack("Quick Attack", super.getLevel(), super.getAttackDamage(), 40, "Normal");  //Level 9
        slam = new Attack("Slam", super.getLevel(), super.getAttackDamage(), 80, "Normal");  //Level 22
        thunderbolt = new Attack("Thunderbolt", super.getLevel(), super.getAttackDamage(), 95, "Electric");  //Level 30
        thunder = new Attack("Thunder",super.getLevel(), super.getAttackDamage(), 120,"Electric");  //Level 38

        getUnusedSkills.add(thunderShock);
        getUnusedSkills.add(quickAttack);
        getUnusedSkills.add(slam);
        getUnusedSkills.add(thunderbolt);
        getUnusedSkills.add(thunder);

        getAttacks().add(thunderShock);
    }

    public PikaChu(int level)
    {
        super("Pika Chu","Electric", level, 35, 55, 30, 90, 50);
        //attacks = new ArrayList<Attack>(4);
        getUnusedSkills = new ArrayList<Attack>();
        
        thunderShock = new Attack("Thunder Shock", super.getLevel(), super.getAttackDamage(), 40, "Electric");
        quickAttack = new Attack("Quick Attack", super.getLevel(), super.getAttackDamage(), 40, "Normal");  //Level 9
        slam = new Attack("Slam", super.getLevel(), super.getAttackDamage(), 80, "Normal");  //Level 22
        thunderbolt = new Attack("Thunderbolt", super.getLevel(), super.getAttackDamage(), 95, "Electric");  //Level 30
        thunder = new Attack("Thunder",super.getLevel(), super.getAttackDamage(), 120,"Electric");  //Level 38

        getUnusedSkills.add(thunderShock);
        getUnusedSkills.add(quickAttack);
        getUnusedSkills.add(slam);
        getUnusedSkills.add(thunderbolt);
        getUnusedSkills.add(thunder);

        getAttacks().add(thunderShock);
        automaticSkillAssign();
        evolve();
    }

    public void automaticSkillAssign()
    {
        if(getLevel() >= 11)
        {
            switchAttack(quickAttack);
        }
        if(getLevel() >=  20)
        {
            switchAttack(slam);
        }
        if(getLevel() >= 26)
        {
            switchAttack(thunderbolt);
        }
        if(getLevel() >= 41)
        {
            switchAttack(thunder);
        }
    }
    
    public boolean evolve()
    {
        return false;
    }

}