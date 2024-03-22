package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="ExodusMovement", group="Linear OpMode")
public class ExodusMovement extends LinearOpMode {
    @Override
    public void runOpMode() {
        Hardware hardware = new Hardware(hardwareMap);
        Control control = new Control(gamepad1, gamepad2);
        // Wheelbase wheelbase = new Wheelbase(hardware.getWheelbaseMotors("left", "right", "front", "back"));
        Hook hook = new Hook(hardware.getHookServos("leftHookServo", "rightHookServo"), 0, 1);
        hook.configure();

        // wheelbase.configure();
        waitForStart();
        while (opModeIsActive()) {
            // wheelbase.setPowers(PowersCalculator.normalizePowers(PowersCalculator.calculatePowers(Control.getMovementValues())));
            if (control.getHookGrabValue()) {
                hook.grab();
            }
            if (control.getHookHomeValue()) {
                hook.home();
            }
        }
    }
}

