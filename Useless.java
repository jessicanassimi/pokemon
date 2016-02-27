
import java.util.ArrayList;
public class Useless extends Pokemon
{


    //moves squirtle has 
    private Attack attack1, attack2, attack3, attack4;

    // All moves Squirtle can learn
    private Attack doNothing, boom;

    //private ArrayList<Attack> attacks;
    private ArrayList<Attack> getUnusedSkills;
    public Useless()
    {
        //Name Pokemon, Type, HP Base, Attack Base, Defense Base, Speed, Special Average
        super("Useless","Normal", 5, 100, 1, 100, 30, 70);
        //getAttacks() = new ArrayList<Attack>(4);
        getUnusedSkills = new ArrayList<Attack>();

        doNothing = new Attack("Do Nohting", super.getLevel(), super.getAttackDamage(), 0, "Normal"); //starter skill
        boom = new Attack("Boom", super.getLevel(), super.getAttackDamage(), -9999, "Normal");  //Level 8

        

        getUnusedSkills.add(doNothing);
        getUnusedSkills.add(boom);

        getAttacks().add(doNothing);
        getAttacks().add(boom);
    }

    public Useless(int level)
    {
                //Name Pokemon, Type, HP Base, Attack Base, Defense Base, Speed, Special Average
        super("Useless","Normal", level, 100, 1, 100, 30, 70);
        //getAttacks() = new ArrayList<Attack>(4);
        getUnusedSkills = new ArrayList<Attack>();

        doNothing = new Attack("Do Nothing", super.getLevel(), super.getAttackDamage(), 0, "Normal"); //starter skill
        boom = new Attack("Boom", super.getLevel(), super.getAttackDamage(), -9999, "Normal");  //Level 8

        

        getUnusedSkills.add(doNothing);
        getUnusedSkills.add(boom);

        getAttacks().add(doNothing);
        getAttacks().add(boom);

        automaticSkillAssign();
        evolve();
    }

    public void automaticSkillAssign()
    {

    }
  
    public boolean evolve()
    {
        if(super.getLevel() >= 21 && super.getName() != "More Useless")
        {
            super.changeName("More Useless");
            super.changeBase(200, 1, 300, 40, 70);
            return true;
        }
        else
        {
            return false;
        }
    }
}

