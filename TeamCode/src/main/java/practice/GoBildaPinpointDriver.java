package practice;

import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchDevice;
import com.qualcomm.robotcore.hardware.configuration.annotations.DeviceProperties;
import com.qualcomm.robotcore.hardware.configuration.annotations.I2cDeviceType;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@I2cDeviceType
@DeviceProperties(name = "goBILDA® Pinpoint Odometry Computer", xmlTag = "goBildaPinpointDriver", description = "goBILDA® Pinpoint Odometry Computer")
public class GoBildaPinpointDriver extends I2cDeviceSynchDevice<I2cDeviceSynch> {

    // --- REQUIRED HARDWARE METHODS (THE FIX) ---
    @Override
    public Manufacturer getManufacturer() {
        // This must return a Manufacturer Enum, not a String
        return Manufacturer.Other;
    }

    @Override
    public String getDeviceName() {
        return "goBILDA® Pinpoint Odometry Computer";
    }

    // --- ENUMS ---
    public enum DeviceState {
        NOT_READY(0), READY(1), CALIBRATING(10),
        FAULT_X_POD_NOT_DETECTED(20), FAULT_Y_POD_NOT_DETECTED(21),
        FAULT_NO_PODS_DETECTED(22), FAULT_IMU_NOT_DETECTED(23);
        private final int value;
        DeviceState(int value) { this.value = value; }
    }

    public enum Register {
        DEVICE_ID(0x00), DEVICE_VERSION(0x01), DEVICE_STATE(0x02),
        CONTROL_REG(0x03), X_OFFSET(0x04), Y_OFFSET(0x08),
        X_POS(0x0C), Y_POS(0x10), H_POS(0x14),
        ENCODER_RES(0x24), ENCODER_DIR(0x26);
        private final int bVal;
        Register(int bVal) { this.bVal = bVal; }
    }

    public enum GoBildaOdometryPods {
        goBILDA_4_BAR_POD(33144), goBILDA_SWINGARM_POD(13328);
        public final int res;
        GoBildaOdometryPods(int res) { this.res = res; }
    }

    public enum EncoderDirection {
        FORWARD(0), REVERSED(1);
        private final int val;
        EncoderDirection(int val) { this.val = val; }
    }

    // --- CONSTRUCTOR ---
    public GoBildaPinpointDriver(I2cDeviceSynch deviceSynch) {
        super(deviceSynch, true);
        this.deviceClient.setI2cAddress(I2cAddr.create7bit(0x08));
        super.registerArmingStateCallback(false);
        this.deviceClient.engage();
    }

    @Override
    protected boolean doInitialize() {
        return true;
    }

    // --- USER METHODS ---
    public void update() {
        this.deviceClient.read(Register.DEVICE_STATE.bVal, 1);
    }

    public void setOffsets(double x, double y) {
        byte[] data = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN)
                .putFloat((float)x).putFloat((float)y).array();
        deviceClient.write(Register.X_OFFSET.bVal, data);
    }

    public void setEncoderResolution(GoBildaOdometryPods pods) {
        byte[] data = ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN)
                .putShort((short)pods.res).array();
        deviceClient.write(Register.ENCODER_RES.bVal, data);
    }

    public void setEncoderDirections(EncoderDirection xDir, EncoderDirection yDir) {
        int val = (xDir.val) | (yDir.val << 1);
        deviceClient.write(Register.ENCODER_DIR.bVal, new byte[]{(byte)val});
    }

    public void resetPosAndIMU() {
        deviceClient.write(Register.CONTROL_REG.bVal, new byte[]{1});
    }

    public double getHeading() {
        byte[] data = deviceClient.read(Register.H_POS.bVal, 4);
        return (double) ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).getFloat();
    }

    public Pose2D getPosition() {
        byte[] data = deviceClient.read(Register.X_POS.bVal, 12);
        ByteBuffer buffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        float x = buffer.getFloat();
        float y = buffer.getFloat();
        float h = buffer.getFloat();
        return new Pose2D(DistanceUnit.MM, x, y, AngleUnit.RADIANS, h);
    }
}