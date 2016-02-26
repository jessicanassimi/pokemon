import java.util.ArrayList;
public class Charmander extends Pokemon
{

    private Attack attack1, attack2, attack3, attack4;

    private Attack scratch, ember, rage, slash, flamethrower, fireSpin;

    //private ArrayList<Attack> attacks;
    private ArrayList<Attack> getUnusedSkills;
    public Charmander()
    {
        super("Charmander","Fire", 5, 39, 52, 43, 65, 50);
        //attacks = new ArrayList<Attack>(4);
        getUnusedSkills = new ArrayList<Attack>();

        scratch = new Attack("Scratch", super.getLevel(), super.getAttackDamage(), 40, "Normal"); //starter skill
        ember = new Attack("Ember", super.getLevel(), super.getAttackDamage(), 40, "Fire");  //Level 9
        rage = new Attack("Rage", super.getLevel(), super.getAttackDamage(), 20, "Normal");  //Level 22
        slash = new Attack("Slash", super.getLevel(), super.getAttackDamage(), 70, "Normal");  //Level 30
        flamethrower = new Attack("Flamethrower",super.getLevel(), super.getAttackDamage(), 95,"Fire");  //Level 38
        fireSpin = new Attack("Fire Spin", super.getLevel(), super.getAttackDamage(), 15, "Fire");  //Level 46

        getUnusedSkills.add(scratch);
        getUnusedSkills.add(ember);
        getUnusedSkills.add(rage);
        getUnusedSkills.add(slash);
        getUnusedSkills.add(flamethrower);
        getUnusedSkills.add(fireSpin);

        getAttacks().add(scratch);
    }

    public Charmander(int level)
    {
        super("Charmander","Fire", level, 39, 52, 43, 65, 50);
        //attacks = new ArrayList<Attack>(4);
        getUnusedSkills = new ArrayList<Attack>();
        scratch = new Attack("Scratch", super.getLevel(), super.getAttackDamage(), 40, "Normal"); //starter skill
        ember = new Attack("Ember", super.getLevel(), super.getAttackDamage(), 40, "Fire");  //Level 9
        rage = new Attack("Rage", super.getLevel(), super.getAttackDamage(), 20, "Normal");  //Level 22
        slash = new Attack("Slash", super.getLevel(), super.getAttackDamage(), 70, "Normal");  //Level 30
        flamethrower = new Attack("Flamethrower",super.getLevel(), super.getAttackDamage(), 95,"Fire");  //Level 38
        fireSpin = new Attack("Fire Spin", super.getLevel(), super.getAttackDamage(), 15, "Fire");  //Level 46

        getUnusedSkills.add(scratch);
        getUnusedSkills.add(ember);
        getUnusedSkills.add(rage);
        getUnusedSkills.add(slash);
        getUnusedSkills.add(flamethrower);
        getUnusedSkills.add(fireSpin);

        getAttacks().add(scratch);
        automaticSkillAssign();
        evolve();
    }

    public void automaticSkillAssign()
    {
        if(getLevel() >= 9)
        {
            switchAttack(ember);
        }
        if(getLevel() >=  22)
        {
            switchAttack(rage);
        }
        if(getLevel() >= 30)
        {
            switchAttack(slash);
        }
        if(getLevel() >= 38)
        {
            switchAttack(flamethrower);
        }
        if(getLevel() >= 46)
        {
            switchAttack(fireSpin);
        }
    }

    public boolean evolve()
    {
        if(super.getLevel() >= 36 && super.getName() != "Charizard")
        {
            super.changeName("Charizard");
            super.changeBase(78,84,78,100,90);
            return true;
        }
        else if(super.getLevel() >= 16 && super.getLevel() <= 35 && super.getName() != "Charmeleon")
        {
            super.changeName("Charmeleon");
            super.changeBase(58, 64, 58, 80, 70);
            return true;
        }
        else
        {
            return false;
        }
    }

}