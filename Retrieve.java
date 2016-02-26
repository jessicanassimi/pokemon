import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Retrieve
{
    public static Play deserializePlay()
    {
        Play game = null;
        try
        {
            FileInputStream fin = new FileInputStream("currentSave.ser");
            ObjectInputStream ois = new ObjectInputStream(fin);
            game = (Play) ois.readObject();
            ois.close();
        } catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return game;
    }
}