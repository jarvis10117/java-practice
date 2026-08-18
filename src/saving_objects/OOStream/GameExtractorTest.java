package saving_objects.OOStream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class GameExtractorTest {

    public static void main(String[] args) {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));

            GameCharacter one =  (GameCharacter) is.readObject();
            GameCharacter two = (GameCharacter) is.readObject();
            GameCharacter three = (GameCharacter) is.readObject();
            GameCharacter four = (GameCharacter) is.readObject();

            System.out.println("one = " + one.getType());
            System.out.println("two = " + two.getType());
            System.out.println("three = " + three.getType());
            System.out.println("four = " + four.getType());
        }
        catch (Exception e) {
            e.printStackTrace();
        }



    }
}
