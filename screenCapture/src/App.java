import javax.swing.JFrame;

public class App {
    JFrame mainFrame;
    public static void main(String[] args) throws Exception {
        mainFrame frame = new mainFrame();
        frame.insertPrtScrButton(100, 100);
        frame.insertPrtScrButton(200, 200);
    }
}
