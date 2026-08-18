package saving_objects.OOStream;

import java.io.*;

public class Pond implements Serializable {

    private Duck duck = new Duck(12,"Sara");

    public static void main(String[] args) {

        Pond myPond = new Pond();

        try {

            FileOutputStream fs = new FileOutputStream("Pond.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(myPond);
            os.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Pond.ser"));
            Pond myPond2 = (Pond) ois.readObject();
            ois.close();
            System.out.println(myPond2.duck.name);

        } catch (Exception ex) {

            ex.printStackTrace();

        }

    }

}
class Duck implements Serializable {
    private transient int size;
    String name;

    Duck(int size, String name) {
        this.size = size;
        this.name = name;
    }
}
