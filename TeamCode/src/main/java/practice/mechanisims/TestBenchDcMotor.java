/*
package org.firstinspires.ftc.teamcode.mechanisims;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestBenchDcMotor {
    private DcMotor motor; //motor give it a more descriptive name this is what we use later on

    private double ticksPerRev; // revolution

    public void init(HardwareMap hwMap) {

        // DC Motor?
        motor =hwMap.get(DcMotor .class,"motor"); //Basically same notes as for touchSensor
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);// This makes it so motor is most accurate other good types exist though.
        ticksPerRev = motor.getMotorType().getTicksPerRev();
    }
    public void setMotorSpeed(double speed) {
        // accepts values from - 1.0 to 1.0
        motor.setPower(speed);
    }
    public double getMotorRevs(){
        return motor.getCurrentPosition()/ ticksPerRev;

        Dividing how many ticks motor has spun by how many ticks in a revolution to get the number
        of revolutions this changes if you have a gear ratio

    }
    public void setMotorZeroBehavior(DcMotor.ZeroPowerBehavior zeroBehavior) {
        motor.setZeroPowerBehavior(zeroBehavior);
    }

}
*/