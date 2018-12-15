package core.swing.swingFileChooser;

import javax.swing.*;
import java.io.File;

public class SwingFileChooser {
    private JPanel fileChooserPanel;
    private JLabel label;
    private static JMenuBar mainBar;
    private static JMenuItem open, exit;
    private static JFileChooser fileChooser;

    public static void main(String[] args) {
        JFrame frame = new JFrame("SwingFileChooser");
        SwingFileChooser mainFC = new SwingFileChooser();
        frame.setContentPane(mainFC.fileChooserPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(creatingMenuBar(mainFC.label));
        frame.pack();
        frame.setBounds(400, 300, frame.getWidth(), frame.getHeight());
        frame.setVisible(true);
    }

    private static JMenuBar creatingMenuBar(JLabel label) {
        mainBar = new JMenuBar();

        open = new JMenuItem("Open");
        fileChooser = new JFileChooser();
        open.addActionListener(e -> {
            fileChooser.showOpenDialog(null);
            File file = fileChooser.getSelectedFile();
            String fileName = file.getName();
            label.setText(fileName);
            System.out.println(fileName);
        });
        mainBar.add(open);

        exit = new JMenuItem("Exit");
        exit.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to close this window?", "Close Window?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        mainBar.add(exit);

        return mainBar;
    }
}
