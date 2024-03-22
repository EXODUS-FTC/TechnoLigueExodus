package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class Control {
    private final Gamepad gamepad1;
    private final Gamepad gamepad2;

    public Control(Gamepad gamepad1, Gamepad gamepad2) {
        this.gamepad1 = gamepad1;
        this.gamepad2 = gamepad2;
    }
    public HashMap<String, Float> getMovementValues() {
        HashMap<String, Float> values = new HashMap<>();
        values.put("horizontal", gamepad1.left_stick_x);
        values.put("vertical", gamepad1.left_stick_y);
        values.put("rotation", gamepad1.right_stick_x);
        return values;
    }
    public boolean getHookGrabValue() {
        return gamepad1.b;
    }
    public boolean getHookHomeValue() {
        return gamepad1.a;
    }
    public float getConveyorForward() {
        return gamepad1.right_trigger;
    }
    public float getConveyorReverse() {
        return gamepad1.left_trigger;
    }
    public float getElevatorUp() {
        return gamepad2.right_trigger;
    }
    public float getElevatorDown() {
        return gamepad2.left_trigger;
    }
    public boolean getEject() {
        return gamepad2.a;
    }
    public boolean getEjectClose() {
        return gamepad2.b;
    }
}
