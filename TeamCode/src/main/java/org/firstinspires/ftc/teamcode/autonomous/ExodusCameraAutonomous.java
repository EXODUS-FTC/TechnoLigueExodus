package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.core.AprilTagBannerDetector;
import org.firstinspires.ftc.teamcode.core.AutonomousRunner;
import org.firstinspires.ftc.teamcode.core.Hardware;
import org.firstinspires.ftc.teamcode.core.Wheelbase;
import org.firstinspires.ftc.teamcode.dtos.Detection;


@Autonomous(name = "ExodusCameraAutonomous", group = "Robot")
public class ExodusCameraAutonomous extends LinearOpMode {
    @Override
    public void runOpMode() {
        Hardware hardware = new Hardware(hardwareMap);
        Wheelbase wheelbase = new Wheelbase(hardware.getWheelbaseMotors("r1", "l1", "r2", "l2"));
        wheelbase.configure();
        AprilTagBannerDetector bannerDetector = new AprilTagBannerDetector(hardware.getCamera("camera"));
        AutonomousRunner autonomousRunner = new AutonomousRunner(
                new CameraAutonomous1(telemetry, wheelbase),
                new CameraAutonomous2(telemetry, wheelbase),
                new CameraAutonomous3(telemetry, wheelbase)
        );
        waitForStart();
        Detection detection = bannerDetector.detect();
        while (!detection.detected) {
            detection = bannerDetector.detect();
            telemetry.addLine(String.format("x: %f, y: %f", detection.x, detection.y));
            telemetry.update();
        }
        sleep(100);
        autonomousRunner.runAutonomous(detection);
    }
}

