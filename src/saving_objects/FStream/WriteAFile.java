package saving_objects.FStream;

import java.io.*;

class WriteAFile {

    public static void main(String[] args) {

        try {

            FileWriter writer = new FileWriter("Foo.txt");
            writer.write("hello foo!");
            writer.close();

            FileReader reader = new FileReader("Foo.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            System.out.println("line = " + bufferedReader.readLine());
            bufferedReader.close();
            reader.close();


//            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//            }

        } catch (IOException ex) {

            ex.printStackTrace();

        }

    }

}
