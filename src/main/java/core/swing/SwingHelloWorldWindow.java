package core.swing;

import javax.swing.*;

public class SwingHelloWorldWindow {
    private JPanel mainPanel;
    private JLabel myLabel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("SwingHelloWorldWindow");
        //połączenie z designer'em
        frame.setContentPane(new SwingHelloWorldWindow().mainPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //rozmieszczenie okna na ekranie
        frame.setBounds(300, 300,frame.getWidth(),frame.getHeight());

        frame.pack();
        frame.setVisible(true);
    }
}
