/**
 * Write a description of class Caterpie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Caterpie extends Pokemon
{

    //moves Caterpie
    private Attack attack1, attack2, attack3, attack4;

    // All moves Caterpie can learn
    private Attack tackle, bugbite, confusion,gust, psybeam, silverwind,bugbuzz;

    //private ArrayList<Attack> attacks;
    private ArrayList<Attack> getUnusedSkills;
    public Caterpie()
    {
        //Name Pokemon, Type, HP Base, Attack Base, Defense Base, Speed, Special Average
        super("Caterpie","Bug",5, 45, 30, 35, 45, 20);
        //getAttacks() = new ArrayList<Attack>(4);
        getUnusedSkills = new ArrayList<Attack>();
        //health = 45;
        //attackDamage = 30;
        //defense = 35;
        //speed = 45;
        //special = 20;
        tackle = new Attack("Tackle", super.getLevel(), super.getAttackDamage(), 50, "Normal"); //starter skill
        bugbite = new Attack("Bug Bite", super.getLevel(), super.getAttackDamage(), 60, "Grass");  //Level 15
        confusion = new Attack("Confusion", super.getLevel(), super.getAttackDamage(), 50, "Psychic");  //Level 10
        gust = new Attack("Gust", super.getLevel(), super.getAttackDamage(), 40, "Flying");  //Level 16
        psybeam = new Attack("Psybeam", super.getLevel(), super.getAttackDamage(), 65, "Psychic");  //Level 24
        silverwind = new Attack("Silver Wind", super.getLevel(), super.getAttackDamage(), 60, "Bug");  //Level 28
        bugbuzz = new Attack("Bug Buzz", super.getLevel(), super.getAttackDamage(), 90, "Bug");  //Level 42

        getUnusedSkills.add(bugbite);
        getUnusedSkills.add(confusion);
        getUnusedSkills.add(gust);
        getUnusedSkills.add(psybeam);
        getUnusedSkills.add(silverwind);
        getUnusedSkills.add(bugbuzz);

        getAttacks().add(tackle);
    }

    public Caterpie(int level)
    {
        //Name Pokemon, Type, HP Base, Attack Base, Defense Base, Speed, Special Average
        super("Caterpie","Bug",5, 45, 30, 35, 45, 20);
        //getAttacks() = new ArrayList<Attack>(4);
        getUnusedSkills = new ArrayList<Attack>();
        //health = 45;
        //attackDamage = 30;
        //defense = 35;
        //speed = 45;
        //special = 20;
        tackle = new Attack("Tackle", super.getLevel(), super.getAttackDamage(), 50, "Normal"); //starter skill
        bugbite = new Attack("Bug Bite", super.getLevel(), super.getAttackDamage(), 60, "Grass");  //Level 15
        confusion = new Attack("Confusion", super.getLevel(), super.getAttackDamage(), 50, "Psychic");  //Level 10
        gust = new Attack("Gust", super.getLevel(), super.getAttackDamage(), 40, "Flying");  //Level 16
        psybeam = new Attack("Psybeam", super.getLevel(), super.getAttackDamage(), 65, "Psychic");  //Level 24
        silverwind = new Attack("Silver Wind", super.getLevel(), super.getAttackDamage(), 60, "Bug");  //Level 28
        bugbuzz = new Attack("Bug Buzz", super.getLevel(), super.getAttackDamage(), 90, "Bug");  //Level 42

        getUnusedSkills.add(bugbite);
        getUnusedSkills.add(confusion);
        getUnusedSkills.add(gust);
        getUnusedSkills.add(psybeam);
        getUnusedSkills.add(silverwind);
        getUnusedSkills.add(bugbuzz);

        getAttacks().add(tackle);

        automaticSkillAssign();
        evolve();
    }

    public void automaticSkillAssign()
    {
        if(getLevel() >= 15)
        {
            switchAttack(bugbite);
        }
        if(getLevel() >=  10)
        {
            switchAttack(confusion);
        }
        if(getLevel() >=  16)
        {
            switchAttack(gust);
        }
        if(getLevel() >=  24)
        {
            switchAttack(psybeam);
        }
        if(getLevel() >=  28)
        {
            switchAttack(silverwind);
        }
        if(getLevel() >=  42)
        {
            switchAttack(bugbuzz);
        }
    }

    public boolean evolve()
    {
        if(super.getLevel() >= 21 && super.getName() != "Butterfree")
        {
            super.changeName("Butterfree");
            super.changeBase(60, 45, 50, 70, 85);
            return true;
        }
        else if(getLevel() >=7  && getLevel() <= 10 && !getName().equals("Metapod"))
        {
            super.changeName("Metapod");
            super.changeBase(50, 20, 55, 30, 25);
            return true;
        }
        else
        {
            return false;
        }
    }
}

