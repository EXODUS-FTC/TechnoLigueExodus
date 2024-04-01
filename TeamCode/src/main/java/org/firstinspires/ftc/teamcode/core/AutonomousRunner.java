package org.firstinspires.ftc.teamcode.core;

import org.firstinspires.ftc.teamcode.abstracts.IAutonomousProgram;
import org.firstinspires.ftc.teamcode.abstracts.IAutonomousRunner;
import org.firstinspires.ftc.teamcode.dtos.Detection;

public class AutonomousRunner implements IAutonomousRunner {

    private final IAutonomousProgram[] autonomousPrograms;

    public AutonomousRunner(IAutonomousProgram... autonomousPrograms) {
        this.autonomousPrograms = autonomousPrograms;
    }
    @Override
    public void runAutonomous(Detection detection) {
        if (!detection.detected) {
            return;
        }
        if (detection.x <= 350) {
            this.autonomousPrograms[0].run();
            return;
        } else if (detection.x >= 350 && detection.x <= 750) {
            this.autonomousPrograms[1].run();
            return;
        } else if (detection.x >= 750)
        this.autonomousPrograms[2].run();

    }
}
