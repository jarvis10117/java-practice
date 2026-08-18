package saving_objects.OOStream;

import java.io.*;

public class GameSaverTest {

    public static void main(String[] args) {

        GameCharacter one = new GameCharacter(50, "Elfaa", new String[]{"bow", "sword", "dust"});
        GameCharacter two = new GameCharacter(200, "Troll", new String[]{"bare hands", "big ax"});
        GameCharacter three = new GameCharacter(120, "Magician", new String[]{"spells", "invisibility"});
        GameCharacter four = new GameCharacter(300, "Frog", new String[]{"frog"});
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.writeObject(four);

            os.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }



    }

}
