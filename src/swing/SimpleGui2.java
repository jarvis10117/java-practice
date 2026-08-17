package swing;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SimpleGui2 implements ActionListener {

    private JButton button;
    private JFrame frame;

    public static void main(String[] args) {

        SimpleGui2 gui = new SimpleGui2();

        gui.go();

    }

    public void go() {

        frame = new JFrame();
        MyDrawPanel panel = new MyDrawPanel();
        frame.getContentPane().add(panel);

//        button = new JButton("click me");
//        button.addActionListener(this);
//        frame.getContentPane().add(button);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(300, 300);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent event) {

        button.setText("I've been clicked!");

    }

}




class MyDrawPanel extends JPanel {

    public void paintComponent(Graphics g) {

//        g.fillRect(0, 0, this.getWidth(), this.getHeight());
//
////      Get a random values for color
//        Random random = new Random();
//        int red = random.nextInt(256);
//        int green = random.nextInt(256);
//        int blue = random.nextInt(256);
//        Color randomColor = new Color(red, green, blue);
//
//
//        g.setColor(randomColor);
//        g.fillOval(70, 70, 100, 100);
//        g.fillRect(70, 70, 100, 100);



        Random rand = new Random();
        int red = rand.nextInt(255);
        int green = rand.nextInt(255);
        int blue = rand.nextInt(255);
        Color startColor = new Color(red, green, blue);
        Color endColor = new Color(blue, green, red);


        Graphics2D g2 = (Graphics2D) g;
        GradientPaint gradiant = new GradientPaint(70, 70, startColor, 150, 150, endColor);
        g2.setPaint(gradiant);
//        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.fillOval(70, 70, 100, 100);



    }

}
