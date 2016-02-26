import java.util.ArrayList;
public class Weedle extends Pokemon
{
    //Four moves that Weedle has
    private Attack attack1, attack2, attack3, attack4;

    // All moves Weedle can learn
    private Attack poisonSting, bugBite, furyAttack, twineedle, rage, pursuit, pinmissile, assurance, poisonjab;

    //private ArrayList<Attack> attacks;
    private ArrayList<Attack> getUnusedSkills;
    public Weedle()
    {
        //Name, Type, Level, HP, Attack, Defense, Speed, Special Average
        super("Weedle","Bug/Poison", 1, 40, 35, 30, 50, 20);
        //getAttacks() = new ArrayList<Attack>(4);
        getUnusedSkills = new ArrayList<Attack>();
        //health = 40;
        //attackDamage = 35;
        //defense = 30;
        //speed = 50;
        //special = 20;
        poisonSting = new Attack("Poison String", super.getLevel(), super.getAttackDamage(), 15, "Poison"); //starter skill
        bugBite = new Attack("Bug Bite", super.getLevel(), super.getAttackDamage(), 60, "Bug");  //Level 15
        furyAttack = new Attack("Fury Attack", super.getLevel(), super.getAttackDamage(), 15, "Normal");  //Level 10
        twineedle = new Attack("Twineedle", super.getLevel(), super.getAttackDamage(), 25, "Bug");  //Level 16
        rage = new Attack("Rage",super.getLevel(), super.getAttackDamage(), 20,"Normal");  //Level 19
        pursuit = new Attack("Pursuit", super.getLevel(), super.getAttackDamage(), 40, "Dark");  //Level 22
        pinmissile = new Attack("Pin Missile", super.getLevel(), super.getAttackDamage(), 14, "Bug");  //Level 28
        assurance = new Attack("Assurance", super.getLevel(), super.getAttackDamage(), 50, "Dark");  //Level 34
        poisonjab = new Attack("Poison Jab", super.getLevel(), super.getAttackDamage(), 80, "Poison");  //Level 37

        getAttacks().add(poisonSting);

        getUnusedSkills.add(bugBite);
        getUnusedSkills.add(furyAttack);
        getUnusedSkills.add(twineedle);
        getUnusedSkills.add(rage);
        getUnusedSkills.add(pursuit);
        getUnusedSkills.add(pinmissile);
        getUnusedSkills.add(assurance);
        getUnusedSkills.add(poisonjab);

    }

    public Weedle(int level)
    {
        //Name, Type, Level, HP, Attack, Defense, Speed, Special Average
        super("Weedle","Bug/Poison", 1, 40, 35, 30, 50, 20);
        //getAttacks() = new ArrayList<Attack>(4);
        getUnusedSkills = new ArrayList<Attack>();
        //health = 40;
        //attackDamage = 35;
        //defense = 30;
        //speed = 50;
        //special = 20;
        poisonSting = new Attack("Poison String", super.getLevel(), super.getAttackDamage(), 15, "Poison"); //starter skill
        bugBite = new Attack("Bug Bite", super.getLevel(), super.getAttackDamage(), 60, "Bug");  //Level 15
        furyAttack = new Attack("Fury Attack", super.getLevel(), super.getAttackDamage(), 15, "Normal");  //Level 10
        twineedle = new Attack("Twineedle", super.getLevel(), super.getAttackDamage(), 25, "Bug");  //Level 16
        rage = new Attack("Rage",super.getLevel(), super.getAttackDamage(), 20,"Normal");  //Level 19
        pursuit = new Attack("Pursuit", super.getLevel(), super.getAttackDamage(), 40, "Dark");  //Level 22
        pinmissile = new Attack("Pin Missile", super.getLevel(), super.getAttackDamage(), 14, "Bug");  //Level 28
        assurance = new Attack("Assurance", super.getLevel(), super.getAttackDamage(), 50, "Dark");  //Level 34
        poisonjab = new Attack("Poison Jab", super.getLevel(), super.getAttackDamage(), 80, "Poison");  //Level 37

        getUnusedSkills.add(poisonSting);

        getUnusedSkills.add(bugBite);
        getUnusedSkills.add(furyAttack);
        getUnusedSkills.add(twineedle);
        getUnusedSkills.add(rage);
        getUnusedSkills.add(pursuit);
        getUnusedSkills.add(pinmissile);
        getUnusedSkills.add(assurance);
        getUnusedSkills.add(poisonjab);

        getAttacks().add(poisonSting);

        automaticSkillAssign();
        evolve();
    }

    public void automaticSkillAssign()
    {
        if(getLevel() >=  10)
        {
            switchAttack(furyAttack );
        }
        if(getLevel() >= 15)
        {
            switchAttack(bugBite);
        }
        if(getLevel() >= 16)
        {
            switchAttack(twineedle );
        }
        if(getLevel() >= 19)
        {
            switchAttack(rage );
        }
        if(getLevel() >= 22)
        {
            switchAttack(pursuit );
        }
        if(getLevel() >= 28)
        {
            switchAttack(pinmissile  );
        }
        if(getLevel() >= 34)
        {
            switchAttack(assurance  );
        }
        if(getLevel() >= 37)
        {
            switchAttack(poisonjab  );
        }
    }

    public boolean evolve()
    {
        if(getLevel() >= 10 && !getName().equals("Beedrill"))
        {
            changeName("Beedrill");
            changeBase(65, 90, 40, 75, 43);
            return true;
        }
        else if(getLevel() >=7  && getLevel() <= 10 && !getName().equals("Kakuna"))
        {
            changeName("Kakuna");
            changeBase(45, 25, 50, 35, 25);
            return true;
        }
        else
        {
            return false;
        }
    }
}