import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ScreenCapture implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Toolkit tk = Toolkit.getDefaultToolkit();
            Dimension d = tk.getScreenSize();
            Rectangle rec = new Rectangle(0, 0, d.width, d.height);
            Robot ro = new Robot();
            BufferedImage img = ro.createScreenCapture(rec);
            File f = new File("ScreenShot.jpg");// set appropriate path
            ImageIO.write(img, "jpg", f);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}
