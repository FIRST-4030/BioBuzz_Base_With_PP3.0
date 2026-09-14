package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Class used to store values that need to be retained through switching OpModes, such as alliance color.
 */
public class Blackboard {
    public enum Alliance {
        RED,
        BLUE,
        UNKNOWN,
    }
    private static Alliance alliance = Alliance.UNKNOWN;

    public static Alliance getAlliance() {
        return alliance;
    };

    public static void setAlliance(Alliance alliance) {
        Blackboard.alliance = alliance;
    }

    /**
     * Prints information about Blackboard values and lets the user adjust them manually if need be.
     * @param telemetry The telemetry instance to print to.
     * @param gamepad The gamepad that should be used to adjust values.
     */
    public static void initLoopProcess(Telemetry telemetry, Gamepad gamepad) {
        telemetry.addLine("--- BLACKBOARD ---");
        telemetry.addData("Alliance", Blackboard.getAlliance());
        telemetry.addLine("^^^ RB + X: Blue,  RB + B: Red ^^^");
        telemetry.addLine();

        if (gamepad.right_bumper) {
            if (gamepad.xWasPressed()) {
                Blackboard.setAlliance(Alliance.BLUE);
            } else if (gamepad.bWasPressed()) {
                Blackboard.setAlliance(Alliance.RED);
            }
        }
    }
}
