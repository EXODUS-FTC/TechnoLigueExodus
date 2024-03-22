package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
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
    public Servo[] getHookServos(String... deviceNames) {
        Servo[] servos = new Servo[deviceNames.length];
        for (int i = 0; i < deviceNames.length; i++) {
            servos[i] = this.hardwareMap.get(Servo.class, deviceNames[i]);
        }
        return servos;
    }
}
