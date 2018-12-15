package core.swing.swingListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingListener {
    private JPanel panel;
    private JTextField textField1;
    private JButton clickMeButton;
    private JLabel myLabel;

    public SwingListener() {
        clickMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myLabel.setText(textField1.getText());
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
