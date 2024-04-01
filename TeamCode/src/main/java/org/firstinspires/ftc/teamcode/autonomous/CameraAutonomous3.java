package org.firstinspires.ftc.teamcode.autonomous;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.abstracts.WheelBaseAutonomousProgram;
import org.firstinspires.ftc.teamcode.core.Wheelbase;

public class CameraAutonomous3 extends WheelBaseAutonomousProgram {
    public CameraAutonomous3(Telemetry telemetry, Wheelbase wheelbase) {
        super(telemetry, wheelbase);
    }

    @Override
    public void run() {
        telemetry.addLine("Autonomous 3");
        telemetry.update();
        wheelbase.goForward();
        sleep(3000);
        wheelbase.stop();
        sleep(100);
        wheelbase.goLeft();
        sleep(300);
        wheelbase.stop();
    }
}
