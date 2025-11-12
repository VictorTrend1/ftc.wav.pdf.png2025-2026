package org.firstinspires.ftc.teamcode.OpModes;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.Servo;
import com.sun.tools.javac.comp.Todo;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.systeme32.servos;


@Config
@TeleOp(name= "pidf_shooter", group= "Teleop")
public class pidf_shooter extends LinearOpMode {
    public static double pozitie;
    public DcMotorEx shooter;
    public static double p = 300.0;
    public static double i = 0.0;
    public static double d = 0.0;
    public static double f = 12.0;
    public static double target_velocity = 6000;

    @Override
    public void runOpMode() throws InterruptedException {
        shooter = hardwareMap.get(DcMotorEx.class,"Shooter1");
        shooter.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
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
            PIDFCoefficients pidf = new PIDFCoefficients(p, i, d, f);
            shooter.setPIDFCoefficients(DcMotorEx.RunMode.RUN_USING_ENCODER, pidf);
            shooter.setVelocity(target_velocity);

            if(gamepad1.dpad_up){
                servos.scuipator_outttake();
            }
            else{
                servos.scuipator_idle();
            }
            telemetry.addData("velocity",shooter.getVelocity());
            telemetry.update();
        }

    }

}
