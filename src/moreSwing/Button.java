package moreSwing;

import javax.swing.*;
import java.awt.*;

public class Button {
    public static void main(String[] args) {
        Button button = new Button();
        button.go();
    }


    public void go(){
        JFrame frame = new JFrame();
        JButton button = new JButton("Change colors");
        JButton button1 = new JButton("Change colors1");
        JButton button2 = new JButton("Change colors2");
        JButton button3 = new JButton("Change colors3");
        JButton button4 = new JButton("Change colors4");

        frame.getContentPane().add(BorderLayout.EAST,button);
        frame.getContentPane().add(BorderLayout.WEST,button1);
        frame.getContentPane().add(BorderLayout.SOUTH,button2);
        frame.getContentPane().add(BorderLayout.NORTH,button3);
        frame.getContentPane().add(BorderLayout.CENTER,button4);
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
