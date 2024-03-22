package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Elevator implements IElevator {
    private final DcMotor motor;
    public Elevator(DcMotor motor) {
        this.motor = motor;
    }
    public void configure() {
        this.motor.setDirection(DcMotor.Direction.FORWARD);
    }
    @Override
    public void lift() {

    }

    @Override
    public void lower() {

    }

    @Override
    public void setPower(double power) {
        this.motor.setPower(power);
    }
}
