package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
/**
 * Created by JUSTIN on 3/15/18.
 */

public class drivetrain {
    public DcMotor right_top;
    public DcMotor right_bottom;
    public DcMotor left_bottom;
    public DcMotor left_top;
    public static final int TICKS_PER_ROTATION = 1120;
    public static final double WHEEL_DIAMETER     = 4; //fuck you, swerve drive
    public drivetrain(DcMotor right_Top, DcMotor right_Bottom, DcMotor left_Bottom, DcMotor left_Top) {
        this.right_bottom = right_Bottom;
        this.right_top = right_Top;
        this.left_bottom = left_Bottom;
        this.left_top = left_Top;
    }

    public void ENCODERdRIVErIGHT(double position, double power) {
        resetEncoders();
        encoderINIT();
        double rotations = position / (WHEEL_DIAMETER * Math.PI);
        right_top.setTargetPosition((int) (rotations * TICKS_PER_ROTATION));
        right_bottom.setTargetPosition((int) (rotations * TICKS_PER_ROTATION));
        setRightTopPower(power);
        setRightBottomPower(power);
        jigglypuff();
    }
    public void ENCODERdRIVElEFT(double position, double power) {
        resetEncoders();
        encoderINIT();
        double rotations = position / (WHEEL_DIAMETER * Math.PI);
        left_top.setTargetPosition((int) (rotations * TICKS_PER_ROTATION));
        left_bottom.setTargetPosition((int) (rotations * TICKS_PER_ROTATION));
        setLeftBottomPower(power);
        setLeftTopPower(power);
        jigglypuff();
    }
    public void ENCODERdRIVEuP(double position, double power) {
        resetEncoders();
        encoderINIT();
        double rotations = position / (WHEEL_DIAMETER * Math.PI);
        right_bottom.setTargetPosition((int) (rotations * TICKS_PER_ROTATION));
        left_bottom.setTargetPosition((int) (rotations * TICKS_PER_ROTATION));
        setRightTopPower(power);
        setLeftBottomPower(power);
        jigglypuff();
    }
    public void ENCODERdRIVEdOWN(double position, double power) {
        resetEncoders();
        encoderINIT();
        double rotations = position / (WHEEL_DIAMETER * Math.PI);
        left_top.setTargetPosition((int) (rotations * TICKS_PER_ROTATION));
        right_top.setTargetPosition((int) (rotations * TICKS_PER_ROTATION));
        setLeftTopPower(power);
        setRightTopPower(power);
        jigglypuff();
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
    public void resetEncoders() {
        right_bottom.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        left_bottom.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_top.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        left_top.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void encoderINIT () {
        right_bottom.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left_bottom.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_top.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left_top.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void setRightTopPower (double m) {
        right_top.setPower(m);
    }
    public void setRightBottomPower (double m) {
        right_bottom.setPower(m);
    }
    public void setLeftTopPower (double m) {
        left_top.setPower(m);
    }
    public void setLeftBottomPower (double m) {
        left_bottom.setPower(m);
    }
    public void jigglypuff() {
        while (left_bottom.isBusy() || right_bottom.isBusy() || right_top.isBusy() || left_top.isBusy()) {

        }
    }
}
