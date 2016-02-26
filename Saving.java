import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Saving
{
    public static void serializePlay(Play game)
    {
        try
        {
            FileOutputStream fout = new FileOutputStream("currentSave.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fout);   
            oos.writeObject(game);
            oos.close();
            System.out.println("Game saved.");
            System.out.println("(Note: Do not compile or modify the code, or else the save will no longer work.)");
            System.out.println("(The save file can be found in the folder where your .java files are.)");
        } catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}