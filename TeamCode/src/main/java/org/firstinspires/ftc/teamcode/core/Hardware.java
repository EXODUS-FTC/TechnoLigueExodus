package org.firstinspires.ftc.teamcode.core;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;

import java.util.HashMap;
import java.util.Map;

public class Hardware {
    private final HardwareMap hardwareMap;
    public Hardware(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;
    }
    public Map<String, DcMotor> getWheelbaseMotors(String... deviceNames) {
        Map<String, DcMotor> motors = new HashMap<>();
        for (String deviceName:
                deviceNames) {
            motors.put(deviceName, this.hardwareMap.get(DcMotor.class, deviceName));
        }
        return motors;
    }
    public Servo[] getServos(String... deviceNames) {
        Servo[] servos = new Servo[deviceNames.length];
        for (int i = 0; i < deviceNames.length; i++) {
            servos[i] = this.hardwareMap.get(Servo.class, deviceNames[i]);
        }
        return servos;
    }
    public DcMotor getMotor(String deviceName) {
        return this.hardwareMap.get(DcMotor.class, deviceName);
    }
    public Servo getServo(String deviceName) {
        return this.hardwareMap.get(Servo.class, deviceName);
    }
    public WebcamName getCamera(String deviceName) {
        return this.hardwareMap.get(WebcamName.class, deviceName);
    }
}
