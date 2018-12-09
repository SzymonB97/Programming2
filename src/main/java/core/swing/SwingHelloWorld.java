package core.swing;

import javax.swing.*;
import java.awt.*;

public class SwingHelloWorld {
    public static void main(String[] args) {
        createFrame();
    }

    private static void createFrame() {
        JFrame frame = new JFrame("Hello World Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500,500));
        frame.getContentPane().setBackground(Color.green);

        JLabel label = new JLabel("Hello World");
        label.setFont(new Font("TimesNewRoman",Font.PLAIN,30));
        frame.getContentPane().add(label);

        frame.pack();
        frame.setVisible(true);
    }
}
