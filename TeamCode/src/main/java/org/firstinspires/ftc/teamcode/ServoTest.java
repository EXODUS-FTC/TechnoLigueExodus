//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.util.ElapsedTime;
//
//@Autonomous(name = "servo")
//public class ServoTest extends LinearOpMode{
//
//    public Servo  servo;
//    ElapsedTime timer;
//
//    @Override
//    public void runOpMode()
//    {
//        servo = hardwareMap.servo.get("servo1");
//        timer = new ElapsedTime();
//        waitForStart();
//        timer.reset();
//
//        while (opModeIsActive())
//        {
//            if (timer.seconds() > 2)
//            {
//                servo.setPosition(1);
//            if (timer.seconds() > 4)
//                timer.reset(); }
//            else
//            {
//                servo.setPosition(0);
//            }
//            }
//        }
//}


package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

@TeleOp(name="ServoSetter")
public class ServoTest extends OpMode {

    public Servo servo;
    private final double position=0;

    ElapsedTime timer = new ElapsedTime();
    public double additionalPosition = 0;

    @Override
    public void init() {
        servo=hardwareMap.servo.get("servo1");
        servo.setPosition(position);
    }

    @Override
    public void loop() {
            if (timer.seconds() >= 2){
                additionalPosition+=0.1;
                telemetry.addData("position: ", servo.getPosition());
                servo.setPosition(position+additionalPosition);
                timer.reset();
            }

    }
}

