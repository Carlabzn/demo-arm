package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


public class demo_arm extends OpMode{
    DcMotor motor;
    double ticks = 2786.2;
    double newTarget;
    @Override
    public void init(){
        motor=hardwareMap.get(DcMotor.class, "motor");
        telemetry.addData("Hardware", "initialize");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }
    @Override
    public void loop(){
        if(gamepad1.a){
            encoder(2);

        }
        telemetry.addData("Motor Ticks", motor.getCurrentPosition());
    }
    public void encoder(int turnage){
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        newTarget = ticks/turnage;
        motor.setTargetPosition((int)newTarget);
        motor.setPower(0.3);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }
    public void traker(){
        motor.setTargetPosition(0);
        motor.setPower(0.5);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

}
