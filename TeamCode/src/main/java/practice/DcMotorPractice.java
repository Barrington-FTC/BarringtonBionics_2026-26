/*
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.mechanisims.TestBenchDcMotor;

@Disabled
@TeleOp
public class DcMotorPractice extends OpMode {
    TestBenchDcMotor bench = new TestBenchDcMotor();
    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {

        double motorSpeed = -gamepad1.left_stick_y;
        bench.setMotorSpeed(motorSpeed);
        if (gamepad1.a) {
            bench.setMotorZeroBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
        else if (gamepad1.b) {
            bench.setMotorZeroBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        }
        telemetry.addData("Number of Motor Revs So Far", bench.getMotorRevs());
    }
}
/*
1. add a method on your testBench that allows you to change the brake behavior from your OpMode
on A pressed set break on B pressed set float.
 */

