import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AppDesign extends JFrame {
    private JTextField txtIP = new JTextField("Nhập IP");
    private JButton butConnect = new JButton("Kết nối");
    private JButton butProcess = new JButton(
            "<html><center>" + "Process running" + "</center></html>");
    private JButton butApp = new JButton("<html><center>" + "App running" + "</center></html>");
    private JButton butShutdown = new JButton("<html><center>" + "Tắt máy" + "</center></html>");
    private JButton butReg = new JButton("<html><center>" + "Sửa registry" + "</center></html>");
    private JButton butExit = new JButton("<html><center>" + "Thoát" + "</center></html>");
    private JButton butPic = new JButton("<html><center>" + "Chụp màn hình" + "</center></html>");
    private JButton butKeyStroke = new JButton("<html><center>" + "Chụp màn hình" + "</center></html>");

    private Client client = new Client();

    AppDesign() {
        setBounds(0, 0, 400, 300);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void ShowButton() {
        txtIP.setBounds(10, 10, 200, 20);
        butConnect.setBounds(220, 10, 100, 20);
        butConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connect();
            }
        });
        add(txtIP);
        add(butConnect);

        butProcess.setBounds(10, 40, 60, 210);

        butApp.setBounds(80, 40, 200, 60);
        butShutdown.setBounds(80, 110, 110, 60);
        butReg.setBounds(80, 180, 200, 70);
        butPic.setBounds(200, 110, 80, 60);
        butKeyStroke.setBounds(290, 40, 80, 130);
        butExit.setBounds(290, 180, 80, 70);
        add(butProcess);
        add(butApp);
        add(butShutdown);
        add(butReg);
        add(butPic);
        add(butKeyStroke);
        add(butExit);
    }

    private void Connect() {
        this.client.Connect(this.txtIP.getName(), 5656);
        if (!this.client.IsConnected()) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối");
            return;
        }
        JOptionPane.showMessageDialog(null, "Kết nối thành công");
    }
}