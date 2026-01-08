/*
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@Disabled
@TeleOp
public class TeamMemberPractice extends OpMode {
    boolean initDone;

    @Override
    public void init() {
        telemetry.addData("Init", initDone);
        initDone = true;
    }

    double squareinputWithSign(double input){
        double output = input * input;
        if(input < 0){
            output *= -1;
        }
        return output;
    }

    @Override
    public void loop() {
        telemetry.addData("Init", initDone);
        double yAxis = gamepad1.left_stick_y;
        telemetry.addData("Left Stick Normal", yAxis);
        yAxis = squareinputWithSign(yAxis);
        telemetry.addData("Left Stick Modified", yAxis);
    }
}
/*
Variables created in init or loop are only seen in that place to make it seen in both init and loop
create them under the class
double before the method squareinputWithSign means that it returns a double you could change that to
int or boolean or if you aren't returning such as loop and init then change it to void
public means that all clases can access that method such public TeamMemberPractice or Public void loop
double squareinputWithSign is default non-specified which can be acessed by any classes only in the same
package as for private that can only be acessed in the same class

 */
