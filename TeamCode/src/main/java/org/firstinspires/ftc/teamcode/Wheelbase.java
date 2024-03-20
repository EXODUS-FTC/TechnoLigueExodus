package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.Map;

public class Wheelbase {
    private final Map<String, DcMotor> motors;
    public Wheelbase(Map<String, DcMotor> motors) {
        this.motors = motors;
    }
    public void configure() {
        this.motors.get("left").setDirection(DcMotor.Direction.REVERSE);
        this.motors.get("right").setDirection(DcMotor.Direction.FORWARD);
        this.motors.get("back").setDirection(DcMotor.Direction.REVERSE);
        this.motors.get("front").setDirection(DcMotor.Direction.FORWARD);
    }

    public void setPowers(Map<String, Double> powers) {
        for (String motor:
                this.motors.keySet()) {
            this.motors.get(motor).setPower(powers.get(motor));
            telemetry.addData(motor, "%4.2f", powers.get(motor));
        }
        telemetry.update();
    }
}
