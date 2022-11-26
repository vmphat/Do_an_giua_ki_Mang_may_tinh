import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {
    public Socket clientSocket;

    public Client() {
        this.clientSocket = new Socket();
    }

    public void Connect(String ip, int port) {
        if (this.clientSocket.isConnected()) {
            Close();
        }
        try {
            this.clientSocket = new Socket(ip, port);
            JOptionPane.showMessageDialog(null, "Kết nối đến server thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi kết nối dến server");
        }
    }

    public boolean IsConnected() {
        return this.clientSocket.isConnected();
    }

    public void Close() {
        try {
            this.clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
