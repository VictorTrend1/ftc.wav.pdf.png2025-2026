package org.firstinspires.ftc.teamcode.systeme32;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.text.BreakIterator;

public class perie {
    DcMotor perie;
    public void perie_intake(HardwareMap hardwareMap){
        perie = hardwareMap.get(DcMotor.class,"Perie");
        perie.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        perie.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        perie.setPower(0);
    }
    public void perie_intake_on(){
        perie.setPower(1);

    }
    public void perie_intake_off(){
        perie.setPower(0);
    }
}
