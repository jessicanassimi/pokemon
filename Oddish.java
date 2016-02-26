
/**
 * Write a description of class Oddish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Oddish extends Pokemon
{


    //moves squirtle has 
    private Attack attack1, attack2, attack3, attack4;

    // All moves Squirtle can learn
    private Attack absorb, petalDance, solarBeam;

    //private ArrayList<Attack> attacks;
    private ArrayList<Attack> getUnusedSkills;
    public Oddish()
    {
        //Name Pokemon, Type, HP Base, Attack Base, Defense Base, Speed, Special Average
        super("Oddish","Grass", 5, 45, 50, 55, 30, 70);
        //getAttacks() = new ArrayList<Attack>(4);
        getUnusedSkills = new ArrayList<Attack>();
        //health = 44;
        //attackDamage = 48;
        //defense = 65;
        //speed = 43;
        //special = 50;
        absorb = new Attack("Absorb", super.getLevel(), super.getAttackDamage(), 20, "Grass"); //starter skill
        petalDance = new Attack("Petal Dance", super.getLevel(), super.getAttackDamage(), 120, "Grass");  //Level 8
        solarBeam = new Attack("Solar Beam", super.getLevel(), super.getAttackDamage(), 120, "Grass");  //Level 15
        

        getUnusedSkills.add(absorb);
        getUnusedSkills.add(petalDance);
        getUnusedSkills.add(solarBeam);

        getAttacks().add(absorb);
    }

    public Oddish(int level)
    {
        super("Oddish","Grass", level, 45, 50, 55, 30, 70);
        //attacks = new ArrayList<Attack>(4);
        getUnusedSkills = new ArrayList<Attack>();

        absorb = new Attack("Absorb", super.getLevel(), super.getAttackDamage(), 20, "Grass"); //starter skill
        petalDance = new Attack("Petal Dance", super.getLevel(), super.getAttackDamage(), 120, "Grass");  //Level 8
        solarBeam = new Attack("Solar Beam", super.getLevel(), super.getAttackDamage(), 120, "Grass");  //Level 15

        getUnusedSkills.add(absorb);
        getUnusedSkills.add(petalDance);
        getUnusedSkills.add(solarBeam);

        getAttacks().add(absorb);

        automaticSkillAssign();
        evolve();
    }

    public void automaticSkillAssign()
    {
        if(getLevel() >= 33)
        {
            switchAttack(petalDance);
        }
        if(getLevel() >=  46)
        {
            switchAttack(solarBeam);
        }
    }
  
    public boolean evolve()
    {
        if(super.getLevel() >= 21 && super.getName() != "Gloom")
        {
            super.changeName("Gloom");
            super.changeBase(60, 65, 70, 40, 70);
            return true;
        }
        else
        {
            return false;
        }
    }
}

