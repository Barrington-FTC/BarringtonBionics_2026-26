/*
package org.firstinspires.ftc.teamcode.mechanisims;
//import com.qualcomm.robotcore.hardware.CRServo Because we don't actually have rotating servo
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
// A lot of commented stuff because practice if I ever get a rotational servo
public class TestBenchServo {
    private Servo servoSwyft;
    private Servo servoGoBilda;

    public void init(HardwareMap hwMap){
        servoSwyft = hwMap.get(Servo.class, "swyft_servo");
        servoGoBilda = hwMap.get(Servo.class, "gobilda_servo");
        //For Rotation servoRot = hwMap.get(Servo.class, "servo_rot");
        // servoGoBilda.scaleRange(0.5,1.0); I don't need it but would make servo stay in 0.5-1.0 range
        // servoSwyft.scaleRange(0,0.5);
        // servoSwyft.setDirection(Servo.Direction.REVERSE); Reverses movement
        servoGoBilda.setDirection(Servo.Direction.REVERSE); // I wanted both to be same it was weird
        // servoRot.setDirection(DcMotorSimple.Direction.REVERSE); Doesn't exist just practice
    }

    public void setServoSwyft(double angle){
        servoSwyft.setPosition(angle);
    }
    public void setServoGoBilda(double angle){
        servoGoBilda.setPosition((angle));
    }
    /*
    public void setServoRot(double power) {
        servoRot.setPower(power);
        }

}
*/