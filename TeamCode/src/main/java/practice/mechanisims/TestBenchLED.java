/*
package org.firstinspires.ftc.teamcode.mechanisims;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.LED;

public class TestBenchLED {
        private LED redLed, greenLed;
        private boolean redLedToggleState = false;
        private boolean redLedLastState = false;
        public void init (HardwareMap hwMap) {
            redLed = hwMap.get(LED.class, "led_red");
            greenLed = hwMap.get(LED.class, "led_green");
            // "" is what is on the driver hub
        }

    public void setRedLed(boolean isOn) {
        redLed.enable(isOn);
            /*
        Brogan M. Patt's way
        if (isOn) {
            redLed.on();
        }
        else {
            redLed.off();
        }

    }

    public void setGreenLed(boolean isOn) {

        greenLed.enable(isOn);

        Brogan M Patt's way
        if (isOn) {

            greenLed.on();
        }
        else {
            greenLed.off();
        }


    }
    public void toggleRedLed (boolean isOn) {
        if (isOn && !redLedLastState) {
            redLedToggleState = !redLedToggleState;
            redLed.enable(redLedToggleState);
        }
        redLedLastState = isOn;
    }
}
 */