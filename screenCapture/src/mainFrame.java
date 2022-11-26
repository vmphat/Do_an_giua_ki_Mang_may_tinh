import javax.swing.JFrame;

public class mainFrame {
    private JFrame thisFrame;

    public mainFrame() {
        thisFrame = new JFrame();
        thisFrame.setLayout(null);
        thisFrame.setVisible(true);
        thisFrame.setSize(1000, 600);
    }

    public void insertPrtScrButton(int x, int y) {
        screenCapture b = new screenCapture(x, y, thisFrame);
    }
}
