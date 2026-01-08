/*
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisims.TestBenchTouchSensor;
@Disabled
@TeleOp
public class TouchSensorPractice extends OpMode {
    TestBenchTouchSensor bench = new TestBenchTouchSensor();
    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addData("Touch Sensor State", bench.touchSensorPressedOrNotPressed());
    }
    /*
    1. create a new getter method in your testBench class called "isTouchSensorReleased" return true
     if the touch sensor is not being pressed
    2. in your telemetry OpMode, have the telemetry display "Pressed" and "Not Pressed" instead of
    true and false

}
*/