package org.firstinspires.ftc.teamcode.systeme32;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

public class scuipator {
    final private DcMotorEx scuipator;
    final private perie perie = new perie();

    private final double target_velocity = 6000;
    private final double min_velocity = 4000;

    private Launch_state launchState = Launch_state.IDLE;

    public enum Launch_state {
        IDLE,
        SPIN_UP,
        LAUCH
    }

    public scuipator(HardwareMap hardwareMap) {
        scuipator = hardwareMap.get(DcMotorEx.class, "Shooter1");

        PIDFCoefficients pidf = new PIDFCoefficients(300.0, 0.0, 0.0, 12.0);
        scuipator.setPIDFCoefficients(DcMotorEx.RunMode.RUN_USING_ENCODER, pidf);
        scuipator.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
    }

    public void launch(boolean shotRequested) {
        switch (launchState) {
            case IDLE:
                if (shotRequested) {
                    scuipator.setVelocity(target_velocity);
                    launchState = Launch_state.SPIN_UP;
                }
                break;

            case SPIN_UP:
                scuipator.setVelocity(target_velocity);
                if (scuipator.getVelocity() >= min_velocity) {
                    perie.perie_intake_on();
                    launchState = Launch_state.LAUCH;
                }
                if (!shotRequested) {

                    scuipator.setVelocity(0);
                    perie.perie_intake_off();
                    launchState = Launch_state.IDLE;
                }
                break;

            case LAUCH:
                scuipator.setVelocity(target_velocity);
                perie.perie_intake_on();
                if (!shotRequested) {

                    scuipator.setVelocity(0);
                    perie.perie_intake_off();
                    launchState = Launch_state.IDLE;
                } else if (scuipator.getVelocity() < min_velocity) {

                    perie.perie_intake_off();
                    launchState = Launch_state.SPIN_UP;
                }
                break;
        }
    }

    public void reset() {
        perie.perie_intake_off();
        scuipator.setVelocity(0);
        launchState = Launch_state.IDLE;
    }

    public double getVelocity() {
        return scuipator.getVelocity();
    }

    public Launch_state getLaunchState() {
        return launchState;
    }
}
