import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class KeyLogger implements NativeKeyListener {
    public KeyLogger() {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener(new KeyLogger());
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent arg0) {

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent arg0) {

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent arg0) {

    }

}
