import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class AppDesign extends JFrame {
    JButton startButton = new JButton("Mở server");

    AppDesign() {
        setSize(400, 300);
        setLayout(null);

        setTitle("Server");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void ShowButton() {
        startButton.setBounds(100, 25, 200, 200);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Start");
                KeyLogger keyLogger = new KeyLogger();
                startButton.setEnabled(false);
            }
        });
        add(startButton);
    }
}
