package org.firstinspires.ftc.teamcode.core;

import android.util.Size;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.abstracts.IBannerDetector;
import org.firstinspires.ftc.teamcode.dtos.Detection;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;

public class AprilTagBannerDetector implements IBannerDetector {
    private final WebcamName camera;
    private AprilTagProcessor aprilTag;
    private VisionPortal visionPortal;

    public AprilTagBannerDetector(WebcamName camera) {
        this.camera = camera;
        aprilTag = new AprilTagProcessor.Builder().build();
        VisionPortal.Builder builder = new VisionPortal.Builder();
        builder.setCamera(camera);
        builder.setCameraResolution(new Size(1280, 720));
        builder.enableLiveView(true);
        builder.addProcessor(aprilTag);
        visionPortal = builder.build();
        visionPortal.resumeStreaming();
    }

    @Override
    public Detection detect() {
        List<AprilTagDetection> currentDetections = aprilTag.getDetections();
        if (currentDetections.size() == 0) {
            return new Detection(0, 0, false);
        }
        return new Detection(currentDetections.get(0).center.x, currentDetections.get(0).center.y, true);
    }
}
