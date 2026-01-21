package practice.mechanisims;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;

public class MecanumDrive {
    private DcMotor frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor;
    //private IMU imu; // Rev IMU Stuff
    public GoBildaPinpointDriver odo;

    public void init(HardwareMap hwMap) {
        frontLeftMotor = hwMap.get(DcMotor.class, "leftFrontDrive");
        backLeftMotor = hwMap.get(DcMotor.class, "leftBackDrive");
        frontRightMotor = hwMap.get(DcMotor.class, "rightFrontDrive");
        backRightMotor = hwMap.get(DcMotor.class, "rightBackDrive");

        odo = hwMap.get(GoBildaPinpointDriver.class, "pinpoint");

        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        odo.setOffsets(161.0, -175.175, DistanceUnit.MM);
        odo.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        odo.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.FORWARD, GoBildaPinpointDriver.EncoderDirection.FORWARD);
        odo.resetPosAndIMU();

        Pose2D startingPosition = new Pose2D(DistanceUnit.MM, 0, 0, AngleUnit.RADIANS, 0);
        odo.setPosition(startingPosition);

//        Rev IMU STUFF
//        imu = hwMap.get(IMU.cl    ass, "imu");
//        RevHubOrientationOnRobot RevOrientation = new RevHubOrientationOnRobot(
//                RevHubOrientationOnRobot.LogoFacingDirection.LEFT, RevHubOrientationOnRobot.UsbFacingDirection.UP
//        );
//        imu.initialize(new IMU.Parameters(RevOrientation));
    }
    //    Rev Imu Stuff
//    public void reset() {
//            imu.resetYaw();
//        }
    public void resetEverything() {
        odo.resetPosAndIMU();
    }
    public void resetHeading() {
        // This resets the current position to (CurrentX, CurrentY, 0 Heading)
        // This "re-centers" the field orientation without losing your X/Y position
        Pose2D currentPos = odo.getPosition();
        odo.setPosition(new Pose2D(DistanceUnit.MM, currentPos.getX(DistanceUnit.MM), currentPos.getY(DistanceUnit.MM), AngleUnit.RADIANS, 0));
    }
    public void fixIMU() {
        odo.recalibrateIMU();
    }
    public void update() {
        odo.update();
    }

    public void drive (double forward, double strafe, double rotate) {
        double frontLeftPower = forward + strafe + rotate;
        double backLeftPower = forward - strafe + rotate;
        double frontRightPower = forward - strafe - rotate;
        double backRightPower = forward + strafe - rotate;

        double maxPower = 1.0;
        double maxSpeed = 1.0;
        // If You Wanna Nerf All Speed Or Smth For Practice

        maxPower = Math.max(maxPower, Math.abs(frontLeftPower));
        maxPower = Math.max(maxPower, Math.abs(backLeftPower));
        maxPower = Math.max(maxPower, Math.abs(frontRightPower));
        maxPower = Math.max(maxPower, Math.abs(backRightPower));
        // Reassigning maxPower to highest power so we can divide everything to keep scale later

        frontLeftMotor.setPower(maxSpeed * (frontLeftPower/maxPower));
        backLeftMotor.setPower(maxSpeed * (backLeftPower / maxPower ));
        frontRightMotor.setPower(maxSpeed * (frontRightPower / maxPower));
        backRightMotor.setPower(maxSpeed * (backRightPower / maxPower));
    }

    public void fieldOrientadedDrive(double forward, double strafe, double rotate) {
//        Brogan M. Patt's Way
//        double theta = Math.atan2(forward, strafe);
//        double r = Math.hypot(strafe, forward);
//
//        theta = AngleUnit.normalizeRadians(theta - imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS));
//
//        double newForward = r * Math.sin(theta);
//        double newStrafe = r * Math.cos(theta);
//        this.drive(newForward, newStrafe, rotate);
        //double botHeading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS); // Rev Way
        Pose2D pos = odo.getPosition();
        double botHeading = pos.getHeading(AngleUnit.RADIANS);
        // Rotate the movement direction counter to the bot's rotation
        double newForward = strafe * Math.sin(-botHeading) + forward * Math.cos(-botHeading);
        double newStrafe = strafe * Math.cos(-botHeading) - forward * Math.sin(-botHeading);

        newStrafe = newStrafe *1.1; // Counteract imperfect strafing
        this.drive(newForward, newStrafe, rotate);
    }
    public void printStats (Telemetry telemetry){
        Pose2D pos = odo.getPosition();
        telemetry.addData("Status", "Initialized");
        telemetry.addData("X offset", odo.getXOffset(DistanceUnit.MM));
        telemetry.addData("Y offset", odo.getYOffset(DistanceUnit.MM));
        telemetry.addData("Device Version Number:", odo.getDeviceVersion());
        telemetry.addData("Heading Scalar", odo.getYawScalar());
        telemetry.addData("X Position", pos.getX(DistanceUnit.MM));
        telemetry.addData("Y Position", pos.getY(DistanceUnit.MM));
        telemetry.addData("Robot Heading", pos.getHeading(AngleUnit.DEGREES));
    }
}