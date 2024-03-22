package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

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
}
