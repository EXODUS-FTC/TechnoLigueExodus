package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.abstracts.IEjector;

public class Ejector implements IEjector {
    private final Servo servo;
    private final double HOME_POSITION;
    private final double FINAL_POSITION;
    public Ejector(Servo servo, double homePosition, double finalPosition) {
        this.servo = servo;
        this.HOME_POSITION = homePosition;
        this.FINAL_POSITION = finalPosition;
    }
    @Override
    public void configure() {
        this.servo.setDirection(Servo.Direction.FORWARD);
    }

    @Override
    public void eject() {
        this.servo.setPosition(this.FINAL_POSITION);
    }

    @Override
    public void close() {
        this.servo.setPosition(this.HOME_POSITION);
    }
}
