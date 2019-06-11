package hr.rma.sl.ime_tapswipe;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.HapticFeedbackConstants;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputConnection;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class KeyboardLayout extends LinearLayout {

    int margin = 0;
    DisplayMetrics dm;
    Context context;
    LayoutInflater inflater;
    InputConnection inputConn;
    int availableHeight;
    int availableWidth;
    float KEYBOARD_HEIGHT_SCALE_FACTOR;
    LinearLayout touchZone;
    List<View> allElements;
    List<LinearLayout> touchZones = new ArrayList<LinearLayout>();
    boolean lowercase = false;


    public KeyboardLayout(LayoutInflater inflater,
                          final Context ctx,
                          InputConnection inputConn,
                          float kbHeight) {
        super(ctx);
        this.context = ctx;
        this.inflater = inflater;
        this.inputConn = inputConn;

        // Calculate dimensions of the keyboard, relative to the display size:
        this.KEYBOARD_HEIGHT_SCALE_FACTOR = kbHeight;
        this.margin = (int) (context.getResources().getDisplayMetrics().density + 0.5f);
        this.dm = context.getResources().getDisplayMetrics();
        float kbScale = KEYBOARD_HEIGHT_SCALE_FACTOR * dm.heightPixels;
        float kbScaleX = 1f * dm.widthPixels;
        this.availableHeight = (int) kbScale;
        this.availableWidth = (int) kbScaleX;

        // inflate your layout (keyboard_layout.xml):
        inflater.inflate(R.layout.keyboard_layout, this);

        // apply keyboard height
        LinearLayout basicLL = (LinearLayout) this.findViewById(R.id.basicLayout);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) basicLL.getLayoutParams();
        params.height = this.availableHeight;
        params.width = this.availableWidth;
        //touchZone = (LinearLayout) this.findViewById(R.id.touchZoneE);
        allElements = getAllChildrenBFS(basicLL);
        for (int i = 0; i < allElements.size(); i++) {
            final View iElement = allElements.get(i);
            final View linearElement = allElements.get(i);

            if (linearElement instanceof LinearLayout) {
                touchZones.add((LinearLayout) linearElement);
            }
            if (iElement instanceof TextView)
                iElement.setOnTouchListener(new OnSwipeTouchListener(context) {

                    @Override
                    public void onSwipeDown() {
                        String currentText = ((TextView) iElement).getText().toString();
                        switch (currentText) {
                            case "e":
                            case "E":
                                commitText(currentText + "t");
                                touchZones.get(5).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "a":
                            case "A":
                                commitText(currentText + "l");
                                touchZones.get(6).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "i":
                            case "I":
                                commitText(currentText + "s");
                                touchZones.get(7).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "o":
                            case "O":
                                commitText(currentText + "s");
                                touchZones.get(8).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "u":
                            case "U":
                                commitText(currentText + "p");
                                touchZones.get(9).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "m":
                            case "M":
                                commitText(currentText + "e");
                                touchZones.get(10).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "s":
                            case "S":
                                commitText(currentText + "i");
                                touchZones.get(11).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "n":
                            case "N":
                                commitText(currentText + "o");
                                touchZones.get(12).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "p":
                            case "P":
                                commitText(currentText + "u");
                                touchZones.get(13).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "d":
                            case "D":
                                commitText(currentText + "e");
                                touchZones.get(14).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "j":
                            case "J":
                                commitText(currentText + "i");
                                touchZones.get(15).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "t":
                            case "T":
                                commitText(currentText + "e");
                                touchZones.get(16).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "k":
                            case "K":
                                commitText(currentText + "r");
                                touchZones.get(18).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "b":
                            case "B":
                                commitText(currentText + "r");
                                touchZones.get(19).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "z":
                            case "Z":
                                commitText(currentText + "v");
                                touchZones.get(5).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "v":
                            case "V":
                                commitText(currentText + "e");
                                touchZones.get(6).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "r":
                            case "R":
                                commitText(currentText + "o");
                                touchZones.get(7).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "g":
                            case "G":
                                commitText(currentText + "l");
                                touchZones.get(8).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "l":
                            case "L":
                                commitText(currentText + "o");
                                touchZones.get(9).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "š":
                            case "Š":
                                commitText(currentText + "i");
                                touchZones.get(10).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "h":
                            case "H":
                                commitText(currentText + "e");
                                touchZones.get(11).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "ć":
                            case "Ć":
                                commitText(currentText + "a");
                                touchZones.get(12).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "c":
                            case "C":
                                commitText(currentText + "u");
                                touchZones.get(13).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "č":
                            case "Č":
                                commitText(currentText + "n");
                                touchZones.get(14).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "f":
                            case "F":
                                commitText(currentText + "a");
                                touchZones.get(15).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "q":
                            case "Q":
                                touchZones.get(16).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "ž":
                            case "Ž":
                                commitText(currentText + "d");
                                touchZones.get(18).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "đ":
                            case "Đ":
                                commitText(currentText + "u");
                                touchZones.get(19).setBackgroundResource(R.drawable.b_normal);
                                break;
                        }
                    }

                    @Override
                    public void onSwipeLeft() {
                        String currentText = ((TextView) iElement).getText().toString();
                        switch (currentText) {
                            case "e":
                            case "E":
                                commitText(currentText + "d");
                                touchZones.get(5).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "a":
                            case "A":
                                commitText(currentText + "t");
                                touchZones.get(6).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "i":
                            case "I":
                                commitText(currentText + "t");
                                touchZones.get(7).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "o":
                            case "O":
                                commitText(currentText + "d");
                                touchZones.get(8).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "u":
                            case "U":
                                commitText(currentText + "s");
                                touchZones.get(9).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "m":
                            case "M":
                                commitText(currentText + "i");
                                touchZones.get(10).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "s":
                            case "S":
                                commitText(currentText + "e");
                                touchZones.get(11).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "n":
                            case "N":
                                commitText(currentText + "i");
                                touchZones.get(12).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "p":
                            case "P":
                                commitText(currentText + "a");
                                touchZones.get(13).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "d":
                            case "D":
                                commitText(currentText + "i");
                                touchZones.get(14).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "j":
                            case "J":
                                commitText(currentText + "u");
                                touchZones.get(15).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "t":
                            case "T":
                                commitText(currentText + "a");
                                touchZones.get(16).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "k":
                            case "K":
                                commitText(currentText + "u");
                                touchZones.get(18).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "b":
                            case "B":
                                commitText(currentText + "o");
                                touchZones.get(19).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "z":
                            case "Z":
                                commitText(currentText + "i");
                                touchZones.get(5).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "v":
                            case "V":
                                commitText(currentText + "i");
                                touchZones.get(6).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "r":
                            case "R":
                                commitText(currentText + "i");
                                touchZones.get(7).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "g":
                            case "G":
                                commitText(currentText + "u");
                                touchZones.get(8).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "l":
                            case "L":
                                commitText(currentText + "j");
                                touchZones.get(9).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "š":
                            case "Š":
                                commitText(currentText + "e");
                                touchZones.get(10).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "h":
                            case "H":
                                commitText(currentText + "v");
                                touchZones.get(11).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "ć":
                            case "Ć":
                                commitText(currentText + "u");
                                touchZones.get(12).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "c":
                            case "C":
                                commitText(currentText + "e");
                                touchZones.get(13).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "č":
                            case "Č":
                                commitText(currentText + "a");
                                touchZones.get(14).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "f":
                            case "F":
                                commitText(currentText + "r");
                                touchZones.get(15).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "q":
                                commitText("y");
                                touchZones.get(16).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "Q":
                                commitText("Y");
                                touchZones.get(16).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "ž":
                            case "Ž":
                                commitText(currentText + "a");
                                touchZones.get(18).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "đ":
                            case "Đ":
                                commitText(currentText + "i");
                                touchZones.get(19).setBackgroundResource(R.drawable.b_normal);
                                break;
                        }
                    }

                    @Override
                    public void onSwipeUp() {
                        String currentText = ((TextView) iElement).getText().toString();
                        switch (currentText) {
                            case "e":
                            case "E":
                                commitText(currentText + "n");
                                touchZones.get(5).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "a":
                            case "A":
                                commitText(currentText + "m");
                                touchZones.get(6).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "i":
                            case "I":
                                commitText(currentText + "j");
                                touchZones.get(7).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "o":
                            case "O":
                                commitText(currentText + "v");
                                touchZones.get(8).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "u":
                            case "U":
                                commitText(currentText + "t");
                                touchZones.get(9).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "m":
                            case "M":
                                commitText(currentText + "o");
                                touchZones.get(10).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "s":
                            case "S":
                                commitText(currentText + "t");
                                touchZones.get(11).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "n":
                            case "N":
                                commitText(currentText + "a");
                                touchZones.get(12).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "p":
                            case "P":
                                commitText(currentText + "o");
                                touchZones.get(13).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "d":
                            case "D":
                                commitText(currentText + "a");
                                touchZones.get(14).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "j":
                            case "J":
                                commitText(currentText + "e");
                                touchZones.get(15).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "t":
                            case "T":
                                commitText(currentText + "i");
                                touchZones.get(16).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "k":
                            case "K":
                                commitText(currentText + "o");
                                touchZones.get(18).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "b":
                            case "B":
                                commitText(currentText + "i");
                                touchZones.get(19).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "z":
                            case "Z":
                                commitText(currentText + "a");
                                touchZones.get(5).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "v":
                            case "V":
                                commitText(currentText + "a");
                                touchZones.get(6).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "r":
                            case "R":
                                commitText(currentText + "a");
                                touchZones.get(7).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "g":
                            case "G":
                                commitText(currentText + "o");
                                touchZones.get(8).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "l":
                            case "L":
                                commitText(currentText + "i");
                                touchZones.get(9).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "š":
                            case "Š":
                                commitText(currentText + "t");
                                touchZones.get(10).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "h":
                            case "H":
                                commitText(currentText + "a");
                                touchZones.get(11).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "ć":
                            case "Ć":
                                commitText(currentText + "e");
                                touchZones.get(12).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "c":
                            case "C":
                                commitText(currentText + "i");
                                touchZones.get(13).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "č":
                            case "Č":
                                commitText(currentText + "i");
                                touchZones.get(14).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "f":
                            case "F":
                                commitText(currentText + "i");
                                touchZones.get(15).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "q":
                                commitText("w");
                                touchZones.get(16).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "Q":
                                commitText("W");
                                touchZones.get(16).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "ž":
                            case "Ž":
                                commitText(currentText + "e");
                                touchZones.get(18).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "đ":
                            case "Đ":
                                commitText(currentText + "e");
                                touchZones.get(19).setBackgroundResource(R.drawable.b_normal);
                                break;
                        }
                    }

                    @Override
                    public void onSwipeRight() {
                        String currentText = ((TextView) iElement).getText().toString();
                        switch (currentText) {
                            case "e":
                            case "E":
                                commitText(currentText + "m");
                                touchZones.get(5).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "a":
                            case "A":
                                commitText(currentText + "n");
                                touchZones.get(6).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "i":
                            case "I":
                                commitText(currentText + "m");
                                touchZones.get(7).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "o":
                            case "O":
                                commitText(currentText + "j");
                                touchZones.get(8).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "u":
                            case "U":
                                commitText(currentText + "d");
                                touchZones.get(9).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "m":
                            case "M":
                                commitText(currentText + "a");
                                touchZones.get(10).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "s":
                            case "S":
                                commitText(currentText + "a");
                                touchZones.get(11).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "n":
                            case "N":
                                commitText(currentText + "e");
                                touchZones.get(12).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "p":
                            case "P":
                                commitText(currentText + "r");
                                touchZones.get(13).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "d":
                            case "D":
                                commitText(currentText + "o");
                                touchZones.get(14).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "j":
                            case "J":
                                commitText(currentText + "a");
                                touchZones.get(15).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "t":
                            case "T":
                                commitText(currentText + "o");
                                touchZones.get(16).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "k":
                            case "K":
                                commitText(currentText + "a");
                                touchZones.get(18).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "b":
                            case "B":
                                commitText(currentText + "a");
                                touchZones.get(19).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "z":
                            case "Z":
                                commitText(currentText + "n");
                                touchZones.get(5).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "v":
                            case "V":
                                commitText(currentText + "o");
                                touchZones.get(6).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "r":
                            case "R":
                                commitText(currentText + "e");
                                touchZones.get(7).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "g":
                            case "G":
                                commitText(currentText + "a");
                                touchZones.get(8).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "l":
                            case "L":
                                commitText(currentText + "a");
                                touchZones.get(9).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "š":
                            case "Š":
                                commitText(currentText + "a");
                                touchZones.get(10).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "h":
                            case "H":
                                commitText(currentText + "o");
                                touchZones.get(11).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "ć":
                            case "Ć":
                                commitText(currentText + "i");
                                touchZones.get(12).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "c":
                            case "C":
                                commitText(currentText + "a");
                                touchZones.get(13).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "č":
                            case "Č":
                                commitText(currentText + "e");
                                touchZones.get(14).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "f":
                            case "F":
                                commitText(currentText + "o");
                                touchZones.get(15).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "q":
                                commitText("x");
                                touchZones.get(16).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "Q":
                                commitText("X");
                                touchZones.get(16).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "ž":
                            case "Ž":
                                commitText(currentText + "i");
                                touchZones.get(18).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "đ":
                            case "Đ":
                                commitText(currentText + "a");
                                touchZones.get(19).setBackgroundResource(R.drawable.b_normal);
                                break;
                        }
                    }

                    @Override
                    public void onTapDown() {
                        String currentText = ((TextView) iElement).getText().toString();
                        switch (currentText) {
                            case "e":
                            case "E":
                                touchZones.get(5).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(5).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "a":
                            case "A":
                                touchZones.get(6).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(6).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "i":
                            case "I":
                                touchZones.get(7).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(7).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "o":
                            case "O":
                                touchZones.get(8).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(8).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "u":
                            case "U":
                                touchZones.get(9).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(9).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "m":
                            case "M":
                                touchZones.get(10).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(10).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "s":
                            case "S":
                                touchZones.get(11).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(11).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "n":
                            case "N":
                                touchZones.get(12).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(12).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "p":
                            case "P":
                                touchZones.get(13).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(13).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "d":
                            case "D":
                                touchZones.get(14).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(14).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "j":
                            case "J":
                                touchZones.get(15).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(15).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "t":
                            case "T":
                                touchZones.get(16).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(16).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "k":
                            case "K":
                                touchZones.get(18).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(18).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "b":
                            case "B":
                                touchZones.get(19).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(19).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "z":
                            case "Z":
                                touchZones.get(5).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(5).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "v":
                            case "V":
                                touchZones.get(6).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(6).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "r":
                            case "R":
                                touchZones.get(7).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(7).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "g":
                            case "G":
                                touchZones.get(8).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(8).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "l":
                            case "L":
                                touchZones.get(9).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(9).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "š":
                            case "Š":
                                touchZones.get(10).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(10).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "h":
                            case "H":
                                touchZones.get(11).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(11).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "ć":
                            case "Ć":
                                touchZones.get(12).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(12).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "c":
                            case "C":
                                touchZones.get(13).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(13).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "č":
                            case "Č":
                                touchZones.get(14).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(14).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "f":
                            case "F":
                                touchZones.get(15).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(15).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "q":
                            case "Q":
                                touchZones.get(16).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(16).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "ž":
                            case "Ž":
                                touchZones.get(18).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(18).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case "đ":
                            case "Đ":
                                touchZones.get(19).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(19).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                        }
                    }

                    @Override
                    public void onTapUp() {
                        String currentText = ((TextView) iElement).getText().toString();
                        switch (currentText) {
                            case "e":
                            case "E":
                                commitText(currentText);
                                touchZones.get(5).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "a":
                            case "A":
                                commitText(currentText);
                                touchZones.get(6).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "i":
                            case "I":
                                commitText(currentText);
                                touchZones.get(7).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "o":
                            case "O":
                                commitText(currentText);
                                touchZones.get(8).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "u":
                            case "U":
                                commitText(currentText);
                                touchZones.get(9).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "m":
                            case "M":
                                commitText(currentText);
                                touchZones.get(10).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "s":
                            case "S":
                                commitText(currentText);
                                touchZones.get(11).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "n":
                            case "N":
                                commitText(currentText);
                                touchZones.get(12).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "p":
                            case "P":
                                commitText(currentText);
                                touchZones.get(13).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "d":
                            case "D":
                                commitText(currentText);
                                touchZones.get(14).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "j":
                            case "J":
                                commitText(currentText);
                                touchZones.get(15).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "t":
                            case "T":
                                commitText(currentText);
                                touchZones.get(16).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "k":
                            case "K":
                                commitText(currentText);
                                touchZones.get(18).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "b":
                            case "B":
                                commitText(currentText);
                                touchZones.get(19).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "z":
                            case "Z":
                                commitText(currentText);
                                touchZones.get(5).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "v":
                            case "V":
                                commitText(currentText);
                                touchZones.get(6).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "r":
                            case "R":
                                commitText(currentText);
                                touchZones.get(7).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "g":
                            case "G":
                                commitText(currentText);
                                touchZones.get(8).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "l":
                            case "L":
                                commitText(currentText);
                                touchZones.get(9).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "š":
                            case "Š":
                                commitText(currentText);
                                touchZones.get(10).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "h":
                            case "H":
                                commitText(currentText);
                                touchZones.get(11).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "ć":
                            case "Ć":
                                commitText(currentText);
                                touchZones.get(12).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "c":
                            case "C":
                                commitText(currentText);
                                touchZones.get(13).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "č":
                            case "Č":
                                commitText(currentText);
                                touchZones.get(14).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "f":
                            case "F":
                                commitText(currentText);
                                touchZones.get(15).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "q":
                            case "Q":
                                commitText(currentText);
                                touchZones.get(16).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "ž":
                            case "Ž":
                                commitText(currentText);
                                touchZones.get(18).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case "đ":
                            case "Đ":
                                commitText(currentText);
                                touchZones.get(19).setBackgroundResource(R.drawable.b_normal);
                                break;
                        }
                    }
                });
            else if (iElement instanceof ImageButton) {
                iElement.setOnTouchListener(new OnSwipeTouchListener(context){
                    public void onTapDown() {
                        int currentID = iElement.getId();
                        switch (currentID){
                            case R.id.buttonSPACE:
                                touchZones.get(17).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(17).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case R.id.buttonSHIFT:
                                touchZones.get(20).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(20).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case R.id.buttonALT:
                                touchZones.get(21).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(21).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case R.id.buttonENTER:
                                touchZones.get(22).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(22).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                            case R.id.buttonDEL:
                                touchZones.get(23).setBackgroundResource(R.drawable.b_pressed);
                                touchZones.get(23).performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                                break;
                        }
                    }
                    public void onTapUp() {
                        int currentID = iElement.getId();
                        switch (currentID) {
                            case R.id.buttonSPACE:
                                commitAction(iElement.getId());
                                touchZones.get(17).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case R.id.buttonSHIFT:
                                commitAction(iElement.getId());
                                touchZones.get(20).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case R.id.buttonALT:
                                commitAction(iElement.getId());
                                touchZones.get(21).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case R.id.buttonENTER:
                                commitAction(iElement.getId());
                                touchZones.get(22).setBackgroundResource(R.drawable.b_normal);
                                break;
                            case R.id.buttonDEL:
                                commitAction(iElement.getId());
                                touchZones.get(23).setBackgroundResource(R.drawable.b_normal);
                                break;
                        }
                    }

                });
            }
        }
    }

    // Find all View elements in a root View
    private List<View> getAllChildrenBFS(View v) {
        List<View> visited = new ArrayList<View>();
        List<View> unvisited = new ArrayList<View>();
        unvisited.add(v);

        while (!unvisited.isEmpty()) {
            View child = unvisited.remove(0);
            visited.add(child);
            if (!(child instanceof ViewGroup)) continue;
            ViewGroup group = (ViewGroup) child;
            final int childCount = group.getChildCount();
            for (int i=0; i<childCount; i++) unvisited.add(group.getChildAt(i));
        }
        return visited;
    }

    // Parent layout inspects the touch event and decides accordingly...
    @Override
    public boolean dispatchTouchEvent(MotionEvent e) {
        if (e.getAction() == MotionEvent.ACTION_UP) {
            // Whenever UP event is detected, button should be presented as 'normal':
            for(int zones = 5; zones < touchZones.size(); zones++){
                touchZones.get(zones).setBackgroundResource(R.drawable.b_normal);
            }
        }
        return super.dispatchTouchEvent(e);
    }

    // Apply character to the input stream
    private void commitText(String s){
        if (inputConn != null)
            inputConn.commitText(s, 1);
    }

    // Apply action to the input stream
    private void commitAction(int buttonID){
        if (buttonID == R.id.buttonDEL) {
            if (inputConn != null)
                inputConn.deleteSurroundingText(1, 0);
        } else if (buttonID == R.id.buttonSHIFT) {
            toggleCase();
        }
        else if (buttonID == R.id.buttonALT){
            toggleAlt();
        }
        else if(buttonID == R.id.buttonSPACE) {
            if (inputConn != null)
                inputConn.commitText(" ",1);
        }
        else if(buttonID == R.id.buttonENTER) {
            if (inputConn != null)
                inputConn.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                inputConn.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_ENTER));
        }

    }

    // Toggle buttons' lowercase/uppercase
    private void toggleCase(){
        for (int i = 0; i < allElements.size(); i++) {
            View iElement = allElements.get(i);
            if (iElement instanceof TextView) {
                String currentText = ((TextView) iElement).getText().toString();
                if (!lowercase) {
                    ((TextView) iElement).setText(currentText.toLowerCase());
                } else {
                    ((TextView) iElement).setText(currentText.toUpperCase());
                }
            }
        }
        lowercase = !lowercase;
    }

    private void toggleAlt(){
        for (int i = 0; i < allElements.size(); i++) {
            View iElement = allElements.get(i);
            if (iElement instanceof TextView) {
                String currentText = ((TextView) iElement).getText().toString();
                switch (currentText) {
                    case "e":
                    case "E":
                        ((TextView) iElement).setText("z");
                        break;
                    case "en":
                    case "EN":
                        ((TextView) iElement).setText("za");
                        break;
                    case "em":
                    case "EM":
                        ((TextView) iElement).setText("zn");
                        break;
                    case "et":
                    case "ET":
                        ((TextView) iElement).setText("zv");
                        break;
                    case "ed":
                    case "ED":
                        ((TextView) iElement).setText("zi");
                        break;
                    case "a":
                    case "A":
                        ((TextView) iElement).setText("v");
                        break;
                    case "am":
                    case "AM":
                        ((TextView) iElement).setText("va");
                        break;
                    case "an":
                    case "AN":
                        ((TextView) iElement).setText("vo");
                        break;
                    case "at":
                    case "AT":
                        ((TextView) iElement).setText("vi");
                        break;
                    case "al":
                    case "AL":
                        ((TextView) iElement).setText("ve");
                        break;
                    case "i":
                    case "I":
                        ((TextView) iElement).setText("r");
                        break;
                    case "ij":
                    case "IJ":
                        ((TextView) iElement).setText("ra");
                        break;
                    case "im":
                    case "IM":
                        ((TextView) iElement).setText("re");
                        break;
                    case "it":
                    case "IT":
                        ((TextView) iElement).setText("ri");
                        break;
                    case "is":
                    case "IS":
                        ((TextView) iElement).setText("ro");
                        break;
                    case "o":
                    case "O":
                        ((TextView) iElement).setText("g");
                        break;
                    case "ov":
                    case "OV":
                        ((TextView) iElement).setText("go");
                        break;
                    case "oj":
                    case "OJ":
                        ((TextView) iElement).setText("ga");
                        break;
                    case "od":
                    case "OD":
                        ((TextView) iElement).setText("gu");
                        break;
                    case "os":
                    case "OS":
                        ((TextView) iElement).setText("gl");
                        break;
                    case "u":
                    case "U":
                        ((TextView) iElement).setText("l");
                        break;
                    case "ut":
                    case "UT":
                        ((TextView) iElement).setText("li");
                        break;
                    case "ud":
                    case "UD":
                        ((TextView) iElement).setText("la");
                        break;
                    case "us":
                    case "US":
                        ((TextView) iElement).setText("lj");
                        break;
                    case "up":
                    case "UP":
                        ((TextView) iElement).setText("lo");
                        break;
                    case "m":
                    case "M":
                        ((TextView) iElement).setText("š");
                        break;
                    case "mo":
                    case "MO":
                        ((TextView) iElement).setText("št");
                        break;
                    case "ma":
                    case "MA":
                        ((TextView) iElement).setText("ša");
                        break;
                    case "mi":
                    case "MI":
                        ((TextView) iElement).setText("še");
                        break;
                    case "me":
                    case "ME":
                        ((TextView) iElement).setText("ši");
                        break;
                    case "s":
                    case "S":
                        ((TextView) iElement).setText("h");
                        break;
                    case "st":
                    case "ST":
                        ((TextView) iElement).setText("ha");
                        break;
                    case "sa":
                    case "SA":
                        ((TextView) iElement).setText("ho");
                        break;
                    case "se":
                    case "SE":
                        ((TextView) iElement).setText("hv");
                        break;
                    case "si":
                    case "SI":
                        ((TextView) iElement).setText("he");
                        break;
                    case "n":
                    case "N":
                        ((TextView) iElement).setText("ć");
                        break;
                    case "na":
                    case "NA":
                        ((TextView) iElement).setText("će");
                        break;
                    case "ne":
                    case "NE":
                        ((TextView) iElement).setText("ći");
                        break;
                    case "ni":
                    case "NI":
                        ((TextView) iElement).setText("ću");
                        break;
                    case "no":
                    case "NO":
                        ((TextView) iElement).setText("ća");
                        break;
                    case "p":
                    case "P":
                        ((TextView) iElement).setText("c");
                        break;
                    case "po":
                    case "PO":
                        ((TextView) iElement).setText("ci");
                        break;
                    case "pr":
                    case "PR":
                        ((TextView) iElement).setText("ca");
                        break;
                    case "pa":
                    case "PA":
                        ((TextView) iElement).setText("ce");
                        break;
                    case "pu":
                    case "PU":
                        ((TextView) iElement).setText("cu");
                        break;
                    case "d":
                    case "D":
                        ((TextView) iElement).setText("č");
                        break;
                    case "da":
                    case "DA":
                        ((TextView) iElement).setText("či");
                        break;
                    case "do":
                    case "DO":
                        ((TextView) iElement).setText("če");
                        break;
                    case "di":
                    case "DI":
                        ((TextView) iElement).setText("ča");
                        break;
                    case "de":
                    case "DE":
                        ((TextView) iElement).setText("čn");
                        break;
                    case "j":
                    case "J":
                        ((TextView) iElement).setText("f");
                        break;
                    case "je":
                    case "JE":
                        ((TextView) iElement).setText("fi");
                        break;
                    case "ja":
                    case "JA":
                        ((TextView) iElement).setText("fo");
                        break;
                    case "ju":
                    case "JU":
                        ((TextView) iElement).setText("fr");
                        break;
                    case "ji":
                    case "JI":
                        ((TextView) iElement).setText("fa");
                        break;
                    case "t":
                    case "T":
                        ((TextView) iElement).setText("q");
                        break;
                    case "ti":
                    case "TI":
                        ((TextView) iElement).setText("w");
                        break;
                    case "to":
                    case "TO":
                        ((TextView) iElement).setText("x");
                        break;
                    case "ta":
                    case "TA":
                        ((TextView) iElement).setText("y");
                        break;
                    case "te":
                    case "TE":
                        ((TextView) iElement).setText("");
                        break;
                    case "k":
                    case "K":
                        ((TextView) iElement).setText("ž");
                        break;
                    case "ko":
                    case "KO":
                        ((TextView) iElement).setText("že");
                        break;
                    case "ka":
                    case "KA":
                        ((TextView) iElement).setText("ži");
                        break;
                    case "ku":
                    case "KU":
                        ((TextView) iElement).setText("ža");
                        break;
                    case "kr":
                    case "KR":
                        ((TextView) iElement).setText("žd");
                        break;
                    case "b":
                    case "B":
                        ((TextView) iElement).setText("đ");
                        break;
                    case "bi":
                    case "BI":
                        ((TextView) iElement).setText("đe");
                        break;
                    case "ba":
                    case "BA":
                        ((TextView) iElement).setText("đa");
                        break;
                    case "bo":
                    case "BO":
                        ((TextView) iElement).setText("đi");
                        break;
                    case "br":
                    case "BR":
                        ((TextView) iElement).setText("đu");
                        break;
                    case "z":
                    case "Z":
                        ((TextView) iElement).setText("e");
                        break;
                    case "za":
                    case "ZA":
                        ((TextView) iElement).setText("en");
                        break;
                    case "zn":
                    case "ZN":
                        ((TextView) iElement).setText("em");
                        break;
                    case "zi":
                    case "ZI":
                        ((TextView) iElement).setText("ed");
                        break;
                    case "zv":
                    case "ZV":
                        ((TextView) iElement).setText("et");
                        break;
                    case "v":
                    case "V":
                        ((TextView) iElement).setText("a");
                        break;
                    case "va":
                    case "VA":
                        ((TextView) iElement).setText("am");
                        break;
                    case "vo":
                    case "VO":
                        ((TextView) iElement).setText("an");
                        break;
                    case "vi":
                    case "VI":
                        ((TextView) iElement).setText("at");
                        break;
                    case "ve":
                    case "VE":
                        ((TextView) iElement).setText("al");
                        break;
                    case "r":
                    case "R":
                        ((TextView) iElement).setText("i");
                        break;
                    case "ra":
                    case "RA":
                        ((TextView) iElement).setText("ij");
                        break;
                    case "re":
                    case "RE":
                        ((TextView) iElement).setText("im");
                        break;
                    case "ri":
                    case "RI":
                        ((TextView) iElement).setText("it");
                        break;
                    case "ro":
                    case "RO":
                        ((TextView) iElement).setText("is");
                        break;
                    case "g":
                    case "G":
                        ((TextView) iElement).setText("o");
                        break;
                    case "go":
                    case "GO":
                        ((TextView) iElement).setText("ov");
                        break;
                    case "ga":
                    case "GA":
                        ((TextView) iElement).setText("oj");
                        break;
                    case "gu":
                    case "GU":
                        ((TextView) iElement).setText("od");
                        break;
                    case "gl":
                    case "GL":
                        ((TextView) iElement).setText("os");
                        break;
                    case "l":
                    case "L":
                        ((TextView) iElement).setText("u");
                        break;
                    case "li":
                    case "LI":
                        ((TextView) iElement).setText("ut");
                        break;
                    case "la":
                    case "LA":
                        ((TextView) iElement).setText("ud");
                        break;
                    case "lj":
                    case "LJ":
                        ((TextView) iElement).setText("us");
                        break;
                    case "lo":
                    case "LO":
                        ((TextView) iElement).setText("up");
                        break;
                    case "š":
                    case "Š":
                        ((TextView) iElement).setText("m");
                        break;
                    case "št":
                    case "ŠT":
                        ((TextView) iElement).setText("mo");
                        break;
                    case "ša":
                    case "ŠA":
                        ((TextView) iElement).setText("ma");
                        break;
                    case "še":
                    case "ŠE":
                        ((TextView) iElement).setText("mi");
                        break;
                    case "ši":
                    case "ŠI":
                        ((TextView) iElement).setText("me");
                        break;
                    case "h":
                    case "H":
                        ((TextView) iElement).setText("s");
                        break;
                    case "ha":
                    case "HA":
                        ((TextView) iElement).setText("st");
                        break;
                    case "ho":
                    case "HO":
                        ((TextView) iElement).setText("sa");
                        break;
                    case "hv":
                    case "HV":
                        ((TextView) iElement).setText("se");
                        break;
                    case "he":
                    case "HE":
                        ((TextView) iElement).setText("si");
                        break;
                    case "ć":
                    case "Ć":
                        ((TextView) iElement).setText("n");
                        break;
                    case "će":
                    case "ĆE":
                        ((TextView) iElement).setText("na");
                        break;
                    case "ći":
                    case "ĆI":
                        ((TextView) iElement).setText("ne");
                        break;
                    case "ću":
                    case "ĆU":
                        ((TextView) iElement).setText("ni");
                        break;
                    case "ća":
                    case "ĆA":
                        ((TextView) iElement).setText("no");
                        break;
                    case "c":
                    case "C":
                        ((TextView) iElement).setText("p");
                        break;
                    case "ci":
                    case "CI":
                        ((TextView) iElement).setText("po");
                        break;
                    case "ca":
                    case "CA":
                        ((TextView) iElement).setText("pr");
                        break;
                    case "ce":
                    case "CE":
                        ((TextView) iElement).setText("pa");
                        break;
                    case "cu":
                    case "CU":
                        ((TextView) iElement).setText("pu");
                        break;
                    case "č":
                    case "Č":
                        ((TextView) iElement).setText("d");
                        break;
                    case "či":
                    case "ČI":
                        ((TextView) iElement).setText("da");
                        break;
                    case "če":
                    case "ČE":
                        ((TextView) iElement).setText("do");
                        break;
                    case "ča":
                    case "ČA":
                        ((TextView) iElement).setText("di");
                        break;
                    case "čn":
                    case "ČN":
                        ((TextView) iElement).setText("de");
                        break;
                    case "f":
                    case "F":
                        ((TextView) iElement).setText("j");
                        break;
                    case "fi":
                    case "FI":
                        ((TextView) iElement).setText("je");
                        break;
                    case "fo":
                    case "FO":
                        ((TextView) iElement).setText("ja");
                        break;
                    case "fr":
                    case "FR":
                        ((TextView) iElement).setText("ju");
                        break;
                    case "fa":
                    case "FA":
                        ((TextView) iElement).setText("ji");
                        break;
                    case "q":
                    case "Q":
                        ((TextView) iElement).setText("t");
                        break;
                    case "w":
                    case "W":
                        ((TextView) iElement).setText("ti");
                        break;
                    case "x":
                    case "X":
                        ((TextView) iElement).setText("to");
                        break;
                    case "Y":
                    case "y":
                        ((TextView) iElement).setText("ta");
                        break;
                    case "":
                        ((TextView) iElement).setText("te");
                        break;
                    case "ž":
                    case "Ž":
                        ((TextView) iElement).setText("k");
                        break;
                    case "že":
                    case "ŽE":
                        ((TextView) iElement).setText("ko");
                        break;
                    case "ži":
                    case "ŽI":
                        ((TextView) iElement).setText("ka");
                        break;
                    case "ža":
                    case "ŽA":
                        ((TextView) iElement).setText("ku");
                        break;
                    case "žd":
                    case "ŽD":
                        ((TextView) iElement).setText("kr");
                        break;
                    case "đ":
                    case "Đ":
                        ((TextView) iElement).setText("b");
                        break;
                    case "đe":
                    case "ĐE":
                        ((TextView) iElement).setText("bi");
                        break;
                    case "đa":
                    case "ĐA":
                        ((TextView) iElement).setText("ba");
                        break;
                    case "đi":
                    case "ĐI":
                        ((TextView) iElement).setText("bo");
                        break;
                    case "đu":
                    case "ĐU":
                        ((TextView) iElement).setText("br");
                        break;
                }
            }
        }
    }

    // Android Swipe Gesture Detector
    public class OnSwipeTouchListener implements OnTouchListener {

        private GestureDetector gestureDetector;

        public OnSwipeTouchListener(Context c) {
            gestureDetector = new GestureDetector(c, new GestureListener());
        }

        public boolean onTouch(final View view, final MotionEvent motionEvent) {
            return gestureDetector.onTouchEvent(motionEvent);
        }

        private final class GestureListener extends GestureDetector.SimpleOnGestureListener {

            private static final int SWIPE_THRESHOLD = 30;
            private static final int SWIPE_VELOCITY_THRESHOLD = 30;

            @Override
            public boolean onDown(MotionEvent e) {
                onTapDown();
                return true;
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e)  {
                onTapUp();
                return false;
            }

            // Determines the fling velocity and then fires the appropriate swipe event accordingly
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                try {
                    float diffY = e2.getY() - e1.getY();
                    float diffX = e2.getX() - e1.getX();
                    if (Math.abs(diffX) > Math.abs(diffY)) {
                        if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD ) {
                            if (diffX > 0) {
                                onSwipeRight();
                            } else {
                                onSwipeLeft();
                            }
                        }
                    } else {
                        if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD ) {
                            if (diffY > 0) {
                                onSwipeDown();
                            } else {
                                onSwipeUp();
                            }
                        }
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                return false;
            }
        }

        public void onSwipeRight() {
        }

        public void onSwipeLeft() {
        }

        public void onSwipeUp() {
        }

        public void onSwipeDown() {
        }

        public void onTapUp() {
        }

        public void onTapDown() {
        }
    }


}