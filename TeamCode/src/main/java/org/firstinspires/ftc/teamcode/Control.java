package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import java.util.HashMap;

public class Control {
    public static HashMap<String, Float> getMovementValues() {
        HashMap<String, Float> values = new HashMap<>();
        values.put("horizontal", gamepad1.left_stick_x);
        values.put("vertical", gamepad1.left_stick_y);
        values.put("rotation", gamepad1.right_stick_x);
        return values;
    }
    public static boolean getHookGrabValue() {
        return gamepad1.b;
    }
    public static boolean getHookHomeValue() {
        return gamepad1.a;
    }
}
