/*
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisims.TestBenchServo;
@Disabled
@TeleOp
public class ServoExamples extends OpMode {
    TestBenchServo bench = new TestBenchServo();
    double leftTrigger, rightTrigger;
    @Override
    public void init() {
        bench.init(hardwareMap);
        leftTrigger = 0.0;
        rightTrigger = 0.0;
    }

    @Override
    public void loop() {
        //0.0 is max left 0.5 is mid 1.0 is max right I believe
       leftTrigger = gamepad1.left_trigger;
       rightTrigger = gamepad1.right_trigger;

       bench.setServoSwyft(leftTrigger);
       bench.setServoGoBilda(rightTrigger);
        }
    }

/*
1. set your CR servo which btw doesn't exist to reverse it's direction
2. Set OpMode so when you pull the left game pad trigger sets the position of positional servo
and when you pull the right gamepad trigger, 0 is off and 1 is full on
 */