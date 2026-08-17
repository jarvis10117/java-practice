//package swing;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.util.Random;
//
//public class SimpleGui3 implements ActionListener {
//    class X {
//        public void xSet(int x) {
//            this.x = x;
//        }
//
//        int x;
//    }
//
//    private JFrame frame;
//
//    public static void main(String[] args) {
//
//        SimpleGui3 gui = new SimpleGui3();
//        gui.go();
//
//    }
//
//    public void go() {
//
//        frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JButton button = new JButton("Change colors");
//        button.addActionListener(this);
//
//        MyDrawPanel drawPanel = new MyDrawPanel();
//
//        frame.getContentPane().add(BorderLayout.SOUTH, button);
//        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
//
//
//
//        frame.setSize(300, 300);
//        frame.setVisible(true);
//
//    }
//
//    public void actionPerformed(ActionEvent event) {
//
//        frame.repaint();
//
//    }
//
//}
//class MyDrawPanel extends JPanel {
//    public void paintComponent(Graphics g) {
//
//        Random rand = new Random();
//        int red = rand.nextInt(255);
//        int green = rand.nextInt(255);
//        int blue = rand.nextInt(255);
//        Color startColor = new Color(red, green, blue);
//        int red1 = rand.nextInt(255);
//        int green1 = rand.nextInt(255);
//        int blue1 = rand.nextInt(255);
//        Color endColor = new Color(red1, green1, blue1);
//
//        Graphics2D g2 = (Graphics2D) g;
//        GradientPaint gradiant = new GradientPaint(70, 70, startColor, 150, 150, endColor);
//        g2.setPaint(gradiant);
//        g2.fillOval(70, 70, 100, 100);
//
//    }
//
//}