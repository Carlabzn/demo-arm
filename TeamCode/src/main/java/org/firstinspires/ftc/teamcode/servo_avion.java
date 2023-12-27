package org.firstinspires.ftc.teamcode;
import com.pi4j.io.gpio.*;
import com.pi4j.wiringpi.GpioUtil;
public class ServoLauncher {
    public static void main(String[] args) {
        GpioUtil.export(25, GpioUtil.DIRECTION_OUT); // Must be changed
        GpioPinPwmOutput pwn = GpioFactory.getInstance().provisionPwmOutpunPin(RaspiPin.GPIO_25);
        GpioUtil.export(1, GpioUtil.DIRECTION_IN); // Must be changed
        final GpioPinDigitalInput button = GpioFactory.getInstance().provisionDigitalInputPin(RaspiPin.GPIO_2, PinPullResistance.PULL_DOWN);


        int InitialPoition = 1;//Must be changed

        try {
            while (true) {
                if (button.isHigh()) {
                    pwm.setPwm(InitialPoition);
                    Thread.sleep(100)//May need to be changed;
                    pwm.setPwm(0);
                    break;
                }
                Thread.sleep(100);//May need to be changed; For stability;
            }
        }
    catch.(Exception e)
            {
                e.printStackTrace();
            }
    finally{
                pwm.set.Pwm(0);
            }
        }
    }

