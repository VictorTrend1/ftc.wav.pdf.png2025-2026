package org.firstinspires.ftc.teamcode.systeme32;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class servos {
    Servo servo;
    private double outake = 0.9;
    private double idle = 1;
    public servos(HardwareMap hardwareMap) {
    servo = hardwareMap.get(Servo.class,"servo");
    }
    public void scuipator_outttake(){
        servo.setPosition(outake);
    }
    public void scuipator_idle(){
        servo.setPosition(idle);
    }
}
