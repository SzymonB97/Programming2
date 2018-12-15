package core.swing.swingMenuBar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class swingMenuBar {
    private JPanel menuBarPanel;
    private static JMenuBar mainBar;
    private static JMenu file, search;
    private static JMenuItem open, save, exit, find;

    public static void main(String[] args) {
        JFrame frame = new JFrame("swingMenuBar");
        frame.setContentPane(new swingMenuBar().menuBarPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(creatingMenuBar());
        frame.pack();
        frame.setBounds(400, 300, frame.getWidth(), frame.getHeight());
        frame.setVisible(true);
    }

    private static JMenuBar creatingMenuBar() {
        mainBar = new JMenuBar();

        file = new JMenu("File");

        open = new JMenuItem("Open");
        file.add(open);
        save = new JMenuItem("Save");
        file.add(save);
        exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to close this window?", "Close Window?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        file.add(exit);
        mainBar.add(file);

        search = new JMenu("Search");

        find = new JMenuItem("Find");
        search.add(find);
        mainBar.add(search);

        return mainBar;
    }
}
