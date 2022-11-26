import javax.swing.JFrame;

public class ScreenCapture extends JFrame {
    public ScreenCapture() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1024, 768);
    }

    public void Open() {
        setVisible(true);
    }
}
