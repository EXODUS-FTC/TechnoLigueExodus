package org.firstinspires.ftc.teamcode.dtos;

public class Detection {
    public double x;
    public double y;
    public boolean detected;

    public Detection(double x, double y, boolean detected) {
        this.x = x;
        this.y = y;
        this.detected = detected;
    }
}
