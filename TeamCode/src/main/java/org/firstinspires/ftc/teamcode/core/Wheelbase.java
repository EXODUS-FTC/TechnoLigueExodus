package org.firstinspires.ftc.teamcode.core;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
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

    public void goLeft() {
        this.motors.get("r1").setPower(0.5);
        this.motors.get("l1").setPower(0.5);
        this.motors.get("r2").setPower(-0.5);
        this.motors.get("l2").setPower(-0.5);
    }

    public void goRight() {
        this.motors.get("r1").setPower(-0.5);
        this.motors.get("l1").setPower(-0.5);
        this.motors.get("r2").setPower(0.5);
        this.motors.get("l2").setPower(0.5);
    }

    public void goForward() {
        this.motors.get("r1").setPower(0.5);
        this.motors.get("l1").setPower(-0.5);
        this.motors.get("r2").setPower(0.5);
        this.motors.get("l2").setPower(-0.5);
    }

    public void goBack() {
        this.motors.get("r1").setPower(-0.5);
        this.motors.get("l1").setPower(0.5);
        this.motors.get("r2").setPower(-0.5);
        this.motors.get("l2").setPower(0.5);
    }

    public void stop() {
        this.motors.get("r1").setPower(0);
        this.motors.get("l1").setPower(0);
        this.motors.get("r2").setPower(0);
        this.motors.get("l2").setPower(0);
    }

    public void setPowers(Map<String, Double> powers) {
        for (String motor:
                this.motors.keySet()) {
            this.motors.get(motor).setPower(powers.get(motor));
        }
    }
}
