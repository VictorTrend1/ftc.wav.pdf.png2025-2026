package org.firstinspires.ftc.teamcode.OpModes;


import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.systeme32.perie;
import org.firstinspires.ftc.teamcode.systeme32.scuipator;
import org.firstinspires.ftc.teamcode.systeme32.servos;
import org.firstinspires.ftc.teamcode.systeme32.perie;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Teleop" , group="Teleop")
public class TeleOp extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException{
        perie perie = new perie(hardwareMap);
        scuipator scuipator = new scuipator(hardwareMap);
        servos servos = new servos(hardwareMap);
        MecanumDrive drive = new MecanumDrive(hardwareMap , new Pose2d(0,0,0));
        waitForStart();
        while(opModeIsActive()){
            drive.setDrivePowers(new PoseVelocity2d(

                    new Vector2d(
                            -gamepad1.left_stick_y,
                            -gamepad1.left_stick_x
                    ),
                    -gamepad1.right_stick_x
            ));
            scuipator.launch(gamepad1.left_bumper);
            if(gamepad1.right_bumper) {
                perie.perie_intake_on();
            }
            else{
                perie.perie_intake_off();
            }
            if(gamepad1.dpad_up){
                servos.scuipator_outttake();
            }
            else{
                servos.scuipator_idle();
            }
            telemetry.addData("velocity: ", scuipator.getVelocity());
        telemetry.addData("status outtake: ", scuipator.getLaunchState() );
        telemetry.update();
        }




    }
}
