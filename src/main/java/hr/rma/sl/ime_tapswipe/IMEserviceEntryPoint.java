package hr.rma.sl.ime_tapswipe;

import android.content.Context;
import android.content.res.Configuration;
import android.inputmethodservice.InputMethodService;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.WindowManager;


public class IMEserviceEntryPoint extends InputMethodService  {

    Context context;
    LayoutInflater inflater;
    KeyboardLayout layout;
    // Keyboard height: hardcoded here (depends on the current device orientation)
    float KEYBOARD_HEIGHT = 0.65f;


    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        inflater = getLayoutInflater();
        // no dim support
        getWindow().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        // all application logic will be performed in respective keyboard layout!
    }


    @Override
    public void onWindowShown() {
        enableKeyboard();
    }


    // Make keyboard enabled (visible), with all properties set
    private void enableKeyboard(){
        checkOrientation();

        layout = new KeyboardLayout(inflater,
                context,
                this.getCurrentInputConnection(),
                KEYBOARD_HEIGHT);
        setInputView(layout);
        updateInputViewShown();
    }


    // Reacting on orientation change
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        enableKeyboard();
    }


    // Setting keyboard height according to the current device orientation
    private void checkOrientation(){
        Display display = ((WindowManager)
                context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int rotation = display.getRotation();

        switch (rotation) {
            case Surface.ROTATION_0:
                KEYBOARD_HEIGHT = 0.50f;
                break;
            case Surface.ROTATION_90:
                KEYBOARD_HEIGHT = 0.65f;
                break;
            case Surface.ROTATION_180:
                KEYBOARD_HEIGHT = 0.50f;
                break;
            case Surface.ROTATION_270:
                KEYBOARD_HEIGHT = 0.65f;
                break;
            default:
                KEYBOARD_HEIGHT = 0.50f;
                break;
        }
    }
}