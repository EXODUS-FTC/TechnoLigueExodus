package org.firstinspires.ftc.teamcode.abstracts;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.core.Wheelbase;

public abstract class WheelBaseAutonomousProgram implements IAutonomousProgram {
    protected final Telemetry telemetry;
    protected final Wheelbase wheelbase;

    public WheelBaseAutonomousProgram(Telemetry telemetry, Wheelbase wheelbase) {
        this.telemetry = telemetry;
        this.wheelbase = wheelbase;
    }

    protected void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
