/*
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.mechanisims.TestBenchDcMotor;
import org.firstinspires.ftc.teamcode.mechanisims.TestBenchIMU;
@Disabled
@TeleOp
public class ImuPractice extends OpMode {
    TestBenchIMU bench = new TestBenchIMU();
    double heading;
    @Override
    public void init() {
        bench.init(hardwareMap);
        bench.resetHeading();
    }

    @Override
    public void loop() {
        heading = bench.getHeading(AngleUnit.RADIANS);
        telemetry.addData("Heading", heading);
        if (heading < -0.5) {
            bench.setMotor(0.5);
        }
        else if (heading < 0.5 && heading > -0.5) {
            bench.setMotor(0.0);
        }
        else {
            bench.setMotor(-0.5);
        }
    }
}
/*
1.Return heading in raidans
2. When your heading is <0.5 && greater than -0.5 stop a motor, If its less than -0.5 make your motor positive
and if its greater than .5 make your motor negative
 */
