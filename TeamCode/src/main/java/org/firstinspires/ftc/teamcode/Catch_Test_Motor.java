package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="Catch_Test", group="OpMode")

public class Catch_Test_Motor extends OpMode {

    private DcMotorEx leftFrontDrive = null;
    private DcMotorEx leftBackDrive = null;
    private DcMotorEx rightFrontDrive = null;
    private DcMotorEx rightBackDrive = null;
    DcMotorEx catch_motor1 = null;
    DcMotorEx catch_motor2 = null;
    DcMotorEx elevator = null;


    public void init() {

        catch_motor1 = hardwareMap.get(DcMotorEx.class, "catch_motor1");
        catch_motor2 = hardwareMap.get(DcMotorEx.class, "catch_motor2");
        elevator = hardwareMap.get(DcMotorEx.class, "elevator");

        catch_motor1.setDirection(DcMotorEx.Direction.FORWARD);
        catch_motor2.setDirection(DcMotorEx.Direction.FORWARD);
        elevator.setDirection(DcMotorEx.Direction.FORWARD);
        elevator.setTargetPosition(0);
        elevator.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        elevator.setPower(1.);

        leftFrontDrive = hardwareMap.get(DcMotorEx.class, "leftFrontDrive");
        leftBackDrive = hardwareMap.get(DcMotorEx.class, "leftBackDrive");
        rightFrontDrive = hardwareMap.get(DcMotorEx.class, "rightFrontDrive");
        rightBackDrive = hardwareMap.get(DcMotorEx.class, "rightBackDrive");

        leftFrontDrive.setDirection(DcMotorEx.Direction.REVERSE);
        leftBackDrive.setDirection(DcMotorEx.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotorEx.Direction.FORWARD);
        rightBackDrive.setDirection(DcMotorEx.Direction.FORWARD);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

    }

    public void start() {

    }
    public void loop()
    {
        double max;
        double axial = -gamepad1.left_stick_y;
        double lateral = gamepad1.left_stick_x;
        double yaw = gamepad1.right_stick_x;

        double leftFrontPower = axial + lateral + yaw;
        double rightFrontPower = axial - lateral - yaw;
        double leftBackPower = axial - lateral + yaw;
        double rightBackPower = axial + lateral - yaw;

        max = Math.max(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
        max = Math.max(max, Math.abs(leftBackPower));
        max = Math.max(max, Math.abs(rightBackPower));

        if (max > 1.0) {
            leftFrontPower /= max;
            rightFrontPower /= max;
            leftBackPower /= max;
            rightBackPower /= max;

        }
        leftFrontDrive.setPower(leftFrontPower);
        rightFrontDrive.setPower(rightFrontPower);
        leftBackDrive.setPower(leftBackPower);
        rightBackDrive.setPower(rightBackPower);


        telemetry.addData("Front left/Right", "%4.2f, %4.2f", leftFrontPower, rightFrontPower);
        telemetry.addData("Back  left/Right", "%4.2f, %4.2f", leftBackPower, rightBackPower);
        telemetry.update();

        if (gamepad2.y)
        {
            elevator.setTargetPosition(1000);
        }
        else if (gamepad2.a)
        {
            elevator.setTargetPosition(0);
        }

        catch_motor1.setPower(gamepad2.left_trigger-gamepad2.right_trigger);
        catch_motor2.setPower(gamepad2.left_trigger-gamepad2.right_trigger);
    }
    public void stop(){

    }

}