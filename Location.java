
/**
 * Tracks location in wild grass phase.
 * 
 * @TeamPokemon 
 * @version (5/13/14)
 */
public class Location
{
    private int x;
    private int y;

    public Location()
    {
        x = 0; //left
        y = 0; //bottom     (origin... grid is 1st quadrant of x,y plane)
    }
    
    public boolean isRight()
    {
        if (x == 3)
            return true;
        else
            return false;
    }
    
    public boolean isLeft()
    {
        if (x == 0)
            return true;
        else
            return false;
    }
    
    public boolean isTop()
    {
        if (y == 3)
            return true;
        else
            return false;
    }
    
    public boolean isBottom()
    {
        if (y == 0)
            return true;
        else
            return false;
    }
    
    public void moveRight()
    {
        
        x++;
    }
    
    public void moveLeft()
    {
        x--;
    }
    
    public void moveUp()
    {
        y++;
    }
    
    public void moveDown()
    {
        y--;
    }
    
    public void print()
    {
        System.out.print("\f");
        for(int i = 0; i<6; i++)
            System.out.println();
        String dashes = "-------------------------";
        String separators = "|     |     |     |     |";
        for (int i = 0; i<4;i++)
        {
            if(i == 3-y)
            {
                System.out.println(dashes);
                System.out.println(separators.substring(0,(x*6)+3) + "o" + separators.substring(x*6 + 4));
                System.out.println(separators.substring(0,(x*6)+3) + "^" + separators.substring(x*6 + 4));
            }
            else
            {
                System.out.println(dashes);
                System.out.println(separators);
                System.out.println(separators);
            }
        }
        System.out.println(dashes);
    }
}
