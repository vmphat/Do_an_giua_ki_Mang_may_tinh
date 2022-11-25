import java.net.Socket;

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
        } catch (Exception e) {
            e.printStackTrace();
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
