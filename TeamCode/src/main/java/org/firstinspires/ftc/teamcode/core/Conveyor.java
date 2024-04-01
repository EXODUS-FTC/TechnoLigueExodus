package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.abstracts.IConveyor;

public class Conveyor implements IConveyor {
    private final DcMotor motor;
    public Conveyor(DcMotor motor) {
        this.motor = motor;
    }
    @Override
    public void configure() {
        this.motor.setDirection(DcMotor.Direction.FORWARD);
    }

    @Override
    public void goUp() {

    }

    @Override
    public void goDown() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void setPower(double power) {
        this.motor.setPower(power);
    }
}
