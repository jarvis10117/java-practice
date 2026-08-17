package moreSwing;

import javax.swing.*;

import java.awt.*;

public class Panel1 {

    public static void main(String[] args) {

        Panel1 gui = new Panel1();

        gui.go();

    }

    public void go() {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton button = new JButton("Click me");
        JButton button1 = new JButton("Click me1");
        JButton button2 = new JButton("Click me2");

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.setBackground(Color.darkGray);
        panel.add(button);
        panel.add(button1);
        panel.add(button2);


        frame.getContentPane().add(BorderLayout.EAST, panel);


        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }

}
