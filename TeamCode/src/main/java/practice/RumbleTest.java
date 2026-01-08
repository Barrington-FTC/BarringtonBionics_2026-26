/*
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad; // Needed for the LED Effect

@Disabled
@TeleOp
public class RumbleTest extends OpMode {
    // boolean wasA, isA;
    boolean isEndGame;
    boolean isFinalWarning;
    // double endGameStart;
    @Override
    public void init() {

    }

    @Override
    public void start() {
        // endGameStart = getRuntime() + 98;
        resetRuntime();
    }

    @Override
    public void loop() {
        // end game check
        if (getRuntime() >= 98 && !isEndGame) {
            gamepad1.rumbleBlips(3);
            gamepad1.setLedColor(0, 255, 0, 1000);
            isEndGame = true;
        }
        if (getRuntime() >= 113 && !isFinalWarning) {
            gamepad1.rumble(1000); // Solid rumble for 1 second

            // Create a "Police" flashing effect:
            // Red for 250ms, Blue for 250ms, repeating for 5 seconds
            Gamepad.LedEffect policeSiren = new Gamepad.LedEffect.Builder()
                    .addStep(255, 0, 0, 250) // Red
                    .addStep(0, 0, 255, 250) // Blue
                    .setRepeating(true)
                    .build();

            gamepad1.runLedEffect(policeSiren);
            isFinalWarning = true;


        }
        double timeLeft = 120-getRuntime();
        telemetry.addData("Match Time", "%.1f", timeLeft);
        telemetry.update();
        }




        /*isA = gamepad1.a;
        if (isA && !wasA) {
            gamepad1.rumbleBlips(3);
            gamepad1.setLedColor(0, 255, 0, 1000);
        }
        wasA = isA;

    }

 */