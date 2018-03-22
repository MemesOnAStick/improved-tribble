package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by JUSTIN on 3/15/18.
 */

public class drivetrain {
    public DcMotor right_top;
    public DcMotor right_bottom;
    public DcMotor left_bottom;
    public DcMotor left_top;
    public drivetrain(DcMotor right_Top, DcMotor right_Bottom, DcMotor left_Bottom, DcMotor left_Top) {
        this.right_bottom = right_Bottom;
        this.right_top = right_Top;
        this.left_bottom = left_Bottom;
        this.left_top = left_Top;
    }
    public void mechanumDrive(double movX, double movY, double rotation) {
        //assign motor powers their inputs based on position on the robot
        double forwardLeftPower = Range.clip((-1*movX - movY), -1, 1) - rotation;
        double forwardRightPower = -1*(Range.clip((-1*movX + movY), -1, 1) - rotation);
        double backLeftPower = Range.clip((movX - movY), -1, 1) - rotation;
        double backRightPower = -1*(Range.clip((movX + movY), -1, 1) - rotation);

        left_bottom.setPower(forwardLeftPower);
        right_top.setPower(forwardRightPower);
        left_bottom.setPower(backLeftPower);
        right_bottom.setPower(backRightPower);
    }

}
