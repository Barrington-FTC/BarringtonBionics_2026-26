package practice;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

import practice.mechanisims.MecanumDrive;

@TeleOp
public class MecanumFieldOrientatedOpMode extends OpMode {
    MecanumDrive drive = new MecanumDrive();
    @Override
    public void init() {
        drive.init(hardwareMap);
    }

    @Override
    public void start() {
    }

    @Override
    public void loop() {
        drive.update();

        double forward = -gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;
        double rotate = gamepad1.right_stick_x;
        if (Math.abs(forward) < 0.1) forward = 0;
        if (Math.abs(strafe)  < 0.1) strafe = 0;
        if (Math.abs(rotate) < 0.1) rotate = 0;
        // 2. Check for Reset Button (Options or Start button)
        // This resets "Forward" to completely away from the driver
        if (gamepad1.options) {
            drive.resetHeading();
        }
        drive.fieldOrientadedDrive(forward, strafe, rotate);
        drive.printStats(telemetry);
    }
}
