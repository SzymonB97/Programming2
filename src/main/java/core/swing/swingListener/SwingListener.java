package core.swing.swingListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SwingListener {
    private JPanel panel;
    private JTextField textField1;
    private JButton clickMeButton;
    private JLabel myLabel;
    private JButton counterButton;
    private int click = 0;

    public SwingListener() {
        clickMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myLabel.setText(textField1.getText());
                click++;
            }
        });

        counterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(clickMeButton, "Click me button was click " + click + " times.");
            }
        });

        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                System.out.println(e.getKeyChar());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SwingListener");
        frame.setContentPane(new SwingListener().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
