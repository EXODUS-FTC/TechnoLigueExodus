package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Servo;

public class Hook implements IHook {
    private final Servo[] servos;
    private final double HOME_POSITION;
    private final double FINAL_POSITION;

    public Hook(Servo[] servos, double HOME_POSITION, double FINAL_POSITION) {
        this.servos = servos;
        this.HOME_POSITION = HOME_POSITION;
        this.FINAL_POSITION = FINAL_POSITION;
    }
    @Override
    public void grab() {
        for (Servo servo:
             this.servos) {
            servo.setPosition(FINAL_POSITION);
        }
    }

    @Override
    public void home() {
        for (Servo servo:
                this.servos) {
            servo.setPosition(HOME_POSITION);
        }
    }

    @Override
    public void configure() {
        this.servos[0].setDirection(Servo.Direction.FORWARD);
        this.servos[1].setDirection(Servo.Direction.FORWARD);
    }
}
