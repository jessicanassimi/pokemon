import java.util.ArrayList;
public class Bulbasaur extends Pokemon
{
    //moves squirtle has 
    private Attack attack1, attack2, attack3, attack4;

    // All moves Squirtle can learn
    private Attack tackle, vineWhip, razorLeaf, solarBeam;

    //private ArrayList<Attack> attacks;
    private ArrayList<Attack> getUnusedSkills;
    public Bulbasaur()
    {
        //Name Pokemon, Type, HP Base, Attack Base, Defense Base, Speed, Special Average
        super("Bulbasaur","Grass", 5, 45, 49, 49, 45, 65);
        //getAttacks() = new ArrayList<Attack>(4);
        getUnusedSkills = new ArrayList<Attack>();
        //health = 44;
        //attackDamage = 48;
        //defense = 65;
        //speed = 43;
        //special = 50;
        tackle = new Attack("Tackle", super.getLevel(), super.getAttackDamage(), 35, "Normal"); //starter skill
        vineWhip = new Attack("Vine Whip", super.getLevel(), super.getAttackDamage(), 35, "Grass");  //Level 8
        razorLeaf = new Attack("Razor Leaf", super.getLevel(), super.getAttackDamage(), 55, "Grass");  //Level 15
        solarBeam = new Attack("Solar Beam", super.getLevel(), super.getAttackDamage(), 120, "Grass");  //Level 22

        getUnusedSkills.add(tackle);
        getUnusedSkills.add(vineWhip);
        getUnusedSkills.add(razorLeaf);
        getUnusedSkills.add(solarBeam);

        getAttacks().add(tackle);
    }

    public Bulbasaur(int level)
    {
        super("Bulbasaur","Grass", level, 45, 49, 49, 45, 65);
        //attacks = new ArrayList<Attack>(4);
        getUnusedSkills = new ArrayList<Attack>();

        tackle = new Attack("Tackle", super.getLevel(), super.getAttackDamage(), 35, "Normal"); //starter skill
        vineWhip = new Attack("Vine Whip", super.getLevel(), super.getAttackDamage(), 35, "Grass");  //Level 8
        razorLeaf = new Attack("Razor Leaf", super.getLevel(), super.getAttackDamage(), 55, "Grass");  //Level 15
        solarBeam = new Attack("Solar Beam", super.getLevel(), super.getAttackDamage(), 120, "Grass");  //Level 22

        getUnusedSkills.add(tackle);
        getUnusedSkills.add(vineWhip);
        getUnusedSkills.add(razorLeaf);
        getUnusedSkills.add(solarBeam);

        getAttacks().add(tackle);

        automaticSkillAssign();
        evolve();
    }

    public void automaticSkillAssign()
    {
        if(getLevel() >= 13)
        {
            switchAttack(vineWhip);
        }
        if(getLevel() >=  27)
        {
            switchAttack(razorLeaf);
        }
        if(getLevel() >= 48)
        {
            switchAttack(solarBeam);
        }
    }
  
    public boolean evolve()
    {
        if(super.getLevel() >= 32 && super.getName() != "Venusaur")
        {
            super.changeName("Venusaur");
            super.changeBase(80, 82, 83, 80, 100);
            return true;
        }
        else if(super.getLevel() >= 16 && super.getLevel() <= 31 && super.getName() != "Ivysaur")
        {
            super.changeName("Ivysaur");
            super.changeBase(60, 62, 63, 60, 80);
            return true;
        }
        else
        {
            return false;
        }
    }
}