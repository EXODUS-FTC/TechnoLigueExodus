package org.firstinspires.ftc.teamcode.autonomous;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.abstracts.WheelBaseAutonomousProgram;
import org.firstinspires.ftc.teamcode.core.Wheelbase;

public class CameraAutonomous1 extends WheelBaseAutonomousProgram {

    public CameraAutonomous1(Telemetry telemetry, Wheelbase wheelbase) {
        super(telemetry, wheelbase);
    }

    @Override
    public void run() {
        telemetry.addLine("Autonomous 1");
        telemetry.update();
        wheelbase.goForward();
        sleep(200);
        wheelbase.stop();
        sleep(100);
        wheelbase.goLeft();
        sleep(1000);
        wheelbase.stop();
    }
}
