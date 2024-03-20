package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="ExodusMovement", group="Linear OpMode")
public class ExodusMovement extends LinearOpMode {
    @Override
    public void runOpMode() {
        Wheelbase wheelbase = new Wheelbase(Hardware.getWheelbaseMotors("left", "right", "front", "back"));
        Hook hook = new Hook(Hardware.getHookServos("leftHookServo", "rightHookServo"), 0, 1);
        hook.configure();
        wheelbase.configure();
        waitForStart();
        while (opModeIsActive()) {
            wheelbase.setPowers(PowersCalculator.normalizePowers(PowersCalculator.calculatePowers(Control.getMovementValues())));
            if (Control.getHookGrabValue()) {
                hook.grab();
            }
            if (Control.getHookHomeValue()) {
                hook.home();
            }
        }
    }
}

