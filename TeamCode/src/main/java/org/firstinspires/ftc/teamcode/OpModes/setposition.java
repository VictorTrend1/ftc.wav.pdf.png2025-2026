package org.firstinspires.ftc.teamcode.OpModes;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.sun.tools.javac.comp.Todo;


@Config
@TeleOp(name= "setpozision", group= "Teleop")
public class setposition extends LinearOpMode {
    public static double pozitie;
    public Servo servo;
    @Override
    public void runOpMode() throws InterruptedException {
        servo = hardwareMap.get(Servo.class,"servo");
        servo.setPosition(0);
        waitForStart();
        while(opModeIsActive()){
            servo.setPosition(pozitie);
            telemetry.addData("pozitie servo: ", servo.getPosition());
            telemetry.update();
        }

    }
    // TODO:  masina: 0.7 stanga masina , 0.5 FATA , 0.3 DREAPTA
    //TODO robit pozitie start 1 , 0.8 shoot
}
