package e_Flashcards;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class QuizCardBuilder {

    private ArrayList<QuizCard> cardList = new ArrayList<>();
    private JTextArea question;
    private JTextArea answer;
    private JFrame frame;

    public static void main(String[] args) {
        QuizCardBuilder builder = new QuizCardBuilder();
        builder.go();
    }


    public void go() {

//      <===================Basic config===================>
        frame = new JFrame("Quiz Card Builder");
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);

//      <===================TestArea config==================>
        question = createTextArea(bigFont);
        JScrollPane qScroller = createScroller(question);
        answer = createTextArea(bigFont);
        JScrollPane aScroller = createScroller(answer);

//      <===================Adding ScrollPane==================>
        mainPanel.add(new JLabel("Question:"));
        mainPanel.add(qScroller);
        mainPanel.add(new JLabel("Answer:"));
        mainPanel.add(aScroller);

//      <===================Next Button=======================>
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> nextCard());
        mainPanel.add(nextButton);

//      <=================Menu===================>
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(e -> clearAll());

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(e -> saveCard());

        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

//      <==================Basic config=================>
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500, 600);
        frame.setVisible(true);
    }

    private void clearAll() {
        cardList.clear();
        clearCard();
    }

    public void nextCard() {
        QuizCard card = new QuizCard(question.getText(), answer.getText());
        cardList.add(card);
        clearCard();

    }

    public void saveCard() {
        QuizCard card = new QuizCard(question.getText(), answer.getText());
        cardList.add(card);

        JFileChooser fileSave = new JFileChooser();
        fileSave.showSaveDialog(frame);
        saveFile(fileSave.getSelectedFile());
        clearCard();
    }

    public void clearCard() {
        question.setText("");
        answer.setText("");
        question.requestFocus();
    }

    public void saveFile(File file) {
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            for (QuizCard card : cardList) {


                if (!card.getQuestion().isEmpty()) {
                    writer.write(card.getQuestion() + "/");

                    writer.write(card.getAnswer() + "\n");
                }
            }

            writer.close();

        } catch (IOException e) {

            System.out.println("Couldn't write the cardList out: " + e.getMessage());

        }


    }

    private JScrollPane createScroller(JTextArea textArea) {
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        return scrollPane;
    }

    private JTextArea createTextArea(Font bigFont) {
        JTextArea textArea = new JTextArea(6, 20);
        textArea.setFont(bigFont);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        return textArea;
    }


}
