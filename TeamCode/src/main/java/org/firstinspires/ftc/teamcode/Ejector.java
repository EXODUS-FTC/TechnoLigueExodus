package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Servo;

public class Ejector implements IEjector {
    private final Servo servo;
    public Ejector(Servo servo) {
        this.servo = servo;
    }
    @Override
    public void configure() {
        this.servo.setDirection(Servo.Direction.FORWARD);
    }

    @Override
    public void eject() {

    }

    @Override
    public void close() {

    }
}
