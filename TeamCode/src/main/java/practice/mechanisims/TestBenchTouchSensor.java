/*
package org.firstinspires.ftc.teamcode.mechanisims;

import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestBenchTouchSensor {
    private DigitalChannel touchSensor; // touchSensorIntake give a more descriptive name




    public void init(HardwareMap hwMap) {
        //touch sensor code
        touchSensor = hwMap.get(DigitalChannel.class, "touch_sensor");

        The name touchSensor comes from private DigitalChannel touchSensor;
        all the code knows till now is that we have a thing called touchSensor that is a DigitalChannel
        this line says that touchSensor = the thing called "touch_sensor" on the driver hub.

        touchSensor.setMode(DigitalChannel.Mode.INPUT);
        Digital Channels are of two types one that give ouputs e.g. led light
        and one that give inputs e.g. touch sensor here we are setting it to give inputs bcs its to

    }


    public boolean getTouchSensorState() {
        return !touchSensor.getState();
    }




















// Prob Not Gonna Be Used
//Returns the actual messed up false for pressed and true for released
    public boolean isTouchSensorReleased() {
        return touchSensor.getState();
    }
//Returns pressed and not pressed
    public String touchSensorPressedOrNotPressed(){
        String touchSensorState;
        if (getTouchSensorState()){
            touchSensorState = "Pressed";
        }
        else {
            touchSensorState = "Not Pressed";
        }
        return touchSensorState;
    }


}
*/