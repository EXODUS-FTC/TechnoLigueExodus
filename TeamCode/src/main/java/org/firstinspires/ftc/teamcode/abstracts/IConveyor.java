package org.firstinspires.ftc.teamcode.abstracts;

public interface IConveyor {
    public void configure();
    public void goUp();
    public void goDown();
    public void stop();
    public void setPower(double power);
}
