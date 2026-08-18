package saving_objects.FStream;

import java.io.*;
import java.nio.file.*;

class WriteAndRead {

    public static void main(String[] args) {

        try {
            File file = new File("question.txt");
            FileWriter writer = new FileWriter(file);
            writer.write("What is blue + yellow?/green\n" +
                    "\n" +
                    "What is red + blue?/purple");
            writer.close();

        } catch (IOException ex) {

            ex.printStackTrace();

        }

        try {
            File file = new File("question.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        }
        catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Yo!");
        }


        try {
            Files.lines(Path.of("question.txt"))
                    .forEach(line -> System.out.println(line));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
