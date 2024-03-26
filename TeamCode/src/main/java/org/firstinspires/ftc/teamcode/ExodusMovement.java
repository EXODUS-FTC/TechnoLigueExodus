package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

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
            if (control.getHookGrabValue()) {
                hook.grab();
            }
            if (control.getHookHomeValue()) {
                hook.home();
            }
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

