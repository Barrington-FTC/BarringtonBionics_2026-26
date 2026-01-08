/*
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@Disabled
@TeleOp
public class IfPractice extends OpMode {
    @Override
    public void init() {

    }

    @Override
    public void loop() {
        double motorSpeed = gamepad2.left_stick_y;

        if (!gamepad1.a){
            motorSpeed *= 0.5; //motorSpeed = motorSpeed * 0.5;
        }

        telemetry.addData("Left Stick value", motorSpeed);
        /*
        1. Make a turbo button. If the a button is NOT pressed, multiply the motor speed by 0.5
        otherwise use the standard speed

    }

}

And - &&: if (leftY< 0.5 && leftY >0)
OR ||: if (leftY<0 || rightY<0)
NOT !: if(!clawClosed)
 */