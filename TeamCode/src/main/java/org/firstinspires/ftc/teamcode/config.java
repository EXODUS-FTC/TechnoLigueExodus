//package org.firstinspires.ftc.teamcode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorEx;
//import com.qualcomm.robotcore.hardware.DcMotorSimple;
//import com.qualcomm.robotcore.hardware.HardwareMap;
//
//@TeleOp
//public class config{
//
//    private DcMotorEx leftFrontDrive = null;
//    private DcMotorEx leftBackDrive = null;
//    private DcMotorEx rightFrontDrive = null;
//    private DcMotorEx rightBackDrive = null;
//    private DcMotorEx captureFirstDrive= null;
//    private DcMotorEx captureSecondDrive = null;
//    private DcMotorEx rotationDrive = null;
//
//    public config (){
//
//    }
//
//
//    public void init(HardwareMap hwmap) {
//        leftFrontDrive = hwmap.get(DcMotorEx.class, "left_front_drive");
//        leftBackDrive = hwmap.get(DcMotorEx.class, "left_back_drive");
//        rightFrontDrive = hwmap.get(DcMotorEx.class, "right_front_drive");
//        rightBackDrive = hwmap.get(DcMotorEx.class, "right_back_drive");
//
//        captureFirstDrive = hwmap.get(DcMotorEx.class, "zaxvat1");
//        captureSecondDrive = hwmap.get(DcMotorEx.class, "zaxvat2");
//
//        leftFrontDrive.setDirection(DcMotorEx.Direction.REVERSE);
//        leftBackDrive.setDirection(DcMotorEx.Direction.REVERSE);
//        rightFrontDrive.setDirection(DcMotorEx.Direction.FORWARD);
//        rightBackDrive.setDirection(DcMotorEx.Direction.FORWARD);
//
//        captureFirstDrive.setDirection(DcMotorEx.Direction.REVERSE);
//        captureSecondDrive.setDirection(DcMotorEx.Direction.FORWARD);
//        rotationDrive.setDirection(DcMotorEx.Direction.FORWARD);
//
//
//        }
//        public void loop (){
//
//            double max;
//
//            double axial   = -gamepad1.left_stick_y;
//            double lateral =  gamepad1.left_stick_x;
//            double yaw     =  gamepad1.right_stick_x;
//
//
//
//            double leftFrontPower  = axial + lateral + yaw;
//            double rightFrontPower = axial - lateral - yaw;
//            double leftBackPower   = axial - lateral + yaw;
//            double rightBackPower  = axial + lateral - yaw;
//
//
//
//            max = Math.max(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
//            max = Math.max(max, Math.abs(leftBackPower));
//            max = Math.max(max, Math.abs(rightBackPower));
//
//
//
//            if (max > 1.0) {
//                leftFrontPower  /= max;
//                rightFrontPower /= max;
//                leftBackPower   /= max;
//                rightBackPower  /= max;
//
//            }
//            leftFrontDrive.setPower(leftFrontPower);
//            rightFrontDrive.setPower(rightFrontPower);
//            leftBackDrive.setPower(leftBackPower);
//            rightBackDrive.setPower(rightBackPower);
//
//            captureFirstDrive.setPower(gamepad2.right_trigger-gamepad2.left_trigger);
//            captureSecondDrive.setPower(gamepad2.right_trigger-gamepad2.left_trigger);
//            rotationDrive.setPower(gamepad2.right_stick_y);
//        }
//    public void stop() {
//
//    }
//    }
