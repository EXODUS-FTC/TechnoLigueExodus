package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.core.Hardware;
import org.firstinspires.ftc.teamcode.core.Wheelbase;


@Autonomous(name="ExodusAutonomous56", group="Robot")
public class ExodusAutonomous56 extends LinearOpMode {
    @Override
    public void runOpMode() {
        Hardware hardware = new Hardware(hardwareMap);
        Wheelbase wheelbase = new Wheelbase(hardware.getWheelbaseMotors("r1", "l1", "r2", "l2"));
        wheelbase.configure();
        waitForStart();
        wheelbase.goForward();
        sleep(100);
        wheelbase.stop();
        sleep(100);
        wheelbase.goRight();
        sleep(1300);
        wheelbase.stop();
        sleep(100);
        wheelbase.goBack();
        sleep(200);
        wheelbase.stop();
    }
}
