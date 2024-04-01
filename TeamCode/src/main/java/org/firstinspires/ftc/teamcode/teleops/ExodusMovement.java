package org.firstinspires.ftc.teamcode.teleops;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.core.Control;
import org.firstinspires.ftc.teamcode.core.Conveyor;
import org.firstinspires.ftc.teamcode.core.Ejector;
import org.firstinspires.ftc.teamcode.core.Elevator;
import org.firstinspires.ftc.teamcode.core.Grabber;
import org.firstinspires.ftc.teamcode.core.Hardware;
import org.firstinspires.ftc.teamcode.core.Hook;
import org.firstinspires.ftc.teamcode.core.PowersCalculator;
import org.firstinspires.ftc.teamcode.core.Wheelbase;

@TeleOp(name="ExodusMovement", group="Linear OpMode")
public class ExodusMovement extends LinearOpMode {
    @Override
    public void runOpMode() {
        // Init necessary modules
        Hardware hardware = new Hardware(hardwareMap);
        Control control = new Control(gamepad1, gamepad2);
        Wheelbase wheelbase = new Wheelbase(hardware.getWheelbaseMotors("r1", "l1", "r2", "l2"));
        Hook hook = new Hook(hardware.getServos("leftHookServo", "rightHookServo"), 0, 1);
        Elevator elevator = new Elevator(hardware.getMotor("elevatorMotor"));
        Ejector ejector = new Ejector(hardware.getServo("ejectorServo"), 0, 0.8);
        Conveyor conveyor = new Conveyor(hardware.getMotor("conveyorMotor"));
        Grabber grabber = new Grabber(
                hardware.getServos("grabberServoL", "grabberServoR"),
                hardware.getServos("moverServoL", "moverServoR"),
                0,
                1,
                0,
                1);

        // Configuring
        wheelbase.configure();
        hook.configure();
        elevator.configure();
        ejector.configure();
        conveyor.configure();
        grabber.configure();
        waitForStart();
        while (opModeIsActive()) {
            wheelbase.setPowers(PowersCalculator.normalizePowers(PowersCalculator.calculatePowers(control.getMovementValues())));
            elevator.setPower(control.getElevatorUp()-control.getElevatorDown());
            conveyor.setPower(control.getConveyorForward()-control.getConveyorReverse());

            if (control.getEject()) {
                ejector.eject();
            }
            if (control.getEjectClose()) {
                ejector.close();
            }
            if (control.getGrabberGrab()) {
                grabber.grab();
            }
            if (control.getGrabberHome()) {
                grabber.home();
            }
            if (control.getMoverDown()) {
                grabber.goDown();
            }
            if (control.getMoverUp()) {
                grabber.goUp();
            }
        }
    }
}

