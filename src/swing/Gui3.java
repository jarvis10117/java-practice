package swing;


import javax.swing.*;
import java.awt.*;

public class Gui3 {
    public static void main(String[] args) {
        Gui3 gui = new Gui3();
        gui.go();

    }



    public void go (){
        JFrame frame = new JFrame("Swing GUI Example");

        // 1. Instantiate components
        MyDrawPanel panel = new MyDrawPanel();
        // Use JButton (Swing) instead of heavy-weight Button (AWT)
        JButton button = new JButton("Click Me");

        // 2. Add components to separate regions of the BorderLayout
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);

        // 3. Configure window settings
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 4. Make it visible LAST so everything draws correctly
        frame.setVisible(true);
    }
}

