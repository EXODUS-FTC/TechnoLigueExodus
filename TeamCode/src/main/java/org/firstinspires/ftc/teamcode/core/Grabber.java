package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.abstracts.IGrabber;

public class Grabber implements IGrabber {
    private final Servo[] grabberServos;
    private final double GRABBER_HOME_POSITION;
    private final double GRABBER_FINAL_POSITION;
    private final double MOVER_HOME_POSITION;
    private final double MOVER_FINAL_POSITION;
    private final Servo[] moverServo;

    public Grabber(Servo[] grabberServos,
            Servo[] moverServo,
            double GRABBER_HOME_POSITION,
            double GRABBER_FINAL_POSITION,
            double MOVER_HOME_POSITION,
            double MOVER_FINAL_POSITION) {
        this.moverServo = moverServo;
        this.grabberServos = grabberServos;
        this.GRABBER_HOME_POSITION = GRABBER_HOME_POSITION;
        this.GRABBER_FINAL_POSITION = GRABBER_FINAL_POSITION;
        this.MOVER_HOME_POSITION = MOVER_HOME_POSITION;
        this.MOVER_FINAL_POSITION = MOVER_FINAL_POSITION;
    }
    public void configure() {

    }
    @Override
    public void grab() {
        for (Servo servo:
                this.grabberServos) {
            servo.setPosition(this.GRABBER_FINAL_POSITION);
        }
    }

    @Override
    public void home() {
        for (Servo servo:
                this.grabberServos) {
            servo.setPosition(this.GRABBER_HOME_POSITION);
        }
    }

    @Override
    public void goDown() {
        for (Servo servo:
                this.moverServo) {
            servo.setPosition(this.MOVER_FINAL_POSITION);
        }
    }

    @Override
    public void goUp() {
        for (Servo servo:
                this.moverServo) {
            servo.setPosition(this.MOVER_HOME_POSITION);
        }
    }
}
