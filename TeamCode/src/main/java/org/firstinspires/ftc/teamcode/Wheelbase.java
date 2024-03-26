package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import java.util.Map;

public class Wheelbase {
    private final Map<String, DcMotor> motors;
    public Wheelbase(Map<String, DcMotor> motors) {
        this.motors = motors;
    }
    public void configure() {
        this.motors.get("r1").setDirection(DcMotor.Direction.FORWARD);
        this.motors.get("l1").setDirection(DcMotor.Direction.REVERSE);
        this.motors.get("r2").setDirection(DcMotor.Direction.FORWARD);
        this.motors.get("l2").setDirection(DcMotor.Direction.FORWARD);
    }

    public void goLeft(double seconds) {
        this.motors.get("r1").setPower(0.5);
        this.motors.get("l1").setPower(0.5);
        this.motors.get("r2").setPower(-0.5);
        this.motors.get("l2").setPower(-0.5);
    }

    public void goRight(double seconds) {
        this.motors.get("r1").setPower(0.5);
        this.motors.get("l1").setPower(0.5);
        this.motors.get("r2").setPower(-0.5);
        this.motors.get("l2").setPower(-0.5);
    }

    public void setPowers(Map<String, Double> powers) {
        for (String motor:
                this.motors.keySet()) {
            this.motors.get(motor).setPower(powers.get(motor));
        }
    }
}
