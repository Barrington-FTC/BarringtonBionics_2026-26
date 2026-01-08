/*
package org.firstinspires.ftc.teamcode.mechanisims;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class TestBenchColorSensor {
    NormalizedColorSensor colorSensor;

    public enum DetectedColor {
        PURPLE,
        GREEN,
        UNKOWNN
    }

    public void init(HardwareMap hwMap) {
        colorSensor = hwMap.get(NormalizedColorSensor.class, "sensor_color_distance");
        colorSensor.setGain(10);
    }

    public DetectedColor getDetectedColor(Telemetry telemetry) {
        NormalizedRGBA colors = colorSensor.getNormalizedColors(); // returns 4 values Red Green Blue
        // and Alpha/how much light is getting returned back
        float normRed, normGreen, normBlue;
        normRed = colors.red / colors.alpha;
        normGreen = colors.green / colors.alpha;
        normBlue = colors.blue / colors.alpha;

        telemetry.addData("red", normRed);
        telemetry.addData("green", normGreen);
        telemetry.addData("blue", normBlue);

        // TODO add if statements for specefic colors added
        /*
        red, green, blue
        GREEN = <0.25, >0.75, <0.6
        Purple = >0.9, >0.9 >0.9

        if (normRed < 0.25 && normGreen > 0.75 && normBlue < 0.6) {
            return DetectedColor.GREEN;
        } else if (normRed > 0.9 && normGreen > 0.9 && normBlue > 0.9) {
            return DetectedColor.PURPLE;
        } else {
            return DetectedColor.UNKOWNN;
        }
    }
}
*/