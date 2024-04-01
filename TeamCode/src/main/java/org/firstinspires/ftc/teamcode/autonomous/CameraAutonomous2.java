package org.firstinspires.ftc.teamcode.autonomous;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.abstracts.IAutonomousProgram;
import org.firstinspires.ftc.teamcode.abstracts.WheelBaseAutonomousProgram;
import org.firstinspires.ftc.teamcode.core.Wheelbase;

public class CameraAutonomous2 extends WheelBaseAutonomousProgram {

    public CameraAutonomous2(Telemetry telemetry, Wheelbase wheelbase) {
        super(telemetry, wheelbase);
    }

    @Override
    public void run() {
        telemetry.addLine("Autonomous 2");
        telemetry.update();
        wheelbase.goForward();
        sleep(1200);
        wheelbase.stop();
        sleep(100);
        wheelbase.goRight();
        sleep(250);
        wheelbase.stop();
    }
}
