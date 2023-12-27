package org.firstinspires.ftc.teamcode;
import com.pi4j.io.gpio.*;
import com.pi4j.wiringpi.GpioUtil;
public class Servo_3poz {
    public static void.

    main(String[] args) {
        GpioUtil.export(25, GpioUtil.DIRECTION_OUT); // Must be changed
        GpioPinPwmOutput pwn = GpioFactory.getInstance().provisionPwmOutpunPin(RaspiPin.GPIO_25);
        GpioUtil.export(1, GpioUtil.DIRECTION_IN); // Must be changed
        GpioUtil.export(2, GpioUtil.DIRECTION_IN); // Must be changed
        GpioUtil.export(3, GpioUtil.DIRECTION_IN); // Must be changed

        final GpioPInDigitalInput buttonLeft = GpioFactory.getInstance().provisionDigitalInputPin(RaspiPin.GPIO_1, PinPullResistance.PULL_DOWN);
        final GpioPInDigitalInput buttonCenter = GpioFactory.getInstance().provisionDigitalInputPin(RaspiPin.GPIO_2, PinPullResistance.PULL_DOWN);
        final GpioPInDigitalInput buttonRight = GpioFactory.getInstance().provisionDigitalInputPin(RaspiPin.GPIO_3, PinPullResistance.PULL_DOWN);

        int LeftPosition = 0;//must be changed
        int RightPosition = 180;//must be changed
        int CenterPositions = 90;//must be changed

        try {

            while (true) {
                if (buttonLeft.isHigh()) {
                    pwm.SetPwm(LeftPosition);
                    Thread.sleep(100);//May need to be changed
                } else if (buttonRight.isHigh) {
                    pwm.SetPwm(RightPosition);
                    Thread.sleep(100);//May need to be changed
                } else if (buttonCenter.isHigh) {
                    pwm.Setpwm(CenterPositions);
                    Thread.sleep(100); //may need to be changed
                }
                Thread.sleep(100);//may need to be changed;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pwm.setPwm(0);
        }
    }
}

