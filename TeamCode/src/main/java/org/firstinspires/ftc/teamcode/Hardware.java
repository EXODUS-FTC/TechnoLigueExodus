package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.HashMap;
import java.util.Map;

public class Hardware {
    public static Map<String, DcMotor> getWheelbaseMotors(String... deviceNames) {
        Map<String, DcMotor> motors = new HashMap<>();
        for (String deviceName:
                deviceNames) {
            motors.put(deviceName, hardwareMap.get(DcMotor.class, deviceName));
        }
        return motors;
    }
    public static Servo[] getHookServos(String... deviceNames) {
        Servo[] servos = new Servo[deviceNames.length];
        for (int i = 0; i < deviceNames.length; i++) {
            servos[i] = hardwareMap.get(Servo.class, deviceNames[i]);
        }
        return servos;
    }
}
